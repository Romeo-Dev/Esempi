package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.OperaDto;
import dto.PaginaDto;
import dto.UtenteDto;
import javafx.scene.text.Text;

public class OperaDao {

	public OperaDao() throws SQLException, DatabaseException {
		new ConnectionManager();
		ConnectionManager.openConnection(); 
	}
	
	public static void caricaimmagineDao(Connection c,String _titolo, int _npag, String _path) throws DatabaseException {
		CallableStatement cs = null;
		 ResultSet rs = null;
		 try {
			 cs = c.prepareCall("{call inserImage(?,?,?)}");
			 cs.setString(1,_titolo);
			 cs.setInt(2,_npag);
			 cs.setString(3,_path);
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
	
	public static void caricatrascrizioneDao(Connection c, String _trascrizione, String path) throws DatabaseException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {
			 ps = c.prepareStatement("update pagine set trascrizione = ?, stato_trascrizione = 'sospeso' where immagine = ?;");
			 ps.setString(1,_trascrizione);
			 ps.setString(2, path);
			 int affected = ps.executeUpdate();
		}
		catch (SQLException ex) {
			throw new DatabaseException("Errore di esecuzione della query", ex);
		}
		finally {
			ConnectionManager.closeResources(ps);
		}
	}
	
	
	public static OperaDto operaselezionata(Connection c, String titolo_opera, String autore_opera) throws DatabaseException {
		CallableStatement cs = null;
		ResultSet rs = null;
		 try {
			 cs = c.prepareCall("{call pagineDiUnOpera(?,?)}");
			 cs.setString(1,titolo_opera);
			 cs.setString(2,autore_opera);
			 cs.execute();
			 rs = cs.getResultSet();
			 OperaDto operadto = new OperaDto();
			 while (rs.next()) {
				operadto.operaDto.add(new PaginaDto(rs));
			 }
			 return operadto;
		 }
		 catch (SQLException ex) {
			 throw new DatabaseException("Errore di esecuzione della query", ex);
		 }
		 finally {
			 ConnectionManager.closeResources(cs,rs);
		 }
	}
	
	public static ArrayList<OperaDto> ricercaOperaDao(Connection c, String titolo, String autore, String categoria, int anno) throws DatabaseException {
		 CallableStatement cs = null;
		 ResultSet rs = null;
		 try {
			 cs = c.prepareCall("{call ricercaOpere(?,?,?,?)}");
			 cs.setString(1,titolo);
			 cs.setString(2,autore);
			 cs.setInt(3,anno);
			 cs.setString(4,categoria);
			 cs.execute();
			 rs = cs.getResultSet();
			 ArrayList<OperaDto> listaopereDto = new ArrayList<OperaDto>();
			 while (rs.next()) {
				OperaDto operadto = new OperaDto();
				operadto.setTitoloDto(rs);
				operadto.setAutoreDto(rs);
				operadto.setCategoriaDto(rs);
				operadto.setAnnoDto(rs);
				listaopereDto.add(operadto);
			 }
			 return listaopereDto;
		 }
		 catch (SQLException ex) {
			 throw new DatabaseException("Errore di esecuzione della query", ex);
		 }
		 finally {
			 ConnectionManager.closeResources(cs,rs);
		 }
	}
	
	public static String path_immagineDao(Connection c, String _titolo, int _index) throws DatabaseException {
		CallableStatement cs = null;
		ResultSet rs = null;
		String URL_im = null;
		try {
			 cs = c.prepareCall("{call path_immagine(?,?)}");
			 cs.setString(1,_titolo);
			 cs.setInt(2,_index);
			 cs.execute();
			 rs = cs.getResultSet();
			 if (rs.next()) 
				 URL_im = rs.getString("immagine");
			 return URL_im;
		 }
		 catch (SQLException ex) {
			 throw new DatabaseException("Errore di esecuzione della query", ex);
		 }
		 finally {
			 ConnectionManager.closeResources(cs,rs);
		 }
	}
	
	public static String path_trascrizioneDao(Connection c, String _titolo, int _index) throws DatabaseException {
		CallableStatement cs = null;
		ResultSet rs = null;
		String URL_tr = null;
		try {
			 cs = c.prepareCall("{call path_trascrizione(?,?)}");
			 cs.setString(1,_titolo);
			 cs.setInt(2,_index);
			 cs.execute();
			 rs = cs.getResultSet();
			 if (rs.next()) 
				 URL_tr = rs.getString("trascrizione");
			 return URL_tr;
		 }
		 catch (SQLException ex) {
			 throw new DatabaseException("Errore di esecuzione della query", ex);
		 }
		 finally {
			 ConnectionManager.closeResources(cs,rs);
		 }
	}
}
