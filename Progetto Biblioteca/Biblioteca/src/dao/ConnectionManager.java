package dao;
import java.sql.*;

public class ConnectionManager {
	
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_NAME = "eramodb";
	private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&noAccessToProcedureBodies=true";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	public static Connection openConnection() throws DatabaseException {
		try {
			Class.forName(JDBC_DRIVER);
			Connection c = DriverManager.getConnection(CONNECTION_STRING,DB_USER,DB_PASSWORD);
			return c;
		}
		catch(ClassNotFoundException ex){
			 throw new DatabaseException("Driver non trovato", ex);
		}
		catch(SQLException ex){
            throw new DatabaseException("Errore di connessione", ex);
		}
	}
	
	public static void closeResources(Statement s) throws DatabaseException {
		if (s != null) {
			try {
				s.close();
			}
			catch (SQLException ex) {
				throw new DatabaseException("Problema nella chiusura della risorsa Statement", ex);
			}
		}
	}
	
	public static void closeResources(PreparedStatement ps) throws DatabaseException {
		if (ps != null) {
			try {
				ps.close();
			}
			catch (SQLException ex) {
				throw new DatabaseException("Problema nella chiusura della risorsa PreparedStatement", ex);
			}
		}
	}
	
	
	public static void closeResources(Statement s, ResultSet rs) throws DatabaseException {
		if (s != null) {
			try {
				s.close();
			}
			catch (SQLException ex) {
				throw new DatabaseException("Problema nella chiusura della risorsa Statement", ex);
			}
		}
		 if (rs != null) {
			try {
				 rs.close();
			 }
			catch (SQLException ex) {
				throw new DatabaseException("Problema nella chiusura della risorsa ResultSet", ex);
			}
		 }
	}
	
    private static void closeResources(CallableStatement cs, ResultSet rs) throws DatabaseException {
		if (cs != null) {
			try {
				cs.close();
			}
			catch (SQLException ex) {
				throw new DatabaseException("Problema nella chiusura della risorsa CallableStatement", ex);
			}
		}
		if (rs != null) {
			try {
				 rs.close();
			}
			catch (SQLException ex) {
				throw new DatabaseException("Problema nella chiusura della risorsa ResultSet", ex);
			}
		}
    }
	
	public static void closeConnection(Connection c) throws DatabaseException {
		if (c != null) {
			try {
				c.close();
			}
			catch (SQLException ex) {
				throw new DatabaseException("Problema nella chiusura della connessione", ex);
			}
		 }	
	}
}
