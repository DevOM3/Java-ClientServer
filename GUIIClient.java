import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class GUIIClient extends JFrame implements ActionListener {
	JTextField no1;
	JTextField no2;
	JTextField add;
	JTextField sub;
	JTextField mul;
	JTextField div;

	GUIIClient() {
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		no1 = new JTextField(21);
		no2 = new JTextField(21);
		JButton jButton = new JButton("Calculate");
		jButton.addActionListener(this);

		add = new JTextField(21);
		add.setEditable(false);
		sub = new JTextField(21);
		sub.setEditable(false);
		mul = new JTextField(21);
		mul.setEditable(false);
		div = new JTextField(21);
		div.setEditable(false);

		container.add(no1);
		container.add(no2);
		container.add(jButton);
		container.add(add);
		container.add(sub);
		container.add(mul);
		container.add(div);
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

			dos.writeUTF(no1.getText() + "," + no2.getText());
			
			String calculationString = (String)dis.readUTF();
			String[] calculationArray = calculationString.split(",");

			no1.setText("");
			no2.setText("");
			add.setText(calculationArray[0]);
			sub.setText(calculationArray[1]);
			mul.setText(calculationArray[2]);
			div.setText(calculationArray[3]);
	}
	
	public static void main(String []ar) {	
		GUIIClient gc = new GUIIClient();
		gc.setVisible(true);
		gc.setSize(300, 500);
	}
}
