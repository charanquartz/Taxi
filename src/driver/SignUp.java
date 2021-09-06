package driver;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.border.Border;
public class SignUp extends JPanel{
    Connection connection;
    Label lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,lbl13,lbl14,lbl15,lbl16,lbl17,lbl18,lbl19;
    JTextField txtFld1,txtFld2,txtFld3,txtFld4,txtFld5,txtFld6,txtFld7,txtFld8,txtFld11,txtFld12,txtFld13,txtFld14,txtFld16,txtFld17;
    JComboBox<String> list1,list2;
    JPasswordField txtFld9,txtFld10;
    JButton btn1;
    String[] arr;
    JRadioButton radBtn1,radBtn2,radBtn3;
    ButtonGroup btnGrp1;
    Font f;
    int num;
    String query;
    Border bdr=BorderFactory.createLineBorder(Color.BLACK,5);
    SignUp(){
        f=new Font("Times New Roman",Font.BOLD,19);
        setBackground(new Color(255, 167, 88));
        setBounds(0,0,2000,1900);
        setFont(new Font("Times New Roman",Font.BOLD,19));
        setVisible(true);
        setLayout(null);

        //Label
        lbl1=new Label("FirstName : ");
        lbl2=new Label("LastName : ");
        lbl3=new Label("Gender : ");
        lbl4=new Label("Date of Birth : ");
        lbl5=new Label("Driving Experience : ");
        lbl6=new Label("Address : ");
        lbl7=new Label("City : ");
        lbl8=new Label("Nationality : ");
        lbl9=new Label("Mobile Number : ");
        lbl10=new Label("Email : ");
        lbl11=new Label("Password : ");
        lbl12=new Label("Re-enter Password : ");
        lbl13=new Label("Driver Lisence ID : ");
        lbl14=new Label("Car ID : ");
        lbl15=new Label("Car Company : ");
        lbl16=new Label("Model : ");
        lbl17=new Label("Capacity : ");
        lbl18=new Label("AC : ");
        lbl19=new Label("Fare/KM: ");

        //TextField
        txtFld1=new JTextField();
        txtFld2=new JTextField();
        txtFld2.setText("");
        txtFld3=new JTextField();
        txtFld4=new JTextField();
        txtFld5=new JTextField();
        txtFld6=new JTextField();
        txtFld7=new JTextField();
        txtFld8=new JTextField();
        txtFld9=new JPasswordField();
        txtFld10=new JPasswordField();
        txtFld11=new JTextField();
        txtFld12=new JTextField();
        txtFld13=new JTextField();
        txtFld14=new JTextField();
        txtFld16=new JTextField();
        txtFld17=new JTextField();

        //Button
        btn1=new JButton("SIGNUP");

        //JCombo box
        arr=new String[]{"Andhra Pradesh",
                "Arunachal Pradesh",
                "Assam",
                "Bihar",
                "Chhattisgarh",
                "Goa",
                "Gujarat",
                "Haryana",
                "Himachal Pradesh",
                "Jammu and Kashmir",
                "Jharkhand",
                "Karnataka",
                "Kerala",
                "Madhya Pradesh",
                "Maharashtra",
                "Manipur",
                "Meghalaya",
                "Mizoram",
                "Nagaland",
                "Odisha",
                "Punjab",
                "Rajasthan",
                "Sikkim",
                "Tamil Nadu",
                "Telangana",
                "Tripura",
                "Uttarakhand",
                "Uttar Pradesh",
                "West Bengal",
                "Andaman and Nicobar Islands",
                "Chandigarh",
                "Dadra and Nagar Haveli",
                "Daman and Diu",
                "Delhi",
                "Lakshadweep",
                "Puducherry"};
        list1=new JComboBox<>(arr);
        arr=new String[]{"Yes","No"};
        list2=new JComboBox<>(arr);

        //RadioButton
        radBtn1=new JRadioButton("Male");
        radBtn2=new JRadioButton("Female");
        radBtn3=new JRadioButton("Others");

        //Button Group
        btnGrp1=new ButtonGroup();
        btnGrp1.add(radBtn1);
        btnGrp1.add(radBtn2);
        btnGrp1.add(radBtn3);

        //SetBounds for Label
        lbl1.setBounds(10,10,250,60);//FirstName
        lbl2.setBounds(10,80,250,60);//LastName
        lbl3.setBounds(10,150,250,60);//Gender
        lbl4.setBounds(10,220,250,60);//DOB
        lbl5.setBounds(10,290,250,60);//Driving experience
        lbl6.setBounds(10,360,250,60);//Address
        lbl7.setBounds(10,430,250,60);//City
        lbl8.setBounds(10,500,250,60);//Nationality
        lbl9.setBounds(10,570,250,60);//MobileNo
        lbl10.setBounds(10,640,250,60);//Email
        lbl11.setBounds(10,710,250,60);//Password
        lbl12.setBounds(10,780,250,60);//Re-Enter pass
        lbl13.setBounds(530,220,250,60);//Lisence ID
        lbl14.setBounds(530,290,250,60);
        lbl15.setBounds(530,360,250,60);
        lbl16.setBounds(530,430,250,60);
        lbl17.setBounds(530,500,250,60);
        lbl18.setBounds(530,570,250,60);
        lbl19.setBounds(530,640,250,60);

        //SetBounds for textFields
        txtFld1.setBounds(270,10,250,60);//FirstName
        txtFld2.setBounds(270,80,250,60);//LastName
        txtFld3.setBounds(270,220,250,60);//DOB
        txtFld4.setBounds(270,290,250,60);//Driving Experience
        txtFld5.setBounds(270,360,250,60);//Address
        txtFld6.setBounds(270,430,250,60);//City
        txtFld7.setBounds(270,570,250,60);//Mobile No
        txtFld8.setBounds(270,640,250,60);//Email
        txtFld9.setBounds(270,710,250,60);//Password
        txtFld10.setBounds(270,780,250,60);//Re enter pass
        txtFld11.setBounds(790,290,250,60);//Car ID
        txtFld12.setBounds(790,360,250,60);//Company
        txtFld13.setBounds(790,430,250,60);//Model
        txtFld14.setBounds(790,500,250,60);//Capacity
        txtFld16.setBounds(790,640,250,60);//Fare
        txtFld17.setBounds(790,220,250,60);//License ID

        //setBounds for buttons
        btn1.setBounds(270,850,250,60);

        //setBounds for Radio buttons
        radBtn1.setBounds(270,150,250,60);
        radBtn2.setBounds(530,150,250,60);
        radBtn3.setBounds(790,150,250,60);

        //Setbounds for JCombo box
        list1.setBounds(270,500,250,60);
        list2.setBounds(790,570,250,60);

        btn1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(validateEntries()){
                    if(!driverAlreadyPresent()){
                        Label OTPLabel=new Label("Enter OTP : ");
                        TextField txtFld4=new TextField();
                        Button btn=new Button("Submit OTP");
                        OTPLabel.setBounds(530,710,250,60);
                        txtFld4.setBounds(790,710,250,60);
                        btn.setBounds(790,780,250,60);
                        add(OTPLabel);
                        add(txtFld4);
                        add(btn);
                        num=generateRandomNumber();
                        sendOTP(num);
                        btn.addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if(num==0){
                                    JOptionPane.showMessageDialog(null, "Already registered");
                                }
                                else if(TabServer.isValidNumber(txtFld4.getText()) && num==Integer.parseInt(txtFld4.getText())) {
                                    dbInsert();
                                    JOptionPane.showMessageDialog(null, "Registration success...");
                                    num=0;
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"Wrong OTP");
                                    Button btn2=new Button("Resend OTP");
                                    add(btn2);
                                    btn2.setBounds(1050,780,250,60);
                                    btn2.addMouseListener(new MouseListener() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            num=generateRandomNumber();
                                            sendOTP(num);
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
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Driver already registered");
                    }
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
        //adding borders
        txtFld1.setBorder(bdr);
        txtFld2.setBorder(bdr);
        txtFld3.setBorder(bdr);
        txtFld4.setBorder(bdr);
        txtFld5.setBorder(bdr);
        txtFld6.setBorder(bdr);
        txtFld7.setBorder(bdr);
        txtFld8.setBorder(bdr);
        txtFld9.setBorder(bdr);
        txtFld10.setBorder(bdr);
        txtFld11.setBorder(bdr);
        txtFld12.setBorder(bdr);
        txtFld13.setBorder(bdr);
        txtFld14.setBorder(bdr);
        txtFld16.setBorder(bdr);
        txtFld17.setBorder(bdr);
        btn1.setBorder(bdr);

        //Adding lists
        add(list1);
        add(list2);

        //Adding Labels
        add(lbl1);
        add(lbl2);
        add(lbl3);
        add(lbl4);
        add(lbl5);
        add(lbl6);
        add(lbl7);
        add(lbl8);
        add(lbl9);
        add(lbl10);
        add(lbl11);
        add(lbl12);
        add(lbl13);
        add(lbl14);
        add(lbl15);
        add(lbl16);
        add(lbl17);
        add(lbl18);
        add(lbl19);

        //Adding labels
        add(txtFld1);
        add(txtFld2);
        add(txtFld3);
        add(txtFld4);
        add(txtFld5);
        add(txtFld6);
        add(txtFld7);
        add(txtFld8);
        add(txtFld9);
        add(txtFld10);
        add(txtFld11);
        add(txtFld12);
        add(txtFld13);
        add(txtFld14);
        add(txtFld16);
        add(txtFld17);

        //Adding Buttons
        add(btn1);

        //Adding Radio Buttons
        add(radBtn1);
        add(radBtn2);
        add(radBtn3);

        //set font to textfields
        txtFld1.setFont(f);
        txtFld2.setFont(f);
        txtFld3.setFont(f);
        txtFld4.setFont(f);
        txtFld5.setFont(f);
        txtFld6.setFont(f);
        txtFld7.setFont(f);
        txtFld8.setFont(f);
        txtFld9.setFont(f);
        txtFld10.setFont(f);
        txtFld11.setFont(f);
        txtFld12.setFont(f);
        txtFld13.setFont(f);
        txtFld14.setFont(f);
        txtFld16.setFont(f);
        txtFld17.setFont(f);
    }

    //Validating entires of the registration form...
    public boolean validateEntries(){
        //FirstName
        if(txtFld1.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your first name");
            return false;
        }
        if( !TabServer.isValidName(txtFld1.getText())){
            JOptionPane.showMessageDialog(null,"Invalid first Name");
            return false;
        }
        //Gender
        if(btnGrp1.getSelection()==null){
            JOptionPane.showMessageDialog(null,"Please select gender");
            return false;
        }
        //DOB
        if(txtFld3.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your DOB");
            return false;
        }
        if(!TabServer.isValidDate(txtFld3.getText())){
            JOptionPane.showMessageDialog(null,"Please enter your DOB in format YYYY-MM-DD");
            return false;
        }
        //Driving Experience
        if(txtFld4.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your Driving experience");
            return false;
        }
        if(!TabServer.isValidNumber(txtFld4.getText())){
            JOptionPane.showMessageDialog(null,"Please enter a valid driving experience");
            return false;
        }
        //Address
        if(txtFld5.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your address");
            return false;
        }
        if(txtFld5.getText().length()<10){
            JOptionPane.showMessageDialog(null,"Please enter your proper address");
            return false;
        }
        //City
        if(txtFld6.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your city");
            return false;
        }
        if(!TabServer.isValidName(txtFld6.getText())){
            JOptionPane.showMessageDialog(null,"Please enter a  valid city name");
            return false;
        }
        //Mobile number
        if(txtFld7.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your mobile number");
            return false;
        }
        if(!TabServer.isValidPhoneNumber(txtFld7.getText())){
            JOptionPane.showMessageDialog(null,"Please enter a valid mobile number");
            return false;
        }
        //E-mail
        if(txtFld8.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your e-mail");
            return false;
        }
        if(!TabServer.isValidEmail(txtFld8.getText())){
            JOptionPane.showMessageDialog(null,"Please enter a valid e-mail id");
            return false;
        }
        //Password
        if(txtFld9.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your password");
            return false;
        }
        if(!TabServer.isValidPassword(txtFld9.getText())){
            System.out.println(txtFld9.getText());
            JOptionPane.showMessageDialog(null,"Please enter a strong password");
            return false;
        }
        //Re enter password
        if(!txtFld10.getText().equals(txtFld9.getText())){
            JOptionPane.showMessageDialog(null,"Passwords do not match");
            return false;
        }
        //License ID
        if(txtFld17.getText().equals("")){
            System.out.println(txtFld17.getText());
            JOptionPane.showMessageDialog(null,"Please enter your license ID");
            return false;
        }
        if(!TabServer.isValidID(txtFld17.getText())){
            JOptionPane.showMessageDialog(null,"Please enter valid license ID");
            return false;
        }
        //Car ID
        if(txtFld11.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your Car ID");
            return false;
        }
        if(carAlreadyPresent()){
            JOptionPane.showMessageDialog(null,"Cannot enter car that is already registered");
            return false;
        }
        if(!TabServer.isValidID(txtFld11.getText()) ){
            JOptionPane.showMessageDialog(null,"Please enter valid car ID");
            return false;
        }
        //Company
        if(txtFld12.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter the company name of your car");
            return false;
        }
        if(!TabServer.isValidName(txtFld12.getText())){
            JOptionPane.showMessageDialog(null,"Please enter a valid company name");
            return false;
        }
        //Model
        if(txtFld13.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter the model name of your car");
            return false;
        }
        if(!TabServer.isValidID(txtFld13.getText())){
            JOptionPane.showMessageDialog(null,"Please enter a valid model name");
            return false;
        }
        //Capacity
        if(txtFld14.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your car's capacity");
            return false;
        }
        if(!TabServer.isValidNumber(txtFld14.getText())){
            JOptionPane.showMessageDialog(null,"Please enter valid capacity of your car");
            return false;
        }
        //Fare
        if(txtFld16.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your car's fare per KM");
            return false;
        }
        if(!TabServer.isValidNumber(txtFld16.getText())){
            JOptionPane.showMessageDialog(null,"Please enter valid fare for your car");
            return false;
        }
        return true;
    }

    //Function to check if the entered email is already present or not...
    public boolean driverAlreadyPresent(){
        try {
            query="select * from driver where email = '"+txtFld8.getText()+"'";
            Statement statement = TabServer.connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            if(rs.next()){
                return true;
            }
            return false;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    //Fuction to check if car is already registered
    public boolean carAlreadyPresent(){
        try{
            Statement statement=TabServer.connection.createStatement();
            ResultSet rs=statement.executeQuery("select ac from car where carId = '"+txtFld11.getText()+"'");
            if(rs.next()){
                return true;
            }
        }
        catch(Exception e){

        }
        return false;
    }

    //Function to insert the details of driver after successful validations...
    public boolean dbInsert(){
        try{
            String gender,date=txtFld3.getText();
            if(radBtn1.isSelected()){
                gender="male";
            }
            else if(radBtn2.isSelected()){
                gender="female";
            }
            else{
                gender="others";
            }
            PreparedStatement statement;
            query="insert into driver values('"+txtFld1.getText()+"','"+txtFld2.getText()+"','"+txtFld11.getText()+"','"+gender+"',TO_DATE('"+date+"','YYYY-MM-DD')"+",'"+txtFld6.getText()+"','"+txtFld5.getText()+"',"+Integer.parseInt(txtFld4.getText())+",'"+txtFld17.getText()+"','"+list1.getItemAt(list1.getSelectedIndex())+"',"+Long.parseLong(txtFld7.getText())+",'"+txtFld8.getText()+"','"+txtFld9.getText()+"','false','false',0)";
            Statement statement1=TabServer.connection.createStatement();
            statement1.executeQuery(query);

            statement=TabServer.connection.prepareStatement("insert into car values(?,?,?,?,?,?,?)");
            statement.setString(1,txtFld8.getText());
            statement.setString(2,txtFld11.getText());
            statement.setString(3,txtFld12.getText());
            statement.setString(4,txtFld13.getText());
            statement.setInt(5,Integer.parseInt(txtFld14.getText()));
            statement.setString(6,list2.getItemAt(list2.getSelectedIndex()));
            statement.setInt(7,Integer.parseInt(txtFld16.getText()));
            statement.executeUpdate();
            return true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return true;
    }

    //Funcion to send OTP to the email after submit...
    public void sendOTP(int num){
        TabServer.sendMail("Registration Confirmation!!!","Your OTP for taxi driver registration is : "+num,txtFld8.getText());
    }

    //Function for generating random number....
    private int generateRandomNumber(){
        long num=0;
        double temp;
        for(int i=0;i<5;i++){
            temp=Math.random()*10;
            num=num*10+(int)temp;
        }
        return (int)num;
    }
}
