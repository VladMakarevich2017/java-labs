package controller;
import java.awt.Button;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import application.Main;
import application.Sound;
import client.TestRunnableClientTester;
import client.WebCamImagesDrawer;
import game.SingleGame;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import webcam.WebCamManipulation;

public class Controller implements Initializable{
	public static boolean onlineGameFlag = false;
	private boolean progressFlag = false;
	private int tempRate;

	@FXML
	private ToggleButton voiceBtn;
	@FXML
	private Text bank;
	@FXML
	private TextField rate;
	@FXML
	private Button fold;
	@FXML
	private Button raise;
	@FXML
	private Button callOrCheck;
	@FXML
	private TextArea info;
	@FXML
	public ImageView tableCard1;
	@FXML
	public ImageView tableCard2;
	@FXML
	public ImageView tableCard3;
	@FXML
	public ImageView tableCard4;
	@FXML
	public ImageView tableCard5;
	@FXML
	public ImageView playerFirstCard;
	@FXML
	public ImageView playerSecondCard;
	@FXML
	public Text player1;
	@FXML
	public Text player2;
	@FXML
	public Text player3;
	@FXML
	public Text player4;
	@FXML
	public Text player5;
	@FXML
	public Text player6;
	@FXML
	public Text player7;
	@FXML
	public Text player8;
	@FXML
	public Text player9;
	@FXML
	private Text rate1;
	@FXML
	private Text rate2;
	@FXML
	private Text rate3;
	@FXML
	private Text rate4;
	@FXML
	private Text rate5;
	@FXML
	private Text rate6;
	@FXML
	private Text rate7;
	@FXML
	private Text rate8;
	@FXML
	private Text rate9;	
	@FXML
	private Text rateValue1;
	@FXML
	private Text rateValue2;
	@FXML
	private Text rateValue3;
	@FXML
	private Text rateValue4;
	@FXML
	private Text rateValue5;
	@FXML
	private Text rateValue6;
	@FXML
	private Text rateValue7;
	@FXML
	private Text rateValue8;
	@FXML
	private Text rateValue9;
	@FXML
	private Text stake1;
	@FXML
	private Text stake2;
	@FXML
	private Text stake3;
	@FXML
	private Text stake4;
	@FXML
	private Text stake5;
	@FXML
	private Text stake6;
	@FXML
	private Text stake7;
	@FXML
	private Text stake8;
	@FXML
	private Text stake9;
	@FXML
	private VBox vbox1;
	@FXML
	private VBox vbox2;
	@FXML
	private VBox vbox3;
	@FXML
	private VBox vbox4;
	@FXML
	private VBox vbox5;
	@FXML
	private VBox vbox6;
	@FXML
	private VBox vbox7;
	@FXML
	private VBox vbox8;
	@FXML
	private VBox vbox9;
	@FXML
	private VBox webCamVBox1;
	@FXML
	private VBox webCamVBox2;
	@FXML
	private VBox webCamVBox3;
	@FXML
	private VBox webCamVBox4;
	@FXML
	private VBox webCamVBox5;
	@FXML
	private VBox webCamVBox6;
	@FXML
	private VBox webCamVBox7;
	@FXML
	private VBox webCamVBox8;
	@FXML
	private VBox webCamVBox9;
	
	
	@FXML
	private void check() throws IOException {
		try {
			if(!onlineGameFlag) {
				if(!rate.getText().isEmpty()) {
					tempRate = Integer.parseInt(rate.getText());
				} else {
					tempRate = 0;
				}
				progressFlag = true;
			} else {
				if(TestRunnableClientTester.compareBet() == false) {
					TestRunnableClientTester.writeUTF(String.valueOf(TestRunnableClientTester.getTempBet()));
				} else {
					TestRunnableClientTester.writeUTF("0");
				}
			}
			rate.clear();
			info.clear();
			info.setText("Ставка принята. Ожидайте хода других игроков.");
		} catch(NumberFormatException e) {
			return;
		} catch (Exception e) {
			info.setText("Ставка недоступна. Ошибка подключения");
		}
	}
	
	@FXML
	private void raiseMenu() throws IOException {
		try {
			if(rate.getText().isEmpty()) return;
			int tempRaise = Integer.parseInt(rate.getText());
			if(!onlineGameFlag) {
				tempRate = tempRaise;
				progressFlag = true;
			} else {
				TestRunnableClientTester.writeUTF(String.valueOf(tempRaise));
			}
			rate.clear();
			info.clear();
			info.setText("Ставка принята. Ожидайте хода других игроков.");
		} catch(NumberFormatException e) {
			return;
		} catch (Exception e) {
			info.setText("Ставка недоступна. Ошибка подключения");
		}
		
	}
	
	@FXML
	private void foldMenu() throws IOException {
		try {
			playerFirstCard.setOpacity(0.3);
			playerSecondCard.setOpacity(0.3);
			if(!onlineGameFlag) {
				tempRate = -1;
				progressFlag = true;
			} else {
				TestRunnableClientTester.writeUTF("-1");
			}
			rate.clear();
			info.clear();
			info.setText("Вы покинули раздачу. Ожидайте следующей.");
		} catch(Exception e) {
			info.setText("Ставка недоступна. Ошибка подключения");
		}
		
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		info.setText("Добро пожаловать.");
		if(onlineGameFlag) {
			ExecutorService exec = Executors.newFixedThreadPool(10);
	        exec.execute(new TestRunnableClientTester(this));
	        exec.execute(new WebCamImagesDrawer(this));
	        exec.shutdown();
		} else {
			SingleGame.controller = this;
		}
	}
	
	@FXML
	public void exit() throws IOException {
		TestRunnableClientTester.setGamePort(0);
		Stage newWindow = new Stage();
		WebCamManipulation.closeWebCam();
		Group group = new Group();
		Parent content = FXMLLoader.load(getClass().getResource("../sampleMain.fxml"));
		BorderPane root = new BorderPane();
		root.setCenter(content);
		group.getChildren().add(root);
		newWindow.setScene(new Scene(group, 1100, 975));
		Main.getArg().close();
		Main.setArg(newWindow);
		newWindow.show();
	}
	
	@FXML
	private void turnOnOrOffVoice() {
		if(voiceBtn.isSelected()) {
			TestRunnableClientTester.setWebCamFlag(true);
		} else {
			TestRunnableClientTester.setWebCamFlag(false);
		}
	}
	
	public void setPlayer1(int stakeSize, double opacity, int bet) {
		vbox1.setOpacity(opacity);
		rate1.setOpacity(1);
		rateValue1.setOpacity(1);
		rateValue1.setText(String.valueOf(bet));
		stake1.setText(String.valueOf(stakeSize));
	}
	public void setPlayer2(int stakeSize, double opacity, int bet) {
		vbox2.setOpacity(opacity);
		rate2.setOpacity(1);
		rateValue2.setOpacity(1);
		rateValue2.setText(String.valueOf(bet));
		stake2.setText(String.valueOf(stakeSize));
	}
	public void setPlayer3(int stakeSize, double opacity, int bet) {
		vbox3.setOpacity(opacity);
		rate3.setOpacity(1);
		rateValue3.setOpacity(1);
		rateValue3.setText(String.valueOf(bet));
		stake3.setText(String.valueOf(stakeSize));
	}
	public void setPlayer4(int stakeSize, double opacity, int bet) {
		vbox4.setOpacity(opacity);
		rate4.setOpacity(1);
		rateValue4.setOpacity(1);
		rateValue4.setText(String.valueOf(bet));
		stake4.setText(String.valueOf(stakeSize));
	}
	public void setPlayer5(int stakeSize, double opacity, int bet) {
		vbox5.setOpacity(opacity);
		rate5.setOpacity(1);
		rateValue5.setOpacity(1);
		rateValue5.setText(String.valueOf(bet));
		stake5.setText(String.valueOf(stakeSize));
	}
	public void setPlayer6(int stakeSize, double opacity, int bet) {
		vbox6.setOpacity(opacity);
		rate6.setOpacity(1);
		rateValue6.setOpacity(1);
		rateValue6.setText(String.valueOf(bet));
		stake6.setText(String.valueOf(stakeSize));
	}
	public void setPlayer7(int stakeSize, double opacity, int bet) {
		vbox7.setOpacity(opacity);
		rate7.setOpacity(1);
		rateValue7.setOpacity(1);
		rateValue7.setText(String.valueOf(bet));
		stake7.setText(String.valueOf(stakeSize));
	}
	public void setPlayer8(int stakeSize, double opacity, int bet) {
		vbox8.setOpacity(opacity);
		rate8.setOpacity(1);
		rateValue8.setOpacity(1);
		rateValue8.setText(String.valueOf(bet));
		stake8.setText(String.valueOf(stakeSize));
	}
	public void setPlayer9(int stakeSize, double opacity, int bet) {
		vbox9.setOpacity(opacity);
		rate9.setOpacity(1);
		rateValue9.setOpacity(1);
		rateValue9.setText(String.valueOf(bet));
		stake9.setText(String.valueOf(stakeSize));
	}
	
	@FXML
	public TextField getRate() {
		return rate;
	}
	
	@FXML
	public TextArea getInfo() {
		return info;
	}
	@FXML
	public ToggleButton getvoiceBtn() {
		return voiceBtn;
	}
	@FXML
	public Text getbank() {
		return bank;
	}
	@FXML
	public Button getfold() {
		return fold;
	}
	@FXML
	public Button getraise() {
		return raise;
	}
	@FXML
	public Button getcallOrCheck() {
		return callOrCheck;
	}

	public boolean isProgressFlag() {
		return progressFlag;
	}

	public void setProgressFlag(boolean progressFlag) {
		this.progressFlag = progressFlag;
	}

	public int getTempRate() {
		return tempRate;
	}

	public void setTempRate(int tempRate) {
		this.tempRate = tempRate;
	}
	
	public ToggleButton getVoiceBtn() {
		return voiceBtn;
	}

	public void setVoiceBtn(ToggleButton voiceBtn) {
		this.voiceBtn = voiceBtn;
	}

	public Text getBank() {
		return bank;
	}

	public void setBank(Text bank) {
		this.bank = bank;
	}

	public Button getFold() {
		return fold;
	}

	public void setFold(Button fold) {
		this.fold = fold;
	}

	public Button getRaise() {
		return raise;
	}

	public void setRaise(Button raise) {
		this.raise = raise;
	}

	public Button getCallOrCheck() {
		return callOrCheck;
	}

	public void setCallOrCheck(Button callOrCheck) {
		this.callOrCheck = callOrCheck;
	}

	public Text getRate1() {
		return rate1;
	}

	public void setRate1(Text rate1) {
		this.rate1 = rate1;
	}

	public Text getRate2() {
		return rate2;
	}

	public void setRate2(Text rate2) {
		this.rate2 = rate2;
	}

	public Text getRate3() {
		return rate3;
	}

	public void setRate3(Text rate3) {
		this.rate3 = rate3;
	}

	public Text getRate4() {
		return rate4;
	}

	public void setRate4(Text rate4) {
		this.rate4 = rate4;
	}

	public Text getRate5() {
		return rate5;
	}

	public void setRate5(Text rate5) {
		this.rate5 = rate5;
	}

	public Text getRate6() {
		return rate6;
	}

	public void setRate6(Text rate6) {
		this.rate6 = rate6;
	}

	public Text getRate7() {
		return rate7;
	}

	public void setRate7(Text rate7) {
		this.rate7 = rate7;
	}

	public Text getRate8() {
		return rate8;
	}

	public void setRate8(Text rate8) {
		this.rate8 = rate8;
	}

	public Text getRate9() {
		return rate9;
	}

	public void setRate9(Text rate9) {
		this.rate9 = rate9;
	}

	public Text getRateValue1() {
		return rateValue1;
	}

	public void setRateValue1(Text rateValue1) {
		this.rateValue1 = rateValue1;
	}

	public Text getRateValue2() {
		return rateValue2;
	}

	public void setRateValue2(Text rateValue2) {
		this.rateValue2 = rateValue2;
	}

	public Text getRateValue3() {
		return rateValue3;
	}

	public void setRateValue3(Text rateValue3) {
		this.rateValue3 = rateValue3;
	}

	public Text getRateValue4() {
		return rateValue4;
	}

	public void setRateValue4(Text rateValue4) {
		this.rateValue4 = rateValue4;
	}

	public Text getRateValue5() {
		return rateValue5;
	}

	public void setRateValue5(Text rateValue5) {
		this.rateValue5 = rateValue5;
	}

	public Text getRateValue6() {
		return rateValue6;
	}

	public void setRateValue6(Text rateValue6) {
		this.rateValue6 = rateValue6;
	}

	public Text getRateValue7() {
		return rateValue7;
	}

	public void setRateValue7(Text rateValue7) {
		this.rateValue7 = rateValue7;
	}

	public Text getRateValue8() {
		return rateValue8;
	}

	public void setRateValue8(Text rateValue8) {
		this.rateValue8 = rateValue8;
	}

	public Text getRateValue9() {
		return rateValue9;
	}

	public void setRateValue9(Text rateValue9) {
		this.rateValue9 = rateValue9;
	}

	public Text getStake1() {
		return stake1;
	}

	public void setStake1(Text stake1) {
		this.stake1 = stake1;
	}

	public Text getStake2() {
		return stake2;
	}

	public void setStake2(Text stake2) {
		this.stake2 = stake2;
	}

	public Text getStake3() {
		return stake3;
	}

	public void setStake3(Text stake3) {
		this.stake3 = stake3;
	}

	public Text getStake4() {
		return stake4;
	}

	public void setStake4(Text stake4) {
		this.stake4 = stake4;
	}

	public Text getStake5() {
		return stake5;
	}

	public void setStake5(Text stake5) {
		this.stake5 = stake5;
	}

	public Text getStake6() {
		return stake6;
	}

	public void setStake6(Text stake6) {
		this.stake6 = stake6;
	}

	public Text getStake7() {
		return stake7;
	}

	public void setStake7(Text stake7) {
		this.stake7 = stake7;
	}

	public Text getStake8() {
		return stake8;
	}

	public void setStake8(Text stake8) {
		this.stake8 = stake8;
	}

	public Text getStake9() {
		return stake9;
	}

	public void setStake9(Text stake9) {
		this.stake9 = stake9;
	}

	public VBox getVbox1() {
		return vbox1;
	}

	public void setVbox1(VBox vbox1) {
		this.vbox1 = vbox1;
	}

	public VBox getVbox2() {
		return vbox2;
	}

	public void setVbox2(VBox vbox2) {
		this.vbox2 = vbox2;
	}

	public VBox getVbox3() {
		return vbox3;
	}

	public void setVbox3(VBox vbox3) {
		this.vbox3 = vbox3;
	}

	public VBox getVbox4() {
		return vbox4;
	}

	public void setVbox4(VBox vbox4) {
		this.vbox4 = vbox4;
	}

	public VBox getVbox5() {
		return vbox5;
	}

	public void setVbox5(VBox vbox5) {
		this.vbox5 = vbox5;
	}

	public VBox getVbox6() {
		return vbox6;
	}

	public void setVbox6(VBox vbox6) {
		this.vbox6 = vbox6;
	}

	public VBox getVbox7() {
		return vbox7;
	}

	public void setVbox7(VBox vbox7) {
		this.vbox7 = vbox7;
	}

	public VBox getVbox8() {
		return vbox8;
	}

	public void setVbox8(VBox vbox8) {
		this.vbox8 = vbox8;
	}

	public VBox getVbox9() {
		return vbox9;
	}

	public void setVbox9(VBox vbox9) {
		this.vbox9 = vbox9;
	}

	public VBox getWebCamVBox1() {
		return webCamVBox1;
	}

	public void setWebCamVBox1(VBox webCamVBox1) {
		this.webCamVBox1 = webCamVBox1;
	}

	public VBox getWebCamVBox2() {
		return webCamVBox2;
	}

	public void setWebCamVBox2(VBox webCamVBox2) {
		this.webCamVBox2 = webCamVBox2;
	}

	public VBox getWebCamVBox3() {
		return webCamVBox3;
	}

	public void setWebCamVBox3(VBox webCamVBox3) {
		this.webCamVBox3 = webCamVBox3;
	}

	public VBox getWebCamVBox4() {
		return webCamVBox4;
	}

	public void setWebCamVBox4(VBox webCamVBox4) {
		this.webCamVBox4 = webCamVBox4;
	}

	public VBox getWebCamVBox5() {
		return webCamVBox5;
	}

	public void setWebCamVBox5(VBox webCamVBox5) {
		this.webCamVBox5 = webCamVBox5;
	}

	public VBox getWebCamVBox6() {
		return webCamVBox6;
	}

	public void setWebCamVBox6(VBox webCamVBox6) {
		this.webCamVBox6 = webCamVBox6;
	}

	public VBox getWebCamVBox7() {
		return webCamVBox7;
	}

	public void setWebCamVBox7(VBox webCamVBox7) {
		this.webCamVBox7 = webCamVBox7;
	}

	public VBox getWebCamVBox8() {
		return webCamVBox8;
	}

	public void setWebCamVBox8(VBox webCamVBox8) {
		this.webCamVBox8 = webCamVBox8;
	}

	public VBox getWebCamVBox9() {
		return webCamVBox9;
	}

	public void setWebCamVBox9(VBox webCamVBox9) {
		this.webCamVBox9 = webCamVBox9;
	}

	public void setRate(TextField rate) {
		this.rate = rate;
	}

	public void setInfo(TextArea info) {
		this.info = info;
	}

}
