package MenageLib;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Libreria {
	
	private List<Libro> lib;
	
	
	
	

	public Libreria() {
		super();
		this.lib = new LinkedList<>();
	}
	
	
	
	public boolean addLibro(Libro l) {
		if(l == null) {
			System.out.println("Nessun Libro inserito");
			return false;
		}
		if(this.lib.contains(l)) {
			System.out.println("Libro gia presente nella libreria");
			return false;
		}
		
		this.lib.add(l);
		System.out.println("Libro aggiunto nella libreria");
		return true;
	}
	
	
	
	public boolean checkLibro(String isbn) {
		if(isbn == null) {
			System.out.println("Nessun codice inserito");
			return false;
		}
		
		Libro check = new Libro(isbn);
		
		for(Libro l: this.lib) {
			
			if(l.equals(check)) {
				System.out.println("Trovato!");
				return true;
			}
		}
		System.out.println("Libro non trovato");
		return false;
	}
	
	
	
	
	public boolean removeLib(String isbn) {
		
		if(isbn == null) {
			System.out.println("Nessun codice inserito");
			return false;
		}
		
		Libro rem = new Libro(isbn);
		Libro find;
		
		Iterator<Libro> itr = this.lib.iterator();
		while (itr.hasNext()) {
			find = itr.next();
			
			if(find.equals(rem)) {
				
				itr.remove();
				System.out.println("Libro rimosso dalla libreria");
				return true;
			}
		}
		System.out.println("Libro non trovato");
		return false;
	}
	
	public void orderByIsbn() {
		
		Collections.sort(this.lib);
		System.out.println("Libreria ordinata per Isbn");
	}
	
	
	public void stampaColl() {
		
		if(this.lib.size() == 0) System.out.println("nessun libro presente nella libreria");
		for(Libro l: this.lib) {
			System.out.println(l);
		}
	}

	public List<Libro> getLib() {
		return lib;
	}

	public void setLib(List<Libro> lib) {
		this.lib = lib;
	}
	
	

}
