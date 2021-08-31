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
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateProfile extends JPanel implements ActionListener {
		
		Container c;
		 JLabel title,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
		 JTextField txtFld1,txtFld2,txtFld3,txtFld4,txtFld5,txtFld6,txtFld7,txt;
		 JButton jb_submit,btn;
		 JPanel jp;
		
		public UpdateProfile()  {
			setVisible(true);
			setLayout(null);
	        setBackground(Color.yellow);
	         setSize(500, 600);
	         
	         title = new JLabel("UPDATE PROFILE");
	         
	         //labels
	         lbl1 = new JLabel("FIRST NAME");
	         lbl2 = new JLabel("LAST NAME");
	         lbl3 = new JLabel("MOBILE");
	         //lbl4 = new JLabel("EMAIL(dont change)");
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
	         
	         
	         
	         title.setBounds(450, 60, 500, 25);
	         txt.setBounds(400,120,200, 30);
	         lbl1.setBounds(400,190, 120, 20);
	         lbl2.setBounds(400,230, 120, 20);
	         lbl3.setBounds(400,270, 120, 20);
	        
	         lbl5.setBounds(400,310, 120,20);
	         lbl6.setBounds(400,350,120, 20);
	         lbl7.setBounds(400,390, 120,20);
	         
	         txtFld1.setBounds(600, 190, 200, 30);
	         txtFld2.setBounds(600,230, 200, 30);
	         txtFld3.setBounds(600, 270, 200, 30);
	         //txtFld4.setBounds(550,210, 120, 20);
	         txtFld5.setBounds(600,310,200, 30);
	         txtFld6.setBounds(600,350, 200, 30);
	         txtFld7.setBounds(600,390, 200,30);
	         
	         jb_submit.setBounds(550,450, 150,30);
	         btn.setBounds(650,120,150,30);
	         
	         title.setFont(new Font("Serif", Font.BOLD, 20));
	         jb_submit.setFont(new Font("Serif", Font.BOLD,15));
	         
	         //add
	         add(title);
	         add(lbl1).setVisible(false);
	         add(lbl2).setVisible(false);
	         add(lbl3).setVisible(false);
	         
	         add(lbl5).setVisible(false);
	         add(lbl6).setVisible(false);
	         add(lbl7).setVisible(false);
	         add(jb_submit).setVisible(false);

	         add(btn);
	         
	         add(txt);
	         add(txtFld1).setVisible(false);
	         add(txtFld2).setVisible(false);
	         add(txtFld3).setVisible(false);
	        
	         add(txtFld5).setVisible(false);
	         add(txtFld6).setVisible(false);
	         add(txtFld7).setVisible(false);
		}
		
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			if(src == btn) {
				try {
		        	 
		        	 Class.forName("oracle.jdbc.driver.OracleDriver");
	                 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","test","sql");
	                 String query="select fname,lname,mob,email,gender,state,pass from std1 where email=?";
	                 PreparedStatement pstmt=con.prepareStatement(query);

	                 pstmt.setString(1,txt.getText());
	                 ResultSet rst=pstmt.executeQuery();
	                 if(rst.next()){
						 txtFld1.setVisible(true);
						 
						 txtFld2.setVisible(true);
						 txtFld3.setVisible(true);
						 txtFld5.setVisible(true);
						 txtFld6.setVisible(true);
						 txtFld7.setVisible(true);
						 lbl1.setVisible(true);
						 lbl2.setVisible(true);
						 lbl3.setVisible(true);
						 lbl5.setVisible(true);
						 lbl6.setVisible(true);
						 lbl7.setVisible(true);
						 
						 jb_submit.setVisible(true);
						 
	                     txtFld1.setText(rst.getString("fname"));
	                     txtFld2.setText(rst.getString("lname"));
	                     txtFld3.setText(rst.getString("mob"));
	                
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
	                   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","test","sql");
	                   String query="update std1 set fname=?,lname=?,mob=?,Gender=?,State=?,Pass=? where Email=?";
	                   PreparedStatement pstmt=con.prepareStatement(query);
	                   pstmt.setString(1,txtFld1.getText());
	                   pstmt.setString(2,txtFld2.getText());
	                   pstmt.setString(3,txtFld3.getText());
	                   pstmt.setString(4,txtFld5.getText());
	                   pstmt.setString(5,txtFld6.getText());
	                   pstmt.setString(6,txtFld7.getText());
	                   pstmt.setString(7,txt.getText());
	                   pstmt.executeUpdate();
	                   con.setAutoCommit(true);
	                   JOptionPane.showMessageDialog(this, "Updation Success Bunny ;)");
	                   
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this,"^^^^^^^^^^^^^^^^"+ e2.toString());
					
				}
			}
			
		}
		
	
	public static void main(String[]args) {
		new UpdateProfile();
		
	}
}
