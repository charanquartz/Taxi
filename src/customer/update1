
package proj;
import proj.jb;

import proj.email;

import proj.home;


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

public class cusup extends JFrame implements ActionListener {
		
		Container c;
		 JLabel title,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
		 JTextField txtFld1,txtFld2,txtFld3,txtFld4,txtFld5,txtFld6,txtFld7,txt;
		 JButton jb_submit,btn;
		 JPanel jp;
		
		public cusup()  {
			
			setTitle("UPDATE PASSANGER PROFILE ;)");
			c=getContentPane();
		     c.setLayout(null); 
	         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         setExtendedState(MAXIMIZED_BOTH);
	         c.setBackground(Color.CYAN);
	         setSize(500, 600);
	         
	         title = new JLabel("UPDATE PROFILE");
	         
	         //labels
	         lbl1 = new JLabel("FIRST NAME");
	         lbl2 = new JLabel("LAST NAME");
	         lbl3 = new JLabel("MOBILE");
	         lbl4 = new JLabel("EMAIL(dont change)");
	         lbl5 = new JLabel("GENDER");
	         lbl6 = new JLabel("STATE");
	         lbl7 = new JLabel("PASSWORD");
	         
	         
	         txtFld1 = new JTextField();
	         txtFld2 = new JTextField();
	         txtFld3 = new JTextField();
	         txtFld4 = new JTextField();
	         txtFld5 = new JTextField();
	         txtFld6 = new JTextField();
	         txtFld7 = new JTextField();
	         
	         
	         txt = new JTextField();
	         txt.setText("ENTER YOUR EMAIL");
	         txt.addFocusListener(new FocusListener() {
	               public void focusGained(FocusEvent e) {
	                   if (txt.getText().equals("ENTER YOUR EMAIL")) {
	                	   txt.setText("");
	                	   txt.setForeground(Color.BLACK);
	                       }

	                   }
	               
	                   public void focusLost(FocusEvent e) {
	                       if (txt.getText().isEmpty()) {
	                    	   txt.setForeground(Color.GRAY);
	                    	   txt.setText("ENTER YOUR EMAIL");
	                       }
	                   }
	               });

	         
	         
	         
	       //submit btn
	         jb_submit = new JButton("Submit");
	         jb_submit.addActionListener(this);
	         
	         btn = new JButton("click");
	         btn.addActionListener(this);
	         
	         
	         
	         title.setBounds(400, 60, 500, 25);
	         txt.setBounds(400,90,200, 20);
	         lbl1.setBounds(400,120, 120, 20);
	         lbl2.setBounds(400,150, 120, 20);
	         lbl3.setBounds(400,180, 120, 20);
	         lbl4.setBounds(400,210, 120, 20);
	         lbl5.setBounds(400,240, 120,20);
	         lbl6.setBounds(400,270,120, 20);
	         lbl7.setBounds(400,300, 120,20);
	         
	         txtFld1.setBounds(550, 120, 120, 20);
	         txtFld2.setBounds(550,150, 120, 20);
	         txtFld3.setBounds(550, 180, 120, 20);
	         txtFld4.setBounds(550,210, 120, 20);
	         txtFld5.setBounds(550,240,120, 20);
	         txtFld6.setBounds(550,270, 120, 20);
	         txtFld7.setBounds(550,300, 120,20);
	         
	         jb_submit.setBounds(500,380, 150,20);
	         btn.setBounds(650,90,150,20);
	         
	         title.setFont(new Font("Serif", Font.BOLD, 20));
	         jb_submit.setFont(new Font("Serif", Font.BOLD,15));
	         
	         //add
	         c.add(title);
	         c.add(lbl1);
	         c.add(lbl2);
	         c.add(lbl3);
	         c.add(lbl4);
	         c.add(lbl5);
	         c.add(lbl6); 
	         c.add(lbl7);
	         
	         c.add(jb_submit);
	         c.add(btn);
	         
	         c.add(txt);
	         c.add(txtFld1);
	         c.add(txtFld2);
	         c.add(txtFld3);
	         c.add(txtFld4);
	         c.add(txtFld5);
	         c.add(txtFld6);
	         c.add(txtFld7);
	         
	         
	         
	         setVisible(true);
	         
	         
			
			
		}
		
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			if(src == btn) {
				try {
		        	 
		        	 Class.forName("oracle.jdbc.driver.OracleDriver");
	                 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","SYSTEM","jana");
	                 String query="select fname,lname,mob,email,gender,state,pass from std1 where email=?";
	                 PreparedStatement pstmt=con.prepareStatement(query);

	                 pstmt.setString(1,txt.getText());
	                 ResultSet rst=pstmt.executeQuery();
	                 if(rst.next()){
	                     txtFld1.setText(rst.getString("fname"));
	                     txtFld2.setText(rst.getString("lname"));
	                     txtFld3.setText(rst.getString("mob"));
	                     txtFld4.setText(rst.getString("email"));
	                     txtFld5.setText(rst.getString("gender"));
	                     txtFld6.setText(rst.getString("state"));
	                     txtFld7.setText(rst.getString("pass"));
	                     
	                     
	                 }
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this,"@@@@@@@@@@@@@@@"+ e1.toString());
				}
			}
			else if(src == jb_submit) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
	                   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","SYSTEM","jana");
	                   String query="update std1 set fname=?,lname=?,mob=?,Gender=?,State=?,Pass=? where Email=?";
	                   PreparedStatement pstmt=con.prepareStatement(query);
	                   pstmt.setString(1,txtFld1.getText());
	                   pstmt.setString(2,txtFld2.getText());
	                   pstmt.setString(3,txtFld3.getText());
	                   pstmt.setString(4,txtFld5.getText());
	                   pstmt.setString(5,txtFld6.getText());
	                   pstmt.setString(6,txtFld7.getText());
	                   pstmt.setString(7,txtFld4.getText());
	                   pstmt.executeUpdate();
	                   con.setAutoCommit(true);
	                   JOptionPane.showMessageDialog(this, "Updation Success Bunny ;)");
	                   
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this,"^^^^^^^^^^^^^^^^"+ e2.toString());
					
				}
			}
			
		}
		
	
	public static void main(String[]args) {
		new cusup();
		
	}
}
