package tools;

import java.util.regex.Pattern;

public class IpValidator {


    public boolean validate(String ip){

        Pattern correct = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");

        if(correct.matcher(ip).matches() && !ip.equals("0.0.0.0"))
            return true;
        else
            return false;
    }
}