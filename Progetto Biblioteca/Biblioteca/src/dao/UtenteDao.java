package dao;
import java.sql.*;
import java.util.ArrayList;

import dto.UtenteDto;
import view.Main;

public class UtenteDao {
	
	public UtenteDao() throws SQLException, DatabaseException {
		new ConnectionManager();
		ConnectionManager.openConnection(); 
	}
	
	public static void aggiornaLivello(Connection c, String _nome, String _password) throws DatabaseException {
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			 cs = c.prepareCall("{call GestisciTrascrittori(?,?)}");
			 cs.setString(1,_nome);
			 cs.setString(2,_password);
			 cs.execute();
			 rs = cs.getResultSet();
		 }
		 catch (SQLException ex) {
			 throw new DatabaseException("Errore di esecuzione della query", ex);
		 }
		 finally {
			 ConnectionManager.closeResources(cs,rs);
		 }
	}
	
	public static ArrayList<UtenteDto> vistaTrascrittori(Connection c) throws DatabaseException{
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 try {
			 ps = c.prepareStatement("SELECT * from utente where ruolo like 'tra%';");
			 rs = ps.executeQuery();
			 ArrayList<UtenteDto> listatrascrittoridto = new ArrayList<UtenteDto>();
			 while (rs.next()) {
				 UtenteDto trascrdto = new UtenteDto();
				 trascrdto.setNomeDto(rs);
				 trascrdto.setCognomeDto(rs);
				 trascrdto.setEtaDto(rs);
				 trascrdto.setEmailDto(rs);
				 trascrdto.setLivelloDto(rs);
				 trascrdto.setIDUtenteDto(rs);
				 trascrdto.setPasswordDto(rs);
				 trascrdto.setPremiumDto(rs);
				 trascrdto.setProfessioneDto(rs);
				 trascrdto.setRuoloDto(rs);
				 trascrdto.setSessoDto(rs);
				 trascrdto.setTitoloStudioDto(rs);
				 listatrascrittoridto.add(trascrdto);
			 }
			 return listatrascrittoridto;
		}
		catch (SQLException ex) {
			throw new DatabaseException("Errore di esecuzione della query", ex);
		}
		finally {
			ConnectionManager.closeResources(ps);
		}
	}
	
	public static boolean loginCheckDao(Connection c, String username, String password) throws SQLException, DatabaseException {
		 CallableStatement cs = null;
		 ResultSet rs = null;
		 try {
			 cs = c.prepareCall("{call loginUtente(?,?)}");
			 cs.setString(1,username);
			 cs.setString(2,password);
			 cs.execute();
			 rs = cs.getResultSet();
			 if (rs.next()) {
				 UtenteDto utenteLoggatoDto = new UtenteDto();
				 utenteLoggatoDto.setIDUtenteDto(rs);
				 utenteLoggatoDto.setRuoloDto(rs);
				 utenteLoggatoDto.setNomeDto(rs);
				 utenteLoggatoDto.setCognomeDto(rs);
				 utenteLoggatoDto.setEtaDto(rs);
				 utenteLoggatoDto.setSessoDto(rs);
				 utenteLoggatoDto.setEmailDto(rs);
				 utenteLoggatoDto.setPasswordDto(rs);
				 utenteLoggatoDto.setLivelloDto(rs);
				 utenteLoggatoDto.setTitoloStudioDto(rs);
				 utenteLoggatoDto.setProfessioneDto(rs);
				 utenteLoggatoDto.setPremiumDto(rs);	
				 Main.utenteloggato = utenteLoggatoDto.toUtenteModel();
				 return true;
			 }
			 return false;
		 }
		 catch (SQLException ex) {
			 throw new DatabaseException("Errore di esecuzione della query", ex);
		 }
		 finally {
			 ConnectionManager.closeResources(cs,rs);
		 }
	}

	 public static boolean registrazioneUtenteDao(Connection c,String nome, String cognome, String password, String sesso, int eta, String email, String titolodistudio, String professione) throws SQLException, DatabaseException {
		CallableStatement cs = null;
		CallableStatement cs2 = null;
		ResultSet rs = null;
		try {
			 cs = c.prepareCall("{call registrazioneUtente(?,?,?,?,?,?,?,?)}");
			 cs.setString(1,nome);
			 cs.setString(2,cognome);
			 cs.setInt(3,eta);
			 cs.setString(4,sesso);
			 cs.setString(5,email);
			 cs.setString(6,password);
			 cs.setString(7,titolodistudio);
			 cs.setString(8,professione);
			 
			 cs2 = c.prepareCall("{call loginUtente(?,?)}");
			 cs2.setString(1,nome);
			 cs2.setString(2,password);
			 cs2.execute();
			 rs = cs2.getResultSet();
			 if (rs.next()) {
				 return false;
			 }
			 cs.execute();
			 return true;
		}
		catch (SQLException ex) {
			throw new DatabaseException("Errore di esecuzione della query", ex);
		}
		finally {
			ConnectionManager.closeResources(cs);
		}
	}
	 
	 public static void modificapremiumDao(Connection c,int ID_utente) throws DatabaseException {
		 PreparedStatement ps = null;
		 try {
			 ps = c.prepareStatement("update utente set premium = 'si' where ID = ?");
			 ps.setInt(1,ID_utente);
			 int affected = ps.executeUpdate();
		}
		catch (SQLException ex) {
			throw new DatabaseException("Errore di esecuzione della query", ex);
		}
		finally {
			ConnectionManager.closeResources(ps);
		}
	 }
	 
	 public static void modificaruoloDao(Connection c,int ID_utente) throws DatabaseException {
		 PreparedStatement ps = null;
		 try {
			 ps = c.prepareStatement("update utente set ruolo = 'trascrittore',livello=1 where ID = ?");
			 ps.setInt(1,ID_utente);
			 int affected = ps.executeUpdate();
		}
		catch (SQLException ex) {
			throw new DatabaseException("Errore di esecuzione della query", ex);
		}
		finally {
			ConnectionManager.closeResources(ps);
		}
	 }
}