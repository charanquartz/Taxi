package admin;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.JTabbedPane;
import java.awt.*;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.regex.*;
import java.sql.*;

public class TabServer extends JFrame {
    public static Connection connection;
    public static Statement statement;
    public static Pattern pattern;
    public static Matcher matcher;
    public static Admin admin;
    public static JTabbedPane tabs;
    public static Font font=new Font("Times new roman",Font.BOLD,18);
    JPanel login, viewDriver, approveDriver,feedback,changepassword;
    public TabServer(){
        admin=new Admin();
        setTitle("ADMIN");
        tabs= new JTabbedPane();
        setBounds(0,0,1900,1000);
        setVisible(true);
        setFont(font);
        add(tabs,BorderLayout.CENTER);

        try{
            connection=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","test","sql");
            connection.setAutoCommit(true);
            statement=connection.createStatement();
        }
        catch(Exception e){
            System.out.println("TabServer()"+e);
        }
        login=new Login();
        approveDriver =new ApproveDriver();
        viewDriver=new ViewDriver();
        feedback=new Feedback();
        changepassword=new ChangePassword();

        tabs.addTab("LOGIN",login);
        tabs.addTab("CHANGE PASSWORD",changepassword);
        tabs.addTab("VIEW DRIVER",viewDriver);
        tabs.addTab("APPROVE DRIVER", approveDriver);
        tabs.addTab("VIEW FEEDBACKS",feedback);
        add(tabs);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        tabs.setEnabledAt(1,false);
        tabs.setEnabledAt(2,false);
        tabs.setEnabledAt(3,false);
        tabs.setEnabledAt(4,false);
    }
    public static boolean isValidPassword(String txt){
        pattern= Pattern.compile("^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$");
        matcher=pattern.matcher(txt);
        return matcher.matches();
    }
    public static String getCustomerName(String email){
        String query;
        try{
            Statement s= connection.createStatement();
            query="select fname,lName from customer where email='"+email+"'";
            ResultSet resultSet=s.executeQuery(query);
            resultSet.next();
            return resultSet.getString(1).trim()+" "+resultSet.getString(2);
        }
        catch(Exception e){
            System.out.println("getCustomerName()"+e);
        }
        return "-1";
    }
    public static String getDriverName(String email){
        String query;
        try{
            Statement s= connection.createStatement();
            query="select fname,lName from driver where email='"+email+"'";
            ResultSet resultSet=s.executeQuery(query);
            resultSet.next();
            return resultSet.getString(1).trim()+" "+resultSet.getString(2);
        }
        catch(Exception e){
            System.out.println("getDriverName()"+e);
        }
        return "-1";
    }
    public static boolean sendMail(String subject,String text,String email){
        final String username = "taxi.booking.service.java@gmail.com";
        final String password = "projectcab";

        final String from = "taxi.booking.service.java@gmail.com";
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
