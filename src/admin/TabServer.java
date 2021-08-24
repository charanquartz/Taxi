package admin;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.*;
import java.util.regex.Pattern;
import java.util.regex.*;

public class TabServer extends JFrame {
    public static Pattern pattern;
    public static Matcher matcher;
    public static Admin admin;
    JTabbedPane tabs;
    JPanel login, viewDriver,removeDriver,feedback,changepassword;
    public TabServer(){
        setTitle("ADMIN");
        tabs= new JTabbedPane();
        setBounds(0,0,1900,1000);
        setVisible(true);
        setFont(new Font("Times new roman",Font.BOLD,18));
        add(tabs,BorderLayout.CENTER);

        login=new Login();
        removeDriver=new RemoveDriver();
        viewDriver=new ViewDriver();
        feedback=new Feedback();
        changepassword=new ChangePassword();

        tabs.addTab("LOGIN",login);
        tabs.addTab("CHANGE PASSWORD : ",changepassword);
        tabs.addTab("VIEW EMPLOYEE",viewDriver);
        tabs.addTab("REMOVE EMPLOYEE",removeDriver);
        tabs.addTab("VIEW FEEDBACKS",feedback);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(tabs);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    static public boolean isValidPassword(String txt){
        pattern= Pattern.compile("^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$");
        matcher=pattern.matcher(txt);
        return matcher.matches();
    }
}
