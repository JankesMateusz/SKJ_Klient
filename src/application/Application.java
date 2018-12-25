package application;

import networking.Connector;
import networking.Peer;
import tools.Setter;


public class Application {

    private Setter setter;
    private Peer peer;
    private Connector connector;


    public Application(String number){
        this.peer = new Peer(number);
        this.setter = new Setter(peer);
        this.connector = new Connector(peer);
    }


    public void run() throws Exception{
        peer.setHostname(setter.setIp());
        peer.setPort(setter.setPort());

        peer.setServerName(setter.setIp());
        peer.setServerPort(setter.setPort());

        connector.connectPeerToServer();
    }

    public void display(String msg){
        System.out.println(msg);
    }
}
