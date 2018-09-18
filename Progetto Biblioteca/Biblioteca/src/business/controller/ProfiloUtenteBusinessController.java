package business.controller;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import business.model.UtenteModel;
import dao.ConnectionManager;
import dao.DatabaseException;
import dao.UtenteDao;
import dto.UtenteDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.Main;
import view.ProfiloUtenteViewController;

public class ProfiloUtenteBusinessController {
	
	public static void ottieniInfo(UtenteModel utenteloggato) {
		
		
		
		
		
		
	}

	public static String visualizzaNomeUtenteLoggato(){
		return Main.utenteloggato.getNome();
	}
	
	public static String visualizzaCognomeUtenteLoggato(){
		return Main.utenteloggato.getCognome();
	}
	
	public static String visualizzaRuoloUtenteLoggato(){
		return Main.utenteloggato.getRuolo();
	}
	
	public static String visualizzaPremiumUtenteLoggato(){
		return Main.utenteloggato.getPremium();
	}
	
	public static String visualizzaProfessioneUtenteLoggato(){
		return Main.utenteloggato.getProfessione();
	}
	
	public static int visualizzaLivelloUtenteLoggato(){
		return Main.utenteloggato.getLivello();
	}
	
	public static String visualizzaTitoloStudioUtenteLoggato(){
		return Main.utenteloggato.getTitoloStudio();
	}
	
	public static int visualizzaEtaUtenteLoggato(){
		return Main.utenteloggato.getEta();
	}
	
	public static String visualizzaSessoUtenteLoggato(){
		return Main.utenteloggato.getSesso();
	}
	public static String visualizzaEmailUtenteLoggato(){
		return Main.utenteloggato.getEmail();
	}

	public static void modificaPremiumloggato() throws DatabaseException {
		int idutente = Main.utenteloggato.getID_Utente();
		new ConnectionManager();
	    UtenteDao.modificapremiumDao(ConnectionManager.openConnection(),idutente);
	    Main.utenteloggato.setPremium("si");
	}
	
	public static void modificaRuolologgato() throws DatabaseException {
		int idutente = Main.utenteloggato.getID_Utente();
		new ConnectionManager();
	    UtenteDao.modificaruoloDao(ConnectionManager.openConnection(),idutente);
	    Main.utenteloggato.setRuolo("trascrittore");
	    Main.utenteloggato.setLivello(1);
	}
}

