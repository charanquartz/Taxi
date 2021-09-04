import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class HomePage extends JFrame implements ActionListener
{
    JButton adminButton, customerButton, driverButton;
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
        login.setBackground(new Color(0,0,0,60));
        login.setBounds(0,0,1900,950);

        adminButton =new JButton("ADMIN");
        adminButton.setBounds(310,210,120,40);
        adminButton.setBackground(new Color(200,180,140));
        adminButton.addActionListener(this);
        login.add(adminButton);

        driverButton =new JButton("DRIVER");
        driverButton.setBounds(310,260,120,40);
        driverButton.setBackground(new Color(200,180,140));
        driverButton.addActionListener(this);
        login.add(driverButton);

        customerButton =new JButton("CUSTOMER");
        customerButton.setBounds(310,310,120,40);
        customerButton.setBackground(new Color(200,180,140));
        customerButton.addActionListener(this);
        login.add(customerButton);

        //frame
        setBounds(0,0,1900,1000);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //background
        ImageIcon background_image=new ImageIcon("C:\\Users\\vadha\\Downloads\\img.jpg");//change it according to your location

        Image img=background_image.getImage();
        Image temp_img=img.getScaledInstance(1900, 1000,Image.SCALE_SMOOTH);
        background_image=new ImageIcon(temp_img);
        JLabel background=new JLabel("", background_image,JLabel.CENTER);

        background.add(login);
        background.add(heading);
        background.setBounds(0,0,1900,1000);
        add(background);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object object=e.getSource();
        if(object== adminButton){
            admin.Main.main(new String[]{"admin"});
        }
        if(object== customerButton){
            customer.Main.main(new String[]{"customer"});
        }
        if(object== driverButton){
            try {
                driver.Main.main(new String[]{"driver"});
            } catch (Exception ex) {
                System.out.println("Home Page"+ex);
            }
        }
    }
    public static void main(String args[])
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (Exception e){
            System.out.println(e);
        }
        new HomePage();
    }
}