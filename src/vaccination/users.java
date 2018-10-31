
package vaccination;

import java.io.Serializable;


public abstract class users implements Serializable { 
    protected String email;
    protected String password;
    filebinary FManger = new filebinary();

   
    public abstract String tostring();

    public users(){
} 
    public users(String email,String password){
            this.email = email;
            this.password = password;
    }
    public void setemail(String email){
    this.email=email;
    }
    public void setpassword(String pass){
    this.password=pass;
    }
    public String getemail(){
    return this.email;
    }
    public String getpassword(){
    return this.password;
    }
    public abstract boolean login(String email, String Password);
        
    
}
