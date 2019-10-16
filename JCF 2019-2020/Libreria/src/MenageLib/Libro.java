package MenageLib;

import java.util.ArrayList;
import java.util.List;

public class Libro implements Comparable<Libro> {
	
	private String isbn;
	private String nome;
   	List<String> autori;
   	
   	
   	
	public Libro(String isbn, String nome) {
		super();
		this.isbn = isbn;
		this.nome = nome;
	}

	public Libro(String isbn) {
		super();
		this.isbn = isbn;
	}


	public Libro(String isbn, String nome, String a1) {
		super();
		this.isbn = isbn;
		this.nome = nome;
		this.autori = new ArrayList<String>();
		
		this.autori.add(a1);
	}
   	
	public Libro(String isbn, String nome, String a1, String a2) {
		super();
		this.isbn = isbn;
		this.nome = nome;
		this.autori = new ArrayList<String>();
		
		this.addAuthor(a1);
		this.addAuthor(a2);
	}



	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public List<String> getAutori() {
		return autori;
	}



	public void setAutori(List<String> autori) {
		this.autori = autori;
	}
   	
   	
	
	public boolean addAuthor(String a1) {
		
		if(this.autori.contains(a1)) return false;
		
		this.autori.add(a1);
		return true;
	}



	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Libro)) return false;
		
		Libro l1 = (Libro) obj;
		
		return this.isbn.equalsIgnoreCase(l1.isbn);
	}



	@Override
	public String toString() {
		return "Codice ISBN : "+ this.isbn + "\n" +
				"Titolo : "+ this.nome + "\n" +
				"Autori : "+ this.autori + "\n";
	}



	@Override
	public int compareTo(Libro o) {
		
		if(!(this.isbn.compareTo(o.isbn) == 0)) {
			
			if(this.isbn.compareTo(o.isbn) > 0) return 1;
			
			if(this.isbn.compareTo(o.isbn) < 0) return -1;
		}
		return 0;
	}
   	
	
	

}
