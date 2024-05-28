package com.sax;

import javax.xml.bind.annotation.XmlAttribute;

public class Book {
    private String id;
    private String author;
    private String title;
    private String genre;
    private Double price;
    private String publishDate;
    private String description;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getId()+ " " + getTitle() + " " + getAuthor()
                + " " + getDescription() + " " + getPrice()
                + " " + getGenre() + " " + " " + getPublishDate()
                + " \n";
    }
}
