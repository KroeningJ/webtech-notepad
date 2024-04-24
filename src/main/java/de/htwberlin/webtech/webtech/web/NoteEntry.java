package de.htwberlin.webtech.webtech.web;



import java.util.Date;

public class NoteEntry {
    private String title;
    private String content;
    private Date createdDate;
    private Date lastModifiedDate;

    public NoteEntry(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdDate = new Date();
        this.lastModifiedDate = new Date();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setTitle(String title) {
        this.title = title;
        this.lastModifiedDate = new Date();
    }

    public void setContent(String content) {
        this.content = content;
        this.lastModifiedDate = new Date();
    }
}
