package driver;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ViewProfile extends JPanel{
    int flag=0;
    Label firstNameLabel, lastNameLabel, genderLabel, dobLabel, drivingExperienceLabel, addressLabel, cityLabel, nationalityLabel, mobileNumberLabel, emailLabel, driverLicenseLabel, carIDLabel, companyLabel, modelLabel, capacityLabel, ACLabel, FarePerKMLabel;
    JTextField firstNameTextField, lastNameTextField, DOBTextField, drivingExpTextField, addressTextField, cityTextField, mobileNoTextField, emailTextField,txtFld11, companyTextField, modelTextField, capacityTextField, ACTextField, fareTextField, licenseTextField;
    JComboBox<String> stateJComboBox, carJComboBox;
    JButton editButton, addCarButton, changePasswordButton,refreshButton;
    String[] arr;
    JRadioButton maleJRadioButton, femaleJRadioButton, othersJRadioButton;
    ButtonGroup btnGrp1;
    Border bdr=BorderFactory.createLineBorder(Color.BLACK,5);
    String currentCarId,query,gender,driverEmail,date;
    ResultSet resultSet;
    Car car;
    Statement statement;
    int index;
    ViewProfile(){
        setBackground(new Color(255, 167, 88));
        setBounds(0,0,2000,1900);
        setFont(TabServer.font);
        setVisible(true);
        setLayout(null);

        //Label
        firstNameLabel =new Label("FirstName : ");
        lastNameLabel =new Label("LastName : ");
        genderLabel =new Label("Gender : ");
        dobLabel =new Label("Date of Birth : ");
        drivingExperienceLabel =new Label("Driving Experience : ");
        addressLabel =new Label("Address : ");
        cityLabel =new Label("City : ");
        nationalityLabel =new Label("Nationality : ");
        mobileNumberLabel =new Label("Mobile Number : ");
        emailLabel =new Label("Email : ");
        driverLicenseLabel =new Label("Driver License ID : ");
        carIDLabel =new Label("Car ID : ");
        companyLabel =new Label("Company : ");
        modelLabel =new Label("Model : ");
        capacityLabel =new Label("Capacity : ");
        ACLabel =new Label("AC : ");
        FarePerKMLabel =new Label("Fare/KM: ");

        //TextField
        firstNameTextField =new JTextField();
        lastNameTextField =new JTextField();
        DOBTextField =new JTextField();
        drivingExpTextField =new JTextField();
        addressTextField =new JTextField();
        cityTextField =new JTextField();
        mobileNoTextField =new JTextField();
        emailTextField =new JTextField();
        txtFld11=new JTextField();
        companyTextField =new JTextField();
        modelTextField =new JTextField();
        capacityTextField =new JTextField();
        ACTextField =new JTextField();
        fareTextField =new JTextField();
        licenseTextField =new JTextField();

        //Button
        editButton =new JButton("EDIT");
        addCarButton =new JButton("ADD CAR");
        changePasswordButton =new JButton("CHANGE PASSWORD");
        refreshButton=new JButton("REFRESH");

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
        stateJComboBox =new JComboBox<>(arr);

        arr=new String[]{};
        carJComboBox =new JComboBox<>(arr);

        //RadioButton
        maleJRadioButton =new JRadioButton("Male");
        femaleJRadioButton =new JRadioButton("Female");
        othersJRadioButton =new JRadioButton("Others");

        //Button Group
        btnGrp1=new ButtonGroup();
        btnGrp1.add(maleJRadioButton);
        btnGrp1.add(femaleJRadioButton);
        btnGrp1.add(othersJRadioButton);

        //SetBounds for Label
        firstNameLabel.setBounds(10,10,250,60);
        lastNameLabel.setBounds(10,80,250,60);
        genderLabel.setBounds(10,150,250,60);
        dobLabel.setBounds(10,220,250,60);
        drivingExperienceLabel.setBounds(10,290,250,60);
        addressLabel.setBounds(10,360,250,60);
        cityLabel.setBounds(10,430,250,60);
        nationalityLabel.setBounds(10,500,250,60);
        mobileNumberLabel.setBounds(10,570,250,60);
        emailLabel.setBounds(10,640,250,60);//Email
        driverLicenseLabel.setBounds(530,220,250,60);
        carIDLabel.setBounds(530,290,250,60);
        companyLabel.setBounds(530,360,250,60);
        modelLabel.setBounds(530,430,250,60);
        capacityLabel.setBounds(530,500,250,60);
        ACLabel.setBounds(530,570,250,60);
        FarePerKMLabel.setBounds(530,640,250,60);

        //SetBounds for textFields
        firstNameTextField.setBounds(270,10,250,60);
        lastNameTextField.setBounds(270,80,250,60);
        DOBTextField.setBounds(270,220,250,60);
        drivingExpTextField.setBounds(270,290,250,60);
        addressTextField.setBounds(270,360,250,60);
        cityTextField.setBounds(270,430,250,60);
        mobileNoTextField.setBounds(270,570,250,60);
        emailTextField.setBounds(270,640,250,60);
        companyTextField.setBounds(790,360,250,60);
        modelTextField.setBounds(790,430,250,60);
        capacityTextField.setBounds(790,500,250,60);
        ACTextField.setBounds(790,570,250,60);
        fareTextField.setBounds(790,640,250,60);
        licenseTextField.setBounds(790,220,250,60);

        //setBounds for buttons
        refreshButton.setBounds(0,710,250,60);
        editButton.setBounds(270,710,250,60);
        addCarButton.setBounds(530,710,250,60);
        changePasswordButton.setBounds(800,710,250,60);
        //refreshButton.setBounds()

        //setBounds for Radio buttons
        maleJRadioButton.setBounds(270,150,250,60);
        femaleJRadioButton.setBounds(530,150,250,60);
        othersJRadioButton.setBounds(790,150,250,60);

        //Setbounds for JCombo box
        stateJComboBox.setBounds(270,500,250,60);
        carJComboBox.setBounds(790,290,250,60);

        //adding borders
        firstNameTextField.setBorder(bdr);
        lastNameTextField.setBorder(bdr);
        DOBTextField.setBorder(bdr);
        drivingExpTextField.setBorder(bdr);
        addressTextField.setBorder(bdr);
        cityTextField.setBorder(bdr);
        mobileNoTextField.setBorder(bdr);
        emailTextField.setBorder(bdr);
        companyTextField.setBorder(bdr);
        modelTextField.setBorder(bdr);
        capacityTextField.setBorder(bdr);
        ACTextField.setBorder(bdr);
        fareTextField.setBorder(bdr);
        licenseTextField.setBorder(bdr);

        //Set font for all fields
        setTextFieldFont(firstNameTextField);
        setTextFieldFont(lastNameTextField);
        setTextFieldFont(DOBTextField);
        setTextFieldFont(drivingExpTextField);
        setTextFieldFont(addressTextField);
        setTextFieldFont(cityTextField);
        setTextFieldFont(mobileNoTextField);
        setTextFieldFont(emailTextField);
        setTextFieldFont(companyTextField);
        setTextFieldFont(modelTextField);
        setTextFieldFont(capacityTextField);
        setTextFieldFont(ACTextField);
        setTextFieldFont(fareTextField);
        setTextFieldFont(licenseTextField);

        editButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(flag%2==0) {
                    flag++;
                    editButton.setText("UPDATE");
                    enableEdit();
                    return;
                }
                if(validEntries()){
                    dbInsert();
                    flag++;
                    disableEdit();
                    editButton.setText("EDIT");
                    JOptionPane.showMessageDialog(null,"Updation success...");
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

        addCarButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new CarTab();
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
        changePasswordButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ChangePassword();
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

        refreshButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                refreshOtherFields();
                refreshCarFields();
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

        //Adding lists
        add(stateJComboBox);
        add(carJComboBox);
        disableEdit();

        //Adding Labels
        add(firstNameLabel);
        add(lastNameLabel);
        add(genderLabel);
        add(dobLabel);
        add(drivingExperienceLabel);
        add(addressLabel);
        add(cityLabel);
        add(nationalityLabel);
        add(mobileNumberLabel);
        add(emailLabel);
        add(driverLicenseLabel);
        add(carIDLabel);
        add(companyLabel);
        add(modelLabel);
        add(capacityLabel);
        add(ACLabel);
        add(FarePerKMLabel);

        //Adding txtfields
        add(firstNameTextField);
        add(lastNameTextField);
        add(DOBTextField);
        add(drivingExpTextField);
        add(addressTextField);
        add(cityTextField);
        add(mobileNoTextField);
        add(emailTextField);
        add(companyTextField);
        add(modelTextField);
        add(capacityTextField);
        add(ACTextField);
        add(fareTextField);
        add(licenseTextField);

        //Adding Buttons
        add(editButton);
        add(addCarButton);
        add(changePasswordButton);
        add(refreshButton);

        //Adding Radio Buttons
        add(maleJRadioButton);
        add(femaleJRadioButton);
        add(othersJRadioButton);
    }

    public boolean validEntries(){
        //FirstName
        if(firstNameTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your first name");
            return false;
        }
        if( !TabServer.isValidName(firstNameTextField.getText())){
            JOptionPane.showMessageDialog(null,"Invalid first Name");
            return false;
        }
        //Last name
        if(lastNameTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your last name");
            return false;
        }
        if(!TabServer.isValidName(lastNameTextField.getText())){
            JOptionPane.showMessageDialog(null,"Invalid last Name");
            return false;
        }
        //Gender
        if(btnGrp1.getSelection()==null){
            JOptionPane.showMessageDialog(null,"Please select gender");
            return false;
        }
        //DOB
        if(DOBTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your DOB");
            return false;
        }
        if(!TabServer.isValidDate(DOBTextField.getText())){
            JOptionPane.showMessageDialog(null,"Please enter your DOB in format YYYY-MM-DD");
            return false;
        }
        //Address
        if(addressTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your address");
            return false;
        }
        if(addressTextField.getText().length()<10){
            JOptionPane.showMessageDialog(null,"Please enter your proper address");
            return false;
        }
        //City
        if(cityTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your city");
            return false;
        }
        if(!TabServer.isValidName(cityTextField.getText())){
            JOptionPane.showMessageDialog(null,"Please enter a  valid city name");
            return false;
        }
        //Mobile number
        if(mobileNoTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your mobile number");
            return false;
        }
        if(!TabServer.isValidNumber(mobileNoTextField.getText())){
            JOptionPane.showMessageDialog(null,"Please enter a valid mobile number");
            return false;
        }
        if(licenseTextField.getText().equals("")){
            System.out.println(licenseTextField.getText());
            JOptionPane.showMessageDialog(null,"Please enter your license ID");
            return false;
        }
        if(!TabServer.isValidID(licenseTextField.getText())){
            JOptionPane.showMessageDialog(null,"Please enter valid license ID");
            return false;
        }
        return true;
    }
    public boolean dbInsert(){
        driverEmail=TabServer.driver.getEmail();
        if(maleJRadioButton.isSelected()){
            gender="male";
        }
        else if(femaleJRadioButton.isSelected()){
            gender="female";
        }
        else{
            gender="others";
        }
        try {
            query = "update driver set fname='" + firstNameTextField.getText() + "'where email='" + driverEmail + "'";
            TabServer.statement.executeQuery(query);
            query="update driver set lname ='"+lastNameTextField.getText()+"' where email ='"+driverEmail+"'";
            TabServer.statement.executeQuery(query);
            query="update driver set gender ='"+gender+"' where email ='"+driverEmail+"'";
            TabServer.statement.executeQuery(query);
            date=DOBTextField.getText();
            date=date.substring(0,4)+"-"+date.substring(5,7)+"-"+date.substring(8,10);
            query="update driver set dob =TO_DATE('"+date+"','YYYY-MM-DD') where email ='"+driverEmail+"'";
            TabServer.statement.executeQuery(query);
            query="update driver set drivingexp ='"+Integer.parseInt(drivingExpTextField.getText())+"' where email ='"+driverEmail+"'";
            TabServer.statement.executeQuery(query);
            query="update driver set address ='"+addressTextField.getText()+"' where email ='"+driverEmail+"'";
            TabServer.statement.executeQuery(query);
            query="update driver set city ='"+cityTextField.getText()+"' where email ='"+driverEmail+"'";
            TabServer.statement.executeQuery(query);
            query="update driver set state ='"+ stateJComboBox.getSelectedItem().toString()+"' where email ='"+driverEmail+"'";
            TabServer.statement.executeQuery(query);
            query="update driver set mobile ="+mobileNoTextField.getText()+" where email ='"+driverEmail+"'";
            TabServer.statement.executeQuery(query);
            query="update driver set password ='"+TabServer.driver.getPass()+"' where email='"+driverEmail+"'";
            TabServer.statement.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println("DB Insert()"+e);
        }
        return true;
    }
    private boolean disableEdit(){
        firstNameTextField.setEditable(false);
        lastNameTextField.setEditable(false);
        DOBTextField.setEditable(false);
        drivingExpTextField.setEditable(false);
        addressTextField.setEditable(false);
        cityTextField.setEditable(false);
        mobileNoTextField.setEditable(false);
        emailTextField.setEditable(false);
        txtFld11.setEditable(false);
        companyTextField.setEditable(false);
        modelTextField.setEditable(false);
        capacityTextField.setEditable(false);
        ACTextField.setEditable(false);
        fareTextField.setEditable(false);
        licenseTextField.setEditable(false);
        stateJComboBox.setEnabled(false);
        return true;
    }
    private boolean enableEdit(){
        firstNameTextField.setEditable(true);
        lastNameTextField.setEditable(true);
        DOBTextField.setEditable(true);
        drivingExpTextField.setEditable(true);
        addressTextField.setEditable(true);
        cityTextField.setEditable(true);
        mobileNoTextField.setEditable(true);
        txtFld11.setEditable(true);
        stateJComboBox.setEditable(false);
        return true;
    }
    public boolean refreshCarFields(){
        try {
            currentCarId=TabServer.driver.getCarID();
            //Adding all cars owned by driver to TabServer.driver
            query="select * from car where owneremail ='"+TabServer.driver.getEmail()+"'";
            resultSet=TabServer.statement.executeQuery(query);
            TabServer.driver.setCars(new ArrayList<>());
            while(resultSet.next()){
                car=new Car();
                car.setCarID(resultSet.getString(2));
                car.setOwnerEmail(resultSet.getString(1));
                car.setCompany(resultSet.getString(3));
                car.setModel(resultSet.getString(4));
                car.setCapacity(resultSet.getInt(5));
                car.setAC(resultSet.getString(6));
                car.setFarePerKM(resultSet.getInt(7));
                TabServer.driver.getCars().add(car);
            }

            //Updating carId jcombobox
            carJComboBox.removeAllItems();
            for(Car car:TabServer.driver.getCars()){
                carJComboBox.addItem(car.getCarID());
            }

            //Updating fields in the tab
            query="select * from car where carid='"+currentCarId+"'";
            resultSet = TabServer.statement.executeQuery(query);
            resultSet.next();
            carJComboBox.setSelectedItem(currentCarId);
            companyTextField.setText(resultSet.getString(3));
            modelTextField.setText(resultSet.getString(4));
            capacityTextField.setText(((Integer)resultSet.getInt(5)).toString());
            ACTextField.setText(resultSet.getString(6));
            fareTextField.setText(resultSet.getString(7));
        }
        catch(Exception e){
            System.out.println("refreshCarFields()"+e);
        }
        return true;
    }
    public boolean refreshOtherFields(){
        query="select * from driver where email ='"+TabServer.driver.getEmail()+"'";
        try{
            resultSet=TabServer.statement.executeQuery(query);
            resultSet.next();
            firstNameTextField.setText(resultSet.getString(1));
            lastNameTextField.setText(resultSet.getString(2));
            gender=resultSet.getString(4);
            if(gender.substring(0,4).equals("male")){
                maleJRadioButton.setSelected(true);
            }
            else if(resultSet.getString(4).substring(0,6).equals("female")){
                femaleJRadioButton.setSelected(true);
            }
            else{
                othersJRadioButton.setSelected(true);
            }
            DOBTextField.setText(resultSet.getString(5).substring(0,10));
            drivingExpTextField.setText(resultSet.getString(8));
            addressTextField.setText(resultSet.getString(7));
            cityTextField.setText(resultSet.getString(6));
            stateJComboBox.setSelectedItem(resultSet.getString(10).substring(0,resultSet.getString(10).length()/6));
            mobileNoTextField.setText(resultSet.getString(11));
            emailTextField.setText(resultSet.getString(12));
            licenseTextField.setText(resultSet.getString(9));
            TabServer.driver.setCarID(getCarID(emailTextField.getText().trim()));
        }
        catch (Exception e){
            System.out.println("refreshOtherFields()"+e);
        }
        return true;
    }
    public boolean setButtonFont(JButton button){
        button.setFont(TabServer.font);
        return true;
    }
    public boolean setTextFieldFont(JTextField button){
        button.setFont(TabServer.font);
        return true;
    }
    public String getCarID(String email){
        try{
            ResultSet rs;
            statement=TabServer.connection.createStatement();
            query="select carID from car where owneremail='"+email+"'";
            rs=statement.executeQuery(query);
            rs.next();
            return rs.getString(1);
        }
        catch(Exception e){
            System.out.println("getCarID()"+e);
        }
        return "";
    }
}