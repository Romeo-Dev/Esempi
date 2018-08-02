package View;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import Model.BankAccount;
import Model.Movimenti;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OpController implements Initializable {

	

    @FXML
    private Label nome_lb;

    @FXML
    private Label cognome_lb;

    @FXML
    private Label balance_lb;
	
	public BankAccount utente_sessione;
	
	  @FXML
	    private JFXTextField importo_txt;
	  
	  @FXML
	    private Label mov_uno;

	    @FXML
	    private Label mov_due;

	    @FXML
	    private Label mov_tre;

	    @FXML
	    private Label mov_quattro;

	    @FXML
	    private Label mov_cinque;
	    	
	    int conta= 1;
	    boolean toggle = true;
	    
	    @FXML
	    private AnchorPane pane_lista;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pane_lista.setVisible(false);
	}

		public void back(ActionEvent event) {
			//metodo back torna alla vista precedente in questo caso la home
			//sistemarlo non funziona!!
			try {
				Parent root =FXMLLoader.load(getClass().getResource("/View/HomeBank.fxml"));
				Scene Home = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setTitle("My Bank");
				window.setScene(Home);
				window.show();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	//richiamato dal metodo per passare l oggetto
		public void iniLabel(BankAccount x) {
			utente_sessione= x;
			nome_lb.setText(x.getNome_cliente());
			cognome_lb.setText(x.getCognome_cliente());
			balance_lb.setText(String.valueOf(x.getBalance()));
		}
		
		public void ListaMove() {
			if(toggle) 
			{
			pane_lista.setVisible(true);
			toggle=false;
			}else 
			{
				pane_lista.setVisible(false);
				toggle=true;
			}
		}
		
		public void buttonPrelievo() {
			utente_sessione.prelievo(Integer.parseInt(importo_txt.getText()));
			balance_lb.setText(String.valueOf(utente_sessione.getBalance()));
			Movimenti mov_fatto = new Movimenti("Prelievo",Integer.parseInt(importo_txt.getText()));
			this.setLabelCheck(mov_fatto);
			importo_txt.setText("");
		}
		public void buttonDeposito() {
			utente_sessione.deposito(Integer.parseInt(importo_txt.getText()));
			balance_lb.setText(String.valueOf(utente_sessione.getBalance()));
			Movimenti mov_fatto = new Movimenti("Deposito",Integer.parseInt(importo_txt.getText()));
			this.setLabelCheck(mov_fatto);
			importo_txt.setText("");
		}
		
		public void  setLabelCheck(Movimenti mov_fatto) {
			if(conta == 1)
			{
				mov_uno.setText(mov_fatto.toString());
				conta++;
				return;
			}else if(conta == 2)
			{
				this.mov_due.setText(mov_fatto.toString());
				conta++;
				return;
			}else if(conta == 3)
			{
				this.mov_tre.setText(mov_fatto.toString());
				conta++;
				return;
			}else if(conta == 4)
			{
				this.mov_quattro.setText(mov_fatto.toString());
				conta++;
				return;
			}else if(conta == 5)
			{
				this.mov_cinque.setText(mov_fatto.toString());
				conta=1;
				return;
			}else if (conta >= 6)
			{
				conta = 1;
				return;
			}
		}
}
