package customer;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class TabServer extends JFrame{
    Customer customer;
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

        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
            System.out.println("getCustomerDetails"+e);
        }
        return null;
    }
}
