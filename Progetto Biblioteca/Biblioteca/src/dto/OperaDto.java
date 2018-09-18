package dto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.model.OperaModel;
import business.model.PaginaModel;

public class OperaDto {

	
	public ArrayList<PaginaDto> operaDto;
	public ArrayList<OperaDto> listaopereDto;
	public String titoloDto;
	public String autoreDto;
	public String categoriaDto;
	public int annoDto;
	public int ID_operaDto;

	
	public String getCategoriaDto() {
		return categoriaDto;
	}
	
	public void setCategoriaDto(ResultSet rs) throws SQLException {
		categoriaDto = rs.getString("categoria");
	}
	
	public int getAnnoDto() {
		return annoDto;
	}
	
	public void setAnnoDto(ResultSet rs) throws SQLException {
		annoDto = rs.getInt("anno");
	}
	
	public String getAutoreDto() {
		return autoreDto;
	}
	
	public void setAutoreDto(ResultSet rs) throws SQLException {
		autoreDto = rs.getString("autore");
	}
	
	public int getID_OperaDto() {
		return ID_operaDto;
	}
	
	public void setID_OperaDto(ResultSet rs) throws SQLException {
		ID_operaDto = rs.getInt("ID");
	}
	
	public String getTitoloDto() {
		return titoloDto;
	}
	
	public void setTitoloDto(ResultSet rs) throws SQLException {
		titoloDto = rs.getString("titolo");
	}

	public ArrayList<OperaDto> getListaopereDto() {
		return listaopereDto;
	}

	public void setListaopereDto(ArrayList<OperaDto> listaopereDto) {
		this.listaopereDto = listaopereDto;
	}

	public ArrayList<PaginaDto> getOperaDto() {
		return operaDto;
	}

	public void setOperaDto(ArrayList<PaginaDto> operaDto) {
		this.operaDto = operaDto;
	}	
}
