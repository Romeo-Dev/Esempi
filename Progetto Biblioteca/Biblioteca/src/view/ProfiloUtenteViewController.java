package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import view.Main;
import business.controller.ProfiloUtenteBusinessController;
import dao.DatabaseException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProfiloUtenteViewController implements Initializable{
	

    @FXML
    private TextField lognome;

    @FXML
    private TextField logruolo;

    @FXML
    private TextField logliv;

    @FXML
    private TextField logsesso;

    @FXML
    private TextField logemail;

    @FXML
    private TextField logcognome;

    @FXML
    private TextField logeta;

    @FXML
    private TextField logprofessione;

    @FXML
    private TextField logpremium;

    @FXML
    private TextField logtitolost;
    
   
    @FXML
    void stampaInfo(ActionEvent event) {
    	ProfiloUtenteBusinessController.ottieniInfo(Main.utenteloggato);
    	lognome.setText(Main.utenteloggato.getNome());
    	logruolo.setText(Main.utenteloggato.getRuolo());
    	logliv.setText(String.valueOf(Main.utenteloggato.getLivello()));
    	logsesso.setText(Main.utenteloggato.getSesso());
    	logemail.setText(Main.utenteloggato.getEmail());
    	logcognome.setText(Main.utenteloggato.getCognome());
    	logeta.setText(String.valueOf(Main.utenteloggato.getEta()));
    	logprofessione.setText(Main.utenteloggato.getProfessione());
    	logpremium.setText(Main.utenteloggato.getPremium());
    	logtitolost.setText(Main.utenteloggato.getTitoloStudio());
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
    void richiestaPremium(ActionEvent event) throws DatabaseException {
    	ProfiloUtenteBusinessController.modificaPremiumloggato();
    }

    @FXML
    void richiestaTrascrittore(ActionEvent event) throws DatabaseException {
    	ProfiloUtenteBusinessController.modificaRuolologgato();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
