import java.util.*;

public class Playlist {


    LinkedList<Song> plays ;


    public Playlist() {
        plays = new LinkedList<>();
    }


    public boolean rimSong(Song s) {
        if (plays.contains(s)) {
            plays.remove(s);
            System.out.println("canzone -" + s.getTitolo() + "- rimossa con successo");
            return true;
        } else {
            System.out.println(s.getTitolo() + " non presente nella mia playlist");
            return false;
        }
    }

    public boolean research(Song s){
            if (plays.contains(s)){
                System.out.println("Si -"+s.getTitolo()+"- e presente nella mia playlist");
                return true;
            }else{
                System.out.println("No -"+s.getTitolo()+"- e presente nella mia playlist");
                return false;
            }
        }


    public void inserimento(Song s){

        if (!(plays.contains(s))){
            plays.addLast(s);
        }

    }

    public TreeSet<Song> orderByDecrase(){
        TreeSet<Song> ordered = new TreeSet<>(new SortDecrease());
        ordered.addAll(plays);
        return ordered;
    }


    public void stampaAnnoCres(){
        System.out.println(this.plays);
    }


    public Map<Integer,Integer> occByAnno(){
        TreeMap<Integer,Integer> tree = new TreeMap<>();
        if (plays.isEmpty()) return null;
        for (Song s: plays) {
            tree.put(s.getAnnoAlbum(),0);
        }
        Iterator<Song> itr = plays.iterator();
        Song s;
        while (itr.hasNext()){
            s= itr.next();
            if (tree.containsKey(s.getAnnoAlbum())){
                tree.put(s.getAnnoAlbum(),tree.get(s.getAnnoAlbum())+1);
            }
        }
       return tree;
    }

    public Map<Integer,LinkedList<String>> raggruppaPerAnno(){
        TreeMap<Integer,LinkedList<String>> tree = new TreeMap<>();
        if (plays.isEmpty()) return  null;
        for (Song s: plays) {
            tree.put(s.getAnnoAlbum(),new LinkedList<>());
        }

        LinkedList<String> list = new LinkedList<>();
        Iterator<Song> itr = plays.iterator();
        Song s;
        while (itr.hasNext()){
            s = itr.next();
            if (tree.containsKey(s.getAnnoAlbum())){
                list = tree.get(s.getAnnoAlbum());
                list.add(s.getTitolo());
                tree.put(s.getAnnoAlbum(),list);
            }
        }
        return tree;
    }

    public Map<String, LinkedList<String>> iMieiArtisti(){
        TreeMap<String,LinkedList<String>> map = new TreeMap<>();
        if (plays.isEmpty()) return null;
        for (Song s:plays) {
            map.put(s.getArtista(),new LinkedList<String>());
        }

        LinkedList<String> save = new LinkedList<>();
        Iterator<Song> itr = plays.iterator();
        Song s ;
        while (itr.hasNext()){
            s =itr.next();
            if (map.containsKey(s.getArtista())){
                save = map.get(s.getArtista());
                save.add(s.getTitolo());
                map.put(s.getArtista(),save);
            }
        }
        return map;
    }

}
