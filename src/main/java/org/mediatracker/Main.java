package org.mediatracker;

import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);

        int choice = -1;

        while (choice != 0) {
            System.out.println("\n===== MEDIA TRACKER =====");
            System.out.println("1. Add media");
            System.out.println("2. View all media");
            System.out.println("3. Search by title");
            System.out.println("4. Update status");
            System.out.println("5. Update rating");
            System.out.println("6. Remove media");
            System.out.println("0. Exit");
            System.out.println("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("You chose: " + choice);
        }
        scanner.close();
        System.out.println("Goodbye!");
    }
}