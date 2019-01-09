/*Esercizio 1 Implementare due classi Song e Playlist. Una canzone è caratterizzata da (i) titolo (String), (ii) nome
        dell’artista o del gruppo che interpreta la canzone (String), (iii) album (String) da cui è estratta la canzone, e (iv)
        anno di produzione dell’album (int). La classe Song è dotata di ordinamento naturale basato sull’anno di
        produzione dell’album.
        Una playlist è una lista di canzoni priva di elementi duplicati. La classe Playlist supporta le seguenti operazioni:
        1. cancellare una data canzone dalla lista,
        2. verificare se la lista contiene una data canzone,
        3. inserire una data canzone in coda alla lista (l’inserimento fallisce se la canzone è già presente in lista),
        4. ordinare la lista in ordine crescente rispetto all’anno di produzione dell’album,
        5. ordinare la lista in ordine decrescente rispetto all’anno di produzione dell’album,
        6. contare per ogni anno di produzione presente in playlist, il numero di canzoni della playlist che sono
        state pubblicate in quello specifico anno.*/
public class Song implements Comparable<Song>{

    private String titolo, artista, album;
    private int annoAlbum;

    public Song(String titolo, String artista, String album, int annoAlbum) {
        this.titolo = titolo.toUpperCase();
        this.artista = artista;
        this.album = album;
        this.annoAlbum = annoAlbum;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getAnnoAlbum() {
        return annoAlbum;
    }

    public void setAnnoAlbum(int annoAlbum) {
        this.annoAlbum = annoAlbum;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Song)) return false;
        Song s = (Song) obj;
        return this.titolo.equalsIgnoreCase(s.titolo);
    }

    @Override
    public String toString() {
        return "Titolo: "+this.titolo+"\t Artista: "+this.artista+"\n"+
                "Album: "+this.album+"\t Anno Album: "+this.annoAlbum+"\n"+
                "-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*---->\n";
    }

    /*public static Map<Integer,Integer> meregeDiSet(TreeSet<Integer> set1, TreeSet<Integer> set2){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        if (!(set1.size() == set2.size())) return null;
        Iterator<Integer> itr1 = set1.iterator();
        Iterator<Integer> itr2 = set2.iterator();
        Integer s1;
        Integer s2;
        while (itr1.hasNext() && itr2.hasNext()){
            s1 = itr1.next();
            s2 = itr2.next();
            map.put(s1,s2);
        }
        return map;
    }*/

    @Override
    public int compareTo(Song o) {
        if (!(this.annoAlbum == o.annoAlbum)){
            if (this.annoAlbum < o.annoAlbum) return -1;
            if (this.annoAlbum > o.annoAlbum) return 1;

        }
        return 0;
    }
}
