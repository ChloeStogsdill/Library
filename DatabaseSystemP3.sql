-- Create Table Queries
CREATE TABLE Users (
    Username VARCHAR(50) PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Email VARCHAR(100) UNIQUE,
    Password VARCHAR(255)
);

CREATE TABLE Library (
    LibraryID INT PRIMARY KEY,
    Name VARCHAR(100)
);

CREATE TABLE Author (
    AuthorID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DOB DATE,
    DOD DATE
);

CREATE TABLE SerialPublication (
    ISSN VARCHAR(8) PRIMARY KEY,
    Title VARCHAR(100),
    Publisher VARCHAR(100),
    Editor VARCHAR(100) NULL,       
    Category VARCHAR(50) NULL,
    IllustratorName VARCHAR(100) NULL,  
    SeriesTitle VARCHAR(100) NULL   
);

CREATE TABLE Book (
    ISBN VARCHAR(13) PRIMARY KEY,
    Title VARCHAR(100),
    Publisher VARCHAR(100),
    Genre VARCHAR(50) NULL,         
    Subject VARCHAR(100) NULL,      
    Edition INT NULL                
);
-- Create above first

CREATE TABLE UsersToLibrary (
    Username VARCHAR(50),
    LibraryID INT,
    PRIMARY KEY (Username, LibraryID),
    FOREIGN KEY (Username) REFERENCES Users(Username),
    FOREIGN KEY (LibraryID) REFERENCES Library(LibraryID)
);

CREATE TABLE AuthorToSerialPublication (
    AuthorID INT,
    ISSN VARCHAR(8),   PRIMARY KEY (AuthorID, ISSN),
    FOREIGN KEY (AuthorID) REFERENCES Author(AuthorID),
    FOREIGN KEY (ISSN) REFERENCES SerialPublication(ISSN)
);

CREATE TABLE AuthorToBook (
    AuthorID INT,
    ISBN VARCHAR(13),
    PRIMARY KEY (AuthorID, ISBN),
    FOREIGN KEY (AuthorID) REFERENCES Author(AuthorID),
    FOREIGN KEY (ISBN) REFERENCES Book(ISBN)
);

CREATE TABLE BooksInLibrary (
    LibraryID INT,
    ISBN VARCHAR(13),
    PRIMARY KEY (LibraryID, ISBN),
    FOREIGN KEY (LibraryID) REFERENCES Library(LibraryID),
    FOREIGN KEY (ISBN) REFERENCES Book(ISBN)
);

CREATE TABLE SerialPublicationsInLibrary (
    LibraryID INT,
    ISSN VARCHAR(8),
    PRIMARY KEY (LibraryID, ISSN),
    FOREIGN KEY (LibraryID) REFERENCES Library(LibraryID),
    FOREIGN KEY (ISSN) REFERENCES SerialPublication(ISSN)
);
-- Create above second

-- ALTER TABLE CONSTRAINTS

ALTER TABLE Users
ADD CONSTRAINT chk_email_format
CHECK (Email LIKE '%_@__%.__%');

ALTER TABLE Users
ADD CONSTRAINT chk_password_length CHECK (LEN(Password) >= 8);

ALTER TABLE Book
ADD CONSTRAINT chk_isbn_length CHECK (LEN(ISBN) = 13);

ALTER TABLE SerialPublication
ADD CONSTRAINT chk_issn_length CHECK (LEN(ISSN) = 8);


-- Insert Data Queries

INSERT INTO Author (AuthorID, FirstName, LastName, DOB, DOD) VALUES 
(1, 'George', 'Orwell', '1903-06-25', '1950-01-21'),
(2, 'J.K.', 'Rowling', '1965-07-31', NULL),
(3, 'Harper', 'Lee', '1926-04-28', '2016-02-19'),
(4, 'J.R.R.', 'Tolkien', '1892-01-03', '1973-09-02'),
(5, 'Jane', 'Austen', '1775-12-16', '1817-07-18'),
(6, 'Mark', 'Twain', '1835-11-30', '1910-04-21'),
(7, 'F. Scott', 'Fitzgerald', '1896-09-24', '1940-12-21'),
(8, 'Ernest', 'Hemingway', '1899-07-21', '1961-07-02'),
(9, 'Agatha', 'Christie', '1890-09-15', '1976-01-12'),
(10, 'Stephen', 'King', '1947-09-21', NULL),
(11, 'Isaac', 'Asimov', '1920-01-02', '1992-04-06'),
(12, 'Ray', 'Bradbury', '1920-08-22', '2012-06-05'),
(13, 'Arthur', 'Clarke', '1917-12-16', '2008-03-19'),
(14, 'Virginia', 'Woolf', '1882-01-25', '1941-03-28'),
(15, 'Charles', 'Dickens', '1812-02-07', '1870-06-09'),
(16, 'Mary', 'Shelley', '1797-08-30', '1851-02-01'),
(17, 'H.G.', 'Wells', '1866-09-21', '1946-08-13'),
(18, 'Leo', 'Tolstoy', '1828-09-09', '1910-11-20'),
(19, 'Emily', 'Brontë', '1818-07-30', '1848-12-19'),
(20, 'Herman', 'Melville', '1819-08-01', '1891-09-28'),
(21, 'Jules', 'Verne', '1828-02-08', '1905-03-24'),
(22, 'Aldous', 'Huxley', '1894-07-26', '1963-11-22'),
(23, 'George', 'Eliot', '1819-11-22', '1880-12-22'),
(24, 'John', 'Steinbeck', '1902-02-27', '1968-12-20'),
(25, 'Kurt', 'Vonnegut', '1922-11-11', '2007-04-11'),
(26, 'Toni', 'Morrison', '1931-02-18', '2019-08-05'),
(27, 'Gabriel', 'García Márquez', '1927-03-06', '2014-04-17'),
(28, 'Fyodor', 'Dostoevsky', '1821-11-11', '1881-02-09'),
(29, 'Franz', 'Kafka', '1883-07-03', '1924-06-03'),
(30, 'Oscar', 'Wilde', '1854-10-16', '1900-11-30');

INSERT INTO Book (ISBN, Title, Publisher, Genre, Subject, Edition) VALUES 
('9780451524935', '1984', 'Secker & Warburg', 'Dystopian', NULL, 1),
('9780439358071', 'Harry Potter and the Order of the Phoenix', 'Bloomsbury', 'Fantasy', NULL, 1),
('9780061120084', 'To Kill a Mockingbird', 'J.B. Lippincott & Co.', 'Fiction', NULL, 1),
('9780345339683', 'The Hobbit', 'Allen & Unwin', 'Fantasy', NULL, 2),
('9780141439518', 'Pride and Prejudice', 'T. Egerton', 'Romance', NULL, 1),
('9780486280615', 'Adventures of Huckleberry Finn', 'Charles L. Webster & Co.', 'Fiction', NULL, 1),
('9780743273565', 'The Great Gatsby', 'Charles Scribner''s Sons', 'Fiction', NULL, 1),
('9780684801223', 'The Old Man and the Sea', 'Charles Scribner''s Sons', 'Fiction', NULL, 1),
('9780062073488', 'And Then There Were None', 'Collins Crime Club', 'Mystery', NULL, 1),
('9781501142970', 'The Shining', 'Doubleday', 'Horror', NULL, 1),
('9780553293357', 'Foundation', 'Gnome Press', 'Science Fiction', NULL, 1),
('9781451673319', 'Fahrenheit 451', 'Ballantine Books', 'Science Fiction', NULL, 1),
('9780345413994', '2001: A Space Odyssey', 'New American Library', 'Science Fiction', NULL, 1),
('9780156027915', 'Mrs. Dalloway', 'Hogarth Press', 'Fiction', NULL, 1),
('9780141439563', 'A Tale of Two Cities', 'Chapman & Hall', 'Historical Fiction', NULL, 1),
('9780143131847', 'Frankenstein', 'Lackington, Hughes, Harding, Mavor & Jones', 'Gothic', NULL, 1),
('9780486419268', 'The War of the Worlds', 'Heinemann', 'Science Fiction', NULL, 1),
('9780199232765', 'War and Peace', 'The Russian Messenger', 'Historical Fiction', NULL, 1),
('9780141439785', 'Wuthering Heights', 'Thomas Cautley Newby', 'Gothic', NULL, 1),
('9780142437247', 'Moby-Dick', 'Harper & Brothers', 'Adventure', NULL, 1),
('9780451530851', 'Twenty Thousand Leagues Under the Sea', 'Pierre-Jules Hetzel', 'Adventure', NULL, 1),
('9780060850521', 'Brave New World', 'Chatto & Windus', 'Dystopian', NULL, 1),
('9780141441375', 'Middlemarch', 'William Blackwood & Sons', 'Fiction', NULL, 1),
('9780141185460', 'The Grapes of Wrath', 'The Viking Press', 'Fiction', NULL, 1),
('9780385333849', 'Slaughterhouse-Five', 'Delacorte', 'Science Fiction', NULL, 1),
('9781400033416', 'Beloved', 'Alfred A. Knopf', 'Fiction', NULL, 1),
('9780307389732', 'One Hundred Years of Solitude', 'Harper & Row', 'Magical Realism', NULL, 1),
('9780374528379', 'Crime and Punishment', 'The Russian Messenger', 'Philosophical Fiction', NULL, 1),
('9780805209990', 'The Trial', 'Verlag Die Schmiede', 'Philosophical Fiction', NULL, 1),
('9780141439693', 'The Picture of Dorian Gray', 'Lippincott''s Monthly Magazine', 'Philosophical Fiction', NULL, 1);

-- Insert above third

INSERT INTO AuthorToBook (AuthorID, ISBN) VALUES 
(1, '9780451524935'), -- George Orwell - 1984
(2, '9780439358071'), -- J.K. Rowling - Harry Potter and the Order of the Phoenix
(3, '9780061120084'), -- Harper Lee - To Kill a Mockingbird
(4, '9780345339683'), -- J.R.R. Tolkien - The Hobbit
(5, '9780141439518'), -- Jane Austen - Pride and Prejudice
(6, '9780486280615'), -- Mark Twain - The Adventures of Huckleberry Finn
(7, '9780743273565'), -- F. Scott Fitzgerald - The Great Gatsby
(8, '9780684801223'), -- Ernest Hemingway - The Old Man and the Sea
(9, '9780062073488'), -- Agatha Christie - And then there were none
(10, '9781501142970'), -- Stephen King - The Shining
(11, '9780553293357'), -- Isaac Asimov - Foundation
(12, '9781451673319'), -- Ray Bradbury - Fahrenheit 451
(13, '9780345413994'), -- Arthur Clarke - 2001: A Space Odyssey
(14, '9780156027915'), -- Virginia Woolf - Mrs. Dalloway
(15, '9780141439563'), -- Charles Dickens - A Tale of Two Cities
(16, '9780143131847'), -- Mary Shelley - Frankenstein
(17, '9780486419268'), -- H.G. Wells - The War of the Worlds
(18, '9780199232765'), -- Leo Tolstoy - War and Peace
(19, '9780141439785'), -- Emily Brontë - Wuthering Heights
(20, '9780142437247'), -- Herman Melville - Moby-Dick
(21, '9780451530851'), -- Jules Verne - Twenty Thousand Leagues Under the Sea
(22, '9780060850521'), -- Aldous Huxley - Brave New World
(23, '9780141441375'), -- George Eliot - Middlemarch
(24, '9780141185460'), -- John Steinbeck - The Grapes of Wrath
(25, '9780385333849'), -- Kurt Vonnegut - Slaughterhouse-Five
(26, '9781400033416'), -- Toni Morrison - Beloved
(27, '9780307389732'), -- Gabriel García Márquez - One Hundred Years of Solitude
(28, '9780374528379'), -- Fyodor Dostoevsky - Crime and Punishment
(29, '9780805209990'), -- Franz Kafka - The Trial
(30, '9780141439693'); -- Oscar Wilde - The Picture of Dorian Gray

INSERT INTO Library (LibraryID, Name) VALUES 
(1, 'Central City Library'),
(2, 'Gotham City Library'),
(3, 'Metropolis Public Library'),
(4, 'Star City Library'),
(5, 'Smallville Library'),
(6, 'Coast City Library'),
(7, 'Wellington City Library'),
(8, 'Los Angeles Public Library'),
(9, 'Chicago Public Library'),
(10, 'New York Public Library'),
(11, 'Seattle Public Library'),
(12, 'Boston Public Library'),
(13, 'San Francisco Public Library'),
(14, 'Miami-Dade Public Library'),
(15, 'Denver Public Library'),
(16, 'Houston Public Library'),
(17, 'Phoenix Public Library'),
(18, 'Atlanta-Fulton Public Library'),
(19, 'Dallas Public Library'),
(20, 'Philadelphia Free Library'),
(21, 'Detroit Public Library'),
(22, 'Cleveland Public Library'),
(23, 'Orlando Public Library'),
(24, 'Baltimore City Library'),
(25, 'New Orleans Public Library'),
(26, 'Las Vegas Clark County Library'),
(27, 'Portland Multnomah County Library'),
(28, 'Indianapolis Public Library'),
(29, 'San Diego Public Library'),
(30, 'Nashville Public Library');

INSERT INTO Users (Username, FirstName, LastName, Email, Password) VALUES 
('user01', 'John', 'Doe', 'johndoe@example.com', 'password123'),
('user02', 'Jane', 'Smith', 'janesmith@example.com', 'password123'),
('user03', 'Alice', 'Johnson', 'alicejohnson@example.com', 'password123'),
('user04', 'Bob', 'Brown', 'bobbrown@example.com', 'password123'),
('user05', 'Charlie', 'Davis', 'charliedavis@example.com', 'password123'),
('user06', 'Dana', 'Wilson', 'danawilson@example.com', 'password123'),
('user07', 'Eve', 'Moore', 'evemoore@example.com', 'password123'),
('user08', 'Frank', 'Taylor', 'franktaylor@example.com', 'password123'),
('user09', 'Grace', 'Anderson', 'graceanderson@example.com', 'password123'),
('user10', 'Hank', 'Thomas', 'hankthomas@example.com', 'password123'),
('user11', 'Ivy', 'Jackson', 'ivyjackson@example.com', 'password123'),
('user12', 'Jack', 'White', 'jackwhite@example.com', 'password123'),
('user13', 'Kim', 'Harris', 'kimharris@example.com', 'password123'),
('user14', 'Leo', 'Martin', 'leomartin@example.com', 'password123'),
('user15', 'Mia', 'Thompson', 'miathompson@example.com', 'password123'),
('user16', 'Nina', 'Garcia', 'ninagarcia@example.com', 'password123'),
('user17', 'Oscar', 'Martinez', 'oscarmartinez@example.com', 'password123'),
('user18', 'Paul', 'Robinson', 'paulrobinson@example.com', 'password123'),
('user19', 'Quinn', 'Clark', 'quinnclark@example.com', 'password123'),
('user20', 'Ray', 'Rodriguez', 'rayrodriguez@example.com', 'password123'),
('user21', 'Sara', 'Lewis', 'saralewis@example.com', 'password123'),
('user22', 'Tom', 'Lee', 'tomlee@example.com', 'password123'),
('user23', 'Uma', 'Walker', 'umawalker@example.com', 'password123'),
('user24', 'Vera', 'Hall', 'verahall@example.com', 'password123'),
('user25', 'Will', 'Allen', 'willallen@example.com', 'password123'),
('user26', 'Xena', 'Young', 'xenayoung@example.com', 'password123'),
('user27', 'Yara', 'King', 'yaraking@example.com', 'password123'),
('user28', 'Zane', 'Scott', 'zanescott@example.com', 'password123'),
('user29', 'Ava', 'Green', 'avagreen@example.com', 'password123'),
('user30', 'Ethan', 'Adams', 'ethanadams@example.com', 'password123');

-- Insert above fouth

INSERT INTO UsersToLibrary (Username, LibraryID) VALUES 
('user01', 1),
('user02', 2),
('user03', 3),
('user04', 4),
('user05', 5),
('user06', 6),
('user07', 7),
('user08', 8),
('user09', 9),
('user10', 10),
('user11', 11),
('user12', 12),
('user13', 13),
('user14', 14),
('user15', 15),
('user16', 16),
('user17', 17),
('user18', 18),
('user19', 19),
('user20', 20),
('user21', 21),
('user22', 22),
('user23', 23),
('user24', 24),
('user25', 25),
('user26', 26),
('user27', 27),
('user28', 28),
('user29', 29),
('user30', 30);

INSERT INTO SerialPublication (ISSN, Title, Publisher, Editor, Category, IllustratorName, SeriesTitle) VALUES 
('25149822', 'The Legend of Batman', 'DC Comics', NULL, 'Comic', 'Bob Kane', 'Batman'),
('30348730', 'Ultimate Spider-man', 'Marvel Comics', NULL, 'Comic', 'Mark Bagley', 'Spider-Man'),
('12461369', 'X-men', 'Marvel Comics', NULL, 'Comic', 'Jim Lee', 'X-Men'),
('22272860', 'The Walking Dead', 'Image Comics', NULL, 'Comic', 'Charlie Adlard', 'The Walking Dead'),
('1052102X', 'The Guardians of the Galaxy', 'Marvel', NULL, 'Magazine', 'Arnold Drake', 'The Guardians of the Galaxy'),
('18949843', 'Iron Man', 'Marvel', NULL, 'Comic', 'Bob Layton', 'Iron Man'),
('23287039', 'Maus', 'Pantheon Books', NULL, 'Comic', 'Art Spiegelman', 'Maus'),
('21648425', 'Superman', 'DC Comics', NULL, 'Comic', 'Joe Shuster', 'Superman'),
('09563903', 'Saga', 'Image Comics', NULL, 'Comic', 'Fiona Staples', 'Saga'),
('00931896', 'Hellboy', 'Dark Horse Comics', NULL, 'Comic', 'Mike Mignola', 'Hellboy'),
('0040781X', 'Time Magazine', 'Time Inc.', 'Sam Jacobs', 'Magazine', NULL, NULL),
('00279358', 'National Geographic', 'National Geographic Society', 'Nathan Lump', 'Magazine', NULL, NULL),
('0028792X', 'The New Yorker', 'Condé Nast', 'David Remnick', 'Magazine', NULL, NULL),
('00368733', 'Scientific American', 'Springer Nature', 'Mariette DiChristina', 'Magazine', NULL, NULL),
('00156914', 'Forbes', 'Forbes Media', 'Steve Forbes', 'Magazine', NULL, NULL),
('00428000', 'Vogue', 'Condé Nast', 'Anna Wintour', 'Magazine', NULL, NULL),
('0035791X', 'Rolling Stone', 'Penske Media Corporation', 'Gus Wenner', 'Magazine', NULL, NULL),
('10591028', 'Wired', 'Condé Nast', 'Scott Dadich', 'Magazine', NULL, NULL),
('21519463', 'The Atlantic', 'The Atlantic Monthly Group', 'Jeffrey Goldberg', 'Magazine', NULL, NULL),
('00140791', 'Esquire', 'Hearst Communications', 'Jay Fielden', 'Magazine', NULL, NULL),
('2376497X', 'The Amazing Spider-Man', 'Marvel Comics', NULL, 'Comic', 'John Romita Sr.', 'Spider-Man'),
('30141168', 'Wonder Woman', 'DC Comics', NULL, 'Comic', 'Harry G. Peter', 'Wonder Woman'),
('22587268', 'Detective Comics', 'DC Comics', NULL, 'Comic', 'James Tynion IV', 'Batman'),
('30152925', 'Green Lantern', 'DC Comics', NULL, 'Comic', 'Michael Green', 'Green Lantern'),
('02745240', 'Avengers', 'Marvel Comics', NULL, 'Comic', 'Jack Kirby', 'Avengers'),
('2150430X', 'Teen Titans', 'DC Comics', NULL, 'Comic', 'George Pérez', 'Teen Titans'),
('29979846', 'Fantastic Four', 'Marvel Comics', NULL, 'Comic', 'Jack Kirby', 'Fantastic Four'),
('26888777', 'Daredevil', 'Marvel Comics', NULL, 'Comic', 'Jimmy Palmiotti', 'Daredevil'),
('21649162', 'Justice League', 'DC Comics', NULL, 'Comic', 'Alex Ross', 'Justice League'),
('10997334', 'Thor', 'Marvel Comics', NULL, 'Comic', 'Jack Kirby', 'Thor');
INSERT INTO Author (AuthorID, FirstName, LastName, DOB, DOD) VALUES 
(31, 'Frank', 'Miller', '1957-01-27', NULL),
(32, 'Brian', 'Michael Bendis', '1967-08-01', NULL),
(33, 'Chris', 'Claremont', '1950-11-25', NULL),
(34, 'Robert', 'Kirkman', '1978-11-30', NULL),
(35, 'Dan', 'Abnett', '1965-10-12', NULL),
(36, 'Ted', 'Hughes', '1930-08-17', '1998-10-28'),
(37, 'Art', 'Spiegelman', '1948-02-15', NULL),
(38, 'Jerry', 'Siegel', '1914-10-07', '1996-01-28'),
(39, 'Brian', 'K. Vaughan', '1976-07-17', NULL),
(40, 'Mike', 'Mignola', '1960-09-16', NULL),
(41, 'Edward', 'Felsenthal', '1965-06-14', NULL),
(42, 'Nathan', 'Lump', 'NULL', NULL),
(43, 'David', 'Remnick', '1958-10-29', NULL),
(44, 'Mariette', 'DiChristina', '1966-09-02', NULL),
(45, 'Steve', 'Forbes', '1947-07-18', NULL),
(46, 'Anna', 'Wintour', '1949-11-03', NULL),
(47, 'Gus', 'Wenner', '1985-02-01', NULL),
(48, 'Scott', 'Dadich', '1983-04-19', NULL),
(49, 'Jeffrey', 'Goldberg', '1970-09-01', NULL),
(50, 'Jay', 'Fielden', '1965-05-18', NULL),
(51, 'Stan', 'Lee', '1922-12-28', '2018-11-12'),
(52, 'William', 'Moulton Marston', '1893-05-09', '1947-05-12'),
(53, 'Bill', 'Finger', '1914-02-08', '1974-01-18'),
(54, 'John', 'Broome', '1913-05-04', '1999-03-04'),
(55, 'Bob', 'Haney', '1926-03-15', '2004-11-25'),
(56, 'Gardner', 'Fox', '1911-05-20', '1986-12-24');

-- Insert above fifth

INSERT INTO AuthorToSerialPublication (AuthorID, ISSN) VALUES 
(31, '25149822'), -- Frank Miller - The Legend of Batman
(32, '30348730'), -- Brian Michael Bendis - Ultimate Spider-man
(33, '12461369'), -- Chris Claremont - X-Men
(34, '22272860'), -- Robert Kirkman - The Walking Dead
(35, '1052102X'), -- Dan Abnett - The Guardians of the Galaxy
(36, '18949843'), -- Ted Hughes - Iron Man
(37, '23287039'), -- Art Spiegelman - Maus
(38, '21648425'), -- Jerry Siegel - Superman
(39, '09563903'), -- Brian K. Vaughan - Saga
(40, '00931896'), -- Mike Mignola - Hellboy
(41, '0040781X'), -- Edward Felsenthal - Time Magazine
(42, '00279358'), -- Susan Goldberg - National Geographic
(43, '0028792X'), -- David Remnick - The New Yorker
(44, '00368733'), -- Mariette DiChristina - Scientific American
(45, '00156914'), -- Steve Forbes - Forbes
(46, '00428000'), -- Anna Wintour - Vogue
(47, '0035791X'), -- Gus Wenner - Rolling Stone
(48, '10591028'), -- Scott Dadich - Wired
(49, '21519463'), -- Jeffrey Goldberg - The Atlantic
(50, '00140791'), -- Jay Fielden - Esquire
(51, '2376497X'), -- Stan Lee - The Amazing Spider-Man
(52, '30141168'), -- William Moulton Marston - Wonder Woman
(53, '22587268'), -- Bill Finger - Detective Comics
(54, '30152925'), -- John Broome - Green Lantern
(51, '02745240'), -- Stan Lee - Avengers
(55, '2150430X'), -- Bob Haney - Teen Titans
(51, '29979846'), -- Stan Lee - Fantastic Four
(51, '26888777'), -- Stan Lee - Daredevil
(56, '21649162'), -- Gardner Fox - Justice League
(51, '10997334'); -- Stan Lee - Thor

INSERT INTO BooksInLibrary (LibraryID, ISBN) VALUES
(1, '9780451524935'),  
(1, '9780439358071'),  
(1, '9780345339683'),  
(1, '9780141439518'),  
(2, '9780451524935'),  
(2, '9780345339683'),  
(2, '9780486280615'),  
(2, '9780684801223'),  
(3, '9780439358071'),  
(3, '9780345339683'),  
(4, '9780141439518'),  
(4, '9780684801223'),  
(5, '9781451673319'),  
(5, '9780345413994'),  
(6, '9780553293357'),  
(6, '9780451524935'),  
(7, '9780345339683'),  
(7, '9780439358071'),  
(8, '9780141439518'),  
(8, '9780486280615'),  
(9, '9780345413994'),  
(9, '9780684801223'),  
(10, '9780451524935'), 
(10, '9780439358071'), 
(10, '9780345339683'), 
(11, '9780553293357'), 
(11, '9780345413994'), 
(11, '9781451673319'), 
(12, '9780486280615'), 
(12, '9780439358071'), 
(12, '9780345339683'); 

INSERT INTO SerialPublicationsInLibrary (LibraryID, ISSN) VALUES
(1, '25149822'), 
(1, '30348730'), 
(1, '12461369'), 
(1, '22272860'), 
(2, '1052102X'), 
(2, '18949843'), 
(2, '23287039'), 
(2, '21648425'), 
(3, '22272860'), 
(3, '25149822'),
(4, '30348730'), 
(4, '09563903'), 
(5, '21648425'), 
(5, '09563903'), 
(6, '12461369'), 
(6, '18949843'), 
(7, '1052102X'), 
(7, '21648425'), 
(8, '23287039'), 
(8, '30348730'), 
(9, '21648425'), 
(9, '22272860'), 
(10, '00931896'), 
(10, '12461369'), 
(10, '21648425'), 
(9, '25149822'), 
(8, '00931896'), 
(11, '18949843'), 
(6, '23287039'), 
(5, '30348730'), 
(11, '1052102X'); 

-- Insert above sixth

-- Write 10 Descriptive Aggregate, Joins, Subqueries

-- 1 Count of Books in each Library (count)
SELECT LibraryID, COUNT(ISBN) AS TotalBooks
FROM BooksInLibrary
GROUP BY LibraryID;

-- 2 Books and their Authors (join)
SELECT B.Title AS BookTitle, A.FirstName, A.LastName AS LastName
FROM Book B
JOIN AuthorToBook AB ON B.ISBN = AB.ISBN
JOIN Author A ON AB.AuthorID = A.AuthorID;

 -- 3 Authors and their Serial Publications (subquery)
SELECT SP.Title, (SELECT A.FirstName FROM Author A WHERE A.AuthorID = ATS.AuthorID) AS FirstName,
(SELECT A.LastName FROM Author A WHERE A.AuthorID = ATS.AuthorID) AS LastName
FROM SerialPublication SP
JOIN AuthorToSerialPublication ATS ON SP.ISSN = ATS.ISSN;

-- 4 Get all Books in user01's Library (join)
SELECT B.Title AS BookTitle FROM Book B 
JOIN BooksInLibrary BIL ON B.ISBN = BIL.ISBN 
JOIN UsersToLibrary UTL ON BIL.LibraryID = UTL.LibraryID
WHERE UTL.Username = 'user01'

-- 5 Get all Serial Publications in user01's Library 
SELECT S.Title AS SerialPublicationTitle FROM SerialPublication S 
JOIN SerialPublicationsInLibrary SIL ON S.ISSN = SIL.ISSN 
JOIN UsersToLibrary UTL ON SIL.LibraryID = UTL.LibraryID
WHERE UTL.Username = 'user01'

-- 6 Find how many libraries each User owns (count)
SELECT U.Username, COUNT(UL.LibraryID) AS LibraryCount
FROM Users U
LEFT JOIN UsersToLibrary UL ON U.Username = UL.Username
GROUP BY U.Username;


-- 7 All libraries with more than 2 Books (subquery)
SELECT L.LibraryID, L.Name FROM Library L
WHERE (SELECT COUNT(*) FROM BooksInLibrary BIL WHERE BIL.LibraryID = L.LibraryID) > 2;

-- 8 All Users with more than 2 Books
SELECT U.Username, COUNT(BIL.ISBN) AS BookCount
FROM Users U
JOIN UsersToLibrary UTL ON U.Username = UTL.Username
JOIN BooksInLibrary BIL ON UTL.LibraryID = BIL.LibraryID
GROUP BY U.Username HAVING COUNT(BIL.ISBN) > 1;

-- 9 All Users with more than 2 Serial Publications
SELECT U.Username, COUNT(SIL.ISSN) AS SerialPublicationCount
FROM Users U
JOIN UsersToLibrary UTL ON U.Username = UTL.Username
JOIN SerialPublicationsInLibrary SIL ON UTL.LibraryID = SIL.LibraryID
GROUP BY U.Username HAVING COUNT(SIL.ISSN) > 1;

-- 10 All Authors with more than 1 Serial Publication in the Database
SELECT A.FirstName, A.LastName, COUNT(ATS.ISSN) AS SerialPublicationCount
FROM Author A
JOIN AuthorToSerialPublication ATS ON A.AuthorID = ATS.AuthorID
GROUP BY A.FirstName, A.LastName HAVING COUNT(ATS.ISSN) > 1;


