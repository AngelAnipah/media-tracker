package org.mediatracker;

public class Main {
    public static void main(String[] args) {
        MediaLibrary library = new MediaLibrary();
        library.addMedia(new Media("Berserk", "Manga", "Reading", 9.5));

        boolean statusUpdated = library.updateStatus("Berserk", "Completed");
        boolean ratingUpdated = library.updateRating("Berserk", 10.0);

        library.addMedia(new Media("Solo Leveling", "Manhwa", "Planned", 8.0));
        library.addMedia(new Media("Reverend Insanity", "Novel", "Planned", 8.5));

        System.out.println("Status updated: " + statusUpdated);
        System.out.println("Rating updated: " + ratingUpdated);

        Media result = library.searchByTitle("Berserk");
        System.out.println(result);
    }
}