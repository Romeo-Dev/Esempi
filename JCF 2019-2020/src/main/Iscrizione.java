package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Iscrizione {

	
	List<Studente> iscrizioni;
	private String materia;
	
	public Iscrizione(String nome) {
		
		this.materia = nome;
		iscrizioni = new ArrayList<>();
		
	}

	
	
	
	public boolean addIscrizione(Studente s) {
		
		if(s == null) return false;
		
		this.iscrizioni.add(s);
		return true;
		
	}
	
	
	public boolean removeIsc(Studente s) {
		if(s == null) return false;
		Studente find;
		Iterator<Studente> itr = this.iscrizioni.iterator();
		while(itr.hasNext()) {
			find = itr.next();
			if(s.equals(find)) {
				itr.remove();
				System.out.println("Studente trovato e rimosso con successo");
				return true;
			}
		}
		System.out.println("Studente non trovato nella lista");
		return false;
	}
	
	
	
	public void stampaIscritti() {
		System.out.println(this);
	}
	
	
	public void order() {
		Collections.sort(this.iscrizioni);
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "Iscrizioni per l'esame di "+this.materia+": \n"+
				this.iscrizioni;
	}


	public List<Studente> getIscrizioni() {
		return iscrizioni;
	}

	public void setIscrizioni(List<Studente> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	
	
	
}
