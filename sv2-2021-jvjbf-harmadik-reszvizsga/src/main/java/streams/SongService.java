package streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SongService {

    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public Optional<Song> shortestSong() {
        return songs.stream()
                .min(Comparator.comparingInt(Song::getLength));
    }

    public List<Song> getSongs() {
        return songs;
    }

    public List<Song> findSongByTitle(String title) {
        return songs.stream()
                .filter(song -> song.getTitle().equals(title))
                .toList();
    }

    public boolean isPerformerInSong(Song song, String title) {
        return songs.stream()
                .anyMatch(s -> s.equals(song) && s.getPerformers().contains(title));
    }


    public  List<String> titlesBeforeDate(LocalDate date) {
        return songs.stream()
                .filter(song -> song.getRelease().isBefore(date))
                .map(song -> song.getTitle())
                .toList();
    }
}
