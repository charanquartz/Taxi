package customer;

import java.awt.Color;
import driver.Ride;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class BookRide extends JPanel implements ActionListener {
    JLabel lbl1, lbl2, lbl3, lbl4,otpLabel;
    String query;
    JTextField txtFld1, txtFld2,otpTextField;
    JComboBox<Integer> carseat;
    JButton jb_submit,submitOtpButton,chatBoxButton;
    Ride ride;
    int otp;

    public BookRide() {
        setLayout(null);
        setBackground(Color.yellow);
        setSize(500, 600);
        ride = new Ride();

        //labels
        lbl1 = new JLabel("Pickup Location");
        lbl2 = new JLabel("Destination Location");
        lbl4 = new JLabel("No of Seats");
        otpLabel=new JLabel("Enter OTP : ");

        //txt field
        txtFld1 = new JTextField();
        txtFld1.setForeground(Color.GRAY);
        txtFld1.setText("Enter the Pickup Location");
        txtFld1.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (txtFld1.getText().equals("Enter the Pickup Location")) {
                    txtFld1.setText("");
                    txtFld1.setForeground(Color.BLACK);
                }

            }

            public void focusLost(FocusEvent e) {
                if (txtFld1.getText().isEmpty()) {
                    txtFld1.setForeground(Color.BLACK);
                    txtFld1.setText("Enter the Pickup Location");
                }
            }
        });
        txtFld2 = new JTextField();
        txtFld2.setForeground(Color.GRAY);
        txtFld2.setText("Enter the Destination Location");
        txtFld2.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (txtFld2.getText().equals("Enter the Destination Location")) {
                    txtFld2.setText("");
                    txtFld2.setForeground(Color.BLACK);
                }

            }

            public void focusLost(FocusEvent e) {
                if (txtFld2.getText().isEmpty()) {
                    txtFld2.setForeground(Color.BLACK);
                    txtFld2.setText("Enter the Destination Location");
                }
            }
        });
        otpTextField=new JTextField();

        carseat = new JComboBox<>();
        carseat.addItem(1);
        carseat.addItem(2);
        carseat.addItem(3);
        carseat.addItem(4);
        carseat.addItem(5);
        carseat.addItem(6);
        carseat.addItem(7);
        carseat.addItem(8);

        //book ride btn
        jb_submit = new JButton("Book Ride");
        jb_submit.addActionListener(this);
        submitOtpButton=new JButton("Submit OTP");
        submitOtpButton.addActionListener(this);
        chatBoxButton=new JButton("Chat with driver ");
        chatBoxButton.setBounds(890,300,150,30);
        chatBoxButton.addActionListener(this);

        //setbounds area
        lbl1.setBounds(80, 120, 200, 25);
        lbl2.setBounds(80, 180, 200, 25);
        otpLabel.setBounds(410,300,150,30);
        otpTextField.setBounds(570,300,150,30);
        submitOtpButton.setBounds(730,300,150,30);

        lbl4.setBounds(80, 240, 200, 25);
        jb_submit.setBounds(250, 300, 150, 30);
        //jb_upd.setBounds(1000,15,120,20);


        lbl1.setFont(new Font("Serif", Font.BOLD, 21));
        lbl2.setFont(new Font("Serif", Font.BOLD, 21));
        lbl4.setFont(new Font("Serif", Font.BOLD, 21));
        jb_submit.setFont(new Font("Serif", Font.BOLD, 20));

        txtFld1.setBounds(300, 120, 250, 30);
        txtFld2.setBounds(300, 180, 250, 30);

        carseat.setBounds(300, 240, 45, 30);

        //add
        add(lbl1);
        add(lbl2);
        // c.add(lbl3);
        add(lbl4);

        add(jb_submit);
        add(submitOtpButton).setVisible(false);
        add(otpLabel).setVisible(false);
        add(otpTextField).setVisible(false);
        add(chatBoxButton).setVisible(false);

        add(txtFld1);
        add(txtFld2);

        add(carseat);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();
        if (obj == jb_submit) {
            try {
                if(!isValidLocationName(txtFld1.getText())){
                    return;
                }
                if(!isValidLocationName(txtFld2.getText())){
                    return;
                }
                if(TabServer.hasAlreadyBookedARide(TabServer.customer.getEmail())){
                    JOptionPane.showMessageDialog(null,"Please complete your current ride to book a new ride...");
                    chatBoxButton.setVisible(true);
                    return;
                }
                TabServer.sendMail("Ride Booking","Your OTP for ride booking proces : "+otp,TabServer.customer.getEmail());
                JOptionPane.showMessageDialog(this, "OTP is sent to your mail...");
                otpLabel.setVisible(true);
                otpTextField.setVisible(true);
                submitOtpButton.setVisible(true);
            }
            catch (Exception ex) {
                System.out.println("Action performed"+ex);
            }
        }
        else if(obj == submitOtpButton){
            if(submitOtpButton.isVisible()){
                try{
                    if(otp==Integer.parseInt(otpTextField.getText())){
                        /*Procedure
                SQL>create or replace procedure insertRide(email varchar,noOfSeats int,pickup varchar,dest varchar,driverAssigned char,startKM int,otp int) as
                  2  begin
                  3  insert into ride values(email,noOfSeats,pickup,dest,driverAssigned,startKM,otp);
                  4  end;
                  5  */
                        query="{call insertRide(?,?,?,?,?,?,?)}";
                        CallableStatement callableStatement=TabServer.connection.prepareCall(query);
                        callableStatement.setString(1, TabServer.customer.getEmail());
                        callableStatement.setInt(2, Integer.parseInt(carseat.getSelectedItem().toString()));
                        callableStatement.setString(3, txtFld1.getText());
                        callableStatement.setString(4, txtFld2.getText());
                        callableStatement.setString(5, "false");
                        callableStatement.setInt(6, -1);
                        otp=TabServer.generateRandomNumber();
                        while(TabServer.getRideDetails(otp).next()){
                            otp=TabServer.generateRandomNumber();
                        }
                        callableStatement.setInt(7,otp);

                        callableStatement.executeUpdate();
                        JOptionPane.showMessageDialog(this,"Ride is booked successfully.\nKindly share this OTP with your driver during pickup"+otp);
                        TabServer.sendMail("Ride Confirmation","OTP for your ride : "+otp+"\nKindly share it with your driver at pickup location",TabServer.customer.getEmail());
                        chatBoxButton.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"Wrong OTP");
                        otpTextField.setText("");
                    }
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(this,"Wrong OTP");
                    System.out.println("ActionPerformed--->Bookride"+e);
                }
            }
        }
        else if(obj==chatBoxButton){
            if(!chatBoxButton.isEnabled()){
                return;
            }
            Thread t=new Thread() {
                public void run() {
                    new CustomerChatBox(TabServer.customer.getPortNumber());
                }
            };
            t.start();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Booking Not Success");
        }
    }
    private boolean isValidLocationName(String Fromm){
        String Name = Fromm.replaceAll("\\s", "");
        String regex_Fromm = "^[A-Za-z]{3,40}+$";
        Pattern pt = Pattern.compile(regex_Fromm);
        Matcher mFromm = pt.matcher(Name);
        boolean Fromm_match = mFromm.matches();
        if (Fromm_match == true) {
            //this.Fromm = Fromm;
        } else if (Fromm.length() < 3) {
            JOptionPane.showMessageDialog(null, "A location  should contain atleast 3 characters");
            return false;
        } else {
            Pattern ptfname_check = Pattern.compile("[^a-zA-z]");
            Matcher mtfname = ptfname_check.matcher(Fromm);
            boolean splcheck = mtfname.find();
            if (splcheck == true) {
                JOptionPane.showMessageDialog(null, "Special characters and numbers are not allowed");
                return false;
            }
        }
        return true;
    }
}
