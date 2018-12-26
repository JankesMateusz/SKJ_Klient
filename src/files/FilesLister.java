package files;

import java.io.File;
import java.util.ArrayList;

public class FilesLister {


    public ArrayList<String> files(String directory){

        ArrayList<String> files = new ArrayList<>();
        File dir = new File(directory);
        File[] dirList = dir.listFiles();

        if(dirList != null){
            for(File child : dirList){
                files.add(child.getName());
            }
        }
        return files;
    }
}
