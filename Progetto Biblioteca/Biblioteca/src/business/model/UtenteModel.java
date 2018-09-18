package business.model;
import java.sql.SQLException;
import java.util.*;

import dao.ConnectionManager;
import dao.DatabaseException;

import dto.UtenteDto;
import view.Main;

public class UtenteModel {
	
	private int ID_utente;
	private String nome;
	private String cognome;
	private int eta;
	private String email;
	private String professione;
	private String titolo_studio;
	private String password;
	private String sesso;
	private String ruolo;
	private String premium;
	private int livello;
	
	public UtenteModel() {}
	
	@Override
	public String toString() {
		return "UtenteModel [ID_utente=" + ID_utente + ", nome=" + nome + ", cognome=" + cognome + ", età=" + eta
				+ ", email=" + email + ", professione=" + professione + ", titolo_studio=" + titolo_studio
				+ ", password=" + password + ", sesso=" + sesso + ", ruolo=" + ruolo + ", premium=" + premium
				+ ", livello=" + livello + "]";
	}
	
//	public void conversionetrascrittoridto(ArrayList<UtenteDto> listatrascrittoridto) throws SQLException, DatabaseException {
//		for(UtenteDto x: listatrascrittoridto) {
//			UtenteModel trascrittore = new UtenteModel();
//			trascrittore.setNome(x.getNomeDto());
//			trascrittore.setCognome(x.getCognomeDto());
//			trascrittore.setEmail(x.getEmailDto());
//			trascrittore.setLivello(x.getLivelloDto());
//			listatrascrittori.add(x);
//		}
//	}
	
	public String getTitoloStudio() {
		return titolo_studio;
	}
	
	public void setTitoloStudio(String titolo_studio) {
		this.titolo_studio = titolo_studio;
	}
	
	public String getNome() {
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

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getProfessione() {
		return professione;
	}

	public void setProfessione(String professione) {
		this.professione = professione;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	
	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}
	
	public int getLivello() {
		return livello;
	}
	
	public void setLivello(int livello) {
		this.livello = livello;
	}

	public int getID_Utente() {
		return ID_utente;
	}
	
	public void setID_utente(int ID_utente) {
		this.ID_utente = ID_utente;
	}

	public String getRuolo() {
		return ruolo;
	}
	
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
}