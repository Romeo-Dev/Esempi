
public class TesterPortFoglio {

	public static void main(String[] args) {
		PortaMonete p = new PortaMonete();
		Moneta da1 = new Moneta("Uno",1);
		Moneta da2 = new Moneta("Due",2);
		Moneta da5 = new Moneta("Cinque",5);
		Moneta da10 = new Moneta("Dieci",10);
		Moneta da15= new Moneta("Quindici",15);
		Moneta da20 = new Moneta("Venti",20);
		Moneta da30 = new Moneta("Trenta",30);
		Moneta da40= new Moneta("Quaranta",40);
		Moneta da3= new Moneta("Tre",3);
		Moneta da50 = new Moneta("Cinquanta",50);
		Moneta da25= new Moneta(25);
		Moneta da35 = new Moneta(35);
		//-------------Inserimenti----------------
		p.addMoneta(da35);
		p.addMoneta(da25);
		p.addMoneta(da30);
		p.addMoneta(da25);
		p.addMoneta(da30);
		p.addMoneta(da5);
		p.addMoneta(da35);
		p.addMoneta(da1);
		p.addMoneta(da3);
		p.addMoneta(da15);
		p.addMoneta(da50);
		p.addMoneta(da3);
		p.addMoneta(da40);
		//--------------prova di stampa ---------------
		p.stampa();
		System.out.println("totale soldi nel portafoglio: "+p.getTotale());
		//-------------prova altri metodi--------------
		p.rimuovi(da35);
		//  FUNZIONA!  System.out.println(p.conteggio(da25));
		
		p.stampa();
		System.out.println("totale soldi nel portafoglio: "+p.getTotale());
	}

}
