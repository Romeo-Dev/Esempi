package business.controller;

import java.sql.SQLException;

import dao.ConnectionManager;
import dao.DatabaseException;
import dao.UtenteDao;

public class RegistrazioneBusinessController{
	
	public static boolean check_correttezzaRegistrazione(String nome, String cognome, String password, String sesso, int eta, String email, String titolodistudio, String professione) throws SQLException, DatabaseException{
		new ConnectionManager();
		return UtenteDao.registrazioneUtenteDao(ConnectionManager.openConnection(),nome,cognome,password,sesso,eta,email,titolodistudio,professione);
	}
}