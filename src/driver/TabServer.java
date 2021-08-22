package driver;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.*;
public class TabServer extends JFrame{
    static JTabbedPane tabs;
    static Pattern pattern;
    String s;
    static Matcher matcher;
    JPanel login,signup,viewRide,feedback,update;
    static Driver driver;
    static ArrayList<Car> cars;
    static Connection connection;
    public TabServer() throws Exception{
        setBackground(new Color(35, 176, 212));
        setTitle("DRIVER'S HOME");
        tabs=new JTabbedPane();
        setBounds(0,0,1900,1000);
        setVisible(true);
        setLayout(new BorderLayout());
        setFont(new Font("Times new roman",Font.BOLD,18));
        add(tabs,BorderLayout.CENTER);

        //Establishing connection to db
       connection=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","madhi","java");
       connection.setAutoCommit(true);

        login=new Login();
        signup=new SignUp();
        viewRide=new ViewRides();
        feedback =new Feedback();
        update=new ViewProfile();
        tabs.addTab("LOGIN",login);
        tabs.addTab("SIGNUP",signup);
        tabs.addTab("VIEW RIDES",viewRide);
        tabs.addTab("VIEW PROFILE",update);
        tabs.addTab("PROVIDE FEEDBACK",feedback);
//       // tabs.setEnabledAt(2,false);
//        tabs.setEnabledAt(3,false);
//        tabs.setEnabledAt(4,false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        add(tabs);
    }
    static public boolean isValidEmail(String email){
        pattern=Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
        matcher=pattern.matcher(email);
        return matcher.matches();
    }
    static public boolean isValidName(String name){
        pattern=Pattern.compile("[a-zA-Z][a-zA-Z ]+");
        matcher=pattern.matcher(name);
        return matcher.matches();
    }
    static public boolean isValidNumber(String text){
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)-48<0 || text.charAt(i)-48>9){
                return false;
            }
        }
        return true;
    }
    static public boolean isValidDate(String txt){
        pattern=Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$");
        matcher=pattern.matcher(txt);
        return matcher.matches();
    }
    static public boolean isValidPassword(String txt){
        pattern=Pattern.compile("^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$");
        matcher=pattern.matcher(txt);
        return matcher.matches();
    }
    static public boolean isValidID(String txt){
        pattern=Pattern.compile("^[a-zA-Z0-9!@#$&()\\\\-`.+,/\\\"]*$");
        matcher=pattern.matcher(txt);
        return matcher.matches();
    }
    //Functions for tab enable
    public static boolean enableViewRide(){
        tabs.setEnabledAt(2,true);
        return true;
    }
    public static boolean enableFeedback(){
        tabs.setEnabledAt(4,true);
        return true;
    }
    public static boolean enableViewProfile(){
        tabs.setEnabledAt(3,true);
        return true;
    }

    //Functions for tab disable
    public static boolean disableViewRide(){
        tabs.setEnabledAt(2,false);
        return true;
    }
    public static boolean disableFeedback(){
        tabs.setEnabledAt(4,false);
        return true;
    }
    public static  boolean disableViewProfile(){
        tabs.setEnabledAt(3,false);
        return true;
    }
    public static boolean disableLogin(){
        tabs.setEnabledAt(0,false);
        return true;
    }
    public static boolean disableSignUp(){
        tabs.setEnabledAt(1,false);
        return true;
    }
    public static boolean sendMail(String subject,String text,String email){
        final String username = "19eucs076@skcet.ac.in";
        final String password = "krishna123";

        final String from = "19eucs076@skcet.ac.in";
        final String to = email;

        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");




        Authenticator a =new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(username, password);

            }

        };

        Session session = Session.getInstance(props, a);

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

        } catch (MessagingException e) {
            System.out.println(e);
        }
        return true;
    }
}