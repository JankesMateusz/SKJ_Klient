package tools;

import networking.Peer;
import java.util.Scanner;

public class Setter {


    public String setIp(){
        String ip = "";
        IpValidator validator = new IpValidator();
        display("Insert ip: ");
        while(!validator.validate(ip)){
            Scanner input = new Scanner(System.in);
            ip = input.next();
            if(!validator.validate(ip)){
                display("Wrong ip format, try again: ");
            }
        }
        return ip;
    }

    public int setPort(){
        String port = "";
        PortValidator validator = new PortValidator();
        display("Insert port number: ");
        while(!validator.validate(port)){
            Scanner input = new Scanner(System.in);
            port = input.next();
            if(!validator.validate(port)){
                display("Port number should be 10000 and higher!");
            }
        }
        return Integer.parseInt(port);
    }

    public void display(String msg){
        System.out.println(msg);
    }
}
