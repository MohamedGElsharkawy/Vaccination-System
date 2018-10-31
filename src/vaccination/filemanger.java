/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccination;

/**
 *
 * @author TEfa
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class filemanger implements Serializable {

    public boolean write(String Query, String FilePath, boolean appendType) {

        PrintWriter writter = null;
        try {
            System.out.print("\nwritting in ! " + FilePath);

            writter = new PrintWriter(new FileWriter(new File(FilePath), appendType));
            writter.println(Query);

            System.out.println(" ... Done ! ");
            return true;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writter.close();
        }
        return false;
    }

    public ArrayList<Object> read(String FilePath) {

        Scanner Reader = null;
        try {
            System.out.println("Reading ! From " + FilePath);

            Reader = new Scanner(new File(FilePath));

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        if (FilePath.equals("feedback.txt")) {

            ArrayList<feedback> feedbacks = new ArrayList<feedback>();
            feedback x;

            while (Reader.hasNext()) {

                x = new feedback();
                customer c=new customer();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                x.feedbackID=(Integer.parseInt(seprated[0]));
                c.setemail(seprated[1]);
                x.setVeryGood(Boolean.parseBoolean(seprated[2]));
                x.setGood(Boolean.parseBoolean(seprated[3]));
                x.setNormal(Boolean.parseBoolean(seprated[4]));
                x.setBad(Boolean.parseBoolean(seprated[5]));
                x.setVeryBad(Boolean.parseBoolean(seprated[6]));
                x.setMessage(seprated[7]);

                feedbacks.add(x);
            }

            return (ArrayList<Object>) (Object) feedbacks;

        } else {
            return null;
        }

    }

}

