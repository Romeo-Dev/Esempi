package Model;

public class Movimenti {
		private String operazione;
		private int importo;
		
		
		public Movimenti(String operazione, int importo) {
			super();
			this.operazione = operazione;
			this.importo = importo;
		}


		public String getOperazione() {
			return operazione;
		}


		public void setOperazione(String operazione) {
			this.operazione = operazione;
		}


		public double getImporto() {
			return importo;
		}


		public void setImporto(int importo) {
			this.importo = importo;
		}


		@Override
		public String toString() {
			return  operazione + " $" + importo;
		}
		
		
}
