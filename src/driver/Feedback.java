package driver;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Event.*;
import java.awt.*;
public class Feedback extends JPanel{
    Label lbl1;
    JTextArea txtAr1;
    JButton btn1;
    Border bdr;
    Feedback(){
        setBounds(0,0,1900,1000);
        setVisible(true);
        setFont(new Font("Times New Roman",Font.BOLD,19));
        setLayout(null);
        setBackground(new Color(3, 252, 240));

        lbl1=new Label("Enter your feedback : ");
        txtAr1=new JTextArea();
        btn1=new JButton("Submit");

        lbl1.setBounds(10,10,250,60);
        txtAr1.setBounds(10,80,1000,500);

        btn1.setBounds(750,590,250,60);
        bdr=BorderFactory.createLineBorder(Color.BLACK,5);
        txtAr1.setBorder(bdr);
        btn1.setBorder(bdr);

        add(lbl1);
        add(txtAr1);
        add(btn1);
    }
}
