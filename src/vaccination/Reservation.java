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
public class Reservation implements Serializable {
    
    private String reserve_Name;
    private String reserve_Date;
    private double reserve_Price;
    private  int reserve_Time;
    
    Product prodcut= new Product();
    filebinary FManger=new filebinary();
    private final String reservefilename = "reserve.bin";
    public static ArrayList<Reservation> reserve = new ArrayList<Reservation>();
    
    public Reservation(){
    }
    
      public Reservation(String reserve_Name,double reserve_Price,String reserve_Date,int reserve_Time){
    this.reserve_Name=reserve_Name;
     this.reserve_Price=reserve_Price;
     this.reserve_Time=reserve_Time;
     this.reserve_Date=reserve_Date;


    }
    
    
      public void setReserve_Name(String reserve_Name){
    this.reserve_Name=reserve_Name;
    }
    
    public String getReserve_Name(){
    return this.reserve_Name;
    }
    
      public void setReserve_Date(String reserve_Date){
    this.reserve_Date=reserve_Date;
    }
    
    public String getReserve_Date(){
    return this.reserve_Date;
    }
    
    public void setReserve_Price(double reserve_Price){
    this.reserve_Price=reserve_Price;
    }
    
    public double getReserve_Price(){
    return this.reserve_Price;
    }
    
     public void setReserve_Time(int reserve_Time){
    this.reserve_Time=reserve_Time;
    }
    
    public int getReserve_Time(){
    return this.reserve_Time;
    }


    
    public boolean committofile(){
return FManger.write(reservefilename,reserve);
}
public void loadfromfile(){
    reserve = (ArrayList<Reservation>) FManger.read(reservefilename);
}
  public boolean addRes() {
        loadfromfile();
        reserve.add(this);
        return committofile();
    }
  
 private int getVaccID(String name){
     int i;
     for (i=0;i<reserve.size();i++){
     if (reserve.get(i).getReserve_Name().equals(name))
     return i;
      }
      return -1;
      }

 public ArrayList<Reservation> displayAllRes(){
          loadfromfile(); 
         return reserve;

         }
     public Reservation searchRes(String  name) {
         Reservation reservation = new Reservation();
        loadfromfile();
        int index = getVaccID(name);
        if (index != -1) {
            return reserve.get(index);
        } else {
            return reservation;
        }
    }
     public boolean deleteRes(String name){
     loadfromfile();
     int index = getVaccID(name);
     if (index!=-1){
     reserve.remove(index);
     return committofile();
     }
     return false;
     }
     
}
