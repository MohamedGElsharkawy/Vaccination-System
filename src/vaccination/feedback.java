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
 * @author TEfa
 */

public class feedback{
public int feedbackID=0;
private String message;
private boolean veryGood;
private boolean good;
private boolean normal;
private boolean bad;
private boolean veryBad;
//public String rate;
private final String feedbackFileName = "feedback.txt";
 filemanger FManger = new filemanger();
public static ArrayList<feedback> feedbacks =new ArrayList<feedback>();
customer x = new customer();
public feedback(){}

public void setVeryGood(boolean veryGood){
    this.veryGood=veryGood;
}
public void setGood(boolean good){
    this.good=good;}
public void setNormal(boolean normal){
    this.normal=normal;
}
public void setBad(boolean bad){
    this.bad=bad;
}
public void setVeryBad(boolean veryBad){
    this.veryBad=veryBad;
}
public void setMessage(String message){
    this.message=message;
}
public String getMessage(){
    return this.message;
}
public boolean getVeryGood(){
    return this.veryGood;
}
public boolean getGood(){
    return this.good;}
public boolean getNormal(){
    return this.normal;
}
public boolean getBad(){
    return this.bad;
}
public boolean getVeryBad(){
    return this.veryBad;
}
/*public String chooseRate(){
if(this.veryGood=="veryGood")
    rate= this.veryGood;
else if(this.good=="good")
    rate= this.good;
else if(this.normal=="normal")
    rate= this.normal;
else if(this.bad=="bad")
    rate= this.bad;
else 
    rate= this.veryBad;
return rate;
}*/
public boolean addRate(){
        if (this.FManger.write(this.getFeedbackData(), feedbackFileName, true)) {
            return true;
        } else {
            return false;
        }
    }

    private String getFeedbackData() {
        return feedbackID + "@" +x.getemail()+ "@" +getVeryGood()+ "@" +getGood()+ "@" +getNormal()+ "@" +getBad()+ "@" +getVeryBad()+ "@" + this.message + "@" ;
    }
 
/*public void loadFromFile(){
    Feedbacks =(ArrayList<Feedback>) FManger.read(feedbackFileName);
}
  public boolean commitToFile(){
      return FManger.write(feedbackFileName,Feedbacks);
  }  */
 
private void loadFromFile() {
            feedbacks = (ArrayList<feedback>) (Object) FManger.read(feedbackFileName);
    }

    public ArrayList<feedback> listFeedback() {
        loadFromFile();
        /*String S = "\nAll Feedback Data:\n";
        for (feedback x : feedbacks) {
            S = S + x.toString();*/
        return feedbacks;
        }
        
    

}

