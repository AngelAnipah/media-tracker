package org.mediatracker;

import java.util.ArrayList;

public class MediaLibrary {
    private ArrayList<Media> library;

    public MediaLibrary(){
        library = new ArrayList<>();
    }

    public void addMedia(Media media) {
        library.add(media);
    }

    public Media searchByTitle(String title) {
        for (Media item : library) {
            if (item.getTitle().equalsIgnoreCase(title))
                return item;
        }

        return null;
    }

    public boolean removeByTitle(String title) {
        Media media = searchByTitle(title);

        if (media != null) {
            library.remove(media);
            return true;
        }

        return false;
    }

    public boolean updateStatus(String title, String newStatus) {
        Media media = searchByTitle(title);

        if (media != null) {
            media.setStatus(newStatus);
            return true;
        }

        return false;
    }

    public boolean updateRating(String title, double newRating) {
        Media media = searchByTitle(title);

        if (media != null) {
            media.setRating(newRating);
            return true;
        }

        return false;
    }

    public ArrayList<Media> getALlMedia() {
        return new ArrayList<>(library);
    }
}
