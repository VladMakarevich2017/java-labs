package controller;
import java.awt.Button;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import application.Main;
import client.TestRunnableClientTester;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import webcam.WebCamManipulation;

public class ControllerMain implements Initializable{
	
	@FXML
	private TextField gamePort;
	@FXML
	private TextField gameIp;
	@FXML
	private Button createNewGame;
	@FXML
	private Button connectGameButton;

	@FXML
	private void createGame() throws IOException {
		try {
			if(gamePort.getText() != "" && Integer.parseInt(gamePort.getText()) != 0) {
				TestRunnableClientTester.setGamePort(Integer.parseInt(gamePort.getText()));
				Stage newWindow = new Stage();
				Group group = new Group();
				Parent content = FXMLLoader.load(getClass().getResource("../sampleCreate.fxml"));
				BorderPane root = new BorderPane();
				root.setCenter(content);
				group.getChildren().add(root);
				newWindow.setScene(new Scene(group, 400, 332));
				Main.getArg().close();
				Main.setArg(newWindow);
				newWindow.show();
			} else {
			}
		} catch (RuntimeException e) {
		}
	}
	
	@FXML
	private void connectGame() throws IOException {
		try {
			if(gamePort.getText() != "" && Integer.parseInt(gamePort.getText()) != 0) {
				Controller.onlineGameFlag = true;
				TestRunnableClientTester.setGamePort(Integer.parseInt(gamePort.getText()));
				TestRunnableClientTester.setGameIp(gameIp.getText());
				Stage newWindow = new Stage();
				Group group = new Group();
				Parent content = FXMLLoader.load(getClass().getResource("../sample.fxml"));
				BorderPane root = new BorderPane();
				root.setCenter(content);
				group.getChildren().add(root);
				newWindow.setScene(new Scene(group, 1100, 975));
				Main.getArg().close();
				Main.setArg(newWindow);			
				newWindow.show();
			} else {
			}
		} catch (RuntimeException e) {
		} 
		
	}
	
	@FXML
	private void singleGame() throws IOException {
		try {
			Stage newWindow = new Stage();
			Group group = new Group();
			Parent content = FXMLLoader.load(getClass().getResource("../sampleCreateSingle.fxml"));
			BorderPane root = new BorderPane();
			root.setCenter(content);
			group.getChildren().add(root);
			newWindow.setScene(new Scene(group, 400, 230));
			Main.getArg().close();
			Main.setArg(newWindow);
			newWindow.show();
		} catch (RuntimeException e) {
		}
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ExecutorService exec = Executors.newFixedThreadPool(10);
        exec.shutdown();
	}
	
	@FXML
	public Button getcreateNewGame() {
		return createNewGame;
	}

}