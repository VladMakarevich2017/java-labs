package server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

import application.Main;
import player_info.Player;
import table_cards.Card;

public class MonoThreadClientHandler implements Runnable {
    private Socket clientDialog;
   	private DataOutputStream out;
	private DataInputStream in;
	private String webCamConnectionAdress;

	public MonoThreadClientHandler(Socket client) throws IOException {
        clientDialog = client;
        out = new DataOutputStream(clientDialog.getOutputStream());
        in = new DataInputStream(clientDialog.getInputStream());
    }
    
    @Override
    public void run() {
    	return;
    }
    
    public void sendingInformation(Vector<Player> players, int playerId, int bankSize, Vector<Card> tableCards) {
        String message = "code:INFO" + ",bank:" + bankSize + ",cards:{";
        for(int i = 0; i < tableCards.size(); i++) {
        	message += tableCards.elementAt(i).getRange() + "-" + tableCards.elementAt(i).getSuit() + ";";
        }
        message += "}" + ",players:[";
        for(int i = 0; i < players.size();i++) {
        	message += "{&:" + i + ";";
        	message += "stake_size:" + players.elementAt(i).stake.getStakeSize() + ";";
        	message += "bet:" + players.elementAt(i).getCurrentBet() + ";";
        	if(!players.elementAt(i).getFoldFlag()) message += "fold:" + "false" + "}; "; 
        	else message += "fold:" + "true" + "}; "; 
        }
        message += "]";
    	if(!clientDialog.isClosed()) {
    		writeUTF(message);
    	}
    }
    
    public void sendingYourInformation(Player player) {
        String message = "code:YOU" + ",cards:{" + player.getPlayerCards()[0].getRange() + "-" + player.getPlayerCards()[0].getSuit();
        message += ";" + player.getPlayerCards()[1].getRange() + "-" + player.getPlayerCards()[1].getSuit() + "}";
        message += ",position:" + player.getTablePosition();
    	if(!clientDialog.isClosed()) {
    		writeUTF(message);
    	} 
    }
    
    public String webCamSendingRequest() {
    	return readUTF();
    }
    
    public String sendingRequest(int requestCode, int betDifference) {
		try {
            String message;
        	switch(requestCode) {
        		case 1: message = "code:ADD_BET" + ",bet:" + betDifference;
        			break;
        		case 2: message = "code:RAISE,";
        			break;
        		default: message = "code:NULL,";
        			break;
        	}
        	if(!clientDialog.isClosed()) {
            	writeUTF(message);
            	return readUTF();
        	} else {
        		return null;
        	}         
        } catch (Exception e) {
            System.exit(0);
        } 	
		return null;
    }
    
    public String readUTF() {
    		try {
    			return in.readUTF();
    		} catch (IOException e) {
    			e.printStackTrace();
    			return null;
    		}
    }
    
    public void writeUTF(String message) {
    		try {
    			out.writeUTF(message);
    			out.flush();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}	
    }
    
    public Socket getClientDialog() {
		return clientDialog;
	}

	public void setClientDialog(Socket clientDialog) {
		this.clientDialog = clientDialog;
	}
	
	public DataInputStream getIn() {
		return in;
	}

	public void setIn(DataInputStream in) {
		this.in = in;
	}
	
	public DataOutputStream getOut() {
		return out;
	}

	public void setOut(DataOutputStream out) {
		this.out = out;
	}

	public String getWebCamConnectionAdress() {
		return webCamConnectionAdress;
	}

	public void setWebCamConnectionAdress(String webCamConnectionAdress) {
		this.webCamConnectionAdress = webCamConnectionAdress;
	}
}
