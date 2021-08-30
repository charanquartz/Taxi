package customer;

import java.awt.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Feedback extends JPanel  implements ActionListener
{
	private TextArea area_txta;
	private TextField txt;
	private Label elabel,rlabel;
	
	private JPanel jap;
	private CheckboxGroup cbg;
	private Checkbox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5;
	  
	 private Button submit_btn,exit_btn,clear_btn;
	 private String s;
	  
	  public Feedback() {
	  	setVisible(true);
		  setBackground(Color.yellow);
		  setLayout(null);
	      setSize(650,450);
	      setLocation(375,175);
	        
	        elabel = new Label("Email");
	        elabel.setBounds(50,100,50,30);
	        add(elabel);
        
	        rlabel = new Label("Ratings");
	        rlabel.setBounds(50,450,50,30);
	        add(rlabel);
	        
	        
	        
	        txt = new TextField();
	        txt.setBounds(130,100,150,30);
	        txt.setText("Email...");
	        txt.addFocusListener(new FocusListener() {
	               public void focusGained(FocusEvent e) {
	                   if (txt.getText().equals("Email...")) {
	                	   txt.setText("");
	                	   txt.setForeground(Color.BLACK);
	                       }

	                   }
	               
	                   public void focusLost(FocusEvent e) {
	                       if (txt.getText().isEmpty()) {
	                    	   txt.setForeground(Color.GRAY);
	                    	   txt.setText("Email...");
	                       }
	                   }
	               });
	        
	        add(txt);
	        
	        
	        area_txta=new TextArea();
	        area_txta.setBounds(50,150,475,280);
	        area_txta.setText("FEED BACK FORM");
	        area_txta.addFocusListener(new FocusListener() {
	               public void focusGained(FocusEvent e) {
	                   if (area_txta.getText().equals("FEED BACK FORM")) {
	                	   area_txta.setText("");
	                	   area_txta.setForeground(Color.BLACK);
	                       }

	                   }
	               
	                   public void focusLost(FocusEvent e) {
	                       if (area_txta.getText().isEmpty()) {
	                    	   area_txta.setForeground(Color.GRAY);
	                    	   area_txta.setText("FEED BACK FORM");
	                       }
	                   }
	               });
	        
	        
	        add(area_txta);
	        
	        
	        cbg = new CheckboxGroup();
	         checkBox1 = new Checkbox("1", cbg, false);   
	         checkBox2 = new Checkbox("2", cbg, false);  
	         checkBox3 = new Checkbox("3", cbg, false);  
	         checkBox4 = new Checkbox("4", cbg, false);  
	         checkBox5 = new Checkbox("5", cbg, true);  
	        
	         checkBox1.setBounds(120, 450, 20,10);
	         checkBox2.setBounds(150, 450, 20,10);
	        checkBox3.setBounds(180, 450, 20,10);
	         checkBox4.setBounds(210, 450, 20,10);
	         checkBox5.setBounds(240, 450, 20,10);
	        add(checkBox1);
	        add(checkBox2);
	        add(checkBox3);
	        add(checkBox4);
	        add(checkBox5);
	        
	        
	        
	        submit_btn=new Button("Submit");
	        submit_btn.setBounds(25,500,75,30);
	        submit_btn.addActionListener(this);
	        add(submit_btn);
	  }
	  
	  public void paint(Graphics g)
	    {
	            g.setFont(new Font("Informal Roman",Font.BOLD,30));
	            g.setColor(Color.BLACK);
	            g.drawString("FeedBack Form",200,80);
	            
	    }
	  public void actionPerformed(ActionEvent ae)
	    {
	        if(ae.getSource()==submit_btn)
	        {
	        	if(cbg.getSelectedCheckbox() == checkBox1 ) {
	        		s = "1";
	        	}
	        	else if(cbg.getSelectedCheckbox() == checkBox2) {
	        		s = "2";
	        	}
	        	else if(cbg.getSelectedCheckbox() == checkBox3) {
	        		s = "3";
	        	}
	        	else if(cbg.getSelectedCheckbox() == checkBox4) {
	        		s = "4";
	        	}
	        	else {
	        		s = "5";
	        	}
	        	 
	        	try {
	        		Class.forName("oracle.jdbc.driver.OracleDriver");
	                 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","test","sql");
	                 String query="insert into feed values(?,?,?)";
	                 PreparedStatement pstmt = con.prepareStatement(query);
	                    pstmt.setString(1,txt.getText());
		 	            pstmt.setString(2,area_txta.getText());
		 	            pstmt.setString(3,s);
		 	           pstmt.executeUpdate();
		                 con.setAutoCommit(true);
		                 JOptionPane.showMessageDialog(this, "Thank You for Your FeedBack !");
	                 
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, e.toString());
					
				}
	        
	        }
	        else {
	        	
	        }
	    }

	
	
	public static void main(String[]args) {
		new Feedback();
	}
}
//create table feed (email varchar2(20), feed varchar2(500), rate varchar2(20));
