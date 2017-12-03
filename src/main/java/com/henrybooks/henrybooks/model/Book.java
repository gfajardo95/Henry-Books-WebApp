package com.henrybooks.henrybooks.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    private String bookCode;
    private String title;
    private String publisherCode;
    private String type;
    private String paperback;

    @Id
    @Column(name = "bookCode")
    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "publisherCode")
    public String getPublisherCode() {
        return publisherCode;
    }

    public void setPublisherCode(String publisherCode) {
        this.publisherCode = publisherCode;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "paperback")
    public String getPaperback() {
        return paperback;
    }

    public void setPaperback(String paperback) {
        this.paperback = paperback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (bookCode != null ? !bookCode.equals(book.bookCode) : book.bookCode != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (publisherCode != null ? !publisherCode.equals(book.publisherCode) : book.publisherCode != null)
            return false;
        if (type != null ? !type.equals(book.type) : book.type != null) return false;
        if (paperback != null ? !paperback.equals(book.paperback) : book.paperback != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookCode != null ? bookCode.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (publisherCode != null ? publisherCode.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (paperback != null ? paperback.hashCode() : 0);
        return result;
    }
}
