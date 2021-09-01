package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
public class Feedback extends JPanel {
    Statement st;
    ResultSet customerDetailsResultSet,driverDetailsResultSet ;
    JTextField userTypeTextField,nameTextField,stateTextField,feedbackNoTextField,ratingsTextField,emailTextField,mobileNumberTextField;
    JButton refreshButton,markAsReadTextButton;
    JTable driverFeedbackTable, customerFeedbackTable;
    TextArea feedbackTextArea;
    Label customerTableLabel,driverTableLabel,customerTypeLabel,feedbackNoLabel,fullNameLabel,emailLabel,mobileNoLabel,stateLabel,feedbackLabel,ratingsLabel;
    JScrollPane driverScrollPane,customerScrollPane;
    Object[][] arr;
    int rowSelected;
    String query;
    ResultSet resultSet;
    Feedback(){
        setBackground(new Color(3, 252, 240));
        setBounds(0,0,1900,1000);
        setVisible(true);
        setLayout(null);
        setFont(new Font("Tiems new roman",Font.BOLD,19));

        //Label
        customerTableLabel=new Label("Customer feedbacks");
        driverTableLabel=new Label("Driver feedbacks");
        driverTableLabel.setBounds(0,0,200,60);
        customerTableLabel.setBounds(0,470,200,60);
        customerTypeLabel=new Label("User type : ");
        feedbackNoLabel=new Label("Feedback number : ");
        fullNameLabel=new Label("Name : ");
        emailLabel=new Label("Email : ");
        mobileNoLabel=new Label("Mobile number : ");
        stateLabel=new Label("State : ");
        feedbackLabel=new Label("Feedback : ");
        ratingsLabel=new Label("Ratings : ");

        //Set bounds for label
        customerTypeLabel.setBounds(700,0,200,60);
        feedbackNoLabel.setBounds(700,70,200,60);
        fullNameLabel.setBounds(700,140,200,60);
        emailLabel.setBounds(700,210,200,60);
        mobileNoLabel.setBounds(700,280,200,60);
        stateLabel.setBounds(700,350,200,60);
        feedbackLabel.setBounds(700,420,200,60);
        ratingsLabel.setBounds(700,830,200,60);

        //TextFields
        userTypeTextField=new JTextField();
        feedbackNoTextField=new JTextField();
        nameTextField=new JTextField();
        emailTextField=new JTextField();
        mobileNumberTextField=new JTextField();
        stateTextField=new JTextField();
        ratingsTextField=new JTextField();
        userTypeTextField.setEditable(false);
        feedbackNoTextField.setEditable(false);
        nameTextField.setEditable(false);
        emailTextField.setEditable(false);
        mobileNumberTextField.setEditable(false);
        stateTextField.setEditable(false);
        ratingsTextField.setEditable(false);

        //Set Bounds for textFields
        userTypeTextField.setBounds(910,0,200,60);
        feedbackNoTextField.setBounds(910,70,200,60);
        nameTextField.setBounds(910,140,200,60);
        emailTextField.setBounds(910,210,200,60);
        mobileNumberTextField.setBounds(910,280,200,60);
        stateTextField.setBounds(910,350,200,60);
        ratingsTextField.setBounds(910,830,200,60);

        //TextArea
        feedbackTextArea=new TextArea();
        feedbackTextArea.setBounds(910,420,800,400);
        feedbackTextArea.setEditable(false);

        //Button
        markAsReadTextButton=new JButton("Mark as read");
        refreshButton=new JButton("Refresh feedbacks");
        markAsReadTextButton.setBounds(1120,830,200,60);
        refreshButton.setBounds(1330,830,200,60);
        markAsReadTextButton.setEnabled(false);

        try {
            st=TabServer.connection.createStatement();
        }
        catch (Exception e){
            System.out.println("Feedback()"+e);
        }
        refresh();
        //MouseListener for button
        refreshButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                refresh();
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

        customerFeedbackTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rowSelected=e.getY()/60;
                if(rowSelected>=customerFeedbackTable.getRowCount()){
                    JOptionPane.showMessageDialog(null,"Error while fetching information.\nKindly refresh or restart the appliction for proper functioning...");
                    return;
                }
                if(!(isCustomerFeedbackPresent((Integer)customerFeedbackTable.getValueAt(rowSelected,0)))){
                    JOptionPane.showMessageDialog(null,"Cant fetch feedback.Please refresh for proper functioning.");
                    return;
                }
                setCustomerFeedback(rowSelected);
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
        markAsReadTextButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!markAsReadTextButton.isEnabled()){
                    return;
                }
                if(userTypeTextField.getText().trim().equals("Customer")){
                    deleteCustomerEntry(Integer.parseInt(feedbackNoTextField.getText()));
                }
                else{
                    deleteDriverEntry(Integer.parseInt(feedbackNoTextField.getText().trim()));
                }
                clearFields();
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
        driverFeedbackTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rowSelected=e.getY()/60;
                if(rowSelected>=driverFeedbackTable.getRowCount()){
                    JOptionPane.showMessageDialog(null,"Error while fetching information.\nKindly refresh or restart the appliction for proper functioning...");
                    return;
                }
                if(!(isDriverFeedbackPresent((Integer)driverFeedbackTable.getValueAt(rowSelected,0)))){
                    JOptionPane.showMessageDialog(null,"Cant fetch feedback info.Please refresh for proper functioning.");
                    return;
                }
                setDriverFeedback(rowSelected);
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


        add(driverTableLabel);
        add(driverScrollPane);
        add(customerScrollPane);
        add(customerTableLabel);
        add(customerTypeLabel);
        add(userTypeTextField);
        add(nameTextField);
        add(emailTextField);
        add(feedbackNoTextField);
        add(mobileNumberTextField);
        add(stateTextField);
        add(ratingsTextField);
        add(feedbackTextArea);
        add(userTypeTextField);
        add(feedbackNoLabel);
        add(fullNameLabel);
        add(emailLabel);
        add(mobileNoLabel);
        add(stateLabel);
        add(feedbackLabel);
        add(ratingsLabel);
        add(markAsReadTextButton);
        add(refreshButton);
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
                arr[i][0]=resultSet.getInt(4);
                arr[i][1]=TabServer.getDriverName(resultSet.getString(1));
                arr[i][2]=resultSet.getString(1);
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
                arr[i][1]=TabServer.getCustomerName(resultSet.getString(2));
                arr[i][2]=resultSet.getString(2);
                resultSet.next();
            }
        }
        catch(Exception e){
            System.out.println("fillCustomerSNoNameAndEmail()"+e);
        }
        return true;
    }
    public void clearFields(){
        userTypeTextField.setText("");
        ratingsTextField.setText("");
        emailTextField.setText("");
        feedbackTextArea.setText("");
        stateTextField.setText("");
        nameTextField.setText("");
        feedbackNoTextField.setText("");
        mobileNumberTextField.setText("");
        markAsReadTextButton.setEnabled(false);
    }
    public boolean refresh(){
        clearFields();
        //Table 1
        arr=new Object[getDriverFeedbackCount()][3];
        fillDriverSNoNameAndEmail(getDriverFeedbackCount());
        driverFeedbackTable =new JTable(arr,new Object[]{"Feedback No.","Name","Email"}){
            @Override
            public boolean isCellEditable(int r,int c){
                return false;
            }
        };
        driverFeedbackTable.setRowHeight(60);
        //DriverScrollpane
        driverScrollPane=new JScrollPane(driverFeedbackTable);
        driverScrollPane.setBounds(0,70,500,400);

        //Table 2
        arr=new Object[getCustomerFeedbackCount()][3];
        fillCustomerSNoNameAndEmail(getCustomerFeedbackCount());
        customerFeedbackTable =new JTable(arr,new Object[]{"Feedback No.","Name","Email"}){
            public boolean isCellEditable(int r,int c){
                return false;
            }
        };
        customerFeedbackTable.setRowHeight(60);

        //CustomerScrollPane
        customerScrollPane=new JScrollPane(customerFeedbackTable);
        customerScrollPane.setBounds(0,540,500,400);
        add(driverScrollPane);
        add(customerScrollPane);
        return true;
    }
    public boolean isCustomerFeedbackPresent(int feedbackNumber){
        try{
            query="select * from customerFeedback where feedbackno="+feedbackNumber;
            resultSet=TabServer.statement.executeQuery(query);
            if(!resultSet.next()){
                return false;
            }
            return true;
        }
        catch(Exception e){
            System.out.println("isCustomerFeedbackPresent"+e);
        }
        return true;
    }
    public boolean isDriverFeedbackPresent(int feedbackNumber){
        try{
            query="select * from driverFeedback where feedbackno="+feedbackNumber;
            resultSet=TabServer.statement.executeQuery(query);
            if(!resultSet.next()){
                return false;
            }
            return true;
        }
        catch(Exception e){
            System.out.println("isDriverFeedbackPresent"+e);
        }
        return true;
    }
    public boolean setCustomerFeedback(int row){
        try{
            query="select * from customerFeedback where feedbackno ="+Integer.parseInt(customerFeedbackTable.getValueAt(row,0).toString());
            resultSet=TabServer.statement.executeQuery(query);
            resultSet.next();
            customerDetailsResultSet = getCustomerDetails(resultSet.getString(2));
            customerDetailsResultSet.next();
            System.out.println(query);

            userTypeTextField.setText("Customer");
            feedbackNoTextField.setText(resultSet.getString(1));
            emailTextField.setText(resultSet.getString(2));
            mobileNumberTextField.setText(customerDetailsResultSet.getString(3));
            stateTextField.setText(customerDetailsResultSet.getString(6));
            feedbackTextArea.setText(resultSet.getString(3));
            if(resultSet.getString(4).trim().equals("-1")){
                ratingsTextField.setText("Not given");
            }
            else {
                ratingsTextField.setText(resultSet.getString(4));
            }
            nameTextField.setText(customerDetailsResultSet.getString(1).trim()+" "+customerDetailsResultSet.getString(2).trim());
            markAsReadTextButton.setEnabled(true);
        }
        catch(Exception e){
            System.out.println("setCustomerFeedback"+e);
        }
        return true;
    }
    public ResultSet getCustomerDetails(String email){
        try{
            query="select * from customer where email='"+email+"'";
            Statement statement=TabServer.connection.createStatement();
            return statement.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("getCustomerDetails()"+e);
        }
        return null;
    }
    public ResultSet getDriverDetails(String email){
        try{
            query="select * from driver where email='"+email+"'";
            Statement statement=TabServer.connection.createStatement();
            return statement.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("getDriverDetails()"+e);
        }
        return null;
    }
    public boolean setDriverFeedback(int row){
        try{
            query="select * from driverFeedback where feedbackno ="+Integer.parseInt(driverFeedbackTable.getValueAt(row,0).toString());
            resultSet=TabServer.statement.executeQuery(query);
            resultSet.next();

            driverDetailsResultSet = getDriverDetails(resultSet.getString(1));
            driverDetailsResultSet.next();

            userTypeTextField.setText("Driver");
            feedbackNoTextField.setText(resultSet.getString(4));
            emailTextField.setText(resultSet.getString(1));
            mobileNumberTextField.setText(driverDetailsResultSet.getString(11));
            stateTextField.setText(driverDetailsResultSet.getString(10));
            feedbackTextArea.setText(resultSet.getString(2));
            if(resultSet.getString(3).trim().equals("-1")){
                ratingsTextField.setText("Not given");
            }
            else {
                ratingsTextField.setText(resultSet.getString(3));
            }
            nameTextField.setText(driverDetailsResultSet.getString(1).trim()+" "+driverDetailsResultSet.getString(2).trim());
            markAsReadTextButton.setEnabled(true);
        }
        catch(Exception e){
            System.out.println("setDriverFeedback"+e);
        }
        return true;
    }
    public boolean deleteDriverEntry(int feedbackNumber){
        try{
            query="delete from driverFeedback where feedbackNo="+feedbackNumber;
            TabServer.statement.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("deleteDriverEntry()"+e);
        }
        return true;
    }
    public boolean deleteCustomerEntry(int feedbackNumber){
        try{
            query="delete from customerFeedback where feedbackno="+feedbackNumber;
            TabServer.statement.executeQuery(query);
            JOptionPane.showMessageDialog(null,"Feedback removed from feedback database");
        }
        catch(Exception e){
            System.out.println("customerDriverEntry()"+e);
        }
        return true;
    }
    public boolean stopEditableTextField(JTextField fld){
        fld.setEditable(false);
        return true;
    }
}