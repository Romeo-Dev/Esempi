package business.controller;

import java.util.ArrayList;

import business.model.OperaModel;
import dao.ConnectionManager;
import dao.DatabaseException;
import dao.OperaDao;
import dto.OperaDto;
import dto.PaginaDto;
import javafx.scene.text.Text;

public class VisualizzaOperaBusinessController {
	
	public static void caricaimmagine(String path, String titolo, int indice) throws DatabaseException {
		new ConnectionManager();
		OperaDao.caricaimmagineDao(ConnectionManager.openConnection(),titolo,indice,path);
	}

	public static void caricatrascrizione(String trascrizione, String path) throws DatabaseException {
		new ConnectionManager();
		OperaDao.caricatrascrizioneDao(ConnectionManager.openConnection(),trascrizione, path);
	}
	

	public static OperaModel ottieniopera(String titolo_opera, String autore_opera, OperaModel operamodel) throws DatabaseException{
		new ConnectionManager();
		OperaDto operadto = new OperaDto();
		OperaModel.passaggiolistapaginemodel(OperaDao.operaselezionata(ConnectionManager.openConnection(),titolo_opera,autore_opera),operamodel);
		return operamodel;
	}
	
	
	public static String ottieniPath_immagine(OperaModel opera, int indice) throws DatabaseException {
		new ConnectionManager();
		String pathimmagine = OperaDao.path_immagineDao(ConnectionManager.openConnection(), opera.getTitolo(), indice);
		return pathimmagine;
	}
	
	public static String ottieniPath_trascrizione(OperaModel opera, int indice) throws DatabaseException {
		new ConnectionManager();
		String pathtrascrizione = OperaDao.path_trascrizioneDao(ConnectionManager.openConnection(), opera.getTitolo(), indice);
		return pathtrascrizione;
	}
	
}


