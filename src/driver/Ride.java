package driver;

public class Ride {
    private String customerEmail,driverAssigned,destination,pickup;

    public Ride(String customerEmail, String driverAssigned, String destination, String pickup) {
        this.customerEmail = customerEmail;
        this.driverAssigned = driverAssigned;
        this.destination = destination;
        this.pickup = pickup;
        insertDB();
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
