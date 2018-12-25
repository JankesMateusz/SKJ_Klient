package tools;

import java.util.regex.Pattern;

public class PortValidator {

    public boolean validate(String ip){

        Pattern correct = Pattern.compile("[1-9]\\d{4}");

        return correct.matcher(ip).matches();
    }
}
