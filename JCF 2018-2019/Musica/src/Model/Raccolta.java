package Model;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Raccolta {
	private String nome;
	List<Playlist> racc;

	public Raccolta(String nomerac) {
		super();
		this.nome=nomerac;
		racc= new LinkedList<>();
	}

	@Override
	public String toString() {
		return "Raccolta "+this.nome+":\n ";
	}

	public void myraccolta() {
		System.out.println(this.toString());
		for(Playlist p: racc) {
			System.out.println(p);
		}
	}
	 public void insertrac(Playlist p) {
			 if(!(racc.contains(p)))
			 racc.add(p);
			 else
		 System.out.println("\n Playlist "+p+" gia presente in "+this.toString());
	 }
	public void ordinaRacc() {
		Collections.sort(racc);
	}
	
}
