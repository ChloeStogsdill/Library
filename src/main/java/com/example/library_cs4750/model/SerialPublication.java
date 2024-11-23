package com.example.library_cs4750.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SerialPublication")
public class SerialPublication {

    @Id
    @Column(name = "ISSN", length = 8)
    private String issn;

    @Column(name = "Title", length = 100)
    private String title;

    @Column(name = "Publisher", length = 100)
    private String publisher;

    @Column(name = "Editor", length = 100)
    private String editor;

    @Column(name = "Category", length = 50)
    private String category;

    @Column(name = "IllustratorName", length = 100)
    private String illustratorName;

    @Column(name = "SeriesTitle", length = 100)
    private String seriesTitle;

    public SerialPublication() {
    }

    public SerialPublication(String issn, String title, String publisher, String editor, String category, String illustratorName, String seriesTitle) {
        this.issn = issn;
        this.title = title;
        this.publisher = publisher;
        this.editor = editor;
        this.category = category;
        this.illustratorName = illustratorName;
        this.seriesTitle = seriesTitle;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIllustratorName() {
        return illustratorName;
    }

    public void setIllustratorName(String illustratorName) {
        this.illustratorName = illustratorName;
    }

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }
}
