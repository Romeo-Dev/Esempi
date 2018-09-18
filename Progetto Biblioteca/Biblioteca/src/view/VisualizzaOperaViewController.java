package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import business.controller.VisualizzaOperaBusinessController;
import business.model.OperaModel;
import business.model.PaginaModel;
import dao.DatabaseException;
import dto.OperaDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VisualizzaOperaViewController {
    @FXML
    private Button pathbutton;
    
    @FXML
    private TextArea editpath;
    
    @FXML
    private Button editbutton;
    
    @FXML
    private Label pagina_cor;

    @FXML
    private Button downloadbutton;

    @FXML
    private ImageView immaginepagina;

    @FXML
    private Label pagina_max;

    @FXML
    private Button uploadbutton;

    @FXML
    private Button transcribebutton;

    @FXML
    private TextArea testotrascrizione;

    public static OperaModel opera_selezionata;
    public int indice = 0;
    public String path_save;
    public boolean edit = false;
    public boolean edit2 = false;
    String var = "file:///";


    @FXML
    void caricapath(ActionEvent event) {
    	if (edit2 == false) {
    		editpath.setEditable(edit2);
    		edit2 = true;
    	}
    	else {
    		editpath.setEditable(edit2);
    		edit2 = false;
    	}
    }
    
    @FXML
    void Back(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/SchermataPrincipaleView.fxml"));
		Scene schermataprincipaleview = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setTitle("Schermata Principale");
		window.setScene(schermataprincipaleview);
		window.show();	
    }
    
    @FXML
    void caricaImmagine(ActionEvent event) throws DatabaseException {
    	String path_immagine = editpath.getText();
    	VisualizzaOperaBusinessController.caricaimmagine(path_immagine, opera_selezionata.getTitolo(), indice);
    }

    @FXML
    void caricaTrascrizione(ActionEvent event) throws DatabaseException {
    	String nuova_trascrizione = testotrascrizione.getText();
    	VisualizzaOperaBusinessController.caricatrascrizione(nuova_trascrizione, path_save);
    }

    @FXML
    void downloadOpera(ActionEvent event) {

    }

    @FXML
    void paginatoreDestro(ActionEvent event) throws DatabaseException {
		indice++;
		path_save = VisualizzaOperaBusinessController.ottieniPath_immagine(opera_selezionata,indice);
		testotrascrizione.setText(VisualizzaOperaBusinessController.ottieniPath_trascrizione(opera_selezionata,indice));
		Image immagine = new Image(var + path_save,true);
		immaginepagina.setImage(immagine);
    }

    @FXML
    void paginatoreSinistro(ActionEvent event) throws DatabaseException {
		indice--;
		path_save = VisualizzaOperaBusinessController.ottieniPath_immagine(opera_selezionata,indice);
		testotrascrizione.setText(VisualizzaOperaBusinessController.ottieniPath_trascrizione(opera_selezionata,indice));
		Image immagine = new Image(var + path_save,true);
		immaginepagina.setImage(immagine);
    }

	public void initialize(URL arg0, ResourceBundle arg1) {
		String ruolo =  Main.utenteloggato.getRuolo();
		switch (ruolo) {
		case "normale":
			uploadbutton.setVisible(false);
			transcribebutton.setVisible(false);
			downloadbutton.setVisible(false);
			editbutton.setVisible(false);
			pathbutton.setVisible(false);
			break;
		case "premium": 
			uploadbutton.setVisible(false);
			transcribebutton.setVisible(false);
			editbutton.setVisible(false);
			pathbutton.setVisible(false);
			break;
		case "uploader": 
			transcribebutton.setVisible(false);
			editbutton.setVisible(false);
			break;
		case "trascrittore": 
			uploadbutton.setVisible(false);
			pathbutton.setVisible(false);
			break;
		}
	}
	
    @FXML
    void setEditableArea(ActionEvent event) {
    	if (edit == false) {
    		testotrascrizione.setEditable(edit);
    		edit = true;
    	}
    	else {
    		testotrascrizione.setEditable(edit);
    		edit = false;
    	}
    }

}
