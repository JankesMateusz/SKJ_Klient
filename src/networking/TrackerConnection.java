package networking;

import java.net.InetAddress;
import java.net.Socket;

public class TrackerConnection {

    private Peer peerServed;
    private Socket connection;


    public TrackerConnection(Peer peer){
        this.peerServed = peer;
    }

    public void connectPeerToServer() throws Exception{

        InetAddress address = InetAddress.getByName(peerServed.getServerName());
        int port = peerServed.getServerPort();

        connection = new Socket(address, port);
    }

    public boolean checkConnection(){
        return connection.isConnected();
    }

    public Socket getConnection(){
        return connection;
    }
}
