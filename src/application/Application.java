package application;

import files.FilesLister;
import networking.TrackerConnection;
import networking.Peer;

import java.util.ArrayList;
import java.util.Scanner;


public class Application {

    private Peer peer;
    private TrackerConnection connection;
    private boolean trackerConnection;
    private ArrayList<String> files;

    public Application(String number){
        this.peer = new Peer(number);
        this.connection = new TrackerConnection(peer);
        this.files = new FilesLister().files(peer.getDirectory());
    }


    public void run() throws Exception{
        peer.setHostname("127.168.1.2");  //(new Setter().setIp());
        peer.setPort(10001);  //(new Setter().setPort());

        peer.setServerName("127.168.1.1");  //(new Setter().setIp());
        peer.setServerPort(10000);  //(new Setter().setPort());

        connection.connectPeerToServer();
        trackerConnection = true;

        while(trackerConnection){
            actionManagement();
            connection.checkConnection();
        }
    }

    public void actionManagement(){
        System.out.println(
                "Choose action:\n" +
                "1. List my files\n" +
                "2. Enter file to search for\n" +
                "3. Exit");
        int choice;
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        System.out.println(choice);
    }
}
