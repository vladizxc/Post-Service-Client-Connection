package org.codekitchen.socialnetworkwebapplication.entity.dto.request;

public class UpdatePostRequest {
    private final String author;
    private final String title;
    private final int numberOfLikes;
    private final int numberOfDislikes;

    public UpdatePostRequest(String author, String title, int numberOfLikes, int numberOfDislikes) {
        this.author = author;
        this.title = title;
        this.numberOfLikes = numberOfLikes;
        this.numberOfDislikes = numberOfDislikes;
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
}
