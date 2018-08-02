package Model;


import Model.Cliente;
public class BankAccount {
		private String nome_cliente;
		private String cognome_cliente;
		private double balance;
		
		
		public BankAccount(Cliente x) {
			this.nome_cliente= x.getNomeCliente();
			this.cognome_cliente= x.getCognome();
			this.balance=0;
		}
		
		//costruttore base bankaccount
		public BankAccount(String nome_cliente, String cognome_cliente, double balance) {
			
			this.nome_cliente = nome_cliente;
			this.cognome_cliente = cognome_cliente;
			this.balance = balance;
		}
		
		public void prelievo(int soldi) {
			this.balance =this.balance - soldi;
		}
		
		public void deposito(int soldi) {
			this.balance =this.balance + soldi;
		}
	
		public void interessi() {}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		@Override
		public String toString() {
			return "BankAccount [nome_cliente=" + nome_cliente + ", cognome_cliente=" + cognome_cliente + ", balance="
					+ balance + "]";
		}

		public String getNome_cliente() {
			return nome_cliente;
		}

		public void setNome_cliente(String nome_cliente) {
			this.nome_cliente = nome_cliente;
		}

		public String getCognome_cliente() {
			return cognome_cliente;
		}

		public void setCognome_cliente(String cognome_cliente) {
			this.cognome_cliente = cognome_cliente;
		}
	

		
}
