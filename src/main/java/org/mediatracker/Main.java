package org.mediatracker;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Media> library = new ArrayList<>();

        Media manga = new Media("Berserk", "Manga", "Reading", 9.5);
        Media manhwa = new Media("Solo Leveling", "Manhwa", "Planned", 8.0);
        Media novel = new Media("Reverend Insanity", "Novel", "Planned", 8.5);

        library.add(manga);
        library.add(manhwa);
        library.add(novel);

        for (Media item: library)
            System.out.println(item);
    }
}