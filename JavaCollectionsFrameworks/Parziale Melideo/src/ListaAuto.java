
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListaAuto{
List<Automobile> list;

public ListaAuto() {
	super();
	List<Automobile> list = new LinkedList<>();
	this.list = list;
}
   
	/*si puo usare il metodo list.contains(x) per vedere se l elemento
	 * gia presiste nella lista in base all if di quesa faccio add
	 * senza usare iterator*/

	public boolean insert(Automobile a1) {
		Iterator<Automobile> itr =list.iterator();
		while(itr.hasNext()) {
			Automobile a2= itr.next();
			if(a1.equals(a2)) return false;
		}list.add(a1);
		return true;
	}
	
	
	public boolean delete(String a1) {
		Iterator<Automobile> itr =list.iterator();
	//--controllo se  la lista e vuota
		if(list.isEmpty()) return false;
	//-- se non lo è parto con l iterator		
		Automobile a2;
		while(itr.hasNext()) {
			a2= itr.next();
			if(a2.getTarga().equalsIgnoreCase(a1)) {
				itr.remove();
				return true;
			}
		}return false;
	}
	
	
	public void Stampa() {
		Iterator<Automobile> itr= list.iterator();
		while(itr.hasNext()) {
			Automobile a1= itr.next();
			System.out.println(a1);
		}
	}

   
}
