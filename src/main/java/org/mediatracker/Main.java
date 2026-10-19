package org.mediatracker;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MediaLibrary library = new MediaLibrary();
        library.addMedia(new Media("Berserk", "Manga", "Reading", 9.5));
        library.addMedia(new Media("Solo Leveling", "Manhwa", "Planned", 8.0));
        library.addMedia(new Media("Reverend Insanity", "Novel", "Planned", 8.5));

        Media result = library.searchByTitle("bleach");

        if (result != null)
            System.out.println("Found: " + result);
        else
            System.out.println("Media not found.");
    }
}