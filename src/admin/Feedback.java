package admin;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class Feedback extends JPanel {
    JTextField nameTextField,stateTextField,feedbackTextField,ratingsTextField,emailTextField,mobileNumberTextField,sNoTextField;
    JButton refreshButton,markAsReadTextButton;
    JTable driverFeedbackTable, customerFeedbackTable;
    Label customerTableLabel,driverTableLabel;
    JScrollPane driverScrollPane,customerScrollPane;
    Object[][] arr;
    String query;
    ResultSet resultSet;
    Feedback(){
        setBounds(0,0,1900,1000);
        setVisible(true);
        setLayout(null);
        setFont(new Font("Tiems new roman",Font.BOLD,19));

        //Table 1
        arr=new Object[getDriverFeedbackCount()][3];
        fillDriverSNoNameAndEmail(getDriverFeedbackCount());
        driverFeedbackTable =new JTable(arr,new Object[]{"SNo.","Name","Email"});

        //DriverScrollpane
        driverScrollPane=new JScrollPane(driverFeedbackTable);
        driverScrollPane.setBounds(0,70,500,400);

        //Table 2
        arr=new Object[getCustomerFeedbackCount()][3];
        fillCustomerSNoNameAndEmail(getCustomerFeedbackCount());
        customerFeedbackTable =new JTable(arr,new Object[]{"SNo.","Name","Email"});

        //CustomerScrollPane
        customerScrollPane=new JScrollPane(customerFeedbackTable);
        customerScrollPane.setBounds(0,540,500,400);

        //Label
        customerTableLabel=new Label("Customer feedbacks");
        driverTableLabel=new Label("Driver feedbacks");
        driverTableLabel.setBounds(0,0,200,60);
        customerTableLabel.setBounds(0,470,200,60);

        //Draw line
        //drawLine


        add(driverTableLabel);
        add(driverScrollPane);
        add(customerScrollPane);
        add(customerTableLabel);
    }

    private int getDriverFeedbackCount(){
        int n=0;
        try{
            query="select count(email) from driverFeedback";
            resultSet=TabServer.statement.executeQuery(query);
            resultSet.next();
            n=resultSet.getInt(1);
        }
        catch(Exception e){
            System.out.println("getDriverFeedbackCount()"+e);
        }
        return n;
    }
    private boolean fillDriverSNoNameAndEmail(int size){
        query="select * from driverFeedback";
        try {
            resultSet = TabServer.statement.executeQuery(query);
            resultSet.next();
            for(int i=0;i<size;i++){
                arr[i][0]=resultSet.getInt(1);
                arr[i][1]=resultSet.getString(3);
                arr[i][2]=resultSet.getString(2);
                resultSet.next();
            }
        }
        catch(Exception e){
            System.out.println("fillDriverSNoNameAndEmail()"+e);
        }
        return true;
    }
    private int getCustomerFeedbackCount(){
        int n=0;
        try{
            query="select count(email) from customerFeedback";
            resultSet=TabServer.statement.executeQuery(query);
            resultSet.next();
            n=resultSet.getInt(1);
        }
        catch(Exception e){
            System.out.println("getCustomerFeedbackCount()"+e);
        }
        return n;
    }
    private boolean fillCustomerSNoNameAndEmail(int size){
        query="select * from customerFeedback";
        try {
            resultSet = TabServer.statement.executeQuery(query);
            resultSet.next();
            for(int i=0;i<size;i++){
                arr[i][0]=resultSet.getInt(1);
                arr[i][1]=resultSet.getString(3);
                arr[i][2]=resultSet.getString(2);
                resultSet.next();
            }
        }
        catch(Exception e){
            System.out.println("fillCustomerSNoNameAndEmail()"+e);
        }
        return true;
    }
}