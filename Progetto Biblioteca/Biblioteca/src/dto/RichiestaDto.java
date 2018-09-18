package dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class RichiestaDto {

	public int ID_richiestadto;
	public String titolooperadto;
	public int numeropaginadto;
	public String descrizionedto;
	public Timestamp ora_richiestadto;
	public String statodto;
	
	
	
	@Override
	public String toString() {
		return "RichiestaDto [ID_richiestadto=" + ID_richiestadto + ", titolooperadto=" + titolooperadto
				+ ", numeropaginadto=" + numeropaginadto + ", descrizionedto=" + descrizionedto + ", ora_richiestadto="
				+ ora_richiestadto + ", statodto=" + statodto + "]";
	}

	public int getID_richiestaDto() {
		return ID_richiestadto;
	}
	
	public void setID_richiestaDto(ResultSet rs) throws SQLException {
		ID_richiestadto = rs.getInt("ID");
	}
	
	public String getTitoloOperaDto() {
		return titolooperadto;
	}
	
	public void setTitoloOperaDto(ResultSet rs) throws SQLException {
		titolooperadto = rs.getString("titolo");
	}
	
	public int getNumeroPaginaDto() {
		return numeropaginadto;
	}
	
	public void setNumeroPaginaDto(ResultSet rs) throws SQLException {
		numeropaginadto = rs.getInt("numero_pagina");
	}
	
	public String getDescrizioneDto() {
		return descrizionedto;
	}

	public void setDescrizioneDto(ResultSet rs) throws SQLException {
		descrizionedto = rs.getString("descr");
	}
	
	public Timestamp getOraRichiestaDto() {
		return ora_richiestadto;
	}

	public void setOraRichiestaDto(ResultSet rs) throws SQLException {
		ora_richiestadto = rs.getTimestamp("ora_richiesta");
	}
	
	public String getStatoDto() {
		return statodto;
	}

	public void setStatoDto(ResultSet rs) throws SQLException {
		statodto = rs.getString("stato");
	}
	
}
