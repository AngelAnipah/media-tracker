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

    public ArrayList<Media> getALlMedia() {
        return new ArrayList<>(library);
    }
}
