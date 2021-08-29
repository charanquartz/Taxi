package customer;


//JAVA BEAN and REGEX
import java.util.Calendar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class JavaBean  {

 private String Fname;
 private String Lname;
 private long   Mob;
 private String Email;
 private String Gender;
 private String State;
 private String Pass;
 private String Fromm;
 private String Too;
 private int Seat;
 


 public String getFname() {
     return Fname;
 }

 public void setFname(String Fname) {
	 String Name =Fname.replaceAll("\\s", "");
	   String regex_fname = "^[A-Za-z]{3,30}+$";
	   Pattern pt = Pattern.compile(regex_fname);
Matcher mfname = pt.matcher(Name);
	   boolean fname_match = mfname.matches();
	   if(fname_match == true) {
      this.Fname = Fname;
	   }
	   else if(Fname.length()<3){
			JOptionPane.showMessageDialog(null, "First Name should contain atleast 3 characters");
		   }
	   else {
			Pattern ptfname_check = Pattern.compile("[^a-zA-z]");
			Matcher mtfname = ptfname_check.matcher(Fname);
			boolean splcheck = mtfname.find();
			if(splcheck==true) {
			JOptionPane.showMessageDialog(null, "Special characters and numbers are not allowed");
			}
	   }
	   }
 public String getLname() {
	 return Lname;
 }
 public void setLname(String Lname) {
	 this.Lname = Lname;
 }

 public String getEmail() {
     return Email;
 }

 public void setEmail(String Email) {
	 String regex_email = "^[\\w!#$%&'+/=?`{|}^-]+(?:\\.[\\w!#$%&'+/=?`{|}^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	    Pattern ptemail= Pattern.compile(regex_email);
	    Matcher memail = ptemail.matcher(Email);
	    boolean email_check = memail.matches();
	    if(email_check==true){
	    	this.Email = Email;
	    }
	    else{
		    JOptionPane.showMessageDialog(null, "Invalid mail ID");
		    }
}

 public String getGender() {
     return Gender;
 }

 public void setGender(String gender) {
     this.Gender = gender;
 }
 
 public String getState() {
     return State;
 }

 public void setState(String state) {
     this.State = state;
 }
 //
 public int getSeat() {
     return Seat;
 }

 public void setSeat(int Seat) {
     this.Seat = Seat;
 }
 //
 //
 public String getFromm() {
     return Fromm;
 }
 public void setFromm(String Fromm) {
	 String Name =Fromm.replaceAll("\\s", "");
	   String regex_Fromm = "^[A-Za-z]{3,40}+$";
	   Pattern pt = Pattern.compile(regex_Fromm);
Matcher mFromm = pt.matcher(Name);
	   boolean Fromm_match = mFromm.matches();
	   if(Fromm_match == true) {
      this.Fromm = Fromm;
	   }
	   else if(Fromm.length()<3){
			JOptionPane.showMessageDialog(null, "First Name should contain atleast 3 characters");
		   }
	   else {
			Pattern ptfname_check = Pattern.compile("[^a-zA-z]");
			Matcher mtfname = ptfname_check.matcher(Fromm);
			boolean splcheck = mtfname.find();
			if(splcheck==true) {
			JOptionPane.showMessageDialog(null, "Special characters and numbers are not allowed");
			}
	   }
	   }
 public String getToo() {
     return Fromm;
 }
 public void setToo(String Too) {
	 String Name =Too.replaceAll("\\s", "");
	   String regex_Too = "^[A-Za-z]{3,40}+$";
	   Pattern pt = Pattern.compile(regex_Too);
Matcher mToo = pt.matcher(Name);
	   boolean Too_match = mToo.matches();
	   if(Too_match == true) {
      this.Too = Too;
	   }
	   else if(Too.length()<3){
			JOptionPane.showMessageDialog(null, "First Name should contain atleast 3 characters");
		   }
	   else {
			Pattern ptToo_check = Pattern.compile("[^a-zA-z]");
			Matcher mtToo = ptToo_check.matcher(Too);
			boolean splcheck = mtToo.find();
			if(splcheck==true) {
			JOptionPane.showMessageDialog(null, "Special characters and numbers are not allowed");
			}
	   }
	   }
 

//
 public long getMob() {
     return Mob;
 }

 public void setMob(String Mob) {
	 String PAT ="^[6-9]{1}[0-9]{9}$";
	    Pattern pt=Pattern.compile(PAT);
	    Matcher mt=pt.matcher(Mob);
	    if(!mt.matches()){
	    JOptionPane.showMessageDialog(null, "Invalid mobile number");
	    }else {
      this.Mob = Long.parseLong(Mob);
	    }
}
 public String getPass() {
     return Pass;
 }
/*
 public void setPass(String Pass) {
 	this.Pass = Pass;
 */
 //
 public void setPass(String Pass) {
	 /*String PAT ="((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
	    Pattern pt=Pattern.compile(PAT);
	    Matcher mt=pt.matcher(Pass);
	    if(!mt.matches()){
	    JOptionPane.showMessageDialog(null, "Pasword Should contain Minimum eight characters, at least one letter in Uppercase and one Symbols:");
	    }
	 else {
      this.Mob = Long.parseLong(Pass);
	    }*/
	  this.Pass = Pass;
}
 
 //
 
}
