package thread;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MyThread extends Thread{
	InetAddress address;
	int port;
	DatagramSocket datagramSocket;

	public MyThread(InetAddress address, int port, DatagramSocket datagramSocket) {
		this.address = address;
		this.port = port;
		this.datagramSocket = datagramSocket;
	}

	
	@Override
	public void run() {
		
		
//		DatagramPacket reply = new DatagramPacket(buf, length, address, port);
//		datagramSocket.send(reply);
	}

}
