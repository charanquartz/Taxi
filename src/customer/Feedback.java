package customer;
import java.awt.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static java.awt.Color.WHITE;
public class Feedback extends JFrame
{
	private TextArea area_txta;
	private TextField txtFld,txtFld1;
	private Label elabel,rlabel;
	private JSlider ratings;
	Integer rate;
	private Button submit_btn;
	public Feedback() {
		setVisible(true);
		setBackground(Color.GRAY);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\GOBAL\\Downloads\\image.JPG")));
		setLayout(null);
		setBounds(0,0,1900,1000);
		elabel = new Label("Email");
		elabel.setBounds(20, 100, 50, 30);
		add(elabel);
		rlabel = new Label("Ratings");
		rlabel.setBounds(20, 450, 100, 30);
		add(rlabel);
		ratings = new JSlider(0, 10, 1);
		ratings.setBounds(20, 500, 150, 50);
		ratings.setMinorTickSpacing(0);
		ratings.setMajorTickSpacing(5);
		ratings.setPaintTicks(true);
		ratings.setPaintLabels(true);
		txtFld1=new TextField();
		txtFld1.setBounds(150,450,100,30);
		txtFld1.setFont(new Font("Times New Roman",Font.BOLD,19));
		txtFld1.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtFld1.getText().equals("")){
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
				rate=ratings.getValue();
				txtFld1.setText(rate.toString());
			}
		});
		txtFld = new TextField();
		txtFld.setBounds(100, 100, 150, 30);
		txtFld.setText("Email...");
		txtFld.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (txtFld.getText().equals("Email...")) {
					txtFld.setText("");

				}

			}

			public void focusLost(FocusEvent e) {
				if (txtFld.getText().isEmpty()) {
					txtFld.setText("Email...");
				}
			}
		});
		add(txtFld);
		add(txtFld1);
		add(ratings);
		area_txta = new TextArea();
		area_txta.setBounds(20, 150, 475, 280);
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
				if (txtFld.getText().equals("Email..."))
					JOptionPane.showMessageDialog(new JFrame(), "please enter email");
				else {
					if (area_txta.getText().equals("FEED BACK FORM")) {
						JOptionPane.showMessageDialog(new JFrame(), "please enter some feedback before submitting !");
						return;
					} else {
						dbinsert();
						JOptionPane.showMessageDialog(new JFrame(), "Thanks for your feedback !");
						txtFld.setText("");
						txtFld1.setText("");
						area_txta.setText("");
					}
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


	public void dbinsert(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "system", "1234");
			String query = "insert into customerfeed values(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, txtFld.getText());
			pstmt.setString(2, area_txta.getText());
			pstmt.setString(3,txtFld1.getText());
			pstmt.executeUpdate();
			con.setAutoCommit(true);
		}
		catch (Exception e){
			System.out.println("dbinsert()"+e);
		}
	}
	public static void main(String[]args) {
		new Feedback();
	}
}

