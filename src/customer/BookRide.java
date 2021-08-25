package customer;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.ItemSelectable;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BookRide extends JFrame implements ActionListener {
	 Container c;
	 JLabel title,lbl1,lbl2,lbl3,lbl4;
	 JTextField txtFld1,txtFld2;
	 @SuppressWarnings("rawtypes")
	 JComboBox carnme , carseat;
	 JRadioButton jrb_male,jrb_female;
	 String str_gender;
	 ButtonGroup bg;
	 JButton jb_submit;
	 JPanel jp;
	 
	 
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 public BookRide() {
		 
		 
		 
		 
		 setTitle("BOOK RIDE");
		 c=getContentPane();
	     c.setLayout(null); 
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setExtendedState(MAXIMIZED_BOTH);
         c.setBackground(Color.yellow);
         setSize(500, 600);
         
         title = new JLabel("TAXI BOOKING ");
         
         //labels
         lbl1 = new JLabel("Current Location");
         lbl2 = new JLabel("Destination Location");
         lbl3 = new JLabel("Car Type");
         lbl4 = new JLabel("No of Seats");
         
         
         //txt field
         txtFld1 = new JTextField();
        // txtFld1.setForeground(Color.GRAY);
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
         
         
         
         //select car seat
         carnme=new JComboBox();
         
         carseat = new JComboBox();
         carseat.addItem("1");
         carseat.addItem("2");
         carseat.addItem("3");
         
         
        
         
         
         
         
         //book ride btn
         jb_submit = new JButton("Book Ride");
         jb_submit.addActionListener(this);
         
         //setbounds area
         title.setBounds(400, 60, 200, 25);
         lbl1.setBounds(300,120, 200, 25);
         lbl2.setBounds(300,180, 200, 25);
         lbl3.setBounds(300,240, 200, 25);
         lbl4.setBounds(300,300, 200, 25);
         jb_submit.setBounds(400,360, 120,20);
         
         title.setFont(new Font("Serif", Font.BOLD, 20));
         lbl1.setFont(new Font("Serif", Font.BOLD, 21));
         lbl2.setFont(new Font("Serif", Font.BOLD, 21));
         lbl3.setFont(new Font("Serif", Font.BOLD, 21));
         lbl4.setFont(new Font("Serif", Font.BOLD, 21));
         jb_submit.setFont(new Font("Serif", Font.BOLD,15));
         
         txtFld1.setBounds(550, 120, 200, 20);
         txtFld2.setBounds(550,180, 200, 20);
         
        
         carnme.setBounds(550,240, 120, 20);
         carseat.setBounds(550,300, 120, 20);
         
         
         //add
         c.add(title);
         c.add(lbl1);
         c.add(lbl2);
         c.add(lbl3);
         c.add(lbl4);
         
         
         c.add(jb_submit);
         
         c.add(txtFld1);
         c.add(txtFld2);
         
         
         c.add(carnme);
         c.add(carseat);
         
         try{
             

             Class.forName("oracle.jdbc.driver.OracleDriver");
             Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","test","sql");
             String query="select company from car";
             PreparedStatement pstmt=con.prepareStatement(query);
             //create table car(ownerEmail varchar(30),carId varchar(10) primary key,company varchar(20),model varchar(30),capacity int,ac char(5),farePerKM int);

             ResultSet rst=pstmt.executeQuery();

             while(rst.next()){

                 carnme.addItem(rst.getInt("Car"));
             }


      }
      catch(Exception ex){
          JOptionPane.showMessageDialog(this, " ---------- "+ ex.toString());
      }
         
         setVisible(true);
         
	 }
	 //

	 //
	 @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) {
			
		     Object obj=e.getSource();
		     if(obj==jb_submit){
		    	 jb oj = new jb();
		    	 oj.setFname(txtFld1.getText());
		    	 oj.setLname(txtFld2.getText());
		    	 
		    	 oj.setState(carnme.getSelectedItem().toString());
		    	 
		    	 
		    	 String con_pass = oj.getPass();

		    	 if(txtFld2.getText().equals(con_pass)) {

				 try{
					 String Fromm = oj.getFromm();
					 String Too = oj.getToo();
					 int Seat = oj.getSeat();
					 
				     
		    		 Class.forName("oracle.jdbc.driver.OracleDriver");
	                 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","test","sql");
	                // Statement stmt=con.createStatement();
					 
	                
	                
	                 String query="insert into bookride values(?,?,?)"; 
		 //create table bookride(fromm varchar2(30),too varchar2(30) , seat int , emaild varchar2(20);
	                 PreparedStatement pstmt = con.prepareStatement(query);
	                 //stmt.executeUpdate(query);
	                 pstmt.setString(1,Fromm);
	 	            pstmt.setString(2,Too);
	 	           pstmt.setInt(3,Seat);
	 	           	            
	             pstmt.executeUpdate();
	                 con.setAutoCommit(true);
	                 JOptionPane.showMessageDialog(this, "Booking Success!");


		            }
		            catch(Exception ex){
		                JOptionPane.showMessageDialog(this, ex.toString());
		            }
		    	 }
			else{
				JOptionPane.showMessageDialog(null, "Booking Not Success");
			}
		    	 
		    	 }
		     }
	 public static void main(String[]args) {
		 new BookRide();
	 }
	 
}
