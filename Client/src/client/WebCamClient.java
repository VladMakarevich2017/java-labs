package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import webcam.ImageManipulation;
import webcam.WebCamManipulation;

public class WebCamClient implements Runnable{
	private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
	
	public WebCamClient(String ip, int port) {
    	try {
			socket = new Socket(ip, port);
            setOut(new DataOutputStream(socket.getOutputStream()));
            setIn(new DataInputStream(socket.getInputStream()));
    	} catch(ConnectException e) {
    		e.printStackTrace();
    	} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
        try 
        {
    		if(!socket.isConnected()) return;
        	while(!socket.isClosed()) {
        		if(WebCamManipulation.getCurrentImage() == null || !PokerClient.isWebCamFlag()) continue;
        		String message = PokerClient.getPlayerPosition() + ImageManipulation.imageToString(WebCamManipulation.getCurrentImage());
        		out.writeUTF(message);
        	}
            out.writeUTF("quit");
            socket.close();
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
        	System.out.println(e.toString() + e.getMessage());
        } 
	}

	public DataOutputStream getOut() {
		return out;
	}

	public void setOut(DataOutputStream out) {
		this.out = out;
	}

	public DataInputStream getIn() {
		return in;
	}

	public void setIn(DataInputStream in) {
		this.in = in;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}
