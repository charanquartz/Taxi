package Admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.*;

public class Tabserver extends JFrame {
    JTabbedPane tabs;
    JPanel login, viewemployee,addemployee,RemoveEmployee,feedbacks;
    TextField textfld1,txtFld2;
    Label lb1,lb2,lb3;
    public Tabserver(){
        setTitle("ADMIN");
        tabs= new JTabbedPane();
        setBounds(0,0,1900,1000);
        setVisible(true);
        setFont(new Font("Times new roman",Font.BOLD,18));
        add(tabs,BorderLayout.CENTER);

        login=new Login();
        RemoveEmployee=new Removeemployee();
        addemployee=new AddEmployee();
        viewemployee=new ViewEmployee();
        feedbacks=new Feedbacks();

        tabs.addTab("LOGIN",login);
        tabs.addTab("ADD EMPLOYEE",addemployee);
        tabs.addTab("REMOVE EMPLOYEE",RemoveEmployee);
        tabs.addTab("VIEW EMPLOYEE",viewemployee);
        tabs.addTab("VIEW FEEDBACKS",feedbacks);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(tabs);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
