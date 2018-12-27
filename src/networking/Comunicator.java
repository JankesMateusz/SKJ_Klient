package networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Comunicator {

    private TrackerConnection trackerConnection;
    private PrintWriter out;
    private BufferedReader in;

    public Comunicator(TrackerConnection connectionToHandle)throws Exception{

        this.trackerConnection = connectionToHandle;
        Socket socket = trackerConnection.getConnection();
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }


}
