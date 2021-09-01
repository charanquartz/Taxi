import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import driver.*;
class HomePage extends JFrame implements ActionListener
{
    JButton admin,customer,driver;
    HomePage()
    {
        //font
        Font f=new Font("Serif",Font.BOLD,30);

        //header
        JPanel heading=new JPanel();
        heading.setBackground(new Color(0,0,0,80));

        heading.setBounds(0,0,900,100);
        JLabel name=new JLabel("HOME PAGE");
        name.setForeground(Color.WHITE);
        name.setFont(f);
        heading.add(name);

        //login panel
        JPanel login=new JPanel();
        login.setLayout(null);
        login.setSize(400,350);
        login.setBackground(new Color(0,0,0,60));
        login.setBounds(0,0,900,550);

        admin=new JButton("ADMIN");
        admin.setBounds(310,210,120,40);
        admin.setBackground(new Color(200,180,140));
        admin.addActionListener(this);
        login.add(admin);

        driver=new JButton("DRIVER");
        driver.setBounds(310,260,120,40);
        driver.setBackground(new Color(200,180,140));
        driver.addActionListener(this);
        login.add(driver);

        customer=new JButton("CUSTOMER");
        customer.setBounds(310,310,120,40);
        customer.setBackground(new Color(200,180,140));
        customer.addActionListener(this);
        login.add(customer);

        //frame
        setSize(900,600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //background
        ImageIcon background_image=new ImageIcon("C:\\Users\\vadha\\Downloads\\img2.jpeg");

        Image img=background_image.getImage();
        Image temp_img=img.getScaledInstance(900, 600,Image.SCALE_SMOOTH);
        background_image=new ImageIcon(temp_img);
        JLabel background=new JLabel("", background_image,JLabel.CENTER);

        background.add(login);
        background.add(heading);
        background.setBounds(0,0,900,600);
        add(background);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object object=e.getSource();
        if(object==admin){
            new admin.Main();
        }
        if(object==customer){
            new customer.Main();
        }
        if(object==driver){
            new driverMain();
        }
    }
    public static void main(String args[])
    {
        new HomePage();
    }
}