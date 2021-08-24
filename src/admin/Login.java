package admin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JPanel{
    JTextField txtFld1;
    JPasswordField passwordTextField;
    Label lbl1,lbl2,lbl3;
    JButton btn1;
    String query;
    ResultSet resultSet;
    public Login(){
        setBackground(new Color(3, 252, 240));
        setLayout(null);
        setVisible(true);
        setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        setBounds(0,0,1000,1900);

        //Label
        lbl1=new Label("Email/Phone Number : ");
        lbl2=new Label("Password : ");
        lbl3=new Label("Forgot password");

        //TextField
        txtFld1=new JTextField();
        passwordTextField =new JPasswordField();

        //Button
        btn1=new JButton("LOGIN");

        lbl1.setBounds(10,10,250,70);
        lbl2.setBounds(10,80,250,70);

        txtFld1.setBounds(260,10,250,70);
        passwordTextField.setBounds(260,80,250,70);
        passwordTextField.setEchoChar('*');
        passwordTextField.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!TabServer.tabs.isEnabledAt(0)){
                    JOptionPane.showMessageDialog(null,"Already logged in...");
                    return;
                }
                login(txtFld1.getText(), passwordTextField.getText());
            }
        });

        btn1.setBounds(260,160,250,60);
        btn1.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!TabServer.tabs.isEnabledAt(0)){
                    JOptionPane.showMessageDialog(null,"Already logged in...");
                    return;
                }
                login(txtFld1.getText(), passwordTextField.getText());
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

        add(lbl1);
        add(lbl2);
        add(txtFld1);
        add(passwordTextField);
        add(btn1);
    }
    public boolean login(String email,String password){
        query="select * from admin where email='"+email+"'";
        try {
            resultSet=TabServer.statement.executeQuery(query);
            if(!resultSet.next()){
                JOptionPane.showMessageDialog(null,"Please enter correct email");
                return false;
            }
            if(!resultSet.getString(2).equals(password)){
                JOptionPane.showMessageDialog(null,"Please enter correct password...");
                return false;
            }
            JOptionPane.showMessageDialog(null,"Login success...");
            TabServer.tabs.setEnabledAt(1,true);
            TabServer.tabs.setEnabledAt(2,true);
            TabServer.tabs.setEnabledAt(3,true);
            TabServer.tabs.setEnabledAt(4,true);
            TabServer.tabs.setEnabledAt(0,false);
            TabServer.admin.setEmail(txtFld1.getText());
            TabServer.admin.setPassword(passwordTextField.getText());
        }
        catch(Exception e){
            System.out.println("login()"+e);
        }
        return true;
    }
}