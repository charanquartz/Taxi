package driver;

public class Ride {
    private String customerEmail,driverAssigned,destination,pickup;
    private int noOfSeats,otp,startKM;
    //3.create table ride(email varchar(30) references customer(email),noOfSeats int,pickup varchar(30),dest varchar(30),driverAssigned char(5),startKM int,otp int primary key);
    public int getStartKM() {
        return startKM;
    }

    public void setStartKM(int startKM) {
        this.startKM = startKM;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getDriverAssigned() {
        return driverAssigned;
    }

    public void setDriverAssigned(String driverAssigned) {
        this.driverAssigned = driverAssigned;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }
    public boolean insertDB(){
        return true;
    }
}
