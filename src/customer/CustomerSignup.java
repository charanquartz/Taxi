package customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class CustomerSignup extends JFrame implements ActionListener,ItemListener{

    JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
    JTextField txtFld1,txtFld2,txtFld3,txtFld4,txtFld5;
    JPasswordField  txtFld6;
    ButtonGroup btngroup;
    JRadioButton radBtn1,radBtn2,radBtn3;
    JComboBox<String> list1,list2;
    JComboBox jcb_city;
    Font k;
    JButton jbtn_signup;
    Container co;
    String[] arr;
    String str_gender="";

    public CustomerSignup(){
    	Font k = new Font("Times New Roman",Font.BOLD,19);
        setBackground(new Color(255, 167, 88));
        setBounds(100,100,3000,1900);
        setFont(new Font("Times New Roman",Font.BOLD,19));
        

        co=getContentPane();
        co.setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbl1=new JLabel("First Name");
        lbl2=new JLabel("Second Name");
        lbl3=new JLabel("Gender");
        lbl4=new JLabel("Mobile Number");
        lbl5=new JLabel("Email ID");
        lbl6=new JLabel("Password");
        lbl7=new JLabel("Country");

        txtFld1=new JTextField();
        txtFld2=new JTextField();
        txtFld3=new JTextField();
        txtFld4=new JTextField();
       // txtFld5=new JTextField();
        txtFld5=new JPasswordField();
        
        
       
        
  

        btngroup=new ButtonGroup();

        radBtn1=new JRadioButton("male");
        radBtn2=new JRadioButton("female");
        radBtn3=new JRadioButton("others");

        btngroup.add(radBtn1);
        btngroup.add(radBtn2);
        btngroup.add(radBtn3);

        jcb_city=new JComboBox();


        jcb_city.addItem("Australia");
        jcb_city.addItem("Bangladesh");
        jcb_city.addItem("Chile");
        jcb_city.addItem("Denmark");
        jcb_city.addItem("Egypt");
        jcb_city.addItem("France");
        jcb_city.addItem("Greenland");
        jcb_city.addItem("HongKong");
        jcb_city.addItem("India");
        jcb_city.addItem("Japan");
        jcb_city.addItem("Kenya");
        jcb_city.addItem("Lithuvania");
        jcb_city.addItem("Madagascar");
        jcb_city.addItem("Nepal");
        jcb_city.addItem("Oman");
        jcb_city.addItem("Poland");
        jcb_city.addItem("Qatar");
        jcb_city.addItem("Russia");
        jcb_city.addItem("Serbia");
        jcb_city.addItem("Turkey");
        jcb_city.addItem("USA");
        jcb_city.addItem("UK");
        jcb_city.addItem("Vietnam");
        jcb_city.addItem("WestIndies");
        jcb_city.addItem("Yemen");
        jcb_city.addItem("Zambia");
        jcb_city.addItem("Zimbabwe");
        

        jbtn_signup=new JButton("submit");

        radBtn1.addItemListener(this);
        radBtn2.addItemListener(this);
        radBtn3.addItemListener(this);
        jbtn_signup.addActionListener(this);

        lbl1.setBounds(100, 50, 250, 25);
        lbl2.setBounds(100, 100, 250, 25);
        lbl3.setBounds(100, 150, 250, 25);
        lbl4.setBounds(100, 200, 250, 25);
        lbl5.setBounds(100, 250, 250, 25);
        lbl6.setBounds(100, 300, 250, 25);
        lbl7.setBounds(100, 350, 250, 25);

        jbtn_signup.setBounds(100, 400, 80, 25);


        txtFld1.setBounds(230, 50, 200, 25);
        txtFld2.setBounds(230, 100, 200, 25);
        radBtn1.setBounds(230, 150, 60, 25);
        radBtn2.setBounds(300, 150, 70, 25);
        radBtn3.setBounds(370, 150, 80, 25);
        txtFld3.setBounds(230, 200, 200, 25);
        txtFld4.setBounds(230, 250, 200, 25);
        txtFld5.setBounds(230, 300, 200, 25);
        //txtFld6.setBounds(230, 450, 120, 25);
        
        
        
        jcb_city.setBounds(230, 350, 120, 25);


        co.add(lbl1);
        co.add(lbl2);
        co.add(lbl3);
        co.add(lbl4);
        co.add(lbl5);
        co.add(lbl6);
        co.add(lbl7);
        

        co.add(jbtn_signup);

        co.add(txtFld1);
        co.add(txtFld2);
        co.add(radBtn1);
        co.add(radBtn2);
        co.add(radBtn3);
        co.add(txtFld3);
        co.add(txtFld4);
        co.add(txtFld5);
        co.add(jcb_city);
        
        


        setSize(500, 500);
        setVisible(true);
        

    }

    public void itemStateChanged(ItemEvent ie){

        ItemSelectable itemselected=ie.getItemSelectable();

        if(itemselected==radBtn1){
                str_gender="male";
        }
        else if(itemselected==radBtn2){
                str_gender="female";
        }
        if(itemselected==radBtn3) {
        	str_gender="Others";
        }
    }

    public void actionPerformed(ActionEvent ae){

        Object obj_source=ae.getSource();

        if(obj_source==jbtn_signup){

            try{
                String str_fname=txtFld1.getText();
                String str_lname=txtFld2.getText();
                String str_mobile=txtFld3.getText();
                String str_email=txtFld4.getText();
                String str_password=txtFld5.getText();
                
                String str_city=jcb_city.getSelectedItem().toString();


                   Class.forName("oracle.jdbc.driver.OracleDriver");
                   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","test","sql");
                   Statement stmt=con.createStatement();
                   String query="insert into customer values("+str_fname+"','"+str_lname+"','"+str_gender+"','"+str_mobile+"','"+str_email+",'"+str_password+"','"+str_city+"')";

                   stmt.executeUpdate(query);
                   con.setAutoCommit(true);
                   JOptionPane.showMessageDialog(this, "Registration Success!");


            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, ex.toString());
            }

        }
    }

    public static void main(String args[]){
        new CustomerSignup();
    }
}
