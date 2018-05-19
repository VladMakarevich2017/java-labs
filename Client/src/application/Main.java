package application;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{
	private static Stage arg;
	
    public static void main(String[] args) throws IOException, InterruptedException {
    	launch(args);
    }
    
	@Override
	public void start(Stage arg0) throws Exception{
		setArg(arg0);
		Group group = new Group();
		Parent content = FXMLLoader.load(getClass().getResource("../sampleMain.fxml"));
		BorderPane root = new BorderPane();
		root.setCenter(content);
		group.getChildren().add(root);
		arg0.setScene(new Scene(group, 1100, 975));
		arg0.show();
	}

	public static Stage getArg() {
		return arg;
	}

	public static void setArg(Stage arg) {
		Main.arg = arg;
	}

}