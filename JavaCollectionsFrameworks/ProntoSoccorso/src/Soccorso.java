import java.util.ArrayList;
import java.util.Iterator;

public class Soccorso {
	ArrayList<Paziente> attesa;
	
	
	public Soccorso() {
		attesa = new ArrayList<>();
	}
	
	
	public void ingresso(String codice, int priorita) {
		Paziente control = new Paziente(codice,priorita);
		if(attesa.contains(control)) return ;
		int pos=0;
		for(Paziente p: attesa) {
			if(control.compareTo(p) > 0) pos++;
			else 
				break;
		}
		attesa.add(pos, control);
	}
	
	public Paziente dimissione() {
		Iterator<Paziente> itr = attesa.iterator();
		Paziente dim;
		
		while (itr.hasNext()) {
			dim = itr.next();
			itr.remove();
			return dim;
		}
		return null;
	}
	public void cambio(String codice, int nuovaPriorita) {
		
		Iterator<Paziente> itr = attesa.iterator();
		Paziente trova;
		
		while (itr.hasNext()) {
			trova = itr.next();
			if(trova.getCodice().equalsIgnoreCase(codice)) {
				itr.remove();
				trova.setPriorita(nuovaPriorita);
			 this.ingresso(trova.getCodice(),trova.getPriorita());
			 return;
			}
		}
		System.out.println("paziente non trovato");
		return ;
	}


	public ArrayList<Paziente> getAttesa() {
		return attesa;
	}
	public void stampa() {
		for(Paziente p: attesa) {
			System.out.println(p);
		}
	}
	
	
}
