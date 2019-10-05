import java.util.Comparator;

public class SortDecrease implements Comparator<Song> {
    @Override
    public int compare(Song o1, Song o2) {
        if (!(o1.getAnnoAlbum() == o2.getAnnoAlbum())){
            if (o1.getAnnoAlbum() < o2.getAnnoAlbum()) return 1;
            if (o1.getAnnoAlbum() > o2.getAnnoAlbum()) return -1;

        }
        return 0;
    }
}
