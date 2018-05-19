package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import server.MonoThreadClientHandler;
import webcam.ImageManipulation;

public class WebCamServer implements Runnable {
	private String ip;
	private static int port = generatePort();
	private Vector<MonoThreadClientHandler> clients;
	private ExecutorService executeIt = Executors.newFixedThreadPool(10);
	private boolean readyFlag;
	
	
	public WebCamServer() {
		readyFlag = false;
		clients = new Vector<MonoThreadClientHandler>();
	}

	@Override
	public void run() {
		try (ServerSocket server = new ServerSocket(port);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                setIp(server.getLocalSocketAddress().toString());
                while(TestRunnableClientTester.getPlayers().size() == 0) Thread.sleep(10);
                for(int i = 0; i < TestRunnableClientTester.getPlayers().size() - 1; i++) { 
                	if (br.ready()) {
                        String serverCommand = br.readLine();
                        if (serverCommand.equalsIgnoreCase("quit")) {
                            server.close();
                            break;
                        }
                    }
                	readyFlag = true;
                	Socket client = server.accept();
                    MonoThreadClientHandler tempElem = new MonoThreadClientHandler(client);
                    clients.add(tempElem);
                    executeIt.execute(tempElem);
                }
                executeIt.shutdown();
                while(clients.size() != 0) {
                	for(int i = 0; i < clients.size(); i++) {
                		if(clients.elementAt(i).getClientDialog().isClosed()) closeHandle(i);
                		String request = clients.elementAt(i).webCamSendingRequest();
                		char position = request.charAt(0);
                		StringBuilder sb = new StringBuilder(request);
                		sb.deleteCharAt(0);
                		TestRunnableClientTester.getPlayers().elementAt(i).setImageDataString(sb.toString());
                		ImageManipulation.savingResizingImage(ImageManipulation.stringToBufferedImage(TestRunnableClientTester.getPlayers().elementAt(i).getImageDataString()), 110, 110, "player-image-" + position + ".jpg");
                	}
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
	}
	
	public static int generatePort() {
		Random rand = new Random();
		int tempPort;
		do {
			tempPort = rand.nextInt(6400) + 1000;
		} while(!isAvailablePort(tempPort) && tempPort != 0 && tempPort != -1);
		return tempPort;
	}
	
	public static boolean isAvailablePort(int port) {
	    if (port < 1000 || port > 65000) {
	        throw new IllegalArgumentException("Invalid start port: " + port);
	    }
	    ServerSocket ss = null;
	    DatagramSocket ds = null;
	    try {
	        ss = new ServerSocket(port);
	        ss.setReuseAddress(true);
	        ds = new DatagramSocket(port);
	        ds.setReuseAddress(true);
	        return true;
	    } catch (IOException e) {
	    } finally {
	        if (ds != null) {
	            ds.close();
	        }

	        if (ss != null) {
	            try {
	                ss.close();
	            } catch (IOException e) {
	            }
	        }
	    }
	    return false;
	}
	
	private void closeHandle(int clientNumber) throws IOException {
		clients.elementAt(clientNumber).getClientDialog().close();
		clients.elementAt(clientNumber).getIn().close();
		clients.elementAt(clientNumber).getOut().close();
		clients.removeElementAt(clientNumber);
	}
	
	public Vector<MonoThreadClientHandler> getClients() {
		return clients;
	}

	public void setClients(Vector<MonoThreadClientHandler> clients) {
		this.clients = clients;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int tempPort) {
		port = tempPort;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public boolean isReadyFlag() {
		return readyFlag;
	}

	public void setReadyFlag(boolean readyFlag) {
		this.readyFlag = readyFlag;
	}

}
