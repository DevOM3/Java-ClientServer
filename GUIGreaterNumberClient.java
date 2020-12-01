import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class GUIGreaterNumberClient extends JFrame implements ActionListener {
	JTextField no1;
	JTextField no2;
	JTextField no3;
	JTextField greater;

	GUIGreaterNumberClient() {
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		JLabel n1 = new JLabel("First Number"); 
		no1 = new JTextField(15);
		JLabel n2 = new JLabel("Second Number"); 
		no2 = new JTextField(15);
		JLabel n3 = new JLabel("Third Number"); 
		no3 = new JTextField(15);
		JButton jButton = new JButton("Calculate");
		jButton.addActionListener(this);

		
		JLabel great = new JLabel("\nGreater Number "); 
		greater = new JTextField(15);
		greater.setEditable(false);

		container.add(n1);
		container.add(no1);
		container.add(n2);
		container.add(no2);
		container.add(n3);
		container.add(no3);
		container.add(jButton);
		container.add(great);
		container.add(greater);
	}

	public void actionPerformed(ActionEvent ae) {
		if(!no1.getText().equals("") && !no1.getText().equals("")) {
			try{
				calculate();
			} catch(Exception e) {}
		}
	}

	public void calculate() throws Exception{
		Socket socket = new Socket("localhost", 100);
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

			dos.writeUTF(no1.getText() + "," + no2.getText() + "," + no3.getText());
			
			String greaterNumber = (String)dis.readUTF();

			no1.setText("");
			no2.setText("");
			no3.setText("");
			greater.setText(greaterNumber);
	}
	
	public static void main(String []ar) {	
		GUIGreaterNumberClient gc = new GUIGreaterNumberClient();
		gc.setVisible(true);
		gc.setSize(300, 500);
	}
}
