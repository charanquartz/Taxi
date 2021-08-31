package customer;

import java.awt.Color;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BookRide extends JPanel implements ActionListener {
	 Container c;
	 JLabel title,lbl1,lbl2,lbl3,lbl4,lbl5;
	 JTextField txtFld1,txtFld2;
	 @SuppressWarnings("rawtypes")
	 JComboBox  carseat;
	 String str_gender;
	 ButtonGroup bg;
	 JButton jb_submit;
	 JPanel jp;

	 int i= TabServer.generateRandomNumber();
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 public BookRide() {
		 setLayout(null);
         setBackground(Color.yellow);
         setSize(500, 600);
         
         title = new JLabel("TAXI BOOKING PAGE");
         
         //labels
         lbl1 = new JLabel("Current Location");
         lbl2 = new JLabel("Destination Location");
         //lbl3 = new JLabel("Car Type");
         lbl4 = new JLabel("No of Seats");
         lbl5 = new JLabel("Your OTP is "+i);
        
         
         
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
         
         
         
         //select car seat
         
         
         carseat = new JComboBox();
         carseat.addItem("1");
         carseat.addItem("2");
         carseat.addItem("3");
         
         
        
         
         
         
         
         //book ride btn
         jb_submit = new JButton("Book Ride");
         jb_submit.addActionListener(this);
         
        // jb_upd = new JButton("  Update  ");
         //jb_upd.addActionListener(this);
         //jb_upd.addActionListener(this);
         
         //setbounds area
         title.setBounds(250, 40, 500, 50);
         lbl1.setBounds(80,120, 200, 25);
         lbl2.setBounds(80, 180, 200, 25);
      
         lbl4.setBounds(80,240, 200, 25);
         jb_submit.setBounds(250,300, 150,30);
         //jb_upd.setBounds(1000,15,120,20);
         
         lbl5.setBounds(800,240, 200, 35);
         
         
         
         title.setFont(new Font("Serif", Font.BOLD, 30));
         lbl1.setFont(new Font("Serif", Font.BOLD, 21));
         lbl2.setFont(new Font("Serif", Font.BOLD, 21));
         lbl4.setFont(new Font("Serif", Font.BOLD, 21));
         lbl5.setFont(new Font("Serif", Font.BOLD, 22));
         jb_submit.setFont(new Font("Serif", Font.BOLD,20));
         
         txtFld1.setBounds(300, 120, 250, 30);
         txtFld2.setBounds(300,180, 250, 30);
         
        
        
         carseat.setBounds(300,240, 45, 30);
         
         
         //add
         add(title);
         add(lbl1);
         add(lbl2);
        // c.add(lbl3);
         add(lbl4);
         add(lbl5).setVisible(false);;
         
         
         add(jb_submit);
         //c.add(jb_upd);
         
         add(txtFld1);
         add(txtFld2);
         
         
         
         add(carseat);
         
         
         setVisible(true);
         
	 }
	 //
	 

	 //
	 @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) {
			
		     Object obj=e.getSource();
		     if(obj==jb_submit){
		    	 
		    	 Email em = new Email();
		    	 String email = em.getEmail();
		    	 
				 try{
					 
					 
				     
		    		 Class.forName("oracle.jdbc.driver.OracleDriver");
	                 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","test","sql");
	                // Statement stmt=con.createStatement();
	                
	                
	                 String query="insert into bookride3 values(?,?,?,?,?,?,?)"; 
	  //create tabel bookride(from varchar(20), to varchar(20), seat varchar(20), email varchar(20), company varchar(20) );
	                 PreparedStatement pstmt = con.prepareStatement(query);
	                 //stmt.executeUpdate(query);
	                 pstmt.setString(1,txtFld1.getText());
	 	            pstmt.setString(2,txtFld2.getText());
	 	           pstmt.setString(3,carseat.getSelectedItem().toString());
	 	           pstmt.setString(4,email);
	 	          pstmt.setString(5,"false");
	 	         pstmt.setInt(6,-1);
	 	           pstmt.setInt(7,i);
	 	           
	             pstmt.executeUpdate();
	                 con.setAutoCommit(true);
	                 
	                 JOptionPane.showMessageDialog(this, "Booking Success!");
	                 lbl5.setVisible(true);
	                 //new feed().setVisible(true);
	                 
	                 


		            }
		            catch(Exception ex){
		                JOptionPane.showMessageDialog(this, ex.toString());
		            }
				 
		     }
	
		    	 
			else{
				JOptionPane.showMessageDialog(null, "Booking Not Success");
			}
		     
		      
		    	 
		     }
	 public static void main(String args[]) {
		  new BookRide();
		 
		 
	 } 
	 
	 
}
