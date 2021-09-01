package driver;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

public class Feedback extends JPanel {
    Label FeedbackLabel, ratingLabel;
    JTextArea feedBackTextArea;
    static JSlider ratingComboBox;
    Object[] arr=new Object[]{"Select",1,2,3,4,5};
    JButton submitButton;
    int count;
    Integer ratings;
    private String query;
    private ResultSet resultSet;

    Feedback() {
        setBounds(0, 0, 1900, 1000);
        setVisible(true);
        setFont(new Font("Times New Roman", Font.BOLD, 19));
        setLayout(null);
        setBackground(new Color(255, 167, 88));

        //Label
        FeedbackLabel = new Label("Enter your feedback : ");
        ratingLabel = new Label("Rate us : ");

        //Button
        submitButton = new JButton("Submit");

        //TextArea
        feedBackTextArea = new JTextArea();
        //JComboBox
        ratingComboBox = new JSlider(0, 10, 1);

        //SetBounds label
        FeedbackLabel.setBounds(10, 10, 250, 60);
        ratingLabel.setBounds(10, 590, 250, 60);

        //SetBounds textArea
        feedBackTextArea.setBounds(10, 80, 1000, 500);
        //setBounds button
        submitButton.setBounds(10, 660, 250, 60);

        //SetBounds JSlider
        ratingComboBox.setBounds(150, 590, 250, 60);
        ratingComboBox.setMinorTickSpacing(0);
        ratingComboBox.setMajorTickSpacing(5);
        ratingComboBox.setPaintLabels(true);
        ratingComboBox.setPaintTicks(true);
        //set border
        //feedBackTextArea.setBorder(TabServer.bdr);
        // submitButton.setBorder(TabServer.bdr);

        //MouseEvent for button
        submitButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (feedBackTextArea.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter some feedback before submitting");
                    return;
                }
                JOptionPane.showMessageDialog(null, "Thanks for your feedback");
                dbInsert();
                ratingComboBox.setValue(0);
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
                ratings = ratingComboBox.getValue();
            }
        });
        //add components to panel
        add(FeedbackLabel);
        add(feedBackTextArea);
        add(submitButton);
        add(ratingComboBox);
        add(ratingLabel);
    }
    public boolean dbInsert(){
        try {
            /*
             create table driverfeedback(email varchar(30) references driver(email),feedback clob,ratings int,feedbackNo int);
             */
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