package networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Comunicator {

    private TrackerConnection trackerConnection;
    private PrintWriter out;
    private BufferedReader in;
    private Socket socket;

    public Comunicator(TrackerConnection connectionToHandle)throws Exception{

        this.trackerConnection = connectionToHandle;
        this.socket = trackerConnection.getConnection();
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void sendInfoAboutMe(){


    }

}
