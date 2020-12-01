import java.net.*;
import java.io.*;

class GUIGreaterNumberServer {
	public static void main(String []ar) throws IOException {
		ServerSocket serverSocket = new ServerSocket(100);
		Socket socket = serverSocket.accept();
	
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

		String numberString = (String)dis.readUTF();
		String[] numbersArray = numberString.split(",");
		
		int no1 = Integer.parseInt(numbersArray[0]);
		int no2 = Integer.parseInt(numbersArray[1]);
		int no3 = Integer.parseInt(numbersArray[2]);

		dos.writeUTF("" + ((no1 < no2 && no2 < no3) ? no3 : (no2 < no3 && no3 < no1) ? no1 : no2));
		
		System.out.println("Numbers: " + no1 + "," +  no2 + "," + no3);
		System.out.println("Greater Number: " + ((no1 < no2 && no2 < no3) ? no3 : (no2 < no3 && no3 < no1) ? no1 : no2 ));
		serverSocket.close();
		socket.close();
	}
}
