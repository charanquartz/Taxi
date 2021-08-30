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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SignUp extends JPanel implements ActionListener {
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
	 public SignUp() {
		 setLayout(null);
         setBackground(Color.yellow);
         setSize(500, 600);
         
         title = new JLabel("SIGNUP PAGE");
         
         //labels
         lbl1 = new JLabel("FIRST NAME");
         lbl2 = new JLabel("LAST NAME");
         lbl3 = new JLabel("MOBILE");
         lbl4 = new JLabel("EMAIL");
         lbl5 = new JLabel("GENDER");
         lbl6 = new JLabel("STATE");
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
         title.setBounds(325, 60, 500, 25);
         lbl1.setBounds(80,120, 100, 20);
         lbl2.setBounds(400,120, 120, 20);
         lbl3.setBounds(80,180, 120, 20);
         lbl4.setBounds(400, 180, 120, 20);
         lbl5.setBounds(80,240, 120,20);
         lbl6.setBounds(400,240,120, 20);
         lbl7.setBounds(80,300, 120,20);
         lbl8.setBounds(390,300, 150, 20);
         jb_submit.setBounds(325,380, 150,30);
         
         title.setFont(new Font("Serif", Font.BOLD, 30));
         jb_submit.setFont(new Font("Serif", Font.BOLD,20));
         
         txtFld1.setBounds(200, 120, 150, 30);
         txtFld2.setBounds(530,120, 150, 30);
         txtFld3.setBounds(200, 180, 150, 30);
         txtFld4.setBounds(530,180, 150, 30);
         jrb_male.setBounds(200,240,55, 30);
         jrb_female.setBounds(260,240,68, 30);
         jcSta.setBounds(530,240, 150, 30);
         txtFld5.setBounds(200,300, 150,30);
         txtFld6.setBounds(530,300, 150, 30);
         
         //add
         add(title);
         add(lbl1);
         add(lbl2);
         add(lbl3);
         add(lbl4);
         add(lbl5);
         add(lbl6);
         add(lbl7);
         add(lbl8);

         add(jb_submit);
         
         add(txtFld1);
         add(txtFld2);
         add(txtFld3);
         add(txtFld4);
         add(txtFld5);
         add(txtFld6);
         add(jcSta);
         add(jrb_female);
         add(jrb_male);
         
         setVisible(true);
         
	 }
	 @SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) {
			
		     Object obj=e.getSource();
		     if(obj==jb_submit){
		    	 Customer oj = new Customer();
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

		    	 if(txtFld6.getText().equals(con_pass)) {
		    		 
		    		 // create table customer(Fname varchar2(30),Lname varchar2(30),Moblie int,Email varchar2(30),Gender char(8),State char(20),Pass varchar2(30),portNumber int primary key);
				 try{
					 String fname = oj.getFname();
					 String lname = oj.getLname();
					 long mob = oj.getMob();
				     String email = oj.getEmail() ;
				     String gender = oj.getGender();
				     String state = oj.getState();
				     String pass =oj.getPass();
		    		 Class.forName("oracle.jdbc.driver.OracleDriver");
	                 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","test","sql");
	                // Statement stmt=con.createStatement();
	                
	                
	                //String query="insert into signup values('"+txtFld1.getText()+"','"+txtFld2.getText()+"','"+txtFld3.getText()+"','"+txtFld4.getText()+"','"+str_gender+"','"+jcSta+"','"+txtFld5.getText()+"')";
	                 String query="insert into std1 values(?,?,?,?,?,?,?)"; 
	                 PreparedStatement pstmt = con.prepareStatement(query);
	                 //stmt.executeUpdate(query);
	                 pstmt.setString(1,fname);
	 	            pstmt.setString(2,lname);
	 	           pstmt.setLong(3,mob);
	 	            pstmt.setString(4,email);
	 	            pstmt.setString(5,gender);
	 	            pstmt.setString(6,state);
	 	            pstmt.setString(7,pass);	            
	             pstmt.executeUpdate();
	                 con.setAutoCommit(true);
	                 JOptionPane.showMessageDialog(this, "Registration Success!");


		            }
		            catch(Exception ex){
		                JOptionPane.showMessageDialog(this, ex.toString());
		            }
		    	 }
			else{
				JOptionPane.showMessageDialog(null, "Password does not match");
			}
		    	 
		    	 }
		     }
	public int generateRandomNumber(){
	     int n=0;
	     for(int i=0;i<6;i++){

         }
	     return n;
    }
	 public static void main(String[]args) {
		 new SignUp();
	 }
	 
}
