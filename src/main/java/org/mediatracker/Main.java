package org.mediatracker;

public class Main {
    public static void main(String[] args) {
        Media manga = new Media("Berserk", "Manga", "Reading", 9.5);

        System.out.println("Title: " + manga.getTitle());
        System.out.println("Type: " + manga.getType());
        System.out.println("Status: " + manga.getStatus());
        System.out.println("Rating: " + manga.getRating());
    }
}