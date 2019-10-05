
public class Moneta implements Comparable<Moneta>{
		private String nome;
		private int valore;
		public static final String VALUTA = "euro";
		
		
		public Moneta(String nome, int valore) {
			
			this.nome = nome;
			this.valore = valore;
		}
		
		public Moneta(int valore) {
			
			this.nome = "sempre il valore ma in lettere";
			this.valore = valore;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getValore() {
			return valore;
		}

		public void setValore(int valore) {
			this.valore = valore;
		}

	
		
		
		@Override
		public String toString() {
			return "Moneta da " + nome + " "+VALUTA+" di valore pari a " + valore+"\n";
		}

		

		@Override
		public boolean equals(Object obj) {
			if(obj==null) return false;
			if(!(obj instanceof Moneta)) return false;
			
			Moneta mon= (Moneta) obj;
			
			return this.valore == mon.valore;
		}

		@Override
		public int compareTo(Moneta o) {
			if(!(this.equals(o))) {
				if(this.valore < o.valore) return -1;
				if(this.valore > o.valore) return 1;
			}
			return 0;
		}
		
		
}
