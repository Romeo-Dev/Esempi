package Model;

public class Cliente {
		private String nome;
		private String cognome;
		
		//costruttore di cliente
		public Cliente(String nome, String cognome) {
			super();
			this.nome = nome;
			this.cognome = cognome;
		}

		
		//incapsulamento con i setters e getters
		public String getNomeCliente() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		
}
