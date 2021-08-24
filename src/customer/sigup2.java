package customer;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class signup extends JFrame implements ActionListener {
	 Container c;
	 JLabel title,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8;
	 JTextField txtFld1,txtFld2,txtFld3,txtFld4,txtFld5,txtFld6;
	 @SuppressWarnings("rawtypes")
	 JComboBox jcSta;
	 JRadioButton jrb_male,jrb_female;
	 String str_gender;
	 ButtonGroup bg;
	 JButton jb_submit;
	 JPanel jp;
	 String State[] = {"Andhra Pradesh"," Arunachal Pradesh","Assam","Bihar","Karnataka",
	            "Kerala","Chhattisgarh","Uttar Pradesh","Goa","Gujarat","Haryana","Himachal Pradesh",
	            "Jammu and Kashmir","Jharkhand","West Bengal","Madhya Pradesh","Maharashtra","Manipur",
	            "Meghalaya","Mizoram","Nagaland","Orissa","Punjab","Rajasthan","Sikkim","Tamil Nadu",			      
	            "Telangana","Tripura","Uttarakhand"};
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 public signup() {
		 setTitle("PASSENGER SIGNUP FORM :)");
		 c=getContentPane();
	     c.setLayout(null); 
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setExtendedState(MAXIMIZED_BOTH);
         c.setBackground(Color.ORANGE);
         setSize(500, 600);
         
         title = new JLabel("TAXI BOOKING ");
         
         //labels
         lbl1 = new JLabel("FIRST NAME");
         lbl2 = new JLabel("LAST NAME");
         lbl3 = new JLabel("MOBILE");
         lbl4 = new JLabel("EMAIL");
         lbl5 = new JLabel("GENDER");
         lbl6 = new JLabel("COUNTRY");
         lbl7 = new JLabel("PASSWORD");
         lbl8 = new JLabel("CONFIRM PASSWORD");
         
         //txt field
         txtFld1 = new JTextField();
        // txtFld1.setForeground(Color.GRAY);
         txtFld1.setText("Atleast 3 Char");
         txtFld1.addFocusListener(new FocusListener() {
             public void focusGained(FocusEvent e) {
                 if (txtFld1.getText().equals("Atleast 3 Char")) {
                	 txtFld1.setText("");
                	 txtFld1.setForeground(Color.BLACK);
                     }

                 }
             
                 public void focusLost(FocusEvent e) {
                     if (txtFld1.getText().isEmpty()) {
                    	 txtFld1.setForeground(Color.GRAY);
                    	 txtFld1.setText("Atleast 3 Char");
                     }
                 }
             });
         txtFld2 = new JTextField();
         txtFld3 = new JTextField();
         txtFld4 = new JTextField();
         txtFld4.setForeground(Color.GRAY);
         txtFld4.setText("abc@gmail.com");
         txtFld4.addFocusListener(new FocusListener() {
             public void focusGained(FocusEvent e) {
                 if (txtFld4.getText().equals("abc@gmail.com")) {
                	 txtFld4.setText("");
                	 txtFld4.setForeground(Color.BLACK);
                     }

                 }
             
                 public void focusLost(FocusEvent e) {
                     if (txtFld4.getText().isEmpty()) {
                    	 txtFld4.setForeground(Color.CYAN);
                    	 txtFld4.setText("abc@gmail.com");
                     }
                 }
             });
         txtFld5 = new JTextField();
         txtFld5.setText("Atleast 3 Char");
         txtFld5.addFocusListener(new FocusListener() {
             public void focusGained(FocusEvent e) {
                 if (txtFld5.getText().equals("Atleast 3 Char")) {
                	 txtFld5.setText("");
                	 txtFld5.setForeground(Color.BLACK);
                     }

                 }
             
                 public void focusLost(FocusEvent e) {
                     if (txtFld5.getText().isEmpty()) {
                    	 txtFld5.setForeground(Color.GRAY);
                    	 txtFld5.setText("Atleast 3 Char");
                     }
                 }
             });
         txtFld6 = new JTextField();
         txtFld6.setText("Confirm pass");
         txtFld6.addFocusListener(new FocusListener() {
             public void focusGained(FocusEvent e) {
                 if (txtFld6.getText().equals("Confirm pass")) {
                	 txtFld6.setText("");
                	 txtFld6.setForeground(Color.BLACK);
                     }

                 }
             
                 public void focusLost(FocusEvent e) {
                     if (txtFld6.getText().isEmpty()) {
                    	 txtFld6.setForeground(Color.GRAY);
                    	 txtFld6.setText("Confirm pass");
                     }
                 }
             });
         //FocusListener for mobileno text field
         txtFld3.setForeground(Color.GRAY);
         txtFld3.setText("+91(10)");
         txtFld3.addFocusListener(new FocusListener() {
             public void focusGained(FocusEvent e) {
                 if (txtFld3.getText().equals("+91(10)")) {
                	 txtFld3.setText("");
                	 txtFld3.setForeground(Color.BLACK);
                     }

                 }
             
                 public void focusLost(FocusEvent e) {
                     if (txtFld3.getText().isEmpty()) {
                    	 txtFld3.setForeground(Color.GRAY);
                    	 txtFld3.setText("+91(10)");
                     }
                 }
             });
         //state select
         jcSta =new JComboBox(State);
         //radio buttn for gender
         bg = new ButtonGroup();
         jrb_male = new JRadioButton("Male");
         jrb_male.setSelected(true);
         jrb_female= new JRadioButton("Female");
         jrb_female.setSelected(false);
         bg.add(jrb_male);
         bg.add(jrb_female);
         
         //submit btn
         jb_submit = new JButton("Submit");
         jb_submit.addActionListener(this);
         
         //setbounds area
         title.setBounds(400, 60, 500, 25);
         lbl1.setBounds(400,120, 120, 20);
         lbl2.setBounds(400,150, 120, 20);
         lbl3.setBounds(400,180, 120, 20);
         lbl4.setBounds(400,210, 120, 20);
         lbl5.setBounds(400,240, 120,20);
         lbl6.setBounds(400,270,120, 20);
         lbl7.setBounds(400,300, 120,20);
         lbl8.setBounds(350,330, 150, 20);
         jb_submit.setBounds(500,380, 150,20);
         
         title.setFont(new Font("Serif", Font.BOLD, 20));
         jb_submit.setFont(new Font("Serif", Font.BOLD,15));
         
         txtFld1.setBounds(550, 120, 120, 20);
         txtFld2.setBounds(550,150, 120, 20);
         txtFld3.setBounds(550, 180, 120, 20);
         txtFld4.setBounds(550,210, 120, 20);
         jrb_male.setBounds(550,240,55, 20);
         jrb_female.setBounds(610,240,68, 20);
         jcSta.setBounds(550,270, 120, 20);
         txtFld5.setBounds(550,300, 120,20);
         txtFld6.setBounds(550,330, 120, 20);
         
         //add
         c.add(title);
         c.add(lbl1);
         c.add(lbl2);
         c.add(lbl3);
         c.add(lbl4);
         c.add(lbl5);
         c.add(lbl6); 
         c.add(lbl7);
         c.add(lbl8);
         
         c.add(jb_submit);
         
         c.add(txtFld1);
         c.add(txtFld2);
         c.add(txtFld3);
         c.add(txtFld4);
         c.add(txtFld5);
         c.add(txtFld6);
         c.add(jcSta);
         c.add(jrb_female);
         c.add(jrb_male);
         
         setVisible(true);
         
	 }
	 @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) {
			
		     Object obj=e.getSource();
		     if(obj==jb_submit){
		    	 jb oj = new jb();
		    	 oj.setFname(txtFld1.getText());
		    	 oj.setLname(txtFld2.getText());
		    	 oj.setMob(txtFld3.getText().toString());
		    	 oj.setEmail(txtFld4.getText());
		    	 oj.setPass(txtFld5.getText());
		    	 oj.setState(jcSta.getSelectedItem().toString());
		    	 if (jrb_male.isSelected()){
		    		 str_gender  = "Male";
		             oj.setGender(str_gender);
		             }
		             else{
		            	 str_gender = "Female";
		             oj.setGender(str_gender);
		             }
		    	 
		    	 String con_pass = oj.getPass();
		    	 //
		    	 try{
		    		 Class.forName("oracle.jdbc.driver.OracleDriver");
	                 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","test","sql");
	                 Statement stmt=con.createStatement();
	                
	                
	                String query="insert into signup values('"+txtFld1.getText()+"','"+txtFld2.getText()+"','"+txtFld2.getText()+"','"+txtFld4.getText()+"','"+str_gender+"','"+jcSta+"','"+txtFld5.getText()+"')";
	                 stmt.executeUpdate(query);
	                 con.setAutoCommit(true);
	                 JOptionPane.showMessageDialog(this, "Registration Success!");


		            }
		            catch(Exception ex){
		                JOptionPane.showMessageDialog(this, ex.toString());
		            }
		    	 
		    	 if(txtFld6.getText().equals(con_pass)) {
		    		 
		    		 /*create table signup( Fname varchar2(20),Lname varchar2(20),Moblie varchar2(20),Email varchar2(20),Gender varchar2(20),State varchar2(20),Pass varchar2(20) );*/
		    	 }
		    	 
		    	 }
		     }
	 public static void main(String[]args) {
		 new signup();
	 }
	 
}
