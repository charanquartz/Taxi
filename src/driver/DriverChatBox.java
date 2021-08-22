package driver;
import javax.swing.*;
import java.awt.*;
import java.io.*;
public class DriverChatBox extends JFrame{
    Label historyLabel,enterNewMessageLabel;
    JTextArea historyTextArea,newMessageTextArea;
    JButton sendButton;
    DriverChatBox(){
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
    }
}
