package customer;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Feedback extends JPanel {
    private TextArea area_txta;
    private TextField txtFld1;
    private Label feedbackLabel, rlabel;
    private JSlider ratings;
    Integer rate;
    private Button submit_btn;
    private String s;

    public Feedback() {
        setVisible(true);
        setBackground(Color.yellow);
        setLayout(null);
        setBounds(0, 0, 1900, 1000);

        feedbackLabel = new Label("Enter feedback : ");
        feedbackLabel.setBounds(0, 0, 140, 50);

        rlabel = new Label("Ratings");
        rlabel.setBounds(20, 450, 100, 30);
        add(rlabel);
        ratings = new JSlider(1, 10, 1);
        ratings.setBounds(20, 500, 150, 50);
        ratings.setMinorTickSpacing(0);
        ratings.setMajorTickSpacing(5);
        ratings.setPaintTicks(true);
        ratings.setPaintLabels(true);
        txtFld1 = new TextField();
        txtFld1.setBounds(150, 450, 100, 30);
        txtFld1.setFont(new Font("Times New Roman", Font.BOLD, 19));
        txtFld1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtFld1.getText().equals("")) {
                    ratings.setValue(0);
                }

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        ratings.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                rate = ratings.getValue();
                txtFld1.setText(rate.toString());
            }
        });

        add(txtFld1);
        add(ratings);
        area_txta = new TextArea();
        area_txta.setBounds(150, 0, 1500, 440);
        area_txta.setText("FEED BACK FORM");
        area_txta.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (area_txta.getText().equals("FEED BACK FORM")) {
                    area_txta.setText("");
                }

            }

            public void focusLost(FocusEvent e) {
                if (area_txta.getText().isEmpty()) {
                    area_txta.setText("FEED BACK FORM");
                }
            }
        });

        add(area_txta);
        submit_btn = new Button("Submit");
        submit_btn.setBounds(25, 600, 100, 70);
        add(submit_btn);
        submit_btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (area_txta.getText().equals("FEED BACK FORM")) {
                    JOptionPane.showMessageDialog(new JFrame(), "please enter some feedback before submitting !");
                    return;
                } else {
                    dbinsert();
                    JOptionPane.showMessageDialog(new JFrame(), "Thanks for your feedback !");
                    area_txta.setText("");
                    ratings.setValue(0);
                    txtFld1.setText("");

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
        add(feedbackLabel);
    }


    public void dbinsert() {
        try {
			/*
				create table customerfeedback(email varchar(30) references customer(email),sno int primary key,feedback clob,ratings int);
			FUNCTION:(This function is used for generating a unique number from customer feedback table so that primary key constraint is not violated...)
				SQL> create or replace function getcustomerlastfeedbackno
  				2  return number
 				3  is
  				4  ans number;
  				5  r customerfeedback%rowtype;
  				6  cursor c is
  				7  select * from customerfeedback;
  				8  begin
			  	9  ans:=1;
 				10  open c;
 				11  loop
 				12  fetch c into r;
 				13  exit when c%notFound;
 				14  ans:=r.feedbackno;
 				15  end loop;
 				16  close c;
 				17  ans:=ans+1;
 				18  return ans;
 				19  end;
 				20  /
			PROCEDURE :(This procedure is used to insert a record into customerfeedback...)
				SQL> create or replace procedure insertCustomerFeedback(email varchar,feedback clob,ratings int) as
  				2  begin
  				3  insert into customerfeedback values(email,feedback,ratings,getcustomerlastfeedbackno());
  				4  end;
  				5  /
				*/
            String query = "{call insertCustomerFeedback(?,?,?)}";
            CallableStatement callableStatement = TabServer.connection.prepareCall(query);
            callableStatement.setString(1, TabServer.customer.getEmail());
            callableStatement.setString(2, area_txta.getText());
            callableStatement.setInt(3, Integer.parseInt(txtFld1.getText()));
            callableStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("dbinsert()" + e);
        }
    }

    public static void main(String[] args) {
        new Feedback();
    }
}