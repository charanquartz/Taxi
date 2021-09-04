package driver;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.awt.*;

public class ViewRides extends JPanel{
    Statement statement;
    ResultSet resultSet;
    Label currentRideLabel,ridesAvailable;
    Object[][] arr;
    JTable currentRideTable, availableRidesTable;
    String query,otp;
    Border bdr=BorderFactory.createLineBorder(Color.BLACK, 5);;
    JButton changingButton,chatButton;
    JScrollPane currentRideTableScrollPane, availabletableJScrollPane;
    private int index,noOfRides,input,currentRideOTP,selectedRow,endKM,hoursElapsed,fare,distanceTravelled;
    private Ride currentRide;
    private Font font;
    String customerName;
    int customerPortNumber,rowClicked;
    ViewRides(){
        setBackground(new Color(255, 167, 88));
        setBounds(0,0,1900,1000);
        setVisible(true);
        font=new Font("Times New Roman",Font.BOLD,19);
        setFont(font);
        setLayout(null);

        //Label
        currentRideLabel=new Label("Current Ride : ");
        currentRideLabel.setBounds(0,0,200,60);
        add(currentRideLabel);
        ridesAvailable=new Label("Rides available : ");
        ridesAvailable.setBounds(0,220,200,60);
        add(ridesAvailable);

        //Table
        arr=new Object[][]{{"-","-","-","-","-","-"}};
        currentRideTable =new JTable(arr,new Object[]{"Customer email","Number of pasengers","Pickup place","Destination place","Kilometers at pickup","Customer mobile number"}){
            public boolean isCellEditable(int r,int c){
                return false;
            }
        };
        currentRideTableScrollPane =new JScrollPane(currentRideTable);
        currentRideTableScrollPane.setBounds(0,70,1800,70);
        currentRideTable.setRowHeight(60);
        //currentRideTable.setBorder(bdr);
        currentRideTable.setFont(new Font("Times new roman",Font.BOLD,19));
        currentRideTableScrollPane.setBorder(bdr);
        add(currentRideTableScrollPane);
        requestedRideDetails();

        //Customizing scroll pane
        currentRideTableScrollPane.getViewport().setBackground(new Color(255, 104, 132));
        currentRideTableScrollPane.getViewport().setFont(font);

        //Button
        changingButton=new JButton("ENTER OTP");
        chatButton=new JButton("CHAT WITH CUSTOMER");

        //Background
        currentRideTable.setBackground(new Color(255, 104, 132));
        availableRidesTable.setBackground(new Color(216, 115, 255));

        //Adding buttons
        add(changingButton);
        add(chatButton);
        changingButton.setBounds(0,150,200,60);
        chatButton.setBounds(210,150,200,60);

        disableButton(changingButton);
        disableButton(chatButton);

        //Mouse event on otp button
        changingButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(changingButton.getText().equals("Ride complete")){
                    rideComplete();
                    return;
                }
                if(!changingButton.isEnabled()){
                    return;
                }
                otp=JOptionPane.showInputDialog(null,"Enter the OTP of the ride : ");
                if(Integer.parseInt(otp)==currentRideOTP){
                    currentRide.setStartKM(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the start Kilometer of the ride : ")));
                    changingButton.setText("Ride complete");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Wrong OTP entered");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //Mouse Event on chat button
        chatButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!chatButton.isEnabled()){
                    return;
                }
                resultSet=getCustomerDetails(""+currentRideTable.getValueAt(0,0));
                try {
                    resultSet.next();
                    customerName = resultSet.getString(1).trim() + " " + resultSet.getString(2);
                    customerPortNumber=resultSet.getInt(8);
                }
                catch(Exception k){
                    System.out.println("ViewRide--->ChatButton()"+k);
                }
                Thread thread=new Thread(){
                    public void run(){
                        new DriverChatBox(customerName,customerPortNumber);
                    }
                };
                thread.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    //Method to display details of available rides....
    private void requestedRideDetails(){
        try{
            index=0;
            noOfRides=0;
            //To count no of rides available at the moment
            query="select count(email) from ride where driverAssigned='false'";
            statement=TabServer.connection.createStatement();
            resultSet=statement.executeQuery(query);
            if(resultSet.next()){
                noOfRides=resultSet.getInt(1);
            }

            //Storing available rides details to table
            query="select * from ride where driverassigned='false'";
            statement=TabServer.connection.createStatement();
            resultSet=statement.executeQuery(query);

            //Rides available table
            arr=new Object[noOfRides][5];
            while(resultSet.next()){
                arr[index]=new Object[]{index+1,resultSet.getString(1),resultSet.getInt(2),resultSet.getString( 3),resultSet.getString(4)};
                index++;
            }
            availableRidesTable =new JTable(arr,new Object[]{"S.No","Customer email","Number of pasengers","Pickup place","Destination place"}){
                public boolean isCellEditable(int r,int c){
                    return false;
                }
            };
            //availableRidesTable.setBorder(bdr);
            availableRidesTable.setEnabled(false);
            availableRidesTable.setRowHeight(60);
            availableRidesTable.setFont(new Font("Times New Roman",Font.BOLD,19));
            availabletableJScrollPane =new JScrollPane(availableRidesTable);
            availabletableJScrollPane.setBounds(0,290,1500,600);
            availabletableJScrollPane.setBorder(bdr);

            //Customizing scroll pane
            availabletableJScrollPane.getViewport().setBackground(new Color(216, 115, 255));
            availabletableJScrollPane.getViewport().setFont(font);

            availableRidesTable.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(changingButton.isEnabled()){
                        JOptionPane.showMessageDialog(null,"Complete your current ride to accept new one");
                        return;
                    }
                    selectedRow=e.getY()/60;
                    if(selectedRow>=arr.length){
                        return;
                    }
                    input=JOptionPane.showConfirmDialog(null,"Are you sure you want to accept the ride?");
                    if(input==0){
                        currentRideOTP=getOTP(arr[selectedRow][1].toString());
                        acceptRide(currentRideOTP);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            add(availabletableJScrollPane);
        }
        catch(Exception e){
            System.out.println("requested ride details");
            System.out.println(e);
        }
    }

    //Functions to implement after the driver accepts a ride
    public boolean acceptRide(int currentRideOTP){
        query="select * from ride where otp="+currentRideOTP;
        try {
            statement = TabServer.connection.createStatement();
            resultSet= statement.executeQuery(query);
            currentRide=new Ride();
            resultSet.next();
            if(driverAssignedForRide(currentRideOTP)){
                JOptionPane.showMessageDialog(null,"Sorry this ride is already in progress / completed by other driver....");
                return false;
            }
            query="select * from ride where otp="+currentRideOTP;
            resultSet= statement.executeQuery(query);
            resultSet.next();
            currentRide.setCustomerEmail(resultSet.getString(1));
            currentRide.setNoOfSeats(resultSet.getInt(2));
            currentRide.setPickup(resultSet.getString(3));
            currentRide.setDestination(resultSet.getString(4));
            currentRide.setDriverAssigned("true");
            currentRide.setOtp(currentRideOTP);
            //Updating driver assigned to the ride
            query="update ride set driverassigned='true' where otp="+currentRideOTP;
            statement=TabServer.connection.createStatement();
            statement.executeQuery(query);

            //Enabling buttons
            enableButton(changingButton);
            enableButton(chatButton);

            //Updating table values...
            currentRideTable.setValueAt(currentRide.getCustomerEmail(),0,0);
            currentRideTable.setValueAt(currentRide.getNoOfSeats(),0,1);
            currentRideTable.setValueAt(currentRide.getPickup(),0,2);
            currentRideTable.setValueAt(currentRide.getDestination(),0,3);
            currentRideTable.setValueAt(-1,0,4);
            currentRideTable.setValueAt(getCustomerMobile(currentRide.getCustomerEmail()),0,5);
            JOptionPane.showMessageDialog(null,"Ride accepted successfully");

            statement=TabServer.connection.createStatement();
            statement.executeQuery(query);

            //SendMail of confirmation
            TabServer.sendMail("Drive request approved","Your ride has been accepted by a driver.\nDriver name : "+TabServer.driver.getFname()+"\nDriver mobile number : "+TabServer.driver.getMobile(),currentRide.getCustomerEmail());
        }
        catch(Exception e){
            System.out.println("Accept ride() "+e);
        }
        return true;
    }
    public long getCustomerMobile(String email){
        long number=-1;
        try {
            statement = TabServer.connection.createStatement();
            query="select mobile from customer where email='"+email+"'";
            resultSet=statement.executeQuery(query);
            resultSet.next();
            return resultSet.getLong(1);
        }
        catch(Exception e){
            System.out.println("getCustomerMobile");
            System.out.println(e);
        }
        return number;
    }
    //Getting otp of the ride with the help of customer email...
    public int getOTP(String email){
        try{
            statement=TabServer.connection.createStatement();
            query="select otp from ride where email='"+email+"'";
            resultSet=statement.executeQuery(query);
            resultSet.next();
            return resultSet.getInt(1);
        }
        catch (Exception e){
            System.out.println("get otp");
            System.out.println(e);
        }
        return -1;
    }
    public boolean disableButton(JButton button){
        button.setEnabled(false);
        return true;
    }
    public boolean enableButton(JButton button){
        button.setEnabled(true);
        return true;
    }
    private boolean rideComplete(){
        fare=0;
        endKM=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the end kilometer : "));
        hoursElapsed=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the hours of travel : "));

        //To find the fare of the car per km
        try {
            query="select fareperkm from car where carid='"+TabServer.driver.getCarID()+"'";
            statement = TabServer.connection.createStatement();
            resultSet=statement.executeQuery(query);
            resultSet.next();
            distanceTravelled=endKM- currentRide.getStartKM();
            fare+=distanceTravelled*resultSet.getInt(1);
            fare+=hoursElapsed*150;
            TabServer.sendMail("Taxi-Ride complete!!!","Diatance Travelled : "+distanceTravelled+"km -----> Charge : ₹"+distanceTravelled*resultSet.getInt(1)+"\nHours of travel : "+hoursElapsed+"hours----->Charge : ₹"+hoursElapsed*150+"\nGrand total : ₹"+fare+"\nThanks for the ride with us!!!\nPlease give your feedback about our services...", currentRide.getCustomerEmail());

            //Deleting current ride form ride table
            query="delete from ride where otp="+otp;
            statement.executeQuery(query);

            //Setting availability of the driver to true
            query="update table driver set availability = 'true' where email='"+TabServer.driver.getEmail()+"'";


            //Setting current ride to empty
            setCurrentRideToEmpty();
        }
        catch (Exception e){
            System.out.println("Ride complete()"+e);
        }
        chatButton.setVisible(false);
        return true;
    }
    private boolean setCurrentRideToEmpty(){
        for(int i=0;i<6;i++){
            currentRideTable.setValueAt("-",0,i);
        }
        changingButton.setText("Enter OTP : ");
        disableButton(changingButton);
        disableButton(chatButton);
        return true;
    }
    //Function to check if ride is already assigned by someone or not
    private boolean driverAssignedForRide(int otp){
        try {
            query ="select driverassigned from ride where otp="+otp;
            statement=TabServer.connection.createStatement();
            resultSet=statement.executeQuery(query);
            resultSet.next();
            if(resultSet.getString(1).equals("true")){
                return true;
            }
        }
        catch(Exception e){
            System.out.println("Driver assigned for ride() "+e);
        }
        return false;
    }
    private ResultSet getCustomerDetails(String email){
        try{
            System.out.println(email);
            query="select * from customer where email='"+email+"'";
            return statement.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}