package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import Model.BankAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController implements Initializable {

	
	  @FXML
	    private AnchorPane account_pane;
	  	
	  

	  @FXML
	    private JFXTextField nome_txt;

	    @FXML
	    private JFXTextField cognome_txt;

	    @FXML
	    private JFXTextField balance_txt;

	  
	  
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		account_pane.setVisible(false);
	}
	
	public void ApriConto() {
		account_pane.setVisible(true);
	}
	// metodo che cambia scena è sempre cosi non cambia
	public void Procedi(ActionEvent event) throws IOException {
		//carico file fxmln
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/View/OpBank.fxml"));
		Parent root = loader.load();
		Scene operazioni = new Scene (root);
		
		//eseguo il passaggio con oggetto richiamando il metodo dell altro controller
		//che inizializza cose all altra vista
		
		OpController controller = loader.getController();
		BankAccount persona_corrente = new BankAccount(nome_txt.getText(),cognome_txt.getText(),Double.parseDouble(balance_txt.getText()));
		controller.iniLabel(persona_corrente);
		
		//mostro lo stage settando la scena caricata
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setTitle("Operazioni possibili");
		window.setScene(operazioni);
		window.show();
	}
}
