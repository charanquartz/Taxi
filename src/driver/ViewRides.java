package driver;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Event.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
public class ViewRides extends JPanel{
    Statement statement;
    ResultSet resultSet;
    Label currentRideLabel,ridesAvailable;
    Object[][] arr;
    JTable currendRide,rides;
    String query;
    Border bdr=BorderFactory.createLineBorder(Color.BLACK, 5);;
    JButton btn1;
    JScrollPane jScrollPane,jScrollPane2;
    int index,noOfRides;
    ViewRides(){
        setBackground(new Color(3, 252, 240));
        setBounds(0,0,1900,1000);
        setVisible(true);
        setFont(new Font("Times New Roman",Font.BOLD,19));
        setLayout(null);

        //Label
        currentRideLabel=new Label("Current Ride : ");
        currentRideLabel.setBounds(0,0,200,60);
        add(currentRideLabel);
        ridesAvailable=new Label("Rides available : ");
        ridesAvailable.setBounds(0,210,200,60);
        add(ridesAvailable);

        //Table
        arr=new Object[][]{{"-","-","-","-","-","-",new JButton()}};
        currendRide=new JTable(arr,new Object[]{"Customer email","Number of pasengers","Pickup place","Destination place","Kilometers at pickup","Customer mobile number","Button"});
        jScrollPane=new JScrollPane(currendRide);
        jScrollPane.setBounds(0,70,1100,130);
        currendRide.setEnabled(false);
        currendRide.setRowHeight(100);
        currendRide.setBorder(bdr);
        currendRide.setFont(new Font("Times new roman",Font.BOLD,19));
        jScrollPane.setBorder(bdr);
        add(jScrollPane);

        enterRideDetails();

    }
    private void enterRideDetails(){
        try{
            index=0;
            noOfRides=0;
            //To count no of rides available at the moment
            query="select count(email) from ride where driverAssigned=''";
            statement=TabServer.connection.createStatement();
            resultSet=statement.executeQuery(query);
            if(resultSet.next()){
                noOfRides=resultSet.getInt(1);
            }

            query="select * from ride where driverAssigned='"+TabServer.driver.getEmail()+"'";
            statement=TabServer.connection.createStatement();
            resultSet=statement.executeQuery(query);
            //Rides available table
            arr=new Object[noOfRides][8];
            while(resultSet.next()){
                arr[index]=new Object[][]{{index+1,resultSet.getString(1),resultSet.getInt(2),resultSet.getString( 3),resultSet.getString(4),resultSet.getInt(6),resultSet.getInt(7),new JButton()}};
                index++;
            }
            rides=new JTable(arr,new Object[]{"S.No","Customer email","Number of pasengers","Pickup place","Destination place","Kilometers at pickup","Customer mobile number","Button"});
            rides.setBorder(bdr);
            rides.setEnabled(false);
            rides.setRowHeight(100);
            jScrollPane2=new JScrollPane(rides);
            jScrollPane2.setBounds(0,270,1500,600);
            jScrollPane2.setBorder(bdr);
            add(jScrollPane2);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}