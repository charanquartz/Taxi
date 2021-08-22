package driver;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ViewProfile extends JPanel{
    int flag=0;
    Label firstNameLabel, lastNameLabel, genderLabel, dobLabel, drivingExperienceLabel, addressLabel, cityLabel, nationalityLabel, mobileNumberLabel, emailLabel, passwordLabel,lbl12, driverLicenseLabel, carIDLabel, companyLabel, modelLabel, capacityLabel, ACLabel, FarePerKMLabel;
    JTextField firstNameTextField, lastNameTextField, DOBTextField, drivingExpTextField, addressTextField, cityTextField, mobileNoTextField, emailTextField,txtFld11, companyTextField, modelTextField, capacityTextField, ACTextField, fareTextField, licenseTextField,txtFld18;
    JPasswordField passwordTextField;
    JComboBox<String> NationalityJComboBox, carJComboBox;
    JButton editButton, addCarButton, changePasswordButton;
    String[] arr;
    JRadioButton maleJRadioButton, femaleJRadioButton, othersJRadioButton;
    ButtonGroup btnGrp1;
    Border bdr=BorderFactory.createLineBorder(Color.BLACK,5);

    ViewProfile(){
        setBackground(new Color(255, 167, 88));
        setBounds(0,0,2000,1900);
        setFont(new  Font("Times New Roman",Font.BOLD,19));
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
        passwordLabel =new Label("Password : ");
        driverLicenseLabel =new Label("Driver Lisence ID : ");
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

        //PasswordFields
        passwordTextField =new JPasswordField();

        //Button
        editButton =new JButton("EDIT");
        addCarButton =new JButton("ADD CAR");
        changePasswordButton =new JButton("CHANGE PASSWORD");

        //JCombo box
        arr=new String[]{"Afghanistan","Albania","Algeria","Andorra","Angola","Anguilla","Antigua &amp; Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia &amp; Herzegovina","Botswana","Brazil","British Virgin Islands","Brunei","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Cape Verde","Cayman Islands","Chad","Chile","China","Colombia","Congo","Cook Islands","Costa Rica","Cote D Ivoire","Croatia","Cruise Ship","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Estonia","Ethiopia","Falkland Islands","Faroe Islands","Fiji","Finland","France","French Polynesia","French West Indies","Gabon","Gambia","Georgia","Germany","Ghana","Gibraltar","Greece","Greenland","Grenada","Guam","Guatemala","Guernsey","Guinea","Guinea Bissau","Guyana","Haiti","Honduras","Hong Kong","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Isle of Man","Israel","Italy","Jamaica","Japan","Jersey","Jordan","Kazakhstan","Kenya","Kuwait","Kyrgyz Republic","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macau","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Mauritania","Mauritius","Mexico","Moldova","Monaco","Mongolia","Montenegro","Montserrat","Morocco","Mozambique","Namibia","Nepal","Netherlands","Netherlands Antilles","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","Norway","Oman","Pakistan","Palestine","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Puerto Rico","Qatar","Reunion","Romania","Russia","Rwanda","Saint Pierre &amp; Miquelon","Samoa","San Marino","Satellite","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","South Africa","South Korea","Spain","Sri Lanka","St Kitts &amp; Nevis","St Lucia","St Vincent","St. Lucia","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Timor L'Este","Togo","Tonga","Trinidad &amp; Tobago","Tunisia","Turkey","Turkmenistan","Turks &amp; Caicos","Uganda","Ukraine","United Arab Emirates","United Kingdom","Uruguay","Uzbekistan","Venezuela","Vietnam","Virgin Islands (US)","Yemen","Zambia","Zimbabwe"};
        NationalityJComboBox =new JComboBox<>(arr);
        /*cars=TabServer.driver.getCars();
        arr=new String[cars.size()];
        for(int i=0;i<cars.size();i++){
            arr[i]=cars.get(i).getCarID();
        }*/
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
        firstNameLabel.setBounds(10,10,250,60);//FirstName
        lastNameLabel.setBounds(10,80,250,60);//LastName
        genderLabel.setBounds(10,150,250,60);//Gender
        dobLabel.setBounds(10,220,250,60);//DOB
        drivingExperienceLabel.setBounds(10,290,250,60);//Driving experience
        addressLabel.setBounds(10,360,250,60);//Address
        cityLabel.setBounds(10,430,250,60);//City
        nationalityLabel.setBounds(10,500,250,60);//Nationality
        mobileNumberLabel.setBounds(10,570,250,60);//MobileNo
        emailLabel.setBounds(10,640,250,60);//Email
        passwordLabel.setBounds(10,710,250,60);//Password
        driverLicenseLabel.setBounds(530,220,250,60);//Lisence ID
        carIDLabel.setBounds(530,290,250,60);
        companyLabel.setBounds(530,360,250,60);
        modelLabel.setBounds(530,430,250,60);
        capacityLabel.setBounds(530,500,250,60);
        ACLabel.setBounds(530,570,250,60);
        FarePerKMLabel.setBounds(530,640,250,60);

        //SetBounds for textFields
        firstNameTextField.setBounds(270,10,250,60);//FirstName
        lastNameTextField.setBounds(270,80,250,60);//LastName
        DOBTextField.setBounds(270,220,250,60);//DOB
        drivingExpTextField.setBounds(270,290,250,60);//Driving Experience
        addressTextField.setBounds(270,360,250,60);//Address
        cityTextField.setBounds(270,430,250,60);//City
        mobileNoTextField.setBounds(270,570,250,60);//Mobile No
        emailTextField.setBounds(270,640,250,60);//Email
        passwordTextField.setBounds(270,710,250,60);//Password
        companyTextField.setBounds(790,360,250,60);//Company
        modelTextField.setBounds(790,430,250,60);//Model
        capacityTextField.setBounds(790,500,250,60);//Capacity
        ACTextField.setBounds(790,570,250,60);//AC
        fareTextField.setBounds(790,640,250,60);//Fare
        licenseTextField.setBounds(790,220,250,60);//License ID

        //setBounds for buttons
        editButton.setBounds(270,780,250,60);
        addCarButton.setBounds(530,710,250,60);
        changePasswordButton.setBounds(800,710,250,60);

        //setBounds for Radio buttons
        maleJRadioButton.setBounds(270,150,250,60);
        femaleJRadioButton.setBounds(530,150,250,60);
        othersJRadioButton.setBounds(790,150,250,60);

        //Setbounds for JCombo box
        NationalityJComboBox.setBounds(270,500,250,60);
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
        passwordTextField.setBorder(bdr);
        companyTextField.setBorder(bdr);
        modelTextField.setBorder(bdr);
        capacityTextField.setBorder(bdr);
        ACTextField.setBorder(bdr);
        fareTextField.setBorder(bdr);
        licenseTextField.setBorder(bdr);

        editButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(flag%2==0) {
                    flag++;
                    editButton.setLabel("UPDATE");
                    enableEdit();
                    return;
                }
                if(validateEntries()){
                    dbInsert();
                    flag++;
                    disableEdit();
                    editButton.setLabel("EDIT");
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
        //Adding lists
        add(NationalityJComboBox);
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
        add(passwordLabel);
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
        add(passwordTextField);
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

        //Adding Radio Buttons
        add(maleJRadioButton);
        add(femaleJRadioButton);
        add(othersJRadioButton);
    }

    public boolean validateEntries(){
        //
        return true;
    }
    public boolean dbInsert(){
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
        NationalityJComboBox.setEnabled(false);
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
        emailTextField.setEditable(true);
        txtFld11.setEditable(true);
        NationalityJComboBox.setEditable(false);
        return true;
    }

}
