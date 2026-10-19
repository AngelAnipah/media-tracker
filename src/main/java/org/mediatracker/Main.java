package org.mediatracker;

public class Main {
    public static void main(String[] args) {
        MediaLibrary library = new MediaLibrary();
        library.addMedia(new Media("Berserk", "Manga", "Reading", 9.5));
        library.addMedia(new Media("Solo Leveling", "Manhwa", "Planned", 8.0));
        library.addMedia(new Media("Reverend Insanity", "Novel", "Planned", 8.5));

        boolean removed = library.removeByTitle("berserk");
        System.out.println("Removed Berserk: "  + removed);

        System.out.println("\nRemaining library:");
        for (Media item : library.getALlMedia())
            System.out.println(item);
    }
}