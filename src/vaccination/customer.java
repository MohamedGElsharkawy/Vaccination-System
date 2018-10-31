
package vaccination;




import java.io.Serializable;
import java.util.ArrayList;

 public class customer extends users implements Serializable {
    
    protected int age;
    protected double phone_number;
    protected String name;
    private final String customerfilename = "customer.bin";
    public static ArrayList<customer> customers = new ArrayList<customer>();
    public customer(){
        
    }
public customer(String password,String email,int age,int phone_number,String name){
     super(email,password);
     
     this.phone_number = phone_number;
     this.age = age;
     this.name = name; 
}
public void setage(int age){
    this.age=age;
}

public void setphone(double phone_number){
    this.phone_number=phone_number;
}
public void setname(String name){
    this.name=name;
}
public int getage(){
    return this.age;
}
public double getphone(){
    return this.phone_number;
}

public String getname(){
    return this.name;
}

public boolean committofile(){
return FManger.write(customerfilename,customers);
}
public void loadfromfile(){
customers = (ArrayList<customer>) FManger.read(customerfilename);
}
  public boolean addcustomer() {
        loadfromfile();
        customers.add(this);
        return committofile();
    }
 private int getcustomerindex(double id){
     int i;
     for (i=0;i<customers.size();i++){
     if (customers.get(i).getphone()== id)
     return i;
      }
      return -1;
      }
 
 public ArrayList<customer> displayallcustomer(){
          loadfromfile(); 
         return customers;
         }
 
 public boolean updatecustomer(double uid,customer x){
      loadfromfile();
     int index = getcustomerindex(uid);
     if(index != -1){
     customers.set(index,this);
     return committofile();
 }
 return false;
 }
     public customer searchcustomer(double id) {
         customer cus = new customer();
        loadfromfile();
        int index = getcustomerindex(id);
        if (index != -1) {
            return customers.get(index);
        } else {
            return cus;
        }
    }
     public boolean deletcustomer(double id){
     loadfromfile();
     int index = getcustomerindex(id);
     if (index!=-1){
     customers.remove(index);
     return committofile();
     }
     return false;
     }
     public boolean check(String email,String username){
     loadfromfile();
     for (customer x : customers) {
            if (email.equals(x.email) || username.equals(x.name)){
                return true;
            }
        }
     return false;
     }
    @Override
    public String tostring() {
       return "\n" + "age:" + age + "\n" +"phone number:" + phone_number+ "\n" + "name:" + name +"\n"; 
    }
    @Override
       public boolean login(String userName, String Pass) {
        loadfromfile();
        for (customer x : customers) {
            if (userName.equals(x.email) && Pass.equals(x.password)){
                return true;
            }
        }
        
        return false;
    }
    
}
