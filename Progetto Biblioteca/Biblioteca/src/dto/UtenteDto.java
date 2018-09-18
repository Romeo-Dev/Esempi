package dto;
import java.sql.*;

import business.model.UtenteModel;
import dao.ConnectionManager;
import dao.DatabaseException;
import dao.UtenteDao;
import view.Main;

public class UtenteDto {
	
	public String nomeDto;
	public String cognomeDto;
	public int etaDto;
	public String emailDto;
	public String professioneDto;
	public String passwordDto;
	public String sessoDto;
	public String ruoloDto;
	public int ID_utenteDto;
	public String premiumDto;
	public int livelloDto;
	public String titolo_studioDto;
	
	
	
	@Override
	public String toString() {
		return "UtenteDto [nomeDto=" + nomeDto + ", cognomeDto=" + cognomeDto + ", et‡Dto=" + etaDto + ", emailDto="
				+ emailDto + ", professioneDto=" + professioneDto + ", passwordDto=" + passwordDto + ", sessoDto="
				+ sessoDto + ", ruoloDto=" + ruoloDto + ", ID_utenteDto=" + ID_utenteDto + ", premiumDto=" + premiumDto
				+ ", livelloDto=" + livelloDto + ", titolo_studioDto=" + titolo_studioDto + "]";
	}

	public void setIDUtenteModel(UtenteModel utente) {
		this.ID_utenteDto = utente.getID_Utente();
	}
	
	public int getIDUtenteDto() {
		return ID_utenteDto;
	}
	
	public void setIDUtenteDto(ResultSet rs) throws SQLException {
		this.ID_utenteDto = rs.getInt("ID");
	}
	
	public String getTitoloStudioDto() {
		return titolo_studioDto;
	}
	
	public void setTitoloStudioDto(ResultSet rs) throws SQLException {
		this.titolo_studioDto = rs.getString("titolo_studio");
	}
	
	public String getRuoloDto() {
		return ruoloDto;
	}
	
	public void setRuoloDto(ResultSet rs) throws SQLException {
		this.ruoloDto = rs.getString("ruolo");
	}
	
	public int getLivelloDto() {
		return livelloDto;
	}
	
	public void setLivelloDto(ResultSet rs) throws SQLException{
		this.livelloDto = rs.getInt("livello");
	}
	
	public String getPremiumDto() {
		return premiumDto;
	}
	
	public void setPremiumDto(ResultSet rs) throws SQLException {
		this.premiumDto = rs.getString("premium");
	}
	
	public String getProfessioneDto() {
		return professioneDto;
	}
	
	public void setProfessioneDto(ResultSet rs) throws SQLException {
		this.professioneDto = rs.getString("professione");
	}
	
	public String getPasswordDto() {
		return passwordDto;
	}
	
	public  void setPasswordDto(ResultSet rs) throws SQLException {
		this.passwordDto = rs.getString("password");
	}
	
	public  String getSessoDto() {
		return sessoDto;
	}
	
	public  void setSessoDto(ResultSet rs) throws SQLException {
		this.sessoDto =  rs.getString("sesso");
	}
		
	public  int getEtaDto() {
		return etaDto;
	}
	
	public  void setEtaDto(ResultSet rs) throws SQLException {
		this.etaDto = rs.getInt("eta");
	}
	
	public  String getEmailDto() {
		return emailDto;
	}

	public  void setEmailDto(ResultSet rs) throws SQLException {
		this.emailDto = rs.getString("email");
	}
	
	public String getNomeDto() {
		return nomeDto;
	}
	
	public  void setNomeDto(ResultSet rs) throws SQLException {
		this.nomeDto = rs.getString("nome");
	}
	
	public  String getCognomeDto() {
		return cognomeDto;
	}
	
	public  void setCognomeDto(ResultSet rs) throws SQLException {
		this.cognomeDto = rs.getString("cognome");
	}
	
	public UtenteModel toUtenteModel() {
		UtenteModel utente = new UtenteModel();
		utente.setNome(this.getNomeDto());
		utente.setCognome(this.getCognomeDto());
		utente.setEta(this.getEtaDto());
		utente.setEmail(this.getEmailDto());
		utente.setProfessione(this.getProfessioneDto());
		utente.setTitoloStudio(this.getTitoloStudioDto());
		utente.setPassword(this.getPasswordDto());
		utente.setSesso(this.getSessoDto());
		utente.setRuolo(this.getRuoloDto());
		utente.setPremium(this.getPremiumDto());
		utente.setLivello(this.getLivelloDto());
		return utente;
	}
}