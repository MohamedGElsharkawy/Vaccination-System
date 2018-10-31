/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccination;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import static vaccination.customer.customers;

/**
 *
 * @author Mohammad
 */
public class Product implements Serializable {
    
    private String Vacc_Name;
    private double Vacc_Price;
    private  String date;
    private  int time;
   
    filebinary FManger=new filebinary();
    private final String productfilename = "product.bin";
    public static ArrayList<Product> products = new ArrayList<Product>();

    
    public Product(){
        
    }
     

public Product(String  Vacc_Name,double Vacc_Price , String date, int time){     
     this.Vacc_Name = Vacc_Name;
     this.Vacc_Price = Vacc_Price;
     this.date=date;
    this.time=time;

}
     public void setVacc_Name(String Vacc_Name){
     this.Vacc_Name=Vacc_Name;
     }
     
     public String getVacc_Name(){
         return this.Vacc_Name;
     }
        public void setVacc_Price(double Vacc_Price){
     this.Vacc_Price=Vacc_Price;
     }
     
     public double getVacc_Price(){
         return this.Vacc_Price;
     }

 
     public void setDate(String date){
     this.date=date;
     }
     
     public String getDate(){
         return this.date;
     }
        public void setTime(int time){
     this.time=time;
     }
     
     public int getTime(){
         return this.time;
     }
     
     
public boolean committofile(){
return FManger.write(productfilename,products);
}
public void loadfromfile(){
    products = (ArrayList<Product>) FManger.read(productfilename);
}
  public boolean addVacc() {
        loadfromfile();
        products.add(this);
        return committofile();
    }
  
 private int getVaccID(double id){
     int i;
     for (i=0;i<products.size();i++){
     if (products.get(i).getTime() == id)
     return i;
      }
      return -1;
      }
private int getVaccID(String name){
     int i;
     for (i=0;i<products.size();i++){
     if (products.get(i).getVacc_Name().equals(name))
     return i;
      }
      return -1;
      }
 public ArrayList<Product> displayAllVacc(){
          loadfromfile(); 
         return products;

         }
 
 public boolean updateVacc(String name , Product x){
      loadfromfile();
     int index = getVaccID(name);
     if(index != -1){
     products.set(index, x);
     return committofile();
 }
 return false;
 }
     public Product searchVacc(double id) {
         Product product = new Product();
        loadfromfile();
        int index = getVaccID(id);
        if (index != -1) {
            return products.get(index);
        } else {
            return product;
        }
    }
    public Product searchVacc(String name) {
         Product product = new Product();
        loadfromfile();
        int index = getVaccID(name);
        if (index != -1) {
            return products.get(index);
        } else {
            return product;
        }
    } 
     public boolean deleteVacc(double id){
     loadfromfile();
     int index = getVaccID(id);
     if (index!=-1){
     products.remove(index);
     return committofile();
     }
     return false;
     }
     public boolean deleteVacc(String name){
     loadfromfile();
     int index = getVaccID(name);
     if (index!=-1){
     products.remove(index);
     return committofile();
     }
     return false;
     }
     public boolean check(String name,String date){
     loadfromfile();
     for (Product x : products) {
            if (name.equals(x.Vacc_Name) && date.equals(x.date)){
                return true;
            }
        }
     return false;
     }
    public String tostring() {
       return "\n" + "Vacc_Name:" + Vacc_Name + "\n" +"Vacc_Price:" + Vacc_Price+ "\n"; 
    }
    
}
