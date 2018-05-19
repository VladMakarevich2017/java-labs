package client;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.Controller;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class WebCamImagesDrawer implements Runnable {
	
	private Controller controller;
	public final String FILE_NAME = "player-image-";
	public final String IMAGE_TYPE = ".jpg";
	
	public WebCamImagesDrawer(Controller controller) {
		this.setController(controller);
	}

	@Override
	public void run() {
		while(controller != null) {
			for(int i = 0; i < 9; i++) {
				BufferedImage tempImage = null;
				try {
					File file = new File(FILE_NAME + i + IMAGE_TYPE);
					tempImage = ImageIO.read(file);
					file.delete();
					Image image = SwingFXUtils.toFXImage(tempImage, null );
					BackgroundSize backgroundSize = new BackgroundSize(110, 110, true, true, true, false);
					BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
					Background background = new Background(backgroundImage);
					selectPlayer(i + 1, background);
				} catch (Exception e) {
					continue;
				} 	
			}
		}
		
	}
	
	public void selectPlayer(int player, Background background) {
		switch (player) {
		case 1: controller.getWebCamVBox1().setStyle("-fx-border-width: 2;" + "-fx-border-color: gray;");
			controller.getWebCamVBox1().setBackground(background);
			break;
		case 2: controller.getWebCamVBox2().setStyle("-fx-border-width: 2;" + "-fx-border-color: gray;");
			controller.getWebCamVBox2().setBackground(background);
			break;
		case 3: controller.getWebCamVBox3().setBackground(background);
			controller.getWebCamVBox3().setStyle("-fx-border-width: 2;" + "-fx-border-color: gray;");
			break;
		case 4: controller.getWebCamVBox4().setBackground(background);
			controller.getWebCamVBox4().setStyle("-fx-border-width: 2;" + "-fx-border-color: gray;");
			break;
		case 5: controller.getWebCamVBox5().setBackground(background);
			controller.getWebCamVBox5().setStyle("-fx-border-width: 2;" + "-fx-border-color: gray;");
			break;
		case 6: controller.getWebCamVBox6().setBackground(background);
			controller.getWebCamVBox6().setStyle("-fx-border-width: 2;" + "-fx-border-color: gray;");
			break;
		case 7: controller.getWebCamVBox7().setBackground(background);
			controller.getWebCamVBox7().setStyle("-fx-border-width: 2;" + "-fx-border-color: gray;");
			break;
		case 8: controller.getWebCamVBox8().setBackground(background);
			controller.getWebCamVBox8().setStyle("-fx-border-width: 2;" + "-fx-border-color: gray;");
			break;
		case 9: controller.getWebCamVBox9().setBackground(background);
			controller.getWebCamVBox9().setStyle("-fx-border-width: 2;" + "-fx-border-color: gray;");
			break;
		default:
			break;
		}
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

}
