package driver;

public class Driver {
    private String fname,lname,carID,gender,dob,nationality,city,address,email,pass;
    private long mobile,driverExp;

    public Driver(String fname, String lname, String carID, String gender, String dob, String nationality, String city, String address, String email, String pass, long mobile, long driverExp) {
        this.fname = fname;
        this.lname = lname;
        this.carID = carID;
        this.gender = gender;
        this.dob = dob;
        this.nationality = nationality;
        this.city = city;
        this.address = address;
        this.email = email;
        this.pass = pass;
        this.mobile = mobile;
        this.driverExp = driverExp;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public long getDriverExp() {
        return driverExp;
    }

    public void setDriverExp(long driverExp) {
        this.driverExp = driverExp;
    }
}
