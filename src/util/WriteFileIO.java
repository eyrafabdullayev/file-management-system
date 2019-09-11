package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteFileIO {
    public static boolean writeObjectToFile(Object obj,String pathname){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(pathname))){
            outputStream.writeObject(obj);
            return true;
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
