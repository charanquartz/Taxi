package driver;
import javax.swing.*;
import java.awt.Event.*;
import java.awt.*;
public class SignUp extends JPanel{
    Label lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,lbl13;
    TextField txtFld1,txtFld2,txtFld3,txtFld4,txtFld5,txtFld6,txtFld7,txtFld8,txtFld9,txtFld10,txtFld12,txtFld11;
    JComboBox<String> list1;
    Button btn1,btn2;
    String[] arr;
    JRadioButton radBtn1,radBtn2,radBtn3;
    ButtonGroup btnGrp1;
    SignUp(){
        setBackground(new Color(3, 252, 240));
        setBounds(0,0,2000,1900);
        setFont(new  Font("Times New Roman",Font.BOLD,19));
        setVisible(true);
        setLayout(null);

        //Label
        lbl1=new Label("FirstName : ");
        lbl2=new Label("LastName : ");
        lbl3=new Label("Gender : ");
        lbl4=new Label("Date of Birth : ");
        lbl5=new Label("Car Details : ");
        lbl6=new Label("Driving Experience : ");
        lbl7=new Label("Address : ");
        lbl8=new Label("City : ");
        lbl9=new Label("Nationality : ");
        lbl10=new Label("Mobile Number : ");
        lbl11=new Label("Email : ");
        lbl12=new Label("Password : ");
        lbl13=new Label("Re-enter Password : ");

        //TextField
        txtFld1=new TextField();
        txtFld2=new TextField();
        txtFld3=new TextField();
        txtFld4=new TextField();
        txtFld5=new TextField();
        txtFld6=new TextField();
        txtFld7=new TextField();
        txtFld8=new TextField();
        txtFld9=new TextField();
        txtFld10=new TextField();
        txtFld11=new TextField();
        txtFld12=new TextField();

        //Button
        btn1=new Button("CAR");
        btn2=new Button("SIGNUP");

        //JCombo box
        arr=new String[]{"Afghanistan","Albania","Algeria","Andorra","Angola","Anguilla","Antigua &amp; Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia &amp; Herzegovina","Botswana","Brazil","British Virgin Islands","Brunei","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Cape Verde","Cayman Islands","Chad","Chile","China","Colombia","Congo","Cook Islands","Costa Rica","Cote D Ivoire","Croatia","Cruise Ship","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Estonia","Ethiopia","Falkland Islands","Faroe Islands","Fiji","Finland","France","French Polynesia","French West Indies","Gabon","Gambia","Georgia","Germany","Ghana","Gibraltar","Greece","Greenland","Grenada","Guam","Guatemala","Guernsey","Guinea","Guinea Bissau","Guyana","Haiti","Honduras","Hong Kong","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Isle of Man","Israel","Italy","Jamaica","Japan","Jersey","Jordan","Kazakhstan","Kenya","Kuwait","Kyrgyz Republic","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macau","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Mauritania","Mauritius","Mexico","Moldova","Monaco","Mongolia","Montenegro","Montserrat","Morocco","Mozambique","Namibia","Nepal","Netherlands","Netherlands Antilles","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","Norway","Oman","Pakistan","Palestine","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Puerto Rico","Qatar","Reunion","Romania","Russia","Rwanda","Saint Pierre &amp; Miquelon","Samoa","San Marino","Satellite","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","South Africa","South Korea","Spain","Sri Lanka","St Kitts &amp; Nevis","St Lucia","St Vincent","St. Lucia","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Timor L'Este","Togo","Tonga","Trinidad &amp; Tobago","Tunisia","Turkey","Turkmenistan","Turks &amp; Caicos","Uganda","Ukraine","United Arab Emirates","United Kingdom","Uruguay","Uzbekistan","Venezuela","Vietnam","Virgin Islands (US)","Yemen","Zambia","Zimbabwe"};
        list1=new JComboBox<>(arr);

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
        lbl2.setBounds(10,80,250,70);//LastName
        lbl3.setBounds(10,150,250,60);//Gender
        lbl4.setBounds(10,220,250,60);//DOB
        lbl5.setBounds(10,290,250,60);//Car details
        lbl6.setBounds(10,360,250,60);//Driving experience
        lbl7.setBounds(10,430,250,60);//Address
        lbl8.setBounds(10,500,250,60);//City
        lbl9.setBounds(10,570,250,60);//Nationality
        lbl10.setBounds(10,640,250,60);//MobileNo
        lbl11.setBounds(10,710,250,60);//Email
        lbl12.setBounds(10,780,250,60);//Password
        lbl13.setBounds(10,850,250,60);//Re-Enter pass

        //SetBounds for textFields
        txtFld1.setBounds(270,10,250,60);//FirstName
        txtFld2.setBounds(270,80,250,60);//LastName
        txtFld3.setBounds(270,220,250,60);//DOB
        txtFld4.setBounds(270,360,250,60);//Driving Experience
        txtFld5.setBounds(270,430,250,60);//Address
        txtFld6.setBounds(270,500,250,60);//City
        txtFld7.setBounds(270,640,250,60);//Mobile No
        txtFld8.setBounds(270,710,250,60);//Email
        txtFld9.setBounds(270,780,250,60);//Password
        txtFld10.setBounds(270,850,250,60);//Re enter pass

        //setBounds for buttons
        btn1.setBounds(270,290,250,60);
        btn2.setBounds(270,920,250,60);

        //setBounds for Radio buttons
        radBtn1.setBounds(270,150,250,60);
        radBtn2.setBounds(520,150,250,60);
        radBtn3.setBounds(770,150,250,60);

        //Setbounds for JCombo box
        list1.setBounds(260,570,250,60);

        //Adding lists
        add(list1);

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

        //Adding Buttons
        add(btn1);
        add(btn2);

        //Adding Radio Buttons
        add(radBtn1);
        add(radBtn2);
        add(radBtn3);
    }
}
