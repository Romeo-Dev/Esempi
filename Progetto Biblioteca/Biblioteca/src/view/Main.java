package view;
	
import java.sql.SQLException;

import business.model.UtenteModel;
import dao.DatabaseException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public static UtenteModel utenteloggato;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
			Scene loginview = new Scene(root,465,400);
			loginview.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Login");
			primaryStage.setScene(loginview);
			primaryStage.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException, DatabaseException {
		launch(args);
	}
}