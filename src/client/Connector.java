package client;

import java.net.InetAddress;
import java.net.Socket;

public class Connector {

    private Peer peerServed;
    private Socket connection;


    public Connector(Peer peer){
        this.peerServed = peer;
    }

    public void connectPeerToServer() throws Exception{

        InetAddress address = InetAddress.getByName(peerServed.getServerName());
        int port = peerServed.getServerPort();

        connection = new Socket(address, port);
    }

    public void checkConnection(){
        System.out.println(connection.isConnected());
    }
}
