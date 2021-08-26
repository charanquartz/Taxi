package proj;
import proj.signup;
import proj.home;

//JAVA BEAN and REGEX
import java.util.Calendar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class jb  {

 private String Fname;
 private String Lname;
 private long Mob;
 private String Email;
 private String Gender;
 private String State;
 private String Pass;
 


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

 public void setPass(String Pass) {
 	this.Pass = Pass;
 }
 
}
