package driver;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CarTab extends Frame{
    Label lbl1,lbl2,lbl3,lbl4,lbl5,lbl6;
    JTextField txtFld1,txtFld2,txtFld3,txtFld4,txtFld5,txtFld6;
    JButton btn1;
    CarTab(){
        setBackground(new Color(3, 252, 240));
        setBounds(0,0,1900,1000);
        setFont(new Font("Times New Roman",Font.BOLD,19));
        setLayout(null);

        //Label
        lbl1=new Label("Car ID : ");
        lbl2=new Label("Company : ");
        lbl3=new Label("Model : ");
        lbl4=new Label("Capacity : ");
        lbl5=new Label("AC : ");
        lbl6=new Label("Fare/KM: ");

        //TextField
        txtFld1=new JTextField();
        txtFld2=new JTextField();
        txtFld3=new JTextField();
        txtFld4=new JTextField();
        txtFld5=new JTextField();
        txtFld6=new JTextField();

        //Button
        btn1=new JButton("ADD");

        //set bounds for label
        lbl1.setBounds(20,50,250,60);
        lbl2.setBounds(20,120,250,60);
        lbl3.setBounds(20,190,250,60);
        lbl4.setBounds(20,260,250,60);
        lbl5.setBounds(20,330,250,60);
        lbl6.setBounds(20,400,250,60);

        //Set Bounds for textFields
        txtFld1.setBounds(280,50,250,60);
        txtFld2.setBounds(280,120,250,60);
        txtFld3.setBounds(280,190,250,60);
        txtFld4.setBounds(280,260,250,60);
        txtFld5.setBounds(280,330,250,60);
        txtFld6.setBounds(280,400,250,60);

        //set bounds
        btn1.setBounds(280,470,250,60);

        //Adding Labels
        add(lbl1);
        add(lbl2);
        add(lbl3);
        add(lbl4);
        add(lbl5);
        add(lbl6);

        //Adding labels
        add(txtFld1);
        add(txtFld2);
        add(txtFld3);
        add(txtFld4);
        add(txtFld5);
        add(txtFld6);

        //Adding buttons
        add(btn1);

        //Window listener
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        btn1.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(validData()){
                    if(!alreadyPresent()){
                        JOptionPane.showMessageDialog(null,"Car added successfully....");
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
        return true;
    }
    public boolean alreadyPresent(){
        return false;
    }
}
