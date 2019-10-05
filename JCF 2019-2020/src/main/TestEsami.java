package main;

public class TestEsami {

	public static void main(String[] args) {
		
		
		Iscrizione isc1 = new Iscrizione("Laboratiorio Algoritmi");
		Iscrizione  isc2 = new Iscrizione("Reti di Calcolatori");
		
		Studente s1 = new Studente("Romeo", "De Vicnentis", "247912");
		Studente s2 = new Studente("Landon", "De Norris", "247816");
		Studente s3 = new Studente("Max", "Verstappen", "247552");
		Studente s4 = new Studente("Carlos", "Sainz", "2489912");
		Studente s5 = new Studente("Pastor", "Maldonado", "347912");
		
		isc1.addIscrizione(s1);
		isc1.addIscrizione(s2);
		isc1.addIscrizione(s5);
		isc1.stampaIscritti();
		
		isc1.removeIsc(s5);
		
		isc1.stampaIscritti();
		
		isc1.order();
		
	}

}
