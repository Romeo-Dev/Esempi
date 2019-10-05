package main;

public class Studente implements Comparable<Studente> {
	
	private String nome, cognome, matricola;

	public Studente(String nome, String cognome, String matricola) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Studente)) return false;
		
		Studente s = (Studente) obj;
		
		return this.matricola.equalsIgnoreCase(s.matricola);
		
	}

	@Override
	public String toString() {
		
		return "\nCognome: \t"+ this.cognome+"\n"+
				"Nome: \t"+ this.nome +"\n"+
				"Matricola: \t"+ this.matricola+"\n";
	}

	@Override
	public int compareTo(Studente o) {
		if(!(this.cognome.compareTo(o.cognome) == 0)) {
			if(this.cognome.compareTo(o.cognome) > 0) return 1;
			if(this.cognome.compareTo(o.cognome) < 0) return -1;
		}else
			if(!(this.matricola.compareTo(o.matricola) == 0)) {
				if(this.matricola.compareTo(o.matricola) > 0) return 1;
				if(this.matricola.compareTo(o.matricola) < 0) return -1;
			}
		return 0;
	}
	
	

}
