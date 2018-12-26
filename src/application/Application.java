package application;

import networking.Connector;
import networking.Peer;
import tools.Setter;


public class Application {

    private Peer peer;
    private Connector connector;


    public Application(String number){
        this.peer = new Peer(number);
        this.connector = new Connector(peer);
    }


    public void run() throws Exception{
        peer.setHostname("127.168.1.2");  //(new Setter().setIp());
        peer.setPort(10001);  //(new Setter().setPort());

        peer.setServerName("127.168.1.1");  //(new Setter().setIp());
        peer.setServerPort(10000);  //(new Setter().setPort());

        connector.connectPeerToServer();
    }

    public void display(String msg){
        System.out.println(msg);
    }
}
