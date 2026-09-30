package org.codekitchen.socialnetworkwebapplication.entity.dto;

import java.time.LocalDate;

public class PostDto {
    private int id;
    private String author;
    private String title;
    private int numberOfLikes;
    private int numberOfDislikes;
    private LocalDate creationTime;

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public int getNumberOfDislikes() {
        return numberOfDislikes;
    }

    public LocalDate getCreationTime() {
        return creationTime;
    }
}
