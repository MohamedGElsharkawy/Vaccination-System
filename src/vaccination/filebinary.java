
package vaccination;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class filebinary implements Serializable {
    public boolean write(String filepath,Object data){
    try{
    System.out.print("wrtting in :" + filepath);
    ObjectOutputStream writter = new ObjectOutputStream(new FileOutputStream(filepath));
    writter.writeObject(data);
    System.out.print("done");
    writter.close();
    return true;
    }
    catch(IOException e){
        System.out.print("can't write" + e);
    }
    return false;
    }
 public Object read(String filepath){
         Object Result = null;

        try {
            System.out.println("Reading ! From " +filepath);

            ObjectInputStream Reader = new ObjectInputStream(new FileInputStream(filepath));

            Result = Reader.readObject();

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(filebinary.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Result;
}
}
