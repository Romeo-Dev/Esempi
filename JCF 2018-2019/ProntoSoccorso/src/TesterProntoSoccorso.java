
public class TesterProntoSoccorso {

	
	public static void main(String[] args) {
		 Soccorso pescina = new Soccorso();
		 
		 
		 pescina.ingresso("zx66zutwj", 1);
		 pescina.ingresso("Aavb32zutwj", 0);
		 pescina.ingresso("74zutwj", 2);
		 pescina.ingresso("torinsct",1);
		 pescina.ingresso("cortellessa",1);
		 pescina.ingresso("abcdefc",1);
		 pescina.ingresso("yolosolo",9);
		 pescina.ingresso("yolosolo",9);
		 pescina.ingresso("thewitcher",2);
		 pescina.ingresso("thewitcher",2);
		 
		 pescina.stampa();
		 
		 pescina.cambio("thewitcher",1);
		 pescina.cambio("yolosolo",2);
		  
		 System.out.println();
		 pescina.stampa();
		 
		 pescina.dimissione();
		 pescina.dimissione();
		 pescina.dimissione();
		 
		 
		 System.out.println();
		 pescina.stampa();
		 
	}

}
