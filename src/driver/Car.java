package driver;
import javax.swing.*;
import java.awt.Event.*;
import java.awt.*;
public class Car {
    private String carID,company,model;
    private Boolean AC,booked;
    private int capacity,farePerKM;
    Car(String carID,String company,String model,boolean AC,int capacity,int farePerKM){
        this.carID=carID;
        this.company=company;
        this.model=model;
        this.AC=AC;
        this.capacity=capacity;
        this.farePerKM=farePerKM;
    }

    public Boolean getBooked() {
        return booked;
    }

    public void setBooked(Boolean booked) {
        this.booked = booked;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getAC() {
        return AC;
    }

    public void setAC(Boolean AC) {
        this.AC = AC;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFarePerKM() {
        return farePerKM;
    }

    public void setFarePerKM(int farePerKM) {
        this.farePerKM = farePerKM;
    }
}
