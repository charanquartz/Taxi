import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
public class CustomerChatBox extends Frame implements ActionListener,Runnable 
{
	Socket s;
	BufferedReader br;
	BufferedWriter bw;
	TextField text;
	Button button1,button2;
	List list;
      Label l1;
	public static void main(String arg[])
	{
		new CustomerChatBox("Customer:");
		
	}
	public void run()
	{
		try
              {
                  s.setSoTimeout(1);
              }
              catch(Exception e){}
              
		while (true)
		{
			try
                      {
                          list.addItem(br.readLine());
			}
                      catch (Exception h){}
		}
	}
	
	public CustomerChatBox(String m)
	{
		super(m);
		setSize(450,500);
		setLocation(500,0);

		this.setLayout(null);

              l1=new Label("Customer");
              l1.setFont(new Font("verdana",Font.BOLD,23));

              
		button1 = new Button("Send");
		button2 = new Button("Exit");
		button1.addActionListener(this);
		button2.addActionListener(this);
		list = new List();
		text = new TextField();

              l1.setBounds(100,50,300,30);
              list.setBounds(100,100,200,200);
              text.setBounds(100,320,200,30);
              button1.setBounds(100,400,80,30);
              button2.setBounds(220,400,80,30);

              add(l1);
		add(list);
		add(button1);
		add(button2);		
		add(text);
              setBackground(Color.pink);

		setVisible(true);
		try{
			s = new Socket("127.0.0.1",100);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			Thread th;
			th = new Thread(this);
			th.start();
			
		}catch(Exception e){}
		
	}
	public void actionPerformed(ActionEvent e)
	{
		 if (e.getSource().equals(button2))
               {
			 System.exit(0);
               }
		 else
               {
                  try{
                      bw.write(text.getText());
			          bw.newLine();
                      bw.flush();			
                     }
                     catch(Exception m){}
		 }
				  
	}
	
}
