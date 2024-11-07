--1. Create 3 Stored Procedures :- For your project create three stored procedures and emphasize how or why they would be used

--ONE
CREATE PROCEDURE AddNewUserWithLibrary
(
    @Username VARCHAR(50),
    @FirstName VARCHAR(50),
    @LastName VARCHAR(50),
    @Email VARCHAR(100),
    @Password VARCHAR(255),
    @Name VARCHAR(100),
    @LibraryID INT
)
AS
BEGIN
    BEGIN
        INSERT INTO [User] (Username, FirstName, LastName, Email, Password)
        VALUES (@Username, @FirstName, @LastName, @Email, @Password);

        IF NOT EXISTS (SELECT 1 FROM Library WHERE LibraryID = @LibraryID)
        BEGIN
            INSERT INTO Library (LibraryID, Name) VALUES (@LibraryID, @Name);
        END

        INSERT INTO UserToLibrary (Username, LibraryID)
        VALUES (@Username, @LibraryID);
    END 
END;
GO

--This procedure would be called whenever a new user is registered. It ensures that a user has a library assigned, simplifying user setup and enforcing data integrity.

--TWO
CREATE PROCEDURE AddNewBook
(
    @ISBN VARCHAR(13),
    @Title VARCHAR(255),
    @Publisher VARCHAR(255),
    @Genre VARCHAR(50) = NULL,
    @Subject VARCHAR(50) = NULL,
    @Edition INT = NULL
)
AS
BEGIN
    IF EXISTS (SELECT 1 FROM Book WHERE ISBN = @ISBN)
    BEGIN
        PRINT 'A book with this ISBN already exists.';
        RETURN;
    END
    INSERT INTO Book (ISBN, Title, Publisher, Genre, Subject, Edition)
    VALUES (@ISBN, @Title, @Publisher, @Genre, @Subject, @Edition);
END;
GO

--This procedure will be helpful to call when creating new books by ensuring unique ISBN entries and simplifying book additions for the library.

--THREE
CREATE PROCEDURE AddNewSerialPublication
(
    @ISSN VARCHAR(8),
    @Title VARCHAR(255),
    @Publisher VARCHAR(255),
    @Editor VARCHAR(255) = NULL,
    @Category VARCHAR(50) = NULL,
    @IllustratorName VARCHAR(255) = NULL,
    @SeriesTitle VARCHAR(255) = NULL
)
AS
BEGIN
    IF EXISTS (SELECT 1 FROM SerialPublication WHERE ISSN = @ISSN)
    BEGIN
        PRINT 'A serial publication with this ISSN already exists.';
        RETURN;
    END
    INSERT INTO SerialPublication (ISSN, Title, Publisher, Editor, Category, IllustratorName, 
        SeriesTitle) VALUES (@ISSN, @Title, @Publisher, @Editor, @Category, 
        @IllustratorName, @SeriesTitle);
END;
GO
--This procedure will be helpful to call when creating new serial publications by ensuring unique ISSN entries and simplifying publications additions for the library.

--2. Create 3 functions :- For your project create three functions and emphasize how or why they would be used

--ONE
CREATE FUNCTION GetAuthorFullName
(
    @AuthorID INT
)
RETURNS VARCHAR(100)
AS
BEGIN
    DECLARE @FullName VARCHAR(100);

    SELECT @FullName = CONCAT(FirstName, ' ', LastName)
    FROM Author
    WHERE AuthorID = @AuthorID;

    RETURN @FullName;
END;
GO

--This function is useful for formatting author information in reports, search results, or any output where a full name display is preferred.

--TWO
CREATE FUNCTION IsBookInLibrary
(
    @LibraryID INT,
    @ISBN VARCHAR(20)
)
RETURNS BIT
AS
BEGIN
    DECLARE @Exists BIT;
    
    IF EXISTS (
        SELECT 1 
        FROM BooksInLibrary 
        WHERE LibraryID = @LibraryID AND ISBN = @ISBN
    )
        SET @Exists = 1;
    ELSE
        SET @Exists = 0;
    
    RETURN @Exists;
END;
GO

--This function is useful when validating whether or not a book has already been added to the library

--THREE
CREATE FUNCTION IsSerialInLibrary
(
    @LibraryID INT,
    @ISSN VARCHAR(20)
)
RETURNS BIT
AS
BEGIN
    DECLARE @Exists BIT;
    
    IF EXISTS (
        SELECT 1 
        FROM SerialPublicationsInLibrary 
        WHERE LibraryID = @LibraryID AND ISSN = @ISSN
    )
        SET @Exists = 1;
    ELSE
        SET @Exists = 0;
    
    RETURN @Exists;
END;
GO

--This function is useful when validating whether or not a serial publication has already been added to the library.

--3. Create 3 views :- For your project create three views for any 3 tables

--ONE
CREATE VIEW UserLibraryInfo AS
SELECT 
    u.Username,
    u.FirstName,
    u.LastName,
    u.Email,
    l.LibraryID,
    l.Name AS LibraryName
FROM 
    Users u
JOIN 
    UsersToLibrary ul ON u.Username = ul.Username
JOIN 
    Library l ON ul.LibraryID = l.LibraryID;
GO

--TWO
CREATE VIEW BooksInLibraries AS
SELECT 
    b.ISBN,
    b.Title,
    b.Publisher,
    bl.LibraryID,
    l.Name AS LibraryName
FROM 
    Book b
JOIN 
    BooksInLibrary bl ON b.ISBN = bl.ISBN
JOIN 
    Library l ON bl.LibraryID = l.LibraryID;
GO

--THREE
CREATE VIEW BooksInDatabase AS
SELECT 
    b.ISBN,
    b.Title,
    b.Publisher,
    b.Genre,
    b.Subject,
    b.Edition,
    COUNT(bl.LibraryID) AS AvailableInLibraries
FROM 
    Book b
LEFT JOIN 
    BooksInLibrary bl ON b.ISBN = bl.ISBN
GROUP BY 
    b.ISBN, b.Title, b.Publisher, b.Genre, b.Subject, b.Edition;
GO

--4. Create 1 Trigger :- For your project create one Trigger associated with any type of action between the referenced tables (primary-foreign key relationship tables)

CREATE TRIGGER trg_AuthorToBookInsert
ON Author
AFTER INSERT
AS
BEGIN
    DECLARE @NewAuthorID INT;
    DECLARE @NewISBN VARCHAR(13);

   
    SELECT @NewAuthorID = AuthorID
    FROM INSERTED;

    SELECT @NewISBN = ISBN
    FROM Book
    WHERE ISBN = (SELECT MAX(ISBN) FROM Book);  -- Get the most recent ISBN

    INSERT INTO AuthorToBook (AuthorID, ISBN)
    VALUES (@NewAuthorID, @NewISBN);
END;


--5. Implement 1 Column Encryption :- For any 1 column in your table, implement the column encryption for security purposes

CREATE MASTER KEY ENCRYPTION BY PASSWORD = 'DBSystems1234!';

CREATE CERTIFICATE PasswordCert WITH SUBJECT = 'Certificate for User Password Encryption';

CREATE SYMMETRIC KEY PasswordKey WITH ALGORITHM = AES_256 ENCRYPTION BY CERTIFICATE PasswordCert;

ALTER TABLE Users ADD EncryptedPassword VARBINARY(128); 

--6. Create 3 non-clustered indexes :- create 3 non-clustered indexes on your tables

CREATE NONCLUSTERED INDEX idx_SerialPublication_Title
ON SerialPublication (Title);

CREATE NONCLUSTERED INDEX idx_Book_Title
ON Book (Title);

CREATE NONCLUSTERED INDEX idx_Author_LastName
ON Author (LastName);

