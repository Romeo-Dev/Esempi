package MenageLib;

public class TestLib {

	public static void main(String[] args) {
		
		Libreria scaffale = new Libreria();
		Libro l1 = new Libro("a414","Algos lab");
		
		
		
		
		scaffale.addLibro(l1);
		
		//scaffale.removeLib("a414");
		
		scaffale.stampaColl();
	}

}
