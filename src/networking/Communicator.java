package networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Communicator {

    private final String[] requests = {"GET", "INTRODUCE", "UPDATE", "BYE"};
    private TrackerConnection trackerConnection;
    private PrintWriter out;
    private BufferedReader in;
    private ObjectOutputStream objectOutputStream;
    private Socket socket;
    private Peer peer;

    public Communicator(TrackerConnection connectionToHandle, Peer peer)throws Exception{

        this.peer = peer;
        this.trackerConnection = connectionToHandle;
        this.socket = trackerConnection.getConnection();
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    public void sendRequest(int number){
        out.println(requests[number]);

    }

    public void getFile(String fileName){
        out.println(requests[0] + " " + fileName);
    }

    public void introduce()throws Exception{
        out.println(requests[1] + " " +
                    peer.getNumber() + " " +
                    peer.getHostname() + " " +
                    peer. getPort());
        objectOutputStream.writeObject(peer.getFileList());
    }

}
