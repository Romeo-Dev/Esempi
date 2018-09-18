package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.RichiestaDto;
import dto.UtenteDto;

public class RichiestaDao {

	
	public RichiestaDao() throws SQLException, DatabaseException {
		new ConnectionManager();
		ConnectionManager.openConnection(); 
	}
	
	public static void accettarichiesta(Connection c, Integer _id) throws DatabaseException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = c.prepareStatement("DELETE FROM `eramodb`.`richiesta` WHERE `ID`= ?");
			ps.setInt(1,_id);
			int affected = ps.executeUpdate();
		 }
		 catch (SQLException ex) {
			 throw new DatabaseException("Errore di esecuzione della query", ex);
		 }
		 finally {
			 ConnectionManager.closeResources(ps,rs);
		 }
	}
	
	public static ArrayList<RichiestaDto> vistaRichieste(Connection c) throws DatabaseException{
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 try {
			 ps = c.prepareStatement("select r.ID, o.titolo, p.numero_pagina , r.descr, r.ora_richiesta, r.stato from opera o join pagine p on (o.ID=p.ID_opera) join richiesta r on(p.ID=r.ID_pagina)");
			 rs = ps.executeQuery();
			 ArrayList<RichiestaDto> listarichiestedto = new ArrayList<RichiestaDto>();
			 while (rs.next()) {
				 RichiestaDto richdto = new RichiestaDto();
				 richdto.setID_richiestaDto(rs);
				 richdto.setTitoloOperaDto(rs);
				 richdto.setNumeroPaginaDto(rs);
				 richdto.setDescrizioneDto(rs);
				 richdto.setOraRichiestaDto(rs);
				 richdto.setStatoDto(rs);
				 listarichiestedto.add(richdto);
			 }
			 System.out.println(listarichiestedto);
			 return listarichiestedto;
		}
		catch (SQLException ex) {
			throw new DatabaseException("Errore di esecuzione della query", ex);
		}
		finally {
			ConnectionManager.closeResources(ps,rs);
		}
	}
	
	
}
