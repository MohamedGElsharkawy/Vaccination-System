
package vaccination;

import java.io.Serializable;


public class admin extends users implements Serializable{
        public admin() {

    }

    public admin(String email,String password) {
        super(email,password);
    }
  
    @Override
    public String tostring(){
    return "i am admin";
    }
    @Override
     public boolean login(String userName, String Pass) {  
            if (userName.equals("admin@yahoo.com") && Pass.equals("admin2000")) {
                return true;
            }

        return false;
    }
}
