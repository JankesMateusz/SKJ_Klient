package files;

import javax.xml.bind.DatatypeConverter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;

public class CheckSumGetter {

    public String getCheckSum(String url) throws Exception{

        byte[] b = Files.readAllBytes(Paths.get(url));
        byte[] hash = MessageDigest.getInstance("MD5").digest(b);

        return DatatypeConverter.printHexBinary(hash);
    }
}
