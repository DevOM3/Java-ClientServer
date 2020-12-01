import java.net.*;
import java.io.*;

class GUIIServer {
	public static void main(String []ar) throws IOException {
		ServerSocket serverSocket = new ServerSocket(100);
		Socket socket = serverSocket.accept();
	
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

		String numberString = (String)dis.readUTF();
		String[] numbersArray = numberString.split(",");
		
		int no1 = Integer.parseInt(numbersArray[0]);
		int no2 = Integer.parseInt(numbersArray[1]);

		dos.writeUTF((no1 + no2) + "," + (no1 - no2) + "," + (no1 * no2) + "," + (no1 / no2));
		
		System.out.println("Numbers: " + no1 + "," +  no2);
		System.out.println("Addition: " + (no1 + no2) + ",\nSubtraction: " + (no1 - no2) + ",Multiplication: " + (no1 * no2) + ",\nDivision" + (no1 / no2));
		serverSocket.close();
		socket.close();
	}
}
