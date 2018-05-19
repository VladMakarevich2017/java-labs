package controller;

import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import application.Main;
import client.TestRunnableClientTester;
import game.OnlineGame;
import game.SingleGame;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ControllerCreateSingleGame implements Initializable{
	
	@FXML
	private TextField numberOfBots;
	@FXML
	private TextField stackSize;
	@FXML
	private Button createNewGame;

	@FXML
	private void createGame() throws IOException {
		try {
			if(numberOfBots.getText() != "" && Integer.parseInt(numberOfBots.getText()) > 0 &&
					stackSize.getText() != "" && Integer.parseInt(stackSize.getText()) > 0) {
				Controller.onlineGameFlag = false;
				ExecutorService exec = Executors.newFixedThreadPool(10);
				Stage newWindow = new Stage();
				Group group = new Group();
				Parent content = FXMLLoader.load(getClass().getResource("../sample.fxml"));
				exec.execute(new SingleGame(Integer.parseInt(numberOfBots.getText()), 
						Integer.parseInt(stackSize.getText()) / 100, Integer.parseInt(stackSize.getText()) / 50,
						 Integer.parseInt(stackSize.getText())));
				exec.shutdown();
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
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		numberOfBots.setText("3");
		stackSize.setText("1200");
		ExecutorService exec = Executors.newFixedThreadPool(10);
        exec.shutdown();
	}
	

}