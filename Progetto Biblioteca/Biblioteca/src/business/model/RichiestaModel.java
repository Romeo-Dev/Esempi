package business.model;

import java.sql.Timestamp;

import dto.OperaDto;

public class RichiestaModel {
	
	private int ID_richiesta;
	private String titoloopera;
	private int numeropagina;
	private String descrizione;
	private Timestamp ora_richiesta;
	private String stato;
	
	public RichiestaModel() {}

	
	
	@Override
	public String toString() {
		return "RichiestaModel [ID_richiesta=" + ID_richiesta + ", titoloopera=" + titoloopera + ", numeropagina="
				+ numeropagina + ", descrizione=" + descrizione + ", ora_richiesta=" + ora_richiesta + ", stato="
				+ stato + "]";
	}



	public int getID_Richiesta() {
		return ID_richiesta;
	}
	
	public void setID_Richiesta(int ID_richiesta) {
		this.ID_richiesta = ID_richiesta;
	}
	
	public String getTitoloOpera() {
		return titoloopera;
	}
	
	public void setTitoloOpera(String titoloopera) {
		this.titoloopera = titoloopera;
	}
	
	public int getNumeroPagina() {
		return numeropagina;
	}
	
	public void setNumeroPagina(int numeropagina) {
		this.numeropagina = numeropagina;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Timestamp getOra_richiesta() {
		return ora_richiesta;
	}

	public void setOra_richiesta(Timestamp ora_richiesta) {
		this.ora_richiesta = ora_richiesta;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}
}
