import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PortaMonete {
		List <Moneta> portafoglio;

		public PortaMonete() {
			
			portafoglio = new LinkedList<>();
		}
		
		public void addMoneta(Moneta m) {
			int index=0;
			for(Moneta mon: portafoglio) {
				if(m.compareTo(mon) > 0) index++;
				else
					break;
			}
			portafoglio.add(index, m);
			return ;
		}
		
		
		public int conteggio(Moneta m) {
			if(!(portafoglio.contains(m))) return 0;
			int cont=0;
			for(Moneta monet: portafoglio) {
				if(monet.equals(m))
					cont++;
			}
			return cont;
		}
		
		
		public int getTotale() {
			int som=0;
			for(Moneta monet: portafoglio) {
				som = som + monet.getValore();
			}
			return som;
		}
		
		public void stampa() {
			System.out.println("\n\nnel mio portafoglio ci sono: \n");
			for(Moneta m: portafoglio) {
				System.out.println(m);
			}
		}
		
		public boolean rimuovi(Moneta m) {
			Iterator<Moneta> itr = portafoglio.iterator();
			Moneta banco;
			while(itr.hasNext()) {
				banco = itr.next();
				if(banco.equals(m)) {
					itr.remove();
					return true;
				}
			}
			return false;
		}
		
		public void ordinaPortaFoglio() {
			Collections.sort(portafoglio);
		}
		
}
