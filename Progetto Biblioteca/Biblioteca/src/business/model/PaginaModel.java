package business.model;

import dto.OperaDto;
import dto.PaginaDto;

public class PaginaModel {

	private int ID_pagina;
	private int numero_pagina;
	private String path_immagine;
	private String path_trascrizione;
	private int ID_opera;
	private String stato_immagine;
	private String stato_trascrizione;
	
	public PaginaModel() {}
	
	@Override
	public String toString() {
		return "PaginaModel [ID_pagina=" + ID_pagina + ", numero_pagina=" + numero_pagina + ", path_immagine="
				+ path_immagine + ", path_trascrizione=" + path_trascrizione + ", ID_opera=" + ID_opera
				+ ", stato_immagine=" + stato_immagine + ", stato_trascrizione=" + stato_trascrizione + "]";
	}

	public int getID_pagina() {
		return ID_pagina;
	}

	public void setID_pagina(int ID_pagina) {
		this.ID_pagina = ID_pagina;
	}
	
	public int getNumero_pagina() {
		return numero_pagina;
	}

	public void setNumero_pagina(int numero_pagina) {
		this.numero_pagina = numero_pagina;
	}

	public String getPath_immagine() {
		return path_immagine;
	}

	public void setPath_immagine(String path_immagine) {
		this.path_immagine = path_immagine;
	}

	public String getPath_trascrizione() {
		return path_trascrizione;
	}

	public void setPath_trascrizione(String path_trascrizione) {
		this.path_trascrizione = path_trascrizione;
	}

	public int getID_opera() {
		return ID_opera;
	}

	public void setID_opera(int iD_opera) {
		ID_opera = iD_opera;
	}

	public String getStato_immagine() {
		return stato_immagine;
	}

	public void setStato_immagine(String stato_immagine) {
		this.stato_immagine = stato_immagine;
	}

	public String getStato_trascrizione() {
		return stato_trascrizione;
	}

	public void setStato_trascrizione(String stato_trascrizione) {
		this.stato_trascrizione = stato_trascrizione;
	}
}