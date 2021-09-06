package driver;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class Login extends JPanel{
    JTextField txtFld1,txtFld2;
    Label lbl1,lbl2,lbl3;
    JPasswordField pwdFld1;
    JButton btn1;
    Font f;
    Border bdr;
    Statement statement;
    ResultSet rs;
    String query;
    Login(){
        f=new Font("Times New Roman",Font.BOLD,19);
        setBackground(new Color(255, 167, 88));
        setLayout(null);
        setVisible(true);
        setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        setBounds(0,0,1000,1900);

        //Label
        lbl1=new Label("Email/Phone Number : ");
        lbl2=new Label("Password : ");
        lbl3=new Label("Forgot password");

        //TextField
        txtFld1=new JTextField();
        pwdFld1=new JPasswordField();

        //Button
        btn1=new JButton("LOGIN");

        //Border
        bdr=BorderFactory.createLineBorder(Color.BLACK, 5);

        //Set Bounds for label
        lbl1.setBounds(10,10,250,60);
        lbl2.setBounds(10,80,250,60);

        //set bounds for txtflds and passwordfields
        txtFld1.setBounds(260,10,250,60);
        pwdFld1.setBounds(260,80,250,60);

        //set font to textfields
        txtFld1.setFont(f);

        //ActionListener for password field
        pwdFld1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                login(txtFld1.getText(),pwdFld1.getText());
            }
        });
        btn1.setBounds(260,160,250,60);
        btn1.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!TabServer.tabs.isEnabledAt(0)){
                    return;
                }
                login(txtFld1.getText(),pwdFld1.getText());
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

        //Creating sample driver for TabServer
        TabServer.driver=new Driver();
        TabServer.driver.setEmail("NULL");

        //Borders
        pwdFld1.setBorder(bdr);
        txtFld1.setBorder(bdr);
        btn1.setBorder(bdr);

        //Adding components to frame
        add(lbl1);
        add(lbl2);
        add(txtFld1);
        add(pwdFld1);
        add(btn1);
    }
    public boolean login(String email,String password){
        if(email.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter valid email");
            return false;
        }
        if(password.equals("")){
            JOptionPane.showMessageDialog(null,"Wrong password/emailID");
            return false;
        }
        if(isPresent(email)){
            if(pass(email).equals(password)){
                if(!isApproved(email)){
                    JOptionPane.showMessageDialog(null,"User not approved by admin...");
                    return false;
                }

                JOptionPane.showMessageDialog(null,"Login success...");
                TabServer.enableFeedback();
                TabServer.enableViewProfile();
                TabServer.enableViewRide();
                TabServer.disableLogin();
                TabServer.disableSignUp();
                updateDriverFields();
            }
            else{
                JOptionPane.showMessageDialog(null,"Wrong password...");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Email not registered...");
        }
        return true;
    }
    public boolean isPresent(String email){
        query="select * from driver where email='"+email+"'";
        try {
            statement = TabServer.connection.createStatement();
            rs =statement.executeQuery(query);
            if(rs.next()){
                return true;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    public boolean isApproved(String email){
        query="select approved from driver where email='"+email+"'";
        try {
            rs = statement.executeQuery(query);
            rs.next();
            return rs.getString(1).substring(0,4).equals("true");
        }
        catch(Exception e){
            System.out.println("isApproved"+e);
        }
        return false;
    }
    public String pass(String email){
        query="select * from driver where email='"+email+"'";
        try {
            statement = TabServer.connection.createStatement();
            rs =statement.executeQuery(query);
            if(rs.next()){
                return rs.getString(13);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return "-1";
    }
    public boolean updateDriverFields(){
        query="select * from driver where email = '"+txtFld1.getText()+"'";
        try {
            rs = statement.executeQuery(query);
            rs.next();
            TabServer.driver=new Driver();
            TabServer.driver.setFname(rs.getString(1));
            TabServer.driver.setLname(rs.getString(2));
            TabServer.driver.setCarID(rs.getString(3));
            TabServer.driver.setGender(rs.getString(4));
            TabServer.driver.setDob(rs.getDate(5));
            TabServer.driver.setCity(rs.getString(6));
            TabServer.driver.setAddress(rs.getString(7));
            TabServer.driver.setDriverExp(rs.getInt(8));
            TabServer.driver.setLicenseId(rs.getString(9));
            TabServer.driver.setState(rs.getString(10));
            TabServer.driver.setMobile(rs.getLong(11));
            TabServer.driver.setEmail(rs.getString(12));
            TabServer.driver.setPass(rs.getString(13));
            TabServer.driver.setApproved(rs.getString(14));
            TabServer.driver.setAvailability(rs.getString(15));
            TabServer.driver.setXp(rs.getLong(16));

            //Cars of driver
            Car car;
            query="select * from car where owneremail='"+TabServer.driver.getEmail()+"'";
            rs=statement.executeQuery(query);
            TabServer.cars=new ArrayList<>();
            while(rs.next()){
                car=new Car();
                car.setOwnerEmail(rs.getString(1));
                car.setCarID(rs.getString(2));
                car.setCompany(rs.getString(3));
                car.setModel(rs.getString(4));
                car.setCapacity(rs.getInt(5));
                car.setAC(rs.getString(6));
                car.setFarePerKM(rs.getInt(7));
                TabServer.cars.add(car);
            }
        }
        catch(Exception e){
            System.out.println("Exception while calling updateDriverFields()");
            System.out.println(e);
        }
        return true;
    }
}
