package customer;

import javafx.scene.control.Tab;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class UpdateProfile extends JPanel implements ActionListener {
    JLabel title, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7;
    JTextField txtFld1, txtFld2, txtFld3, txtFld4, txtFld5, txtFld6;
    JPasswordField txtFld7;
    JButton jb_submit,refreshButton;
	JCheckBox showPasswordCheckBox;

    public UpdateProfile() {
        setVisible(true);
        setLayout(null);
        setBackground(Color.yellow);
        setSize(500, 600);

        title = new JLabel("UPDATE PROFILE");

        //labels
        lbl1 = new JLabel("FIRST NAME");
        lbl2 = new JLabel("LAST NAME");
        lbl3 = new JLabel("MOBILE");
        lbl4 = new JLabel("EMAIL");
        lbl5 = new JLabel("GENDER");
        lbl6 = new JLabel("STATE");
        lbl7 = new JLabel("PASSWORD");

		//TextFields
        txtFld1 = new JTextField();
        txtFld2 = new JTextField();
        txtFld3 = new JTextField();
        txtFld4 = new JTextField();
        txtFld5 = new JTextField();
        txtFld6 = new JTextField();
        txtFld7 = new JPasswordField();

        //Button
        refreshButton=new JButton("Refresh");
        refreshButton.setBounds(650,120,150,35);
        refreshButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enterFields();
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

		//JCheckBox
		showPasswordCheckBox=new JCheckBox("Show Password");
		showPasswordCheckBox.setBounds(810,390,120,20);

		showPasswordCheckBox.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(showPasswordCheckBox.isSelected()){
					txtFld7.setEchoChar((char)0);
					String pass=txtFld7.getText().trim();
					txtFld7.setText(pass);
				}
				if(!(showPasswordCheckBox.isSelected())){
					String pass=txtFld7.getText();
					txtFld7.setEchoChar('*');
					txtFld7.setText(pass);
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

        //submit btn
        jb_submit = new JButton("Submit");
        jb_submit.addActionListener(this);


        title.setBounds(450, 60, 500, 25);
        lbl1.setBounds(400, 190, 120, 20);
        lbl2.setBounds(400, 230, 120, 20);
        lbl3.setBounds(400, 270, 120, 20);

        lbl5.setBounds(400, 310, 120, 20);
        lbl6.setBounds(400, 350, 120, 20);
        lbl7.setBounds(400, 390, 120, 20);

        txtFld1.setBounds(600, 190, 200, 30);
        txtFld2.setBounds(600, 230, 200, 30);
        txtFld3.setBounds(600, 270, 200, 30);
        //txtFld4.setBounds(550,210, 120, 20);
        txtFld5.setBounds(600, 310, 200, 30);
        txtFld6.setBounds(600, 350, 200, 30);
        txtFld7.setBounds(600, 390, 200, 30);

        jb_submit.setBounds(550, 450, 150, 30);

        title.setFont(new Font("Serif", Font.BOLD, 20));
        jb_submit.setFont(new Font("Serif", Font.BOLD, 15));

        //add
        add(title);
        add(lbl1);
        add(lbl2);
        add(lbl3);

        add(lbl5);
        add(lbl6);
        add(lbl7);
        add(jb_submit);
        add(refreshButton);

        add(showPasswordCheckBox).setVisible(false);

        add(txtFld1);
        add(txtFld2);
        add(txtFld3);

        add(txtFld5);
        add(txtFld6);
        add(txtFld7);

    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == jb_submit) {
            try {
                TabServer.customer.setFirstName(txtFld1.getText());
                TabServer.customer.setLastName(txtFld2.getText());
                TabServer.customer.setMobileNumber(txtFld3.getText());
                TabServer.customer.setEmail(txtFld4.getText());
                TabServer.customer.setGender(txtFld5.getText());
                TabServer.customer.setState(txtFld6.getText());
                TabServer.customer.setPassword(txtFld7.getText());
                String query = "update customer set fname=?,lname=?,mobile=?,Gender=?,State=?,Pass=? where Email=?";
                PreparedStatement pstmt = TabServer.connection.prepareStatement(query);
                pstmt.setString(1, txtFld1.getText());
                pstmt.setString(2, txtFld2.getText());
                pstmt.setString(3, txtFld3.getText());
                pstmt.setString(4, txtFld5.getText());
                pstmt.setString(5, txtFld6.getText());
                pstmt.setString(6, txtFld7.getText());
                pstmt.setString(7, TabServer.customer.getEmail());
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Updation Success ");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(this, "^^^^^^^^^^^^^^^^" + e2.toString());

            }
        }
    }
    public boolean enterFields(){
        try {
            String query = "select fname,lname,mobile,email,gender,state,pass,portNumber from customer where email=?";
            PreparedStatement pstmt = TabServer.connection.prepareStatement(query);
            pstmt.setString(1, TabServer.customer.getEmail());
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) {
                showPasswordCheckBox.setVisible(true);
                jb_submit.setVisible(true);

                txtFld1.setText(rst.getString(1).trim());
                txtFld2.setText(rst.getString(2));
                txtFld3.setText(""+rst.getLong(3));
                txtFld4.setText(rst.getString(4).trim());
                txtFld5.setText(rst.getString(5).trim());
                txtFld6.setText(rst.getString(6).trim());
                txtFld7.setText(rst.getString(7).trim());
            } else {
                JOptionPane.showMessageDialog(null, "Email not registered");
            }
        } catch (Exception e1) {
            System.out.println("actionPerformed-->UpdateProfile()" + e1);
        }
        return true;
    }
}
