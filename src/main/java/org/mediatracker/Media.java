package org.mediatracker;

public class Media {
    private String title;
    private String type;
    private String status;
    private double rating;

    public Media(String title, String type, String status, double rating) {
        this.title = title;
        this.type = type;
        this.status = status;
        setRating(rating);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating < 0.0 || rating > 10.0) {
            throw new IllegalArgumentException("Rating must be between 0 and 10.");
        }

        this.rating = rating;
    }
}
