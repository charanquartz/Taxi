package driver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TabServer extends JFrame{
    JTabbedPane tabs;
    JPanel login,signup,acceptRide,feedback,update;
    static Driver driver;
    public TabServer(){
        setBackground(new Color(35, 176, 212));
        setTitle("DRIVER'S HOME");
        tabs=new JTabbedPane();
        setBounds(0,0,1900,1000);
        setVisible(true);
        setFont(new Font("Times new roman",Font.BOLD,18));
        add(tabs,BorderLayout.CENTER);
        login=new Login();
        signup=new SignUp();
        acceptRide=new AcceptRide();
        feedback =new ProvideFeedback();
        update=new UpdateProfile();
        tabs.addTab("LOGIN",login);
        tabs.addTab("SIGNUP",signup);
        tabs.addTab("ACCEPT RIDES",acceptRide);
        tabs.addTab("UPDATE PROFILE",update);
        tabs.addTab("PROVIDE FEEDBACK",feedback);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        add(tabs);
    }
}
