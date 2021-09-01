package admin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class ApproveDriver extends JPanel{
    JTextField stateTextField,drivingLicenseTextField,addressTextField,drivingExpTextField,fNameTextField,lNameTextField,carIDTextField,genderTextField,DOBTextField,cityTextField,mobileTextField,emailTextField,approvedTextField,availabilityTextField,xpTextField;
    Label stateLabel,drivingLicenseLabel,addressLabel,drivingExpLabel,driverDetailLabel,driversTableLabel,fNameLabel,lNameLabel,carIDLabel,genderLabel,DOBLabel,cityLabel,mobileLabel,emailLabel,approvedLabel,availabilityLabel,xpLabel;
    JButton approveDriverButton,refreshButton;
    JTable driversTable;
    JScrollPane driversTableScrollPane;
    Statement statement;
    Object[][] arr;
    String query;
    int rowClicked;
    ResultSet resultSet;
    int noOfApprovedDrivers;
    ApproveDriver(){
        setBackground(new Color(3, 252, 240));
        setBounds(0,0,1900,1000);
        setVisible(true);
        setLayout(null);
        setFont(TabServer.font);

        //Label
        driversTableLabel=new Label("Unapproved Drivers List : ");
        driverDetailLabel=new Label("Driver's Details : ");
        fNameLabel=new Label("First Name : ");
        lNameLabel=new Label("Last Name : ");
        carIDLabel=new Label("Car ID : ");
        genderLabel=new Label("Gender : ");
        DOBLabel=new Label("DOB : ");
        cityLabel=new Label("City : ");
        mobileLabel=new Label("Mobile number : ");
        emailLabel=new Label("Email ID : ");
        approvedLabel=new Label("Approved : ");
        availabilityLabel=new Label("Availability : ");
        xpLabel=new Label("XP gained : ");
        drivingLicenseLabel=new Label("License ID : ");
        drivingExpLabel=new Label("Driving experience : ");
        addressLabel=new Label("Address : ");
        stateLabel=new Label("State : ");

        //TextFields
        fNameTextField=new JTextField();
        lNameTextField=new JTextField();
        carIDTextField=new JTextField();
        genderTextField=new JTextField();
        DOBTextField=new JTextField();
        cityTextField=new JTextField();
        mobileTextField=new JTextField();
        availabilityTextField=new JTextField();
        xpTextField=new JTextField();
        emailTextField=new JTextField();
        approvedTextField=new JTextField();
        drivingLicenseTextField=new JTextField();
        drivingExpTextField=new JTextField();
        addressTextField=new JTextField();
        stateTextField=new JTextField();

        //Button
        approveDriverButton =new JButton("Approve Driver");
        refreshButton=new JButton("Refresh");

        //Table
        fillApprovedDriversDetailsAsArr();

        //Labels
        driversTableLabel.setBounds(0,0,300,60);
        driverDetailLabel.setBounds(820,0,200,60);
        fNameLabel.setBounds(820,70,200,60);
        lNameLabel.setBounds(820,140,200,60);
        carIDLabel.setBounds(820,210,200,60);
        genderLabel.setBounds(820,280,200,60);
        DOBLabel.setBounds(820,350,200,60);
        cityLabel.setBounds(820,420,200,60);
        addressLabel.setBounds(820,490,200,60);
        drivingExpLabel.setBounds(820,560,200,60);
        drivingLicenseLabel.setBounds(1240,70,200,60);
        stateLabel.setBounds(1240,140,200,60);
        mobileLabel.setBounds(1240,210,200,60);
        emailLabel.setBounds(1240,280,200,60);
        approvedLabel.setBounds(1240,350,200,60);
        availabilityLabel.setBounds(1240,420,200,60);
        xpLabel.setBounds(1240,490,200,60);

        //TextFields
        fNameTextField.setBounds(1030,70,200,60);
        lNameTextField.setBounds(1030,140,200,60);
        carIDTextField.setBounds(1030,210,200,60);
        genderTextField.setBounds(1030,280,200,60);
        DOBTextField.setBounds(1030,350,200,60);
        cityTextField.setBounds(1030,420,200,60);
        addressTextField.setBounds(1030,490,200,60);
        drivingExpTextField.setBounds(1030,560,200,60);
        drivingLicenseTextField.setBounds(1440,70,200,60);
        stateTextField.setBounds(1440,140,200,60);
        mobileTextField.setBounds(1440,210,200,60);
        emailTextField.setBounds(1440,280,200,60);
        approvedTextField.setBounds(1440,350,200,60);
        availabilityTextField.setBounds(1440,420,200,60);
        xpTextField.setBounds(1440,490,200,60);
        fNameTextField.setEditable(false);
        lNameTextField.setEditable(false);
        carIDTextField.setEditable(false);
        genderTextField.setEditable(false);
        DOBTextField.setEditable(false);
        cityTextField.setEditable(false);
        addressTextField.setEditable(false);
        drivingExpTextField.setEditable(false);
        drivingLicenseTextField.setEditable(false);
        stateTextField.setEditable(false);
        mobileTextField.setEditable(false);
        emailTextField.setEditable(false);
        approvedTextField.setEditable(false);
        availabilityTextField.setEditable(false);
        xpTextField.setEditable(false);

        //Button
        refreshButton.setBounds(1240,560,190,60);
        approveDriverButton.setBounds(1440,560,200,60);
        approveDriverButton.setEnabled(false);

        //Button
        refreshButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fillApprovedDriversDetailsAsArr();
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
        approveDriverButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!(approveDriverButton.isEnabled())){
                    return;
                }
                approveDriver(emailTextField.getText().trim());
                JOptionPane.showMessageDialog(null,"Driver approval successfull");
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

        driversTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rowClicked=driversTable.getSelectedRow();
                if(rowClicked>=driversTable.getRowCount()){
                    JOptionPane.showMessageDialog(null,"Error while fetching information.\nKindly refresh or restart the appliction for proper functioning...");
                    return;
                }
                fillDetails(driversTable.getValueAt(rowClicked,4).toString());
                approveDriverButton.setEnabled(true);
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

        //Label
        add(fNameLabel);
        add(lNameLabel);
        add(carIDLabel);
        add(genderLabel);
        add(DOBLabel);
        add(cityLabel);
        add(addressLabel);
        add(drivingExpLabel);
        add(drivingLicenseLabel);
        add(stateLabel);
        add(mobileLabel);
        add(emailLabel);
        add(approvedLabel);
        add(availabilityLabel);
        add(xpLabel);

        //TextFields
        add(fNameTextField);
        add(lNameTextField);
        add(carIDTextField);
        add(genderTextField);
        add(DOBTextField);
        add(cityTextField);
        add(drivingLicenseTextField);
        add(drivingExpLabel);
        add(stateTextField);
        add(mobileTextField);
        add(emailTextField);
        add(approvedTextField);
        add(addressTextField);
        add(drivingExpTextField);
        add(availabilityTextField);
        add(xpTextField);

        //Button
        add(approveDriverButton);
        add(refreshButton);

        add(driverDetailLabel);
        add(driversTableScrollPane);
        add(driversTableLabel);
    }
    public int getNoOfUnApprovedDrivers(){
        int n=0;
        try {
            query="select * from driver where approved='false'";
            statement = TabServer.connection.createStatement();
            resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                n++;
            }
        }
        catch(Exception e){
            System.out.println("getNoOfUnApprovedDrivers()"+e);
        }
        return n;
    }
    public void fillApprovedDriversDetailsAsArr(){
        try{
            int size= getNoOfUnApprovedDrivers();
            arr=new Object[getNoOfUnApprovedDrivers()][5];
            query="select * from driver where approved ='false'";
            statement=TabServer.connection.createStatement();
            resultSet=statement.executeQuery(query);
            resultSet.next();
            for(int i=0;i<size;i++){
                arr[i][0]=i+1;
                arr[i][1]=resultSet.getString(1).trim()+" "+resultSet.getString(2).trim();
                arr[i][2]=resultSet.getString(10).trim();
                arr[i][3]=resultSet.getString(11).trim();
                arr[i][4]=resultSet.getString(12).trim();
                resultSet.next();
            }
            driversTable=new JTable(arr,new Object[]{"SNO.","Name","State","Mobile Number","Email"});
            driversTableScrollPane=new JScrollPane(driversTable);
            driversTableScrollPane.setBounds(0,70,800,800);
            driversTable.setRowHeight(60);
            add(driversTableScrollPane);
        }
        catch(Exception e){
            System.out.println("fillApprovedDriverDetailsAsArr()->ApproveDriver"+e);
        }
    }
    public void approveDriver(String email){
        try{
            query="update driver set approved='true' where email='"+email+"'";
            statement=TabServer.connection.createStatement();
            statement.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("approveDriver()"+e);
        }
    }
    public void clearFields(){
        drivingExpTextField.setText("");
        fNameTextField.setText("");
        lNameTextField.setText("");
        carIDTextField.setText("");
        genderTextField.setText("");
        DOBTextField.setText("");
        cityTextField.setText("");
        addressTextField.setText("");
        drivingExpTextField.setText("");
        emailTextField.setText("");
        drivingLicenseTextField.setText("");
        stateTextField.setText("");
        mobileTextField.setText("");
        approvedTextField.setText("");
        availabilityTextField.setText("");
        xpTextField.setText("");
    }
    public boolean fillDetails(String email){
        resultSet=getDriverResultSet(email);
        try {
            resultSet.next();
            fNameTextField.setText(resultSet.getString(1));
            lNameTextField.setText(resultSet.getString(2));
            carIDTextField.setText(resultSet.getString(3));
            genderTextField.setText(resultSet.getString(4));
            DOBTextField.setText(resultSet.getString(5).substring(0,10));
            cityTextField.setText(resultSet.getString(6));
            addressTextField.setText(resultSet.getString(7));
            drivingExpTextField.setText(resultSet.getString(8));
            drivingLicenseTextField.setText(resultSet.getString(9));
            stateTextField.setText(resultSet.getString(10));
            mobileTextField.setText(resultSet.getString(11));
            emailTextField.setText(resultSet.getString(12));
            approvedTextField.setText(resultSet.getString(14));
            availabilityTextField.setText(resultSet.getString(15));
            xpTextField.setText(resultSet.getString(16));
            approveDriverButton.setEnabled(true);
        }
        catch (Exception e){
            System.out.println("fillDetails()"+e);
        }
        return true;
    }
    public ResultSet getDriverResultSet(String email){
        try{
            query="select * from driver where email='"+email+"'";
            statement=TabServer.connection.createStatement();
            resultSet=statement.executeQuery(query);
            return resultSet;
        }
        catch(Exception e){
            System.out.println("getDriverResultSet()"+e);
        }
        return null;
    }
}
