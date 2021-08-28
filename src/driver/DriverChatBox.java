package driver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.*;
public class DriverChatBox extends JFrame{
    Label historyLabel,enterNewMessageLabel;
    static JTextArea historyTextArea,newMessageTextArea;
    JButton sendButton;
    static BufferedReader bf;
    static Socket customerSocket;
    static int customerPortNumber;
    static String customerName;
    DriverChatBox(String name,int PortNumber){
        setBounds(0,0,1900,1000);
        setVisible(true);
        setLayout(null);
        setBackground(new Color(216, 115, 255));
        setFont(new Font("Times New Roman",Font.BOLD,25));

        //Label
        historyLabel=new Label("History : ");
        enterNewMessageLabel=new Label("Enter new Message : ");
        historyLabel.setBounds(0,0,200,60);
        enterNewMessageLabel.setBounds(0,780,200,60);
        add(enterNewMessageLabel);
        add(historyLabel);

        //Button
        sendButton=new JButton("Send");
        sendButton.setBounds(1610,850,200,60);
        add(sendButton);
        sendButton.setBorder(TabServer.bdr);

        //Text Area
        historyTextArea=new JTextArea();
        newMessageTextArea=new JTextArea();
        historyTextArea.setBounds(0,70,1600,700);
        newMessageTextArea.setBounds(0,850,1600,100);
        add(historyTextArea);
        add(newMessageTextArea);
        historyTextArea.setBorder(TabServer.bdr);
        newMessageTextArea.setBorder(TabServer.bdr);

        customerPortNumber=PortNumber;
        customerName=name;

        //Networking

        //Establishing connection with customer...
        Thread thread=new Thread(){
            @Override
            public void run(){
                try {
                    customerSocket = new Socket("127.0.0.1",customerPortNumber);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        };
        thread.start();
        try {
            thread.join();
        }
        catch(Exception e){
            System.out.println(e);
        }

        Thread readerThread=new Thread(){
            @Override
            public void run(){
                while(true){
                    try {
                        historyTextArea.setText(historyTextArea.getText()+"\n"+customerName+" : "+new DataInputStream(customerSocket.getInputStream()).readUTF());
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                }
            }
        };
        Thread writerThread=new Thread(){
            public void run() {
                while (true) {
                    try {
                        new DataOutputStream(customerSocket.getOutputStream()).writeUTF(newMessageTextArea.getText());
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        };
        readerThread.start();

        //Mouseevent for button
        sendButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writerThread.start();
                try {
                    writerThread.join();
                }
                catch(Exception k){
                    System.out.println(k);
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
    }
}
