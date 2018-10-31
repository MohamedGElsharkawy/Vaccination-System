/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccination;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Mohammad
 */
public class Seller extends users implements Serializable {
   
 
    public Seller(){
    }
    public Seller(String userName,String Pass){
    super(userName,Pass);
    
    }
    
    @Override
     public boolean login(String userName, String Pass) {  
            if (userName.equals("seller@yahoo.com") && Pass.equals("seller")){
                return true;
            }

        return false;
    }

    @Override
    public String tostring() {
        return "I'm A Seller";
    }

 }