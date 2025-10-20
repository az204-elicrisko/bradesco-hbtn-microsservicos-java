package com.example.demo;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;

@Repository
public class SongRepository {
    private List<Song> list = new ArrayList<Song>();

    // Construtor que inicializa a lista com duas músicas
    public SongRepository() {
        list.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975"));
        list.add(new Song(2, "Imagine", "John Lennon", "Imagine", "1971"));
    }

    public List<Song> getAllSongs() {
    return list;
    }

    public Song getSongById(Integer id) {
        // TODO
    }

    public void addSong(Song s) {
        // TODO
    }

    public void updateSong(Song s) {
        // TODO
    }

    public void removeSong(Song s) {
        // TODO
    }
}
