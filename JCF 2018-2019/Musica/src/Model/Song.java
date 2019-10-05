package Model;

public class Song implements Comparable<Song>{
	private String nome;
	private String artista;
	private int durata;
	
	
	public Song(String nome, String artista, int durata) {
		super();
		this.nome = nome;
		this.artista = artista;
		this.durata = durata;
	}

	public String getNome() {
		return nome;
	}

    public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	
	
	
	@Override
	public String toString() {
		return "[nome: " + nome + " , artista: " + artista + " , durata: " + durata + "sec. ]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Song)) return false;
		Song s= (Song) obj;
		
		return this.nome.equalsIgnoreCase(s.nome) && this.artista.equalsIgnoreCase(s.artista); 
	
	}

	@Override
	public int compareTo(Song o) {
		if(!(this.durata == o.durata)) {
			if (this.durata < o.durata) return -1;
			else
				return 1;
		}else
			return this.nome.compareTo(o.nome);		
	}
}
