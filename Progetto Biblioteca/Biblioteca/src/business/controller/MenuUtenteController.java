package business.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import business.model.OperaModel;
import dao.ConnectionManager;
import dao.DatabaseException;
import dao.OperaDao;
import dto.OperaDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import view.SchermataPrincipaleViewController;

public class MenuUtenteController{

    public static ArrayList<OperaModel> ricercaOpera(String titolo, String autore, String categoria, int anno) throws DatabaseException {
    	new ConnectionManager();
    	ArrayList<OperaModel> listaoperemodel = new ArrayList<OperaModel>();
    	OperaModel.passaggiolistaoperemodel(OperaDao.ricercaOperaDao(ConnectionManager.openConnection(),titolo,autore,categoria,anno),listaoperemodel);
    	return listaoperemodel;
    }
}
