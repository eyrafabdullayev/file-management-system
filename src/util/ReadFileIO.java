package util;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadFileIO {
    public static Object readFileDeserialize(String pathname){
        Object obj = null;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(pathname))){
            obj = inputStream.readObject();
        }finally {
            return obj;
        }
    }
}
