package files;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class FilesLister {


    public ArrayList<String> getAllFilesList(String directory){

        ArrayList<String> allFiles = new ArrayList<>();
        File dir = new File(directory);
        File[] dirList = dir.listFiles();

        if(dirList != null){
            for(File child : dirList){
                allFiles.add(child.getName());
            }
        }
        return allFiles;
    }

    public HashMap<String, String> files(String directory) throws Exception{

        HashMap<String, String> filesAndChecksums = new HashMap<>();
        File dir = new File(directory);
        File[] dirList = dir.listFiles();

        if(dirList != null){
            for(File child : dirList){
                filesAndChecksums.put(child.getName(), new CheckSumGetter().getCheckSum(child.getPath()));
            }
        }
        return filesAndChecksums;
    }
}
