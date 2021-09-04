package customer;

import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CustomerChatBox extends JFrame{
    Label historyLabel,newMessageLabel;
    static boolean isConnected=false;
    static JTextArea historyTextArea,newMessageTextArea;
    static JButton sendButton;
    static String message;
    static ServerSocket customerServerSocket;
    static Socket driverSocket;
    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    CustomerChatBox(Integer port){
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
        sendButton.setBounds(1220,620,200,50);

        //Adding fields
        add(historyLabel);
        add(newMessageLabel);
        add(historyTextArea);
        add(newMessageTextArea);
        add(sendButton);

        try {
            customerServerSocket = new ServerSocket(port);
            driverSocket = customerServerSocket.accept();
            bufferedReader = new BufferedReader(new InputStreamReader(driverSocket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(driverSocket.getOutputStream()));
            isConnected=true;
        }
        catch(Exception e){
            System.out.println("establishConnection()"+e);
        }
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
        readerThread.start();
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isConnected){
                    JOptionPane.showMessageDialog(null,"Driver is offline");
                    return;
                }
                message=newMessageTextArea.getText().trim();
                if(message.equals("")){
                    return;
                }
                try {
                    bufferedWriter.write(message);
                    historyTextArea.setText(historyTextArea.getText()+"\nYOU : "+message);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    newMessageTextArea.setText("");
                }
                catch(Exception ex){
                    System.out.println("CustomerChatBox()-->actionPerformed()"+e);
                }
            }
        });
    }
}
