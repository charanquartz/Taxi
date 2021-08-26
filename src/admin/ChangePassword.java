package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ChangePassword extends JPanel{
    JTextField oldPasswordTextField, newPasswordTextField, confirmPasswordTextField;
    Label oldPasswordLabel, newPasswordLabel, confirmPasswordLabel;
    JButton changePasswordButton;
    String query;
    ChangePassword(){
        setBackground(new Color(3, 252, 240));
        setBounds(10,10,1000,1000);
        setFont(new Font("Times New Roman",Font.BOLD,18));
        setLayout(null);
        oldPasswordLabel =new Label("Old Password : ");
        newPasswordLabel =new Label("New Password : ");
        confirmPasswordLabel =new Label("Confirm Password : ");
        oldPasswordTextField =new JTextField();
        newPasswordTextField =new JTextField();
        confirmPasswordTextField =new JTextField();

        oldPasswordLabel.setBounds(0,20,180,60);
        newPasswordLabel.setBounds(0,90,180,60);
        confirmPasswordLabel.setBounds(0,160,180,60);

        oldPasswordTextField.setBounds(190,20,180,60);
        newPasswordTextField.setBounds(190,90,180,60);
        confirmPasswordTextField.setBounds(190,160,180,60);

        changePasswordButton =new JButton("Change");
        changePasswordButton.setBounds(190,230,180,60);
        changePasswordButton.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(TabServer.admin.getPassword().equals(oldPasswordTextField.getText())){
                    if(TabServer.isValidPassword(newPasswordTextField.getText())){
                        if(newPasswordTextField.getText().equals(confirmPasswordTextField.getText())){
                            TabServer.admin.setPassword(confirmPasswordTextField.getText());
                            clear();
                            dbUpdate();
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Passwords do no match");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Enter a strong password(Min 8 character,atleast 1 number,atleast one special character");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Wrong password");
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
        add(oldPasswordLabel);
        add(newPasswordLabel);
        add(oldPasswordTextField);
        add(newPasswordTextField);
        add(changePasswordButton);
        add(confirmPasswordTextField);
        add(confirmPasswordLabel);
        setVisible(true);
    }
    public void clear(){
        oldPasswordTextField.setText("");
        newPasswordTextField.setText("");
        confirmPasswordTextField.setText("");
    }
    public boolean dbUpdate(){
        query="update admin set password='"+TabServer.admin.getPassword()+"' where email='"+TabServer.admin.getEmail()+"'";
        try {
            TabServer.statement.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("dbUpdate"+e);
        }
        return true;
    }
}
