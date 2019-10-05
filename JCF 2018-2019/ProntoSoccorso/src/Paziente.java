
public class Paziente implements Comparable<Paziente>{

	private String codice;
	private String nome;
	private String cognome;
	private int priorita;
	
	
	
	public Paziente(String codice) {
		this.codice = codice;
	}
	
	
	public Paziente(String codice, String nome, String cognome, int priorita) {
		
		this.codice = codice.toUpperCase();
		this.nome = nome;
		this.cognome = cognome;
		this.priorita = priorita;
	}

	public Paziente(String codice,int priorita) {
		
		this.codice = codice.toUpperCase();
		this.priorita = priorita;
	}


	
	
	


	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
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

	public int getPriorita() {
		if(priorita < 0 || priorita > 2) {
			this.setPriorita(0);
		}
		return priorita;
	}

	public void setPriorita(int priorita) {
		this.priorita = priorita;
	}

	
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Paziente))return false;
		
		Paziente paz=(Paziente) obj;
		return this.codice.equalsIgnoreCase(paz.codice);
	}

	@Override
	public String toString() {
		return "\ncodice: " + codice + "\t priorita: " + this.getPriorita()+"\nNome: "+nome+"\t Cognome: "+cognome;
	}

	@Override
	public int compareTo(Paziente o) {
		if(!(this.getPriorita() == o.getPriorita())) {
			if((this.getPriorita() > o.getPriorita())) return -1;
			if((this.getPriorita() < o.getPriorita())) return 1;
		}
		return 0;
	}

}
