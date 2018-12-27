package application;

import files.FilesLister;
import networking.TrackerConnection;
import networking.Peer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Application {

    private Peer peer;
    private TrackerConnection connection;
    private boolean trackerConnection;
    private HashMap<String, String> files;

    public Application(String number)throws Exception{
        this.peer = new Peer(number);
        this.connection = new TrackerConnection(peer);
        this.files = new FilesLister().filesMap(peer.getDirectory());
    }


    public void run() throws Exception{
        trackerConnection = true;
        peer.setHostname("127.168.1.2");  //(new Setter().setIp());
        peer.setPort(10001);  //(new Setter().setPort());

        peer.setServerName("127.168.1.1");  //(new Setter().setIp());
        peer.setServerPort(10000);  //(new Setter().setPort());

        connection.connectPeerToServer();
        trackerConnection = true;

        while(trackerConnection){
            actionManagement();
        }
    }

    public void actionManagement()throws Exception{
        System.out.println(
                "Choose action:\n" +
                "1. List my filesMap\n" +
                "2. Enter file to search for\n" +
                "3. Exit");
        getAction();
        System.out.println(connection.checkConnection());
    }

    private void getAction() throws Exception{

        Scanner input = new Scanner(System.in);
        switch(input.nextInt()){
            case 1: listFiles();
                    break;
            case 2: getFileToFind();
                    break;
            case 3: System.exit(0);
                    break;
        }
    }

    private void listFiles(){

        System.out.println("---- FILES ----");
        for(Map.Entry<String, String> entry : files.entrySet()){
            System.out.println(entry.getKey() + " /checksum: " + entry.getValue());
        }
        System.out.println("---------------");
    }

    private void getFileToFind(){

        System.out.println("Enter file: name.type(eg.: photo.jpg)");
        Scanner input = new Scanner(System.in);
        String file = input.next();
    }
}
