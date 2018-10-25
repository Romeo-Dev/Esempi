import java.util.Comparator;

public class SortablePerAnno implements Comparator<Automobile>{

	
	@Override
	public int compare(Automobile o1, Automobile o2) {
		if(o1.getImmatricolazione() < o2.getImmatricolazione()) return -1;
		
		if(o1.getImmatricolazione() > o2.getImmatricolazione()) return 1;
		
		if(o1.getImmatricolazione() == o2.getImmatricolazione()) return 0;
		
		return 0;
	}

}
