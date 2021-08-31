package customer;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JPanel{
	JTextField txtFld1;
	JPasswordField txtFld2;
	JButton jb_login;
	JLabel txt;
	JCheckBox showpasswordCheckBox;
	 public Login() {
		 setLayout(null);
		 setVisible(true);
         setBackground(Color.yellow);
         setBounds(0,0,1900,1000);

         txt = new JLabel("LOGIN PAGE");
         txt.setFont(new Font("Serif", Font.BOLD, 30));

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

          txtFld2 = new JPasswordField();
          txtFld2.setText("Enter password");
          txtFld2.setEchoChar((char)0);

          //Focus listener for txtFld2
		 txtFld2.addFocusListener(new FocusListener() {
			 @Override
			 public void focusGained(FocusEvent e) {
				 if(txtFld2.getText().trim().equals("Enter password")){
				 	txtFld2.setEchoChar('*');
				 	txtFld2.setText("");
					txtFld1.setForeground(Color.BLACK);
				 }
			 }

			 @Override
			 public void focusLost(FocusEvent e) {
			 	if(txtFld2.getText().trim().equals("")){
					txtFld1.setForeground(Color.GRAY);
			 		txtFld2.setEchoChar((char)0);
					txtFld2.setText("Enter password");
				}
			 }
		 });
          // txtFld1.setForeground(Color.GRAY);

		 showpasswordCheckBox=new JCheckBox("Show password");
		 showpasswordCheckBox.setBounds(1030,270,200,35);
		 showpasswordCheckBox.addMouseListener(new MouseListener() {
			 @Override
			 public void mouseClicked(MouseEvent e) {
				 if(txtFld2.getText().trim().equals("Enter password")){
				 	showpasswordCheckBox.setSelected(false);
				 	return;
				 }
				 if(showpasswordCheckBox.isSelected()){
				 	String pass=txtFld2.getText();
				 	txtFld2.setEchoChar((char)0);
				 	txtFld2.setText(pass);
				 }
				 else{
				 	String pass=txtFld2.getText();
				 	txtFld2.setEchoChar('*');
				 	txtFld2.setText(pass);
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

           jb_login = new JButton("Login");
           //Mouse event
		 	jb_login.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try{
						if(!(TabServer.tabs.isEnabledAt(0))){
							JOptionPane.showMessageDialog(null,"Already logged in");
							return;
						}
						ResultSet customerDetails= TabServer.getCustomerDetails(txtFld1.getText());
						if(customerDetails.next()) {
							String password=customerDetails.getString(7);
							if(password.equals(txtFld2.getText())){
								TabServer.customer.setFirstName(customerDetails.getString(1));
								TabServer.customer.setLastName(customerDetails.getString(2));
								TabServer.customer.setMobileNumber(customerDetails.getLong(3)+"");
								TabServer.customer.setGender(customerDetails.getString(5));
								TabServer.customer.setState(customerDetails.getString(6));
								TabServer.customer.setPassword(customerDetails.getString(7));
								TabServer.customer.setPortNumber(customerDetails.getInt(8));
								TabServer.customer.setEmail(txtFld1.getText());
								JOptionPane.showMessageDialog(null,"Login success");
								TabServer.tabs.setEnabledAt(0,false);
								TabServer.tabs.setEnabledAt(1,false);
								TabServer.tabs.setEnabledAt(2,true);
								TabServer.tabs.setEnabledAt(3,true);
								TabServer.tabs.setEnabledAt(4,true);
							}
							else{
								JOptionPane.showMessageDialog(null,"Wrong password");
							}
						}
						else{
							JOptionPane.showMessageDialog(null,"Email not registered");
						}
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Email not registered");
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
           jb_login.setFont(new Font("Serif", Font.BOLD,15));

          // jb_newuser.setFont(new Font("Serif", Font.BOLD,15));
           txt.setBounds(670, 140, 300, 55);
           txtFld1.setBounds(520, 220, 500, 35);
           txtFld2.setBounds(520, 270, 500, 35);
           jb_login.setBounds(695,320, 155, 35);
           //forgetpass.setBounds(655, 220, 155, 35);

           add(txtFld1);
           add(txtFld2);
           add(jb_login);
           add(txt);
           add(showpasswordCheckBox);
	 }
}