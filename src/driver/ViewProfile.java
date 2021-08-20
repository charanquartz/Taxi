package driver;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.Event.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ViewProfile extends JPanel{
    int flag=0;
    Label lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,lbl13,lbl14,lbl15,lbl16,lbl17,lbl18,lbl19;
    JTextField txtFld1,txtFld2,txtFld3,txtFld4,txtFld5,txtFld6,txtFld7,txtFld8,txtFld11,txtFld12,txtFld13,txtFld14,txtFld15,txtFld16,txtFld17,txtFld18;
    JPasswordField txtFld9;
    JComboBox<String> list1,list2;
    Button btn1,btn2,btn3;
    String[] arr;
    JRadioButton radBtn1,radBtn2,radBtn3;
    ButtonGroup btnGrp1;
    Border bdr=BorderFactory.createLineBorder(Color.BLACK,5);
    ArrayList<Car> cars;

    ViewProfile(){
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
        lbl5=new Label("Driving Experience : ");
        lbl6=new Label("Address : ");
        lbl7=new Label("City : ");
        lbl8=new Label("Nationality : ");
        lbl9=new Label("Mobile Number : ");
        lbl10=new Label("Email : ");
        lbl11=new Label("Password : ");
        lbl13=new Label("Driver Lisence ID : ");
        lbl14=new Label("Car ID : ");
        lbl15=new Label("Company : ");
        lbl16=new Label("Model : ");
        lbl17=new Label("Capacity : ");
        lbl18=new Label("AC : ");
        lbl19=new Label("Fare/KM: ");

        //TextField
        txtFld1=new JTextField();
        txtFld2=new JTextField();
        txtFld3=new JTextField();
        txtFld4=new JTextField();
        txtFld5=new JTextField();
        txtFld6=new JTextField();
        txtFld7=new JTextField();
        txtFld8=new JTextField();
        txtFld11=new JTextField();
        txtFld12=new JTextField();
        txtFld13=new JTextField();
        txtFld14=new JTextField();
        txtFld15=new JTextField();
        txtFld16=new JTextField();
        txtFld17=new JTextField();

        //PasswordFields
        txtFld9=new JPasswordField();

        //Button
        btn1=new Button("EDIT");
        btn2=new Button("ADD CAR");
        btn3=new Button("CHANGE PASSWORD");

        //JCombo box
        arr=new String[]{"Afghanistan","Albania","Algeria","Andorra","Angola","Anguilla","Antigua &amp; Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia &amp; Herzegovina","Botswana","Brazil","British Virgin Islands","Brunei","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Cape Verde","Cayman Islands","Chad","Chile","China","Colombia","Congo","Cook Islands","Costa Rica","Cote D Ivoire","Croatia","Cruise Ship","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Estonia","Ethiopia","Falkland Islands","Faroe Islands","Fiji","Finland","France","French Polynesia","French West Indies","Gabon","Gambia","Georgia","Germany","Ghana","Gibraltar","Greece","Greenland","Grenada","Guam","Guatemala","Guernsey","Guinea","Guinea Bissau","Guyana","Haiti","Honduras","Hong Kong","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Isle of Man","Israel","Italy","Jamaica","Japan","Jersey","Jordan","Kazakhstan","Kenya","Kuwait","Kyrgyz Republic","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macau","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Mauritania","Mauritius","Mexico","Moldova","Monaco","Mongolia","Montenegro","Montserrat","Morocco","Mozambique","Namibia","Nepal","Netherlands","Netherlands Antilles","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","Norway","Oman","Pakistan","Palestine","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Puerto Rico","Qatar","Reunion","Romania","Russia","Rwanda","Saint Pierre &amp; Miquelon","Samoa","San Marino","Satellite","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","South Africa","South Korea","Spain","Sri Lanka","St Kitts &amp; Nevis","St Lucia","St Vincent","St. Lucia","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Timor L'Este","Togo","Tonga","Trinidad &amp; Tobago","Tunisia","Turkey","Turkmenistan","Turks &amp; Caicos","Uganda","Ukraine","United Arab Emirates","United Kingdom","Uruguay","Uzbekistan","Venezuela","Vietnam","Virgin Islands (US)","Yemen","Zambia","Zimbabwe"};
        list1=new JComboBox<>(arr);
        /*cars=TabServer.driver.getCars();
        arr=new String[cars.size()];
        for(int i=0;i<cars.size();i++){
            arr[i]=cars.get(i).getCarID();
        }*/
        arr=new String[]{};
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
        txtFld12.setBounds(790,360,250,60);//Company
        txtFld13.setBounds(790,430,250,60);//Model
        txtFld14.setBounds(790,500,250,60);//Capacity
        txtFld15.setBounds(790,570,250,60);//AC
        txtFld16.setBounds(790,640,250,60);//Fare
        txtFld17.setBounds(790,220,250,60);//License ID

        //setBounds for buttons
        btn1.setBounds(270,780,250,60);
        btn2.setBounds(530,710,250,60);
        btn3.setBounds(800,710,250,60);

        //setBounds for Radio buttons
        radBtn1.setBounds(270,150,250,60);
        radBtn2.setBounds(530,150,250,60);
        radBtn3.setBounds(790,150,250,60);

        //Setbounds for JCombo box
        list1.setBounds(270,500,250,60);
        list2.setBounds(790,290,250,60);

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
        txtFld12.setBorder(bdr);
        txtFld13.setBorder(bdr);
        txtFld14.setBorder(bdr);
        txtFld15.setBorder(bdr);
        txtFld16.setBorder(bdr);
        txtFld17.setBorder(bdr);

        btn1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(flag%2==0) {
                    flag++;
                    btn1.setLabel("UPDATE");
                    enableEdit();
                    return;
                }
                if(validateEntries()){
                    dbInsert();
                    flag++;
                    disableEdit();
                    btn1.setLabel("EDIT");
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

        btn2.addMouseListener(new MouseListener() {
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
        btn3.addMouseListener(new MouseListener() {
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
        add(list1);
        add(list2);
        disableEdit();

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
        add(lbl13);
        add(lbl14);
        add(lbl15);
        add(lbl16);
        add(lbl17);
        add(lbl18);
        add(lbl19);

        //Adding txtfields
        add(txtFld1);
        add(txtFld2);
        add(txtFld3);
        add(txtFld4);
        add(txtFld5);
        add(txtFld6);
        add(txtFld7);
        add(txtFld8);
        add(txtFld9);
        add(txtFld12);
        add(txtFld13);
        add(txtFld14);
        add(txtFld15);
        add(txtFld16);
        add(txtFld17);

        //Adding Buttons
        add(btn1);
        add(btn2);
        add(btn3);

        //Adding Radio Buttons
        add(radBtn1);
        add(radBtn2);
        add(radBtn3);
    }

    public boolean validateEntries(){
        //
        return true;
    }
    public boolean dbInsert(){
        return true;
    }
    private boolean disableEdit(){
        txtFld1.setEditable(false);
        txtFld2.setEditable(false);
        txtFld3.setEditable(false);
        txtFld4.setEditable(false);
        txtFld5.setEditable(false);
        txtFld6.setEditable(false);
        txtFld7.setEditable(false);
        txtFld8.setEditable(false);
        txtFld11.setEditable(false);
        txtFld12.setEditable(false);
        txtFld13.setEditable(false);
        txtFld14.setEditable(false);
        txtFld15.setEditable(false);
        txtFld16.setEditable(false);
        txtFld17.setEditable(false);
        list1.setEditable(false);
        return true;
    }
    private boolean enableEdit(){
        txtFld1.setEditable(true);
        txtFld2.setEditable(true);
        txtFld3.setEditable(true);
        txtFld4.setEditable(true);
        txtFld5.setEditable(true);
        txtFld6.setEditable(true);
        txtFld7.setEditable(true);
        txtFld8.setEditable(true);
        txtFld11.setEditable(true);
        list1.setEditable(false);
        return true;
    }
}
