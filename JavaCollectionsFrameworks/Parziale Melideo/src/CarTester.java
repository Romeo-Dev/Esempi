import java.util.Collections;

public class CarTester {

	
	public static void main(String[] args) {
		
		ListaAuto lista1= new ListaAuto();
		
		//inserisco delle auto nella mia lista
		
		Automobile a1=new Automobile("Fiat Punto","DJ244TC",2008,"DLGGNN77P58C632R");
		Automobile a2=new Automobile("Golf Gti","GJ238TC",2010,"DLGGNN77P58C632R");
		Automobile a3=new Automobile("Ford Focus","FJ224US",2005,"DLGGNN77P58C632R");
		Automobile a4=new Automobile("Opel Astra","OPJ244RA",2007,"DLGGNN77P58C632R");
		Automobile a5=new Automobile("Alfa Romeo","AL244EO",2006,"DLGGNN77P58C632R");
		Automobile a6=new Automobile("Ferrari Italia","FR244IT",2008,"DLGGNN77P58C632R");
		Automobile a7=new Automobile("Fiat Punto","DJ244TC",2008,"DLGGNN77P58C632R");
		lista1.insert(a1);
		lista1.insert(a2);
		lista1.insert(a3);
		lista1.insert(a4);
		lista1.insert(a5);
		lista1.insert(a6);
		System.out.println(lista1.insert(a7));//correttezza del metodo insert non inserisce un 
											  //auto identica
		
	//-----------------------------------------------------------------------------
		/*-----stampa la lista
		lista1.Stampa();
		System.out.println();*/
		
		
		/*----provo ad eliminare un elemento nella lista e a ristamparla
		lista1.delete("FR244IT");
		lista1.Stampa();*/
		
		/*sorto la mia lista per targa grazie al compareTo definito nella classe Automobile
		Collections.sort(lista1.list);
		lista1.Stampa();*/
		
		//adesso sorto per anno di immatricolazione grazie all interfaccia comparator(compare)
		Collections.sort(lista1.list, new SortablePerAnno());
		lista1.Stampa();
		
	}
	
}
