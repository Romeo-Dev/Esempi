package business.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import business.model.RichiestaModel;
import business.model.UtenteModel;
import dao.ConnectionManager;
import dao.DatabaseException;
import dao.RichiestaDao;
import dao.UtenteDao;
import dto.RichiestaDto;
import dto.UtenteDto;

public class ManagerBusinessController {
	
	public static void accettarichiesta(Integer id) throws DatabaseException {
		new ConnectionManager();
		RichiestaDao.accettarichiesta(ConnectionManager.openConnection(), id);
	}
	

	public static ArrayList<UtenteModel> getTrascrittoriModel() throws SQLException, DatabaseException{
		new ConnectionManager();
		ArrayList<UtenteModel> listatrascrittori = new ArrayList<UtenteModel>();
		
		for(UtenteDto x: UtenteDao.vistaTrascrittori(ConnectionManager.openConnection())) {
			UtenteModel trascrittore = new UtenteModel();
			trascrittore.setNome(x.getNomeDto());
			trascrittore.setCognome(x.getCognomeDto());
			trascrittore.setEmail(x.getEmailDto());
			trascrittore.setLivello(x.getLivelloDto());
			trascrittore.setEta(x.getEtaDto());
			trascrittore.setID_utente(x.getIDUtenteDto());
			trascrittore.setPassword(x.getPasswordDto());
			trascrittore.setPremium(x.getPremiumDto());
			trascrittore.setProfessione(x.getProfessioneDto());
			trascrittore.setRuolo(x.getRuoloDto());
			trascrittore.setSesso(x.getSessoDto());
			trascrittore.setTitoloStudio(x.getTitoloStudioDto());
			listatrascrittori.add(trascrittore);
			}
		return listatrascrittori;
	}
	
	public static void incrementaLivello(String nome, String password) throws DatabaseException {
		new ConnectionManager();
		UtenteDao.aggiornaLivello(ConnectionManager.openConnection(), nome, password);
	}
	
	public static ArrayList<RichiestaModel> getRichiesteModel() throws SQLException, DatabaseException{
		new ConnectionManager();
		ArrayList<RichiestaModel> listarichieste = new ArrayList<RichiestaModel>();
		for(RichiestaDto x: RichiestaDao.vistaRichieste(ConnectionManager.openConnection())) {
			RichiestaModel richiesta = new RichiestaModel();
			richiesta.setID_Richiesta(x.getID_richiestaDto());
			richiesta.setTitoloOpera(x.getTitoloOperaDto());
			richiesta.setNumeroPagina(x.getNumeroPaginaDto());
			richiesta.setDescrizione(x.getDescrizioneDto());
			richiesta.setOra_richiesta(x.getOraRichiestaDto());
			richiesta.setStato(x.getStatoDto());
			listarichieste.add(richiesta);
		}
		return listarichieste;
	}
}
