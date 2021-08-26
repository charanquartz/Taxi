package driver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChangePassword extends Frame implements WindowListener{
    TextField oldPasswordTextField, newPasswordTextField, confirmPasswordTextField;
    Label oldPasswordLabel, newPasswordLabel, confirmPasswordLabel;
    Button changePasswordButton;
    String s;
    ChangePassword(){
        setBackground(new Color(3, 252, 240));
        setBounds(10,10,1000,1000);
        setFont(new Font("Times New Roman",Font.BOLD,18));
        setLayout(null);
        oldPasswordLabel =new Label("Old Password : ");
        newPasswordLabel =new Label("New Password : ");
        confirmPasswordLabel =new Label("Confirm Password : ");
        oldPasswordTextField =new TextField();
        newPasswordTextField =new TextField();
        confirmPasswordTextField =new TextField();

        oldPasswordLabel.setBounds(20,50,180,50);
        newPasswordLabel.setBounds(20,100,180,50);
        confirmPasswordLabel.setBounds(20,150,180,50);
        oldPasswordTextField.setEchoChar('*');
        newPasswordTextField.setEchoChar('*');
        confirmPasswordTextField.setEchoChar('*');

        oldPasswordTextField.setBounds(200,50,180,50);
        newPasswordTextField.setBounds(200,100,180,50);
        confirmPasswordTextField.setBounds(200,150,180,50);

        changePasswordButton =new Button("Change");
        changePasswordButton.setBounds(200,200,180,50);
        changePasswordButton.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(TabServer.driver.getPass().equals(oldPasswordTextField.getText())){
                    if(TabServer.isValidPassword(newPasswordTextField.getText())){
                        if(newPasswordTextField.getText().equals(confirmPasswordTextField.getText())){
                            TabServer.driver.setPass(confirmPasswordTextField.getText());
                            clear();
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
        addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
    public void clear(){
        oldPasswordTextField.setText("");
        newPasswordTextField.setText("");
        confirmPasswordTextField.setText("");
    }
}
