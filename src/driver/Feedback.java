package driver;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import static java.awt.Color.WHITE;

public class Feedback extends JPanel{
    JTextField ratingfield;
    Label FeedbackLabel,ratingLabel;
    JTextArea feedBackTextArea;
    JSlider ratingComboBox;
    JButton submitButton;
    int count;
    Integer ratings;
    private String query;
    private ResultSet resultSet;
    Feedback(){
        setBounds(0,0,1900,1000);
        setVisible(true);
    setFont(new Font("Times New Roman",Font.BOLD,19));
        setLayout(null);
        setBackground(new Color(255, 167, 88));
        //Label
        FeedbackLabel=new Label("Enter your feedback : ");
        ratingLabel=new Label("Rate us : ");

        //Button
        submitButton =new JButton("Submit");

        //TextArea
        feedBackTextArea =new JTextArea();
         ratingfield=new JTextField();
        //JComboBox
        ratingComboBox=new JSlider(0,10,1);

        //SetBounds label
        FeedbackLabel.setBounds(10,10,250,60);
        ratingLabel.setBounds(10,590,250,60);

        //SetBounds textArea
        feedBackTextArea.setBounds(10,80,1000,500);
         ratingfield.setBounds(70,600,100,30);
         ratingfield.setEnabled(false);
        //setBounds button
        submitButton.setBounds(10,720,250,60);

        //SetBounds JSlider
        ratingComboBox.setMinorTickSpacing(0);
         ratingComboBox.setMajorTickSpacing(5);
         ratingComboBox.setPaintLabels(true);
         ratingComboBox.setPaintTicks(true);
         ratingComboBox.setBounds(10,650,200,60);
        //set border
        feedBackTextArea.setBorder(TabServer.bdr);
        submitButton.setBorder(TabServer.bdr);
        //focus event for text
        ratingfield.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(ratingfield.getText().equals(""))
                    ratingComboBox.setValue(5);
            }
        });
        //MouseEvent for button
        submitButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(feedBackTextArea.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter some feedback before submitting");
                    return;
                }
                dbInsert();
                JOptionPane.showMessageDialog(null,"Thanks for your feedback");
                ratingComboBox.setValue(0);
                ratingfield.setText("");
                feedBackTextArea.setText("");
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
        //state listen for rating combobox
        ratingComboBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                 ratings=ratingComboBox.getValue();
                ratingfield.setFont(new Font("Times New Roman", Font.BOLD, 19));
                ratingfield.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.BLACK, WHITE));
                ratingfield.setText(ratings.toString());
            }
        });
        //add components to panel
        add(FeedbackLabel);
        add(feedBackTextArea);
        add(submitButton);
        add(ratingComboBox);
        add(ratingLabel);
        add(ratingfield);
    }
    public boolean dbInsert(){
        try {
            count=1;
            //To find number of entries in driver feedback...
            query="select feedbackno from driverFeedback ";
            resultSet = TabServer.statement.executeQuery(query);
            if(resultSet.next()) {
                resultSet.last();
                count = resultSet.getInt(1)+1;
            }
            ratings=ratingComboBox.getValue();
            //Entering into query
            query="insert into driverFeedback values('"+TabServer.driver.getEmail()+"','"+feedBackTextArea.getText()+"',"+ratings+","+count+")";
            TabServer.statement.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("dbInsert()"+e);
        }
        return true;
    }
}
