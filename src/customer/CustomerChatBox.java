package customer;

import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CustomerChatBox extends JFrame implements ActionListener{
    Label historyLabel,newMessageLabel;
    static JTextArea historyTextArea,newMessageTextArea;
    static JButton sendButton;
    String message;
    static ServerSocket customerServerSocket;
    static Socket driverSocket;
    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    CustomerChatBox(){
        setVisible(true);
        setLayout(null);
        setBackground(Color.YELLOW);
        setBounds(0,0,1900,1000);

        //Label
        historyLabel=new Label("History : ");
        newMessageLabel=new Label("Enter message : ");

        //TextArea
        historyTextArea=new JTextArea();
        newMessageTextArea=new JTextArea();

        //Button
        sendButton=new JButton("Send");

        //SetBounds
        historyLabel.setBounds(0,0,200,50);
        historyTextArea.setBounds(210,10,1700,600);
        newMessageLabel.setBounds(0,620,200,50);
        newMessageTextArea.setBounds(210,620,1000,200);

        //Adding fields
        add(historyLabel);
        add(newMessageLabel);
        add(historyTextArea);
        add(newMessageTextArea);
        add(sendButton);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object obj=e.getSource();
        if(obj==sendButton){
            message=newMessageTextArea.getText().trim();
            if(message.equals("")){
                return;
            }
            try {
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            catch(Exception ex){
                System.out.println("CustomerChatBox()-->actionPerformed()"+e);
            }
        }
    }
    public static boolean establishConnection(){
        Thread readerThread=new Thread(){
            @Override
            public void run(){
                try{
                    while(true){
                        String receivedMessage=bufferedReader.readLine();
                        historyTextArea.setText(historyTextArea.getText()+"\nDriver : "+receivedMessage);
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        };
        try {
            customerServerSocket = new ServerSocket(TabServer.customer.getPortNumber());
            driverSocket=customerServerSocket.accept();
            bufferedReader=new BufferedReader(new InputStreamReader(driverSocket.getInputStream()));
            bufferedWriter=new BufferedWriter(new OutputStreamWriter(driverSocket.getOutputStream()));
            readerThread.start();
        }
        catch(Exception e){
            System.out.println("establishConnection()"+e);
        }
        return true;
    }
}
