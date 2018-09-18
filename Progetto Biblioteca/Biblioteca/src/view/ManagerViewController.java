package view;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import business.controller.ManagerBusinessController;
import business.model.OperaModel;
import business.model.PaginaModel;
import business.model.RichiestaModel;
import business.model.UtenteModel;
import dao.DatabaseException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ManagerViewController implements Initializable{


    @FXML
    private TableView<RichiestaModel> tabellarichieste;

    @FXML
    private TableColumn<RichiestaModel, String> colopera;

    @FXML
    private TableColumn<RichiestaModel, Integer> colpagina;

    @FXML
    private TableColumn<RichiestaModel, String> coldescr;

    @FXML
    private TableColumn<RichiestaModel, Timestamp> colora;

    @FXML
    private TableColumn<RichiestaModel, String> colstato;
	
	@FXML
	private TableView<UtenteModel> tabellatrascrittori;

    @FXML
    private TableColumn<UtenteModel, String> colonnanome;

    @FXML
    private TableColumn<UtenteModel, String> colonnacognome;

    @FXML
    private TableColumn<UtenteModel, String> colonnaemail;

    @FXML
    private TableColumn<UtenteModel, Integer> colonnalivello;

	
	public ObservableList<UtenteModel> getTrascrittori(ArrayList<UtenteModel> listatrascr) throws SQLException, DatabaseException{
		ObservableList<UtenteModel> trascrittoriobs = FXCollections.observableArrayList();
		for (UtenteModel x: listatrascr) {
			trascrittoriobs.add(x);
		} 
		return trascrittoriobs;
	}
	
	public ObservableList<RichiestaModel> getRichieste(ArrayList<RichiestaModel> listarich) throws SQLException, DatabaseException{
		ObservableList<RichiestaModel> richiesteobs = FXCollections.observableArrayList();
		for (RichiestaModel x: listarich) {
			richiesteobs.add(x);
		}
		System.out.println(richiesteobs);
		return richiesteobs;
	}
    
    @FXML
    void accettaRichiesta(ActionEvent event) throws DatabaseException {
    	RichiestaModel richiestaselezionata = tabellarichieste.getSelectionModel().getSelectedItem();
    	ManagerBusinessController.accettarichiesta(richiestaselezionata.getID_Richiesta());
    }

    @FXML
    public void aggiornaTabella(ActionEvent event) throws SQLException, DatabaseException {
		colonnanome.setCellValueFactory(new PropertyValueFactory<UtenteModel,String>("nome"));
		colonnacognome.setCellValueFactory(new PropertyValueFactory<UtenteModel,String>("cognome"));
		colonnaemail.setCellValueFactory(new PropertyValueFactory<UtenteModel,String>("email"));
		colonnalivello.setCellValueFactory(new PropertyValueFactory<UtenteModel,Integer>("livello"));
		tabellatrascrittori.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    	tabellatrascrittori.setItems(getTrascrittori(ManagerBusinessController.getTrascrittoriModel()));	
    }
    

    @FXML
    void visualizzaRichieste(ActionEvent event) throws SQLException, DatabaseException {
    	colopera.setCellValueFactory(new PropertyValueFactory<RichiestaModel,String>("titoloopera"));
    	colpagina.setCellValueFactory(new PropertyValueFactory<RichiestaModel, Integer>("numeropagina"));
    	coldescr.setCellValueFactory(new PropertyValueFactory<RichiestaModel,String>("descrizione"));
    	colora.setCellValueFactory(new PropertyValueFactory<RichiestaModel,Timestamp>("ora_richiesta"));
    	colstato.setCellValueFactory(new PropertyValueFactory<RichiestaModel,String>("stato"));
    	tabellarichieste.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    	tabellarichieste.setItems(getRichieste(ManagerBusinessController.getRichiesteModel()));
    }

    @FXML
    void incrementaLivello(ActionEvent event) throws DatabaseException {
    	UtenteModel trascrittoreselezionato = tabellatrascrittori.getSelectionModel().getSelectedItem();
    	ManagerBusinessController.incrementaLivello(trascrittoreselezionato.getNome(), trascrittoreselezionato.getPassword());
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

	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
