package customer;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SignUp extends JPanel implements ActionListener {
    JLabel title, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8;
    JTextField txtFld1, txtFld2, txtFld3, txtFld4,otpTextField;
    JPasswordField  txtFld5, txtFld6;
    @SuppressWarnings("rawtypes")
    JComboBox jcSta;
    JRadioButton jrb_male, jrb_female;
    String str_gender;
    ButtonGroup bg;
    JButton OTPButton, jb_submit;
    JPanel jp;
    int otp;
    String State[] = {"Andhra Pradesh", " Arunachal Pradesh", "Assam", "Bihar", "Karnataka",
            "Kerala", "Chhattisgarh", "Uttar Pradesh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh",
            "Jammu and Kashmir", "Jharkhand", "West Bengal", "Madhya Pradesh", "Maharashtra", "Manipur",
            "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu",
            "Telangana", "Tripura", "Uttarakhand"};

    @SuppressWarnings({"unchecked", "rawtypes"})
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
        otpTextField=new JTextField();
        txtFld5 = new JPasswordField();
        //txtFld5.setText("Atleast 3 Char");
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
        txtFld6 = new JPasswordField();
        txtFld6.setEchoChar('*');
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
        jcSta = new JComboBox(State);
        //radio buttn for gender
        bg = new ButtonGroup();
        jrb_male = new JRadioButton("Male");
        jrb_male.setSelected(true);
        jrb_female = new JRadioButton("Female");
        jrb_female.setSelected(false);
        bg.add(jrb_male);
        bg.add(jrb_female);

        //submit btn
        jb_submit = new JButton("Submit");
        jb_submit.addActionListener(this);
        OTPButton = new JButton("Enter OTP");
        OTPButton.addActionListener(this);
        OTPButton.setVisible(false);

        //setbounds area
        title.setBounds(325, 60, 500, 25);
        lbl1.setBounds(80, 120, 100, 20);
        lbl2.setBounds(400, 120, 120, 20);
        lbl3.setBounds(80, 180, 120, 20);
        lbl4.setBounds(400, 180, 120, 20);
        lbl5.setBounds(80, 240, 120, 20);
        lbl6.setBounds(400, 240, 120, 20);
        lbl7.setBounds(80, 300, 120, 20);
        lbl8.setBounds(390, 300, 150, 20);
        jb_submit.setBounds(325, 380, 150, 30);
        OTPButton.setBounds(645, 380, 150, 30);

        title.setFont(new Font("Serif", Font.BOLD, 30));
        jb_submit.setFont(new Font("Serif", Font.BOLD, 20));

        txtFld1.setBounds(200, 120, 150, 30);
        txtFld2.setBounds(530, 120, 150, 30);
        txtFld3.setBounds(200, 180, 150, 30);
        txtFld4.setBounds(530, 180, 150, 30);
        jrb_male.setBounds(200, 240, 55, 30);
        jrb_female.setBounds(260, 240, 68, 30);
        jcSta.setBounds(530, 240, 150, 30);
        txtFld5.setBounds(200, 300, 150, 30);
        txtFld6.setBounds(530, 300, 150, 30);
        otpTextField.setBounds(485, 380, 150, 30);
        otpTextField.setVisible(false);

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
        add(otpTextField);

        add(jb_submit);
        add(OTPButton);

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
        int customerPortNumber=12345;
        Object obj = e.getSource();
        if (obj == jb_submit) {
            TabServer.customer.setFirstName(txtFld1.getText());
            TabServer.customer.setLastName(txtFld2.getText());
            TabServer.customer.setMobileNumber(txtFld3.getText().toString());
            TabServer.customer.setEmail(txtFld4.getText());
            TabServer.customer.setPassword(txtFld5.getText());
            TabServer.customer.setState(jcSta.getSelectedItem().toString());
            try {
                //Generating port number that is not present already in the table...
                while (customerPortNumber>65565 || TabServer.getCustomerDetails(customerPortNumber).next()) {
                    customerPortNumber=TabServer.generateRandomNumber()/10;
                }
            }
            catch (Exception ex){
                System.out.println(ex);
            }
            TabServer.customer.setPortNumber(customerPortNumber);

            //Checking if email / mobile already registered
            ResultSet resultSet;
            try {
                //Checking availability of email...
                resultSet = TabServer.getCustomerDetails(TabServer.customer.getEmail());
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Email already registered");
                    return;
                }
                //Checking availability of phone number...
                resultSet = TabServer.getCustomerDetails(TabServer.customer.getMobileNumber());
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Mobile Number already registered");
                    return;
                }
            } catch (Exception k) {
                System.out.println("Signup->Actionperformed()-->Availability()" + e);
                return;
            }

            if (jrb_male.isSelected()) {
                str_gender = "Male";
                TabServer.customer.setGender(str_gender);
            } else {
                str_gender = "Female";
                TabServer.customer.setGender(str_gender);
            }

            String con_pass = TabServer.customer.getPass();

            if (txtFld6.getText().equals(con_pass)) {
                //After all validations ...
                otp=TabServer.generateRandomNumber();
                TabServer.sendMail("Taxi registration verification","Your One Time Password for taxi registration is : "+otp,TabServer.customer.getEmail());
                OTPButton.setVisible(true);
                otpTextField.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Password does not match");
            }
        }
        else if(e.getSource()==OTPButton){
            if(OTPButton.isEnabled()){
                try {
                    int enteredNum =Integer.parseInt(otpTextField.getText());
                    if(enteredNum==otp){
                        insertDB();
                    }
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Wrong OTP");
                }
            }
        }
    }
    public boolean insertDB(){
        // create table TabServercustomer(Fname varchar2(30),Lname varchar2(30),Moblie int,Email varchar2(30),Gender char(8),State char(20),Pass varchar2(30),portNumber int primary key);
        try {
            String query = "insert into customer values(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = TabServer.connection.prepareStatement(query);
            //stmt.executeUpdate(query);
            pstmt.setString(1, TabServer.customer.getFirstName());
            pstmt.setString(2, TabServer.customer.getLastName());
            pstmt.setLong(3, TabServer.customer.getMobileNumber());
            pstmt.setString(4, TabServer.customer.getEmail());
            pstmt.setString(5, str_gender);
            pstmt.setString(6, TabServer.customer.getState());
            pstmt.setString(7, TabServer.customer.getPassword());
            pstmt.setInt(8, TabServer.customer.getPortNumber());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registration Success!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
        return true;
    }
}
