package servers;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import thread.MyThread;


public class Montreal {
	private static CenterServer centerServer;
	public static void main(String[] args) throws Exception {

		File logFile=new File("mrl.txt");
		centerServer = new CenterServerImp(logFile,"MTL");

		Registry registry = LocateRegistry.createRegistry(3000);
		registry.bind("MTLCenter",centerServer);
		System.out.println("MTL");
		
		DatagramSocket datagramSocket = null;
		
		try {
			datagramSocket = new DatagramSocket(6791);
			byte[] buffer = new byte[1000];
			
			while(true){
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				datagramSocket.receive(request);
				new MyThread(request.getAddress(),request.getPort(),datagramSocket,centerServer);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(datagramSocket != null)
				datagramSocket.close();
		}
	}

}
