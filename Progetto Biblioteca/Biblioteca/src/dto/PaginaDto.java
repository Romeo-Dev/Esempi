package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaginaDto {

	public int ID_paginaDto;
	public int numero_paginaDto;
	public String immagineDto;
	public String trascrizioneDto;
	public int ID_operaDto;
	public String stato_immagineDto;
	public String stato_trascrizioneDto;
	
	
	
	public PaginaDto(ResultSet rs) throws SQLException{
		setID_operaDto(rs);
		setID_paginaDto(rs);
		setImmagineDto(rs);
		setNumero_paginaDto(rs);
		setStato_immagineDto(rs);
		setStato_trascrizioneDto(rs);
		setTrascrizioneDto(rs);
	}
	
	@Override
	public String toString() {
		return "PaginaDto [ID_paginaDto=" + ID_paginaDto + ", numero_paginaDto=" + numero_paginaDto + ", immagineDto="
				+ immagineDto + ", trascrizioneDto=" + trascrizioneDto + ", ID_operaDto=" + ID_operaDto
				+ ", stato_immagineDto=" + stato_immagineDto + ", stato_trascrizioneDto=" + stato_trascrizioneDto + "]";
	}

	public int getID_paginaDto() {
		return ID_paginaDto;
	}
	
	public void setID_paginaDto(ResultSet rs) throws SQLException {
		ID_paginaDto = rs.getInt("ID");
	}
	
	public int getNumero_paginaDto() {
		return numero_paginaDto;
	}
	
	public void setNumero_paginaDto(ResultSet rs) throws SQLException {
		numero_paginaDto = rs.getInt("numero_pagina");
	}
	
	public String getImmagineDto() {
		return immagineDto;
	}
	
	public void setImmagineDto(ResultSet rs) throws SQLException {
		immagineDto = rs.getString("immagine");
	}
	
	public String getTrascrizioneDto() {
		return trascrizioneDto;
	}
	
	public void setTrascrizioneDto(ResultSet rs) throws SQLException {
		trascrizioneDto = rs.getString("trascrizione");
	}
	
	public int getID_operaDto() {
		return ID_operaDto;
	}
	
	public void setID_operaDto(ResultSet rs) throws SQLException {
		ID_operaDto = rs.getInt("ID_opera");
	}
	
	public String getStato_immagineDto() {
		return stato_immagineDto;
	}
	
	public void setStato_immagineDto(ResultSet rs) throws SQLException {
		stato_immagineDto = rs.getString("stato_immagine");
	}
	
	public String getStato_trascrizioneDto() {
		return stato_trascrizioneDto;
	}
	
	public void setStato_trascrizioneDto(ResultSet rs) throws SQLException {
		stato_trascrizioneDto = rs.getString("stato_trascrizione");
	}
	
}
