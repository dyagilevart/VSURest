package com.example.dyagilev.vsurest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.Streams;

import java.util.Date;

public class NewsObject {

    @SerializedName("Description")
    @Expose
    private String description;

    @SerializedName("Id")
    @Expose
    private Integer id;

    @SerializedName("Title")
    @Expose
    private String title;

    @SerializedName("Date")
    @Expose
    private String date;

    @SerializedName("Author")
    @Expose
    private String author;

    @SerializedName("Type")
    @Expose
    private String type;

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) { this.type = type; }
}