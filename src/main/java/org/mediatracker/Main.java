package org.mediatracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MediaLibrary library = new MediaLibrary();

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

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter type (Manga, Manhwa, Manhua, Novel): ");
                    String type = scanner.nextLine();

                    System.out.print("Enter status (Reading, Completed, Planned, Dropped): ");
                    String status = scanner.nextLine();

                    System.out.print("Enter rating (0-10): ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine();

                    Media media = new Media(title, type, status, rating);
                    library.addMedia(media);

                    System.out.println("Media added successfully!");
                    break;

                case 2:
                    if (library.getAllMedia().isEmpty())
                        System.out.println("Your library is empty.");
                    else {
                        System.out.println("\n===== YOUR LIBRARY =====");

                        for (Media item : library.getAllMedia())
                            System.out.println(item);
                    }
                    break;

                case 3:
                    System.out.print("Enter the title to search for: ");
                    String searchTitle = scanner.nextLine();

                    Media found = library.searchByTitle(searchTitle);

                    if (found != null) {
                        System.out.println("Media found:");
                        System.out.println(found);
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("That option isn't implemented yet.");
                    break;
            }
        }
        scanner.close();
        System.out.println("Goodbye!");
    }
}