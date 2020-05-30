package edu.cuny.brooklyn.cisc3120.project.game.net;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StatusReceiver {
	
	
    private final static Logger LOGGER = LoggerFactory.getLogger(StatusReceiver.class);
    
    private final static String TIMER_NAME = "status_receiver";
    private final static long LONG_DELAY_BEFORE_1ST_RUN = 1; // 5000 milliseconds
    private final static long PERIOD_BETWEEN_RUNS = 10000; // 10000 milliseconds
//    private final static int BROADCAST_UDP_PORT = 62017;
//    private final static int BUFFER_SIZE = 8096;
    private static Timer timer;
    private static TimerTask task;
//    private DatagramSocket socket;
    private byte[] buf;
    private DatagramPacket packet;
    
    private int tcpPort;
    
//    private DatagramSocket socket;
    
    
    
    private final static int PORT = 62017;
    private final static String ADDRESS = "0.0.0.0";
    
    private final static int BUFFER_SIZE = 8096;
    
    private StatusMessage msg;
    
    private List<String> listStatusMessage = new LinkedList<String>();
    
    
    public StatusReceiver() throws IOException {
    	
//    	InetAddress 
    	
    		msg = new StatusMessage(null, 0);
        timer = new Timer(TIMER_NAME);
//        socket = new DatagramSocket();
//        socket.setBroadcast(true);
//        if (!socket.getBroadcast()) {
//            socket.close();
//            throw new SocketException("Broadcast is not supported.");
//        }
//        buf = new byte[BUFFER_SIZE];
//        packet = new DatagramPacket(buf, buf.length);
        
        /**
         * this is for supporting the bonus requirement: multiple players play the game online
         */
//        tcpPort = getFreeTcpPort();
    }
    
    public synchronized void close() {
//        socket.close();
//        socket = null;
        timer.cancel();
        LOGGER.debug("closing the UDP --- RECEIVER.");
    }
    
    public void start() {
    		
        task = new TimerTask() {
            @Override
            public void run() {

//            	DatagramSocket socket;
            
            	
        		SocketAddress address = null;
        		
                try {
                    address = new InetSocketAddress(InetAddress.getByName(ADDRESS), PORT);
                } catch (UnknownHostException e) {
                    LOGGER.error(String.format("Address or name %s is not a valid address or name", ADDRESS), e);
                    System.exit(-1);
                }
                
                try (DatagramSocket socket = new DatagramSocket(address)) {
                    byte buf[] = new byte[BUFFER_SIZE];
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);

                        socket.receive(packet);
                        
                        
                        ByteArrayInputStream baos = new ByteArrayInputStream(packet.getData());
                        ObjectInputStream oos = new ObjectInputStream(baos);
                        msg = (StatusMessage)oos.readObject();
                        LOGGER.info(String.format("Local(%d@%s) <<<< Remote (%d@%s): %s"
                                , socket.getLocalPort(), socket.getLocalAddress().toString()
                                , packet.getPort(), packet.getAddress().toString()
                                , msg.toString()));
                    LOGGER.info("Received 100 messages, and now ends gracefully.");
                    

                    
                } catch (SocketException e) {
                    LOGGER.error(String.format("Failed to create a DatagramSocket bound to host %s at port %d."
                            , ADDRESS, PORT), e);
                } catch (IOException e) {
                    LOGGER.error("Failed to read from the DatagramSocket", e);
                } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
            		
             
                
//        		if(!listStatusMessage.contains(msg.toString())) {
//        			listStatusMessage.add(new String(msg.toString()));
//        		}
//        		
//            FXCollections.observableList(listStatusMessage);
            	
            	
            	
            	
            	
            	
            	
            };
        };
        timer.schedule(task, LONG_DELAY_BEFORE_1ST_RUN, PERIOD_BETWEEN_RUNS);    
    }
    
    public StatusMessage getMessage() {
    		return msg;
    }
    
    
    public ObservableList<String> toObservableList() throws ClassNotFoundException, IOException {			
//		UdpStatusMessageReceiver.updateStatusMessage();
		
		if(!listStatusMessage.contains(msg.toString())) {
			listStatusMessage.add(new String(msg.toString()));
		}
		
    return FXCollections.observableList(listStatusMessage);
}
    
     
    

}



