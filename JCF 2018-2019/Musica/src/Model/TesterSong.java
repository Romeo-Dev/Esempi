package Model;
public class TesterSong {
	public static void main(String[] args) {
		
		
	//--------la mia raccolta----------
	Raccolta r1= new Raccolta("myRaccolta");
	//--------Le mie Playlist----------	
	Playlist p1= new Playlist("Svago");
	Playlist p2= new Playlist("Mood");
	Playlist p3= new Playlist("Caffe");
		//----Le mie song-------------
	    Song so1=new Song("Unica","Ozuna",201);
		Song so2=new Song("Dont leave me alone","David Guetta",201);
		Song so3=new Song("Like i do","David Guetta",201);
		Song so4=new Song("La Modelo","Ozuna",232);
		Song so5=new Song("Bling bling","Gue Peq.",200);
		Song so6=new Song("Rescue me","Thirty seconds to mars",169);
		Song so7=new Song("Dangerous night","Thirty seconds to mars",222);
		Song so8=new Song("Love is madness","Thirty seconds to mars",189);
		Song so9=new Song("The spectre","Alan Walker",180);
		Song so10=new Song("Faded","Alan Walker",202);
		Song so11=new Song("Darkside","Alan Walker",345);
		Song so12=new Song("It aint me","Kygo",267);
		Song so13=new Song("Ignite","Alan Walker",252);
		Song so14=new Song("Till i collapse","Eminem",482);
		Song so15=new Song("Next epsode","Dr. dre",320);
		Song so16=new Song("Numb","Linkin park",340);
		Song so17=new Song("what i ve done","Linkin park",280);
		Song so18=new Song("Oh child","Robin schulz",520);
		
		// assignments
		
		p1.aggiungi(so13);
		p1.aggiungi(so1);
		p1.aggiungi(so11);
		p1.aggiungi(so7);
		p1.aggiungi(so9);
		p1.aggiungi(so3);
		p1.aggiungi(so2);
		p1.aggiungi(so13);
		p1.aggiungi(so13);
		p1.aggiungi(so13);
		//---------------
		p2.aggiungi(so12);
		p2.aggiungi(so10);
		p2.aggiungi(so8);
		p2.aggiungi(so5);
		p2.aggiungi(so3);
		p2.aggiungi(so6);
		p2.aggiungi(so4);
		//---------------
		p3.aggiungi(so18);
		p3.aggiungi(so18);
		p3.aggiungi(so17);
		p3.aggiungi(so15);
		p3.aggiungi(so1);
		p3.aggiungi(so8);
		p3.aggiungi(so14);
		p3.aggiungi(so13);
		//-----stampa playlist-----
		p1.stampaPlaylist();
		p2.stampaPlaylist();
		p3.stampaPlaylist();
		//----rimozioni varie dalla plays--------
		p1.rimuovi(so1);
		p1.rimuovi(so2);
		p3.rimuovi(so18);
		//----provo riordinamento per durata-----
		p1.ordinami();
		p1.stampaPlaylist();
		//----provo il metodo esercizio 1------
		System.out.println("\n le canzoni distinte presenti nella playlist "+p1.getNome()+" sono: "+p1.canzoniDistinte());
		System.out.println("\n Riordino la mia raccolta di playlist in base alla durata:\n");
		//faccio l add--------------
		r1.insertrac(p1);
		r1.insertrac(p2);
		r1.insertrac(p3);
		//ordino--------------
		r1.ordinaRacc();
		//stampo----------------
		r1.myraccolta();
		
		
	}
}
