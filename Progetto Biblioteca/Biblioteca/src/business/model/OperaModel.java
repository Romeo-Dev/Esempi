package business.model;
import java.util.ArrayList;

import dto.OperaDto;
import dto.PaginaDto;
import dto.UtenteDto;

public class OperaModel {
	
	private ArrayList<PaginaModel> opera; 
	private ArrayList<OperaModel> listaopere;
	private String titolo;
	private String autore;
	private String categoria;
	private int anno;
	private int ID_opera;
	
	public OperaModel() {}
	
	public static void stampapagine(OperaModel op) {
       	for (PaginaModel x: op.getOpera()) {
    		System.out.println(x);
    	}
	}
	
	@Override
	public String toString() {
		return "OperaModel [opera=" + opera + ", listaopere=" + listaopere + ", titolo=" + titolo + ", autore=" + autore
				+ ", categoria=" + categoria + ", anno=" + anno + ", ID_opera=" + ID_opera + "]";
	}

	public static void passaggiolistaoperemodel(ArrayList<OperaDto> listaoperedto, ArrayList<OperaModel> listaoperemodel) {
		for (OperaDto x: listaoperedto) {
			OperaModel opera = new OperaModel();
			opera.setTitolo(x.getTitoloDto());
			opera.setAutore(x.getAutoreDto());
			opera.setCategoria(x.getCategoriaDto());
			opera.setAnno(x.getAnnoDto());
			listaoperemodel.add(opera);
		}
	} 
	
	public static void passaggiolistapaginemodel(OperaDto listapaginedto, OperaModel operamod) {
		for (PaginaDto x: listapaginedto.getOperaDto()) {
			PaginaModel pagina = new PaginaModel();
			pagina.setID_pagina(x.getID_paginaDto());
			pagina.setNumero_pagina(x.getNumero_paginaDto());
			pagina.setPath_immagine(x.getImmagineDto());
			pagina.setPath_trascrizione(x.getTrascrizioneDto());
			pagina.setID_opera(x.getID_operaDto());
			pagina.setStato_immagine(x.getStato_immagineDto());
			pagina.setStato_trascrizione(x.getStato_trascrizioneDto());
			operamod.getOpera().add(pagina);
		}
	}
	
	public static void stampalistaopere(ArrayList<OperaModel> listaoperemodel){
		for (OperaModel x: listaoperemodel) {
			System.out.println(x);
		}
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getAutore() {
		return autore;
	}
	
	public void setAutore(String autore) {
		this.autore = autore;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getAnno() {
		return anno;
	}
	
	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	public int getID_opera() {
		return ID_opera;
	}
	
	public ArrayList<PaginaModel> getOpera() {
		return opera;
	}
}