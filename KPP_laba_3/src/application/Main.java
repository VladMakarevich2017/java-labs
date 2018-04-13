package application;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controller.MainController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.MainModel;
import paper.DrawingPaper;
import paper.OfficePaper;
import paper.Paper;
import paper.PhotoPaper;
import printer.Printer;
import printer.Xerox;

/**
 * The program calculates the final speed 
 * after an inelastic collision of two bodies 
 * with given masses and velocities
 * @author VladMakarevich
 *
 */

public class Main extends Application {
    public Button refillPaperButton;
	public Button printButton;
	public Button scanButton;
	public Button printScanningButton;
	public Label officePaperLabel;
	public Label photoPaperLabel;
	public Label drawingPaperLabel;
	public Label lengthOfficePaperLabel;
	public Label widthOfficePaperLabel;
	public Label contentOfficePaperLabel;
	public Label contentPhotoPaperLabel;
	public Label contentDrawingPaperLabel;
	public Label lengthPhotoPaperLabel;
	public Label widthPhotoPaperLabel;
	public Label lengthDrawingPaperLabel;
	public Label widthDrawingPaperLabel;
	public TextField lengthOfficePaperText;
	public TextField widthOfficePaperText;
	public TextField lengthPhotoPaperText;
	public TextField widthPhotoPaperText;
	public TextField lengthDrawingPaperText;
	public TextField widthDrawingPaperText;
	public TextField officeContent;
	public TextField photoContent;
	public TextField drawingContent;

	/**
	 * Start the program
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	   OfficePaper officePaper = new OfficePaper();
	   PhotoPaper photoPaper = new PhotoPaper();
	   DrawingPaper drawingPaper = new DrawingPaper();
	   Printer printer = new Printer();
	   Xerox xerox = new Xerox(drawingPaper);
	   Person person = new Person(printer, officePaper, photoPaper);
	   MainModel model = new MainModel(person, printer, xerox);
	   MainController controller = new MainController(this, model);
	   
	   GridPane root = new GridPane(); 
       root.setPadding(new Insets(20));
       root.setHgap(25);
       root.setVgap(15);
        
       refillPaperButton = new Button("Заполнить бумагой");
       printButton = new Button("Печать");
       scanButton = new Button("Сканировать бумагу");
       printScanningButton = new Button("Печать сканированного");
       officePaperLabel = new Label("Офисная бумага");
       photoPaperLabel = new Label("   Фотобумага");
       drawingPaperLabel = new Label("Бумага для черчения");
       lengthOfficePaperLabel = new Label("Длина");
       widthOfficePaperLabel = new Label("Ширина");
       contentOfficePaperLabel = new Label("Содержимое");
       contentPhotoPaperLabel = new Label("Содержимое");
       contentDrawingPaperLabel = new Label("Содержимое");
       lengthPhotoPaperLabel = new Label("Длина");
       widthPhotoPaperLabel = new Label("Ширина");
       lengthDrawingPaperLabel = new Label("Длина");
       widthDrawingPaperLabel = new Label("Ширина");
       lengthOfficePaperText = new TextField("");
       widthOfficePaperText = new TextField("");
       lengthPhotoPaperText = new TextField("");
       widthPhotoPaperText = new TextField("");
       lengthDrawingPaperText = new TextField("");
       widthDrawingPaperText = new TextField("");
       officeContent = new TextField("");
       photoContent = new TextField("");
       drawingContent = new TextField("");

       root.add(refillPaperButton, 0, 0, 2, 1); 
       printButton.setPrefSize(150, 20);
       root.add(printButton, 1, 1, 2, 1);
       GridPane.setHalignment(printButton, HPos.RIGHT);
       
       root.add(officePaperLabel, 0, 2 , 2, 1);
       GridPane.setHalignment(officePaperLabel, HPos.CENTER);
       
       root.add(photoPaperLabel, 3, 2 , 3, 1);
       GridPane.setHalignment(photoPaperLabel, HPos.CENTER);
       
       root.add(lengthOfficePaperLabel, 0, 3 , 1, 1);
       GridPane.setHalignment(lengthOfficePaperLabel, HPos.CENTER);
       
       root.add(widthOfficePaperLabel, 0, 4 , 1, 1);
       GridPane.setHalignment(widthOfficePaperLabel, HPos.CENTER);
       
       root.add(lengthPhotoPaperLabel, 2, 3 , 1, 1);
       GridPane.setHalignment(lengthPhotoPaperLabel, HPos.CENTER);
       
       root.add(widthPhotoPaperLabel, 2, 4 , 1, 1);
       GridPane.setHalignment(widthPhotoPaperLabel, HPos.CENTER);
       
       root.add(lengthOfficePaperText, 1, 3 , 1, 1);
       GridPane.setHalignment(lengthOfficePaperText, HPos.CENTER);
       
       root.add(widthOfficePaperText, 1, 4 , 1, 1);
       GridPane.setHalignment(widthOfficePaperText, HPos.CENTER);
       
       root.add(lengthPhotoPaperText, 3, 3 , 4, 1);
       GridPane.setHalignment(lengthPhotoPaperText, HPos.CENTER);
       
       root.add(widthPhotoPaperText, 3, 4 , 4, 1);
       GridPane.setHalignment(widthPhotoPaperText, HPos.CENTER);
       
       root.add(contentOfficePaperLabel, 0, 5, 1, 1);
       GridPane.setHalignment(contentOfficePaperLabel, HPos.CENTER);

       root.add(officeContent, 1, 5, 1, 1);
       GridPane.setHalignment(officeContent, HPos.CENTER);
       
       root.add(contentPhotoPaperLabel, 2, 5 , 1, 1);
       GridPane.setHalignment(contentPhotoPaperLabel, HPos.CENTER);
       
       root.add(photoContent, 3, 5, 4, 1);
       GridPane.setHalignment(photoContent, HPos.CENTER);
       
       root.add(scanButton, 0, 6, 2,  1);
       GridPane.setHalignment(scanButton, HPos.LEFT);
       
       root.add(printScanningButton, 1, 7, 2,  1);
       GridPane.setHalignment(printScanningButton, HPos.RIGHT);
       
       root.add(drawingPaperLabel, 0, 8, 2, 1);
       GridPane.setHalignment(drawingPaperLabel, HPos.CENTER);
       
       root.add(lengthDrawingPaperLabel, 0, 9, 1, 1);
       GridPane.setHalignment(lengthDrawingPaperLabel, HPos.CENTER);
       
       root.add(widthDrawingPaperLabel, 0, 10, 1, 1);
       GridPane.setHalignment(widthDrawingPaperLabel, HPos.CENTER);
       
       root.add(lengthDrawingPaperText, 1, 9, 1, 1);
       GridPane.setHalignment(lengthDrawingPaperText, HPos.CENTER);
       
       root.add(widthDrawingPaperText, 1, 10, 1, 1);
       GridPane.setHalignment(widthDrawingPaperText, HPos.CENTER);
       
       root.add(contentDrawingPaperLabel, 0, 11, 1, 1);
       GridPane.setHalignment(contentDrawingPaperLabel, HPos.CENTER);

       root.add(drawingContent, 1, 11, 1, 1);
       GridPane.setHalignment(drawingContent, HPos.CENTER);
       
       addPrintListener(model);
       addRefillPaperListener(model);
       addScanButtonListener(model);
       addPrintScanningButtonListener(model);
 	 
       Scene scene = new Scene(root, 680, 600);
       primaryStage.setTitle("KPP laba 3 20v");
       primaryStage.setResizable(false);
       primaryStage.setScene(scene);
       primaryStage.show();
		
	}
	
	public void addPrintListener(MainModel model) {
		printButton.setOnAction(event -> {
			try {
	   		 	this.lengthOfficePaperText.setText(String.valueOf(model.getPrinter().getOfficePaper().getLength()));
	   		 	this.widthOfficePaperText.setText(String.valueOf(model.getPrinter().getOfficePaper().getWidth()));
	   		 	this.officeContent.setText(model.getPrinter().getOfficePaper().getContent());
	   		 	this.lengthPhotoPaperText.setText(String.valueOf(model.getPrinter().getPhotoPaper().getLength()));
	   		 	this.widthPhotoPaperText.setText(String.valueOf(model.getPrinter().getPhotoPaper().getWidth()));
	   		 	this.photoContent.setText(model.getPrinter().getPhotoPaper().getContent());
	   		 	model.getPrinter().setOfficePaper(null);
	   		 	model.getPrinter().setPhotoPaper(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public void addRefillPaperListener(MainModel model) {
		refillPaperButton.setOnAction(event -> {
			try {
				model.getPerson().refillOfficePaper();
		        model.getPerson().refillPhotoPaper();
				model.getPerson().printText();
				model.getPerson().printImage();		
			} catch (Exception e) {
				e.printStackTrace();
			}
   		 	
		});
	}
	
	public void addScanButtonListener(MainModel model) {
		scanButton.setOnAction(event -> {
			model.getXerox().scanPaper(model.getPrinter().getOfficePaper());
		});
	}
	
	public void addPrintScanningButtonListener(MainModel model) {
		printScanningButton.setOnAction(event -> {
			model.getXerox().getDrawingPaper().setContent(model.getXerox().getBuffer());
			model.getXerox().getDrawingPaper().setWidth(model.getXerox().getWidth());
			model.getXerox().getDrawingPaper().setLength(model.getXerox().getLength());
			if(model.getXerox().getDrawingPaper().getLength() > 0 && model.getXerox().getDrawingPaper().getWidth() > 0 &&
					model.getXerox().getDrawingPaper().getContent() != "") {
				this.lengthDrawingPaperText.setText(String.valueOf(model.getXerox().getDrawingPaper().getLength()));
				this.widthDrawingPaperText.setText(String.valueOf(model.getXerox().getDrawingPaper().getWidth()));
	   		 	this.drawingContent.setText(model.getXerox().getDrawingPaper().getContent());
	   		 	model.getXerox().setDrawingPaper(null);
			} else {
				try {
					throw new Exception();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	

}
