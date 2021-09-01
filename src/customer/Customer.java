package customer;

//JAVA BEAN and REGEX

import java.util.regex.*;
import javax.swing.JOptionPane;

public class Customer {

    private String firstName;
    private String lastName;
    private long mobileNumber;
    private String email;
    private String gender;
    private String state;
    private String password;
    private int portNumber;

    public String getPassword() {
        return password;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String Fname) {
        String Name = Fname.replaceAll("\\s", "");
        String regex_fname = "^[A-Za-z]{3,30}+$";
        Pattern pt = Pattern.compile(regex_fname);
        Matcher mfname = pt.matcher(Name);
        boolean fname_match = mfname.matches();
        if (fname_match == true) {
            this.firstName = Fname;
        } else if (Fname.length() < 3) {
            JOptionPane.showMessageDialog(null, "First Name should contain atleast 3 characters");
        } else {
            Pattern ptfname_check = Pattern.compile("[^a-zA-z]");
            Matcher mtfname = ptfname_check.matcher(Fname);
            boolean splcheck = mtfname.find();
            if (splcheck == true) {
                JOptionPane.showMessageDialog(null, "Special characters and numbers are not allowed");
            }
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String Lname) {
        this.lastName = Lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        String regex_email = "^[\\w!#$%&'+/=?`{|}^-]+(?:\\.[\\w!#$%&'+/=?`{|}^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern ptemail = Pattern.compile(regex_email);
        Matcher memail = ptemail.matcher(Email);
        boolean email_check = memail.matches();
        if (email_check == true) {
            this.email = Email;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid mail ID");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setToo(String Too) {
        String Name = Too.replaceAll("\\s", "");
        String regex_Too = "^[A-Za-z]{3,40}+$";
        Pattern pt = Pattern.compile(regex_Too);
        Matcher mToo = pt.matcher(Name);
        boolean Too_match = mToo.matches();
        if (Too_match == true) {
            //this.Too = Too;
        } else if (Too.length() < 3) {
            JOptionPane.showMessageDialog(null, "First Name should contain atleast 3 characters");
        } else {
            Pattern ptToo_check = Pattern.compile("[^a-zA-z]");
            Matcher mtToo = ptToo_check.matcher(Too);
            boolean splcheck = mtToo.find();
            if (splcheck == true) {
                JOptionPane.showMessageDialog(null, "Special characters and numbers are not allowed");
            }
        }
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String Mob) {
        String PAT = "^[6-9]{1}[0-9]{9}$";
        Pattern pt = Pattern.compile(PAT);
        Matcher mt = pt.matcher(Mob);
        if (!mt.matches()) {
            JOptionPane.showMessageDialog(null, "Invalid mobile number");
        } else {
            this.mobileNumber = Long.parseLong(Mob);
        }
    }

    public String getPass() {
        return password;
    }

    public void setPassword(String Pass) {
	 	String PAT ="^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$";
	    Pattern pt=Pattern.compile(PAT);
	    Matcher mt=pt.matcher(Pass);
	    if(!mt.matches()){
	    JOptionPane.showMessageDialog(null, "Pasword Should contain Minimum eight characters, at least one letter in Uppercase and one Symbols:");
	    }
        this.password = Pass;
    }
}
