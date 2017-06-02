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
		
		File file = new File("Manager.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		
		Manager manager1 = new Manager("MTL1111","1");
		callMethod(manager1,registry,centerServer);
		centerServer.createSRecord("Grey", "Lee", "Math", "active", "2017/06/01");
		System.out.println("Create Student Record");
		
		Manager manager2 = new Manager("LVL2222","2");
		callMethod(manager2,registry,centerServer);
		centerServer.createTRecord("Mark", "Chen", "Du Fort", "123456789", "English", "MTL");
		System.out.println("Create Teacher Record");
		
		Manager manager3 = new Manager("DDO3333","3");
		callMethod(manager3,registry,centerServer);
		centerServer.editRecord("10000", "lastName", "Gao");
		
		
		
		
		
		
	}

	private static void callMethod(Manager manager1, Registry registry, CenterServer centerServer) throws Exception {
		
		if(manager1.managerID.startsWith("MTL")){
			registry = LocateRegistry.getRegistry(3000);
			centerServer= (CenterServer) registry.lookup("MTLCenter");
			
		}
		else if(manager1.managerID.startsWith("LVL")){
			registry = LocateRegistry.getRegistry(3001);
			centerServer= (CenterServer) registry.lookup("LVLCenter");
			
		}
		else{
			registry = LocateRegistry.getRegistry(3002);
			centerServer= (CenterServer) registry.lookup("DDOCenter");
			
		}
		
	}
}
