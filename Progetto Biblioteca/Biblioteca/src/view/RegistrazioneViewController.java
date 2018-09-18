package view;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import business.controller.RegistrazioneBusinessController;
import dao.ConnectionManager;
import dao.DatabaseException;
import dao.UtenteDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegistrazioneViewController implements Initializable{
    @FXML
    private TextField nomeR;
    @FXML
    private TextField cognomeR;
    @FXML
    private TextField emailR;
     @FXML
    private PasswordField passwordR;
    @FXML
    private PasswordField repasswordR;
    @FXML
    private TextField codicefiscaleR;
    @FXML
    private TextField professioneR;
    @FXML
    private TextField titolodistudioR;
    @FXML
    private TextField etaR;
    @FXML
    private TextField sessoR;
    
 
    
  @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }
  

    @SuppressWarnings("deprecation")
	@FXML
    void Registrati(ActionEvent event) throws SQLException, DatabaseException {
    
    	String nome = nomeR.getText();
    	String password = passwordR.getText();
    	String cognome = cognomeR.getText();
    	int eta = Integer.valueOf(etaR.getText());
    	String email = emailR.getText();
    	String sesso = sessoR.getText();
    	String titolodistudio = titolodistudioR.getText();
    	String professione= professioneR.getText();

    	if (RegistrazioneBusinessController.check_correttezzaRegistrazione(nome,cognome,password,sesso,eta,email,titolodistudio,professione)) {
     		JOptionPane optionPane = new JOptionPane("Registrazione avvenuta con successo!", JOptionPane.WARNING_MESSAGE);
    		JDialog dialog = optionPane.createDialog("Warning");
    		dialog.setAlwaysOnTop(true);
    		dialog.setVisible(true);
    		try {
    			dialog.hide();
    			Parent backlogin;
    			backlogin = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
    			Scene utenteView = new Scene(backlogin);
    			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    			window.setTitle("Login");
    			window.setScene(utenteView);
    			window.show();
    		}
    		catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	else {
    		JOptionPane optionPane = new JOptionPane("Password già esistente", JOptionPane.WARNING_MESSAGE);
    		JDialog dialog = optionPane.createDialog("Warning");
    		dialog.setAlwaysOnTop(true);
    		dialog.setVisible(true);
    	}	
    }
    
    @FXML
    void Back(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
		Scene loginview = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setTitle("Login");
		window.setScene(loginview);
		window.show();	
    }

}
