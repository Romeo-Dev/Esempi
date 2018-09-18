package view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import business.controller.MenuUtenteController;
import business.controller.ProfiloUtenteBusinessController;
import business.model.OperaModel;
import dao.DatabaseException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import business.model.OperaModel;

public class SchermataPrincipaleViewController implements Initializable {
  
	@FXML
    private TextField titoloinput;
    
    @FXML
    private TextField categoriainput;

    @FXML
    private TextField autoreinput;

    @FXML
    private TextField annoinput;

    @FXML
    private TableView<OperaModel> tabellarisultati;

    @FXML
    private TableColumn<OperaModel,String> colonnatitolo;

    @FXML
    private TableColumn<OperaModel,String> colonnaautore;

    @FXML
    private TableColumn<OperaModel,String> colonnacategoria;

    @FXML
    private TableColumn<OperaModel,Integer> colonnaanno;
    
    @FXML
    private Button managerbutton;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		managerbutton.setVisible(false);
		if (Main.utenteloggato.getRuolo().equals("manager"))
			managerbutton.setVisible(true);
	}
	
	
	
    @FXML
    void Logout(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
		Scene loginview = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setTitle("Login");
		window.setScene(loginview);
		window.show();	
    }

    @FXML
    public void RicercaOpera(ActionEvent event) throws DatabaseException {
    	String titolo = titoloinput.getText();
    	String autore = autoreinput.getText();
    	String categoria = categoriainput.getText();
    	int anno = Integer.valueOf(annoinput.getText());
		colonnatitolo.setCellValueFactory(new PropertyValueFactory<OperaModel,String>("titolo"));
		colonnaautore.setCellValueFactory(new PropertyValueFactory<OperaModel,String>("autore"));
		colonnacategoria.setCellValueFactory(new PropertyValueFactory<OperaModel,String>("categoria"));
		colonnaanno.setCellValueFactory(new PropertyValueFactory<OperaModel,Integer>("anno"));
		tabellarisultati.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    	tabellarisultati.setItems(getlistaopere(MenuUtenteController.ricercaOpera(titolo,autore,categoria,anno)));
    	titoloinput.setText(null); 
    	autoreinput.setText(null); 
    	categoriainput.setText(null); 
    	annoinput.setText(null); 
    }
    
	public ObservableList<OperaModel> getlistaopere(ArrayList<OperaModel> listaoperemodel) {
    	ObservableList<OperaModel> opereobs = FXCollections.observableArrayList();
    	for (OperaModel x: listaoperemodel) {
    		opereobs.add(x);
    	}
    	System.out.println(opereobs);
    	return opereobs;
	}
  
    @FXML
    void userprofile(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/ProfiloUtenteView.fxml"));
		Scene profiloutenteview = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setTitle("Profilo Utente");
		window.setScene(profiloutenteview);
		window.show();
    }
    
    @FXML
    void visualizzaOpera(ActionEvent event) throws IOException, DatabaseException {
    	OperaModel operaselezionata = tabellarisultati.getSelectionModel().getSelectedItem();    	
    	VisualizzaOperaViewController.opera_selezionata = operaselezionata;
		Parent root = FXMLLoader.load(getClass().getResource("/view/VisualizzaOperaView.fxml"));
		Scene visualizzaoperaview = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setTitle("Visualizza Opera");
		window.setScene(visualizzaoperaview);
		window.show();
    }
    
    @FXML
    void managerButton(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/ManagerView.fxml"));
		Scene managerview = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setTitle("Manager Home");
		window.setScene(managerview);
		window.show();
    }
}
