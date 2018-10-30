package Model;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Playlist implements Comparable<Playlist>{
	
	private String nome;
	List<Song> mysong;
	int sommadur=0;
	
	
	public Playlist(String nome) {
		this.nome=nome.toUpperCase();
		mysong = new LinkedList<>();
	}
	
	
	public void aggiungi(Song s) {
		mysong.add(s);
		sommadur = sommadur +s.getDurata();
	}
	
	public void rimuovi(Song s) {
		if(mysong.isEmpty()) return;
		int count=0;
		Iterator<Song> itr= mysong.iterator();
		Song sr;
		while(itr.hasNext()) {
			sr = itr.next();
			if(sr.equals(s)) {
			itr.remove();
			count++;
			sommadur = sommadur - sr.getDurata();
			}
		}if(count > 0) 
			System.out.println("\n  Rimozione della traccia : <"+ s.getNome()+"> presente nella playlist "+this.nome+" presente "+count+" volte");
		else
			System.out.println("\n  Traccia non trovata nella playlist corrente");
	}
		
	
	public void stampaPlaylist() {
		System.out.println("\n \tLa mia playlist: "+ this.nome +"\t durata totale plays: "+ sommadur+"sec. \n");
			for(Song s: mysong) {
				System.out.println(s);
			}
		}
	
	
	public int durataPlays() {
		for(Song s: mysong) {
			sommadur= sommadur + s.getDurata();
		}
		return sommadur;
	}
	
	
	public int canzoniDistinte() {
		List<Song> saveList= new LinkedList<>();
		saveList.add(mysong.get(0));
		for(Song s: mysong) {
			if(!(saveList.contains(s)))
					saveList.add(s);
		}return saveList.size();
	}
	
	
	public void ordinami() {
		Collections.sort(mysong);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public int compareTo(Playlist o) {
		if(!(this.sommadur == o.sommadur )) {
			if(this.sommadur < o.sommadur)
				return -1;
			else 
				return 1;
		}else
			return 0;
	   }


	@Override
	public String toString() {
		return "Playlist:< " + nome + ", " +sommadur + " sec. >";
	}



	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Playlist)) return false;
		
		Playlist psave= (Playlist) obj;
		
		return this.nome.equalsIgnoreCase(psave.nome) && this.sommadur == psave.sommadur;
	}
	
	
	
}
	
