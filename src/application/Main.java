package application;

public class Main {

    public static void main(String... args) throws Exception{

        String number = "";

        if(args.length > 0){
            number = args[0];
        }

        Application app = new Application(number);
        app.run();

    }
}
