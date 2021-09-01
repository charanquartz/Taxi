package customer;
import java.awt.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.sql.*;
import java.util.Properties;

public class TabServer extends JFrame{
    static Customer customer;
    static Connection connection;
    static JTabbedPane tabs;
    JPanel signup,login,bookRide,feedback,updateProfile;
    TabServer(){
        customer=new Customer();
        setTitle("CUSTOMER");
        setVisible(true);
        setBounds(0,0,1900,1000);
        setBackground(Color.YELLOW);

        tabs=new JTabbedPane();
        signup=new SignUp();
        login=new Login();
        bookRide=new BookRide();
        feedback=new Feedback();
        updateProfile=new UpdateProfile();

        //Establishing connection
        try{
            connection=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","test","sql");
            connection.setAutoCommit(true);
        }
        catch(Exception e){
            System.out.println("TabServer()->Customer"+e);
        }

        tabs.addTab("LOGIN",login);
        tabs.addTab("SIGNUP",signup);
        tabs.addTab("UPDATE PROFILE",updateProfile);
        tabs.addTab("BOOK RIDE",bookRide);
        tabs.addTab("FEEDBACK",feedback);

        tabs.setEnabledAt(2,false);
        tabs.setEnabledAt(3,false);
        tabs.setEnabledAt(4,false);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        add(tabs);
    }
    public static int generateRandomNumber(){
        int temp,n=0;
        for(int i=0;i<6;i++){
            temp=(int)(Math.random()*10);
            while(i==0 && temp==0){
                temp=(int)(Math.random()*10);
            }
            n=n*10+temp;
        }
        return n;
    }
    public static ResultSet getCustomerDetails(String email){
        String query="select * from customer where email='"+email+"'";
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("getCustomerDetails-->Email"+e);
        }
        return null;
    }
    public static ResultSet getCustomerDetails(long mobileNumber){
        String query="select * from customer where mobile="+mobileNumber+"";
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("getCustomerDetails-->mobileNumber"+e);
        }
        return null;
    }
    public static ResultSet getCustomerDetails(int portNumber){
        String query="select * from customer where portNumber="+portNumber+"";
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("getCustomerDetails-->mobileNumber"+e);
        }
        return null;
    }
    public static ResultSet getRideDetails(int otp){
        String query="select * from ride where otp="+otp;
        try{
            Statement statement=connection.createStatement();
            return statement.executeQuery(query);
        }
        catch (Exception e){
            System.out.println("getRideDetails()"+e);
        }
        return null;
    }
    public static boolean hasAlreadyBookedARide(String email){
        try{
            String query="select * from ride where email='"+email+"'";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            if(resultSet.next()){
                return true;
            }
        }
        catch(Exception e){
            System.out.println("hasAlreadyBookedRide()"+e);
        }
        return false;
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
