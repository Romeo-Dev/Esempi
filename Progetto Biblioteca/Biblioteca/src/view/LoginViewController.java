package view;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import business.controller.LoginBusinessController;
import business.model.UtenteModel;
import dao.ConnectionManager;
import dao.DatabaseException;
import dao.UtenteDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginViewController implements Initializable {
    
	@FXML
    private PasswordField passwordinput;
    @FXML
    private TextField Usernameinput;
    @FXML
    private Text loginerrato;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	loginerrato.setVisible(false);
    }
    
    @FXML
    void login(ActionEvent event) throws SQLException, IOException, DatabaseException {
    	String username = Usernameinput.getText();
    	String password = passwordinput.getText();
    	if (LoginBusinessController.checkCorrettezzaLogin(username,password)) {
    		Parent root = FXMLLoader.load(getClass().getResource("/view/SchermataPrincipaleView.fxml"));
    		Scene schermataprincipaleview = new Scene(root);
    		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		window.setTitle("Menù principale");
    		window.setScene(schermataprincipaleview);
    		window.show();
    	}
    	else
    		loginerrato.setVisible(true);
    }
    
    @FXML
    void registrazione(ActionEvent event) throws IOException {
    		
    		Parent root = FXMLLoader.load(getClass().getResource("/view/RegistrazioneView.fxml"));
    		Scene registrazioneview = new Scene(root);
    		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		window.setTitle("Menù Registrazione");
    		window.setScene(registrazioneview);
    		window.show();
    	}
}

