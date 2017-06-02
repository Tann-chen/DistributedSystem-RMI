package client;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import servers.CenterServer;

public class ManagerClient {
	public static void main(String[] args) throws Exception {
		Registry registry = null;
		CenterServer centerServer = null;
		boolean flag = false;
		int num = 0;
		
		File file = new File("Manager.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		
		Manager manager1 = new Manager("MTL1111","1");
		num = callMethod(manager1);
		if(num == 1){
			registry = LocateRegistry.getRegistry(3000);
			centerServer= (CenterServer) registry.lookup("MTLCenter");
		}
		else if(num == 2){
			registry = LocateRegistry.getRegistry(3001);
			centerServer= (CenterServer) registry.lookup("LVLCenter");
		}
		else if(num == 3){
			registry = LocateRegistry.getRegistry(3002);
			centerServer= (CenterServer) registry.lookup("DDOCenter");
		}
		flag = centerServer.createSRecord("Grey", "Lee", "Math", "active", "2017/06/01");
		System.out.println("Create Student Record: "+ flag);
		
		Manager manager2 = new Manager("LVL2222","2");
		num = callMethod(manager2);
		if(num == 1){
			registry = LocateRegistry.getRegistry(3000);
			centerServer= (CenterServer) registry.lookup("MTLCenter");
		}
		else if(num == 2){
			registry = LocateRegistry.getRegistry(3001);
			centerServer= (CenterServer) registry.lookup("LVLCenter");
		}
		else if(num == 3){
			registry = LocateRegistry.getRegistry(3002);
			centerServer= (CenterServer) registry.lookup("DDOCenter");
		}
		flag = centerServer.createSRecord("Grey", "Lee", "Math", "active", "2017/06/01");
		registry = LocateRegistry.getRegistry(3001);
		centerServer= (CenterServer) registry.lookup("LVLCenter");
		flag = centerServer.createTRecord("Mark", "Chen", "Du Fort", "123456789", "English", "MTL");
		System.out.println("Create Teacher Record: " + flag);
		
		Manager manager3 = new Manager("DDO3333","3");
		num = callMethod(manager3);
		if(num == 1){
			registry = LocateRegistry.getRegistry(3000);
			centerServer= (CenterServer) registry.lookup("MTLCenter");
		}
		else if(num == 2){
			registry = LocateRegistry.getRegistry(3001);
			centerServer= (CenterServer) registry.lookup("LVLCenter");
		}
		else if(num == 3){
			registry = LocateRegistry.getRegistry(3002);
			centerServer= (CenterServer) registry.lookup("DDOCenter");
		}
		flag = centerServer.createSRecord("Grey", "Lee", "Math", "active", "2017/06/01");
		registry = LocateRegistry.getRegistry(3002);
		centerServer= (CenterServer) registry.lookup("DDOCenter");
		centerServer.editRecord("10000", "lastName", "Gao");
		System.out.println("Edit Record: ");
		
		
		
		
		
	}

	private static int callMethod(Manager manager) {
		
		if(manager.managerID.startsWith("MTL")){
			return 1;
		}
		else if(manager.managerID.startsWith("LVL")){
			
			return 2;
		}
		else
			return 3;
		
		
	}

}
