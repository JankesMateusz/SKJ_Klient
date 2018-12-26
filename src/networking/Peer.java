package networking;

public class Peer {

    private String hostname;
    private int port;
    private String number;

    private String serverName;
    private int serverPort;

    private String directory;


    public Peer(String number){
        this.number = number;
        this.directory = ("D:\\Torrent_" + number);
    }

    public void setPort(int port){
        this.port = port;
        System.out.println("Port set: " + port);
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
        System.out.println("Hostname set: " + hostname);
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public String getServerName() {
        return serverName;
    }

    public int getServerPort() {
        return serverPort;
    }

    public String getDirectory(){return directory;}
}