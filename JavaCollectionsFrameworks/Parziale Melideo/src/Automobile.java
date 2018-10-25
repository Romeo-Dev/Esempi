
import java.lang.Comparable;

public class Automobile implements Comparable<Automobile>{
	private String modello;
	private String targa;
	private int immatricolazione;
	private String codfis;
	
	
	
	public Automobile(String modello, String targa, int immatricolazione, String codfis) {
		super();
		this.modello = modello;
		this.targa = targa.toUpperCase();
		this.immatricolazione = immatricolazione;
		this.codfis = codfis.toUpperCase();
	}



	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public int getImmatricolazione() {
		return immatricolazione;
	}

	public void setImmatricolazione(int immatricolazione) {
		this.immatricolazione = immatricolazione;
	}

	public String getCodfis() {
		return codfis;
	}

	public void setCodfis(String codfis) {
		this.codfis = codfis;
	}



	@Override
	public String toString() {
		return "\n Automobile modello: " + modello + "\n targa: " + targa + "\n immatricolazione: " + immatricolazione
				+ "\n CodiceFiscale: " + codfis;
	}
	
	public boolean equals(Object obj) {
		if(obj ==null) return false;
		if(!(obj instanceof Automobile)) return false;
		
		Automobile a1=(Automobile) obj;
		return this.getTarga().equalsIgnoreCase(a1.getTarga());
	}



	/*per il compare to potevamo usare il seguente metodo:
	 * return this.targa.compareTo(o.targa); usa direttamente il compareTo definito
	 * da string che confronta tutti i char della stringa*/
	
	@Override
	public int compareTo(Automobile o) {
			int i=0;
			while(i<=7 && this.getTarga().charAt(i)==(o.getTarga().charAt(i))) {
				i++;
			}
				if(this.getTarga().charAt(i)<(o.getTarga().charAt(i))) return -1;
				
				if(this.getTarga().charAt(i)>(o.getTarga().charAt(i))) return 1; 
			
				return 0;
	}
	
	
	
}
