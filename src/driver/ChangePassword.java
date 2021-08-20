package driver;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ChangePassword extends Frame implements WindowListener{
    TextField txtFld1,txtFld2,txtFld3;
    Label lbl1,lbl2,lbl3;
    Button btn1;
    String s;
    ChangePassword(){
        setBackground(new Color(3, 252, 240));
        setBounds(10,10,1000,1000);
        setFont(new Font("Times New Roman",Font.BOLD,18));
        setLayout(null);
        lbl1=new Label("Old Password : ");
        lbl2=new Label("New Password : ");
        lbl3=new Label("Confirm Password : ");
        txtFld1=new TextField();
        txtFld2=new TextField();
        txtFld3=new TextField();

        lbl1.setBounds(20,50,180,50);
        lbl2.setBounds(20,100,180,50);
        lbl3.setBounds(20,150,180,50);
        txtFld1.setEchoChar('*');
        txtFld2.setEchoChar('*');
        txtFld3.setEchoChar('*');

        txtFld1.setBounds(200,50,180,50);
        txtFld2.setBounds(200,100,180,50);
        txtFld3.setBounds(200,150,180,50);

        btn1=new Button("Update");
        btn1.setBounds(200,200,180,50);
        btn1.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {

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
        add(txtFld2);
        add(btn1);
        add(txtFld3);
        add(lbl3);
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
        txtFld1.setText("");
        txtFld2.setText("");
        txtFld3.setText("");
    }
}
