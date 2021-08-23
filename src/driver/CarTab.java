package driver;
import javafx.scene.control.Tab;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class CarTab extends JFrame{
    private Label carIDLabel, companyLabel, modelLabel, capacityLabel, ACLabel, fareLabel;
    private JTextField carIDTextField, companyTextField, modelTextField, capacityTextField, ACTextField, fareTextField;
    private JButton addButton;
    private String query;
    private ResultSet resultSet ;
    private Car car;
    CarTab(){
        setBackground(new Color(3, 252, 240));
        setBounds(0,0,1900,1000);
        setFont(new Font("Times New Roman",Font.BOLD,19));
        setLayout(null);

        //Label
        carIDLabel =new Label("Car ID : ");
        companyLabel =new Label("Company : ");
        modelLabel =new Label("Model : ");
        capacityLabel =new Label("Capacity : ");
        ACLabel =new Label("AC : ");
        fareLabel =new Label("Fare/KM: ");

        //TextField
        carIDTextField =new JTextField();
        companyTextField =new JTextField();
        modelTextField =new JTextField();
        capacityTextField =new JTextField();
        ACTextField =new JTextField();
        fareTextField =new JTextField();

        //Button
        addButton =new JButton("ADD");

        //set bounds for label
        carIDLabel.setBounds(20,50,250,60);
        companyLabel.setBounds(20,120,250,60);
        modelLabel.setBounds(20,190,250,60);
        capacityLabel.setBounds(20,260,250,60);
        ACLabel.setBounds(20,330,250,60);
        fareLabel.setBounds(20,400,250,60);

        //Set Bounds for textFields
        carIDTextField.setBounds(280,50,250,60);
        companyTextField.setBounds(280,120,250,60);
        modelTextField.setBounds(280,190,250,60);
        capacityTextField.setBounds(280,260,250,60);
        ACTextField.setBounds(280,330,250,60);
        fareTextField.setBounds(280,400,250,60);

        //set bounds
        addButton.setBounds(280,470,250,60);

        //Adding Labels
        add(carIDLabel);
        add(companyLabel);
        add(modelLabel);
        add(capacityLabel);
        add(ACLabel);
        add(fareLabel);

        car=new Car();

        //Adding labels
        add(carIDTextField);
        add(companyTextField);
        add(modelTextField);
        add(capacityTextField);
        add(ACTextField);
        add(fareTextField);

        //Adding buttons
        add(addButton);

        //Window listener
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        addButton.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(validData()){
                    if(!alreadyPresent()){
                        insertCar();
                        JOptionPane.showMessageDialog(null,"Car added successfully....");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Car already added...");
                    }
                }
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
        setVisible(true);
    }
    public boolean validData(){
        //Car ID
        if(carIDTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your Car ID");
            return false;
        }
        if(!TabServer.isValidID(carIDTextField.getText()) ){
            JOptionPane.showMessageDialog(null,"Please enter valid car ID");
            return false;
        }
        car.setCarID(carIDTextField.getText());
        //Company
        if(companyTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter the company name of your car");
            return false;
        }
        if(!TabServer.isValidName(companyTextField.getText())){
            JOptionPane.showMessageDialog(null,"Please enter a valid company name");
            return false;
        }
        car.setCompany(companyTextField.getText());
        //Model
        if(modelTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter the model name of your car");
            return false;
        }
        if(!TabServer.isValidID(modelTextField.getText())){
            JOptionPane.showMessageDialog(null,"Please enter a valid model name");
            return false;
        }
        car.setModel(modelTextField.getText());
        //Capacity
        if(capacityTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your car's capacity");
            return false;
        }
        if(!TabServer.isValidNumber(capacityTextField.getText())){
            JOptionPane.showMessageDialog(null,"Please enter valid capacity of your car");
            return false;
        }
        car.setCapacity(Integer.parseInt(capacityTextField.getText()));
        //Fare
        if(fareTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter your car's fare per KM");
            return false;
        }
        if(!TabServer.isValidNumber(fareTextField.getText())){
            JOptionPane.showMessageDialog(null,"Please enter valid fare for your car");
            return false;
        }
        car.setFarePerKM(Integer.parseInt(fareTextField.getText()));
        car.setAC(ACTextField.getText());
        return true;
    }
    public boolean alreadyPresent(){
        query="select * from car where carid='"+carIDTextField.getText()+"'";
        try {
            resultSet = TabServer.statement.executeQuery(query);
            if(resultSet.next()){
                return true;
            }
        }
        catch(Exception e){
            System.out.println("alreadyPresent()"+e);
        }
        return false;
    }
    public boolean insertCar(){
        try{
            query="insert into car values('"+TabServer.driver.getEmail()+"','"+car.getCarID()+"','"+car.getCompany()+"','"+car.getModel()+"',"+car.getCapacity()+",'"+car.getAC()+"',"+car.getFarePerKM()+")";
            TabServer.statement.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("InsertCar()"+e);
        }
        return true;
    }
}
