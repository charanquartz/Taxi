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
    String query;
    Border bdr=BorderFactory.createLineBorder(Color.BLACK, 5);;
    JButton changingButton,chatButton;
    JScrollPane jScrollPane,jScrollPane2;
    int index,noOfRides,input,currentRideOTP,selectedRow;
    private Ride currentRide;
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
        arr=new Object[][]{{"-","-","-","-","-","-"}};
        currentRideTable =new JTable(arr,new Object[]{"Customer email","Number of pasengers","Pickup place","Destination place","Kilometers at pickup","Customer mobile number"});
        jScrollPane=new JScrollPane(currentRideTable);
        jScrollPane.setBounds(0,70,1100,130);
        currentRideTable.setEnabled(false);
        currentRideTable.setRowHeight(100);
        currentRideTable.setBorder(bdr);
        currentRideTable.setFont(new Font("Times new roman",Font.BOLD,19));
        jScrollPane.setBorder(bdr);
        add(jScrollPane);
        requestedRideDetails();

        //Button
        changingButton=new JButton("ENTER OTP");
        chatButton=new JButton("CHAT WITH CUSTOMER");

        //Background
        currentRideTable.setBackground(new Color(23, 234, 128));
        availableRidesTable.setBackground(new Color(255, 44, 68));
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
            System.out.println(noOfRides);

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
            availableRidesTable =new JTable(arr,new Object[]{"S.No","Customer email","Number of pasengers","Pickup place","Destination place"});
            availableRidesTable.setBorder(bdr);
            availableRidesTable.setEnabled(false);
            availableRidesTable.setRowHeight(60);
            jScrollPane2=new JScrollPane(availableRidesTable);
            jScrollPane2.setBounds(0,270,1500,600);
            jScrollPane2.setBorder(bdr);

            //MouseListener for table
            jScrollPane2.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getClickCount()==2){
                        selectedRow=e.getY()/60;
                        if(selectedRow>=arr.length){
                            return;
                        }
                        input=JOptionPane.showConfirmDialog(null,"Are you sure you want to accept the ride?");
                        if(input==0){
                            currentRideOTP=(Integer)arr[selectedRow][6];
                            acceptRide(currentRideOTP);
                        }
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

            add(jScrollPane2);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    //Functions to implement after the driver accepts a ride
    public boolean acceptRide(int currentRideOTP){
        query="select from ride where otp="+currentRideOTP;
        try {
            statement = TabServer.connection.createStatement();
            resultSet= statement.executeQuery(query);
            currentRide=new Ride();
            resultSet.next();
            currentRide.setCustomerEmail(resultSet.getString(1));
            currentRide.setNoOfPassengers(resultSet.getInt(2));
            currentRide.setPickup(resultSet.getString(3));
            currentRide.setDestination(resultSet.getString(4));
            currentRide.setDriverAssigned("true");
            currentRide.setOtp(currentRideOTP);

            //changingButton.setBounds();
            //chatButton.setBounds();
            add(changingButton);
            add(chatButton);
            JOptionPane.showMessageDialog(null,"Ride accepted successfully");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
}