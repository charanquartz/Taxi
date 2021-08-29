package proj;
import proj.jb;

import proj.email;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
public class home extends JFrame implements ActionListener {
	Container c;
	JTextField txtFld1,txtFld2;
	 ButtonGroup bg;
	 JButton jb_newuser,jb_login,forgetpass;
	 JPanel jp;
	 
	 public home() {
		 setTitle("PASSENGER HOME PAGE :)");
		 
		 c=getContentPane();
	     c.setLayout(null); 
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setExtendedState(MAXIMIZED_BOTH);
         setSize(400, 600);
         
         txtFld1 = new JTextField();
         // txtFld1.setForeground(Color.GRAY);
          txtFld1.setText("Email ID");
          txtFld1.addFocusListener(new FocusListener() {
              public void focusGained(FocusEvent e) {
                  if (txtFld1.getText().equals("Email ID")) {
                 	 txtFld1.setText("");
                 	 txtFld1.setForeground(Color.BLACK);
                      }

                  }
              
                  public void focusLost(FocusEvent e) {
                      if (txtFld1.getText().isEmpty()) {
                     	 txtFld1.setForeground(Color.GRAY);
                     	 txtFld1.setText("Email ID");
                      }
                  }
              });
          
          txtFld2 = new JTextField();
          // txtFld1.setForeground(Color.GRAY);
           txtFld2.setText("Password");
           txtFld2.addFocusListener(new FocusListener() {
               public void focusGained(FocusEvent e) {
                   if (txtFld2.getText().equals("Password")) {
                  	 txtFld2.setText("");
                  	 txtFld2.setForeground(Color.BLACK);
                       }

                   }
               
                   public void focusLost(FocusEvent e) {
                       if (txtFld2.getText().isEmpty()) {
                      	 txtFld2.setForeground(Color.GRAY);
                      	 txtFld2.setText("Password");
                       }
                   }
               });
           
           jb_login = new JButton("Login");
           jb_login.addActionListener(this);
           
           forgetpass = new JButton("Forgot Password");
           forgetpass.addActionListener(this);
           
           jb_newuser = new JButton("SignUp");
           jb_newuser.addActionListener(this);
           
           jb_login.setFont(new Font("Serif", Font.BOLD,15));
           forgetpass.setFont(new Font("Serif", Font.BOLD,15));
           jb_newuser.setFont(new Font("Serif", Font.BOLD,15));
           
           txtFld1.setBounds(475, 120, 300, 35);
           txtFld2.setBounds(475, 170, 300, 35);
           jb_login.setBounds(475, 220, 125, 35);
           forgetpass.setBounds(655, 220, 155, 35);
           jb_newuser.setBounds(1050,25,180,20);
           
           c.add(txtFld1);
           c.add(txtFld2);
           c.add(forgetpass);
           c.add(jb_login);
           c.add(jb_newuser);
          
           
           setVisible(true);
	 }
	 public void actionPerformed(ActionEvent e) {
			
	     Object obj=e.getSource();
	     if(obj == jb_login) {
	    	 jb oj = new jb();
	    	 oj.setMob(txtFld1.getText().toString());
	    	 oj.setPass(txtFld2.getText().toString());
	    	 String pass = oj.getPass();
	    	 String email = oj.getEmail();
	    	 try{
	    		 Class.forName("oracle.jdbc.driver.OracleDriver");
                 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","test","sql");
                 String query="select email from std1 where pass=?"; 
                 PreparedStatement pstmt = con.prepareStatement(query);
                 pstmt.setString(1,pass);
                 ResultSet rst=pstmt.executeQuery();
                 if(rst.next()) {
                	 if(email.equals(rst.getString("email"))) {
                		 email em = new email();
                		 em.setEmail(email);
				 new BookRide();
                	 }
                	 else {
                		 JOptionPane.showMessageDialog(null,"Mobile Number or Password wrong");
                	 }
                 }
                 
                 
	    	 }
	    	 catch(Exception ex){
	                JOptionPane.showMessageDialog(this, ex.toString());
	            }
	    	 
	     }
	     if(obj == forgetpass) {
	    	 
	     }
	     if(obj == jb_newuser) {
	    	 new signup();
	     }
	 
	 }
	 

	public static void main(String[] args) {
		new home();
	}

}
