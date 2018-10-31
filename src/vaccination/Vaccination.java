
package vaccination;

import java.io.File;
import java.util.*;


public class Vaccination {

 
    public static void main(String[] args) {
      userview.login form = new userview.login();
      form.setVisible(true);
String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        File currentDir = new File(projectPath); // current directory				
	checkDirectoryContents(currentDir);
        
      
        
    }
     public static void checkDirectoryContents(File dir){
        File[] files = dir.listFiles();
        boolean customerfile = true;
         boolean productfile  =true;
        boolean reservefile  =true;

        for (File file : files) {

            if (file.getName().contains("customer.bin")) {
                customerfile = false;
            }
             else if (file.getName().contains("product.bin")) {
                productfile = false;
            }
               else if (file.getName().contains("reserve.bin")) {
                reservefile = false;
            }
        }
        if (customerfile){
            customer x = new customer();
            x.committofile();
        } 
         else if (productfile){
            Product x = new Product();
            x.committofile();
        }
      else if (reservefile){
            Reservation x = new Reservation();
            x.committofile();
        }
    }
}

   

   /* public static String[] Tokens(String line,char separator){
     String result[] =new String[10];
     String word ="";
     int i,ctr=0;
     for( i=0;i<line.length();i++){
     if (line.charAt(i)!=separator){
     word+=line.charAt(i);
      }
     else{
     result[ctr]=word;
     ctr++;
     word = new String();
}
}
  return result;  
 }*/




 
    

