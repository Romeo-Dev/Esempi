package business.controller;

import java.sql.SQLException;
import dao.ConnectionManager;
import dao.DatabaseException;
import dao.UtenteDao;

public class LoginBusinessController {
	
	public static boolean checkCorrettezzaLogin(String username, String password) throws SQLException, DatabaseException {
		new ConnectionManager();
		return UtenteDao.loginCheckDao(ConnectionManager.openConnection(),username,password);
	}
}