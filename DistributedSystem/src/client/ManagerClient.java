package client;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;

import servers.CenterServer;

public class ManagerClient {
	public static void main(String[] args) throws Exception {
		Registry registry = null;
		CenterServer centerServer = null;
		boolean flag = false;
		int num = 0;
		String message;
		
		File file = new File("Manager.txt");

		
		
		Date now = new Date();
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time = simpleDateFormat.format(now);
		
		Manager manager1 = new Manager("MTL1111","manager1");
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
		message = manager1.name + ": Create Student Record: "+ flag + ", at "+ time;
		writelog(message,file);
		System.out.println("Create Student Record: "+ flag);
		
		
		now = new Date();
		time = simpleDateFormat.format(now);
		Manager manager2 = new Manager("LVL2222","manager2");
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
		flag = centerServer.createTRecord("Mark", "Chen", "Du Fort", "123456789", "English", "MTL");
		
		message = manager2.name + ": Create Teacher Record: "+ flag + ", at "+ time;
		writelog(message,file);
		System.out.println("Create Teacher Record: " + flag);
		
		
		now = new Date();
		time = simpleDateFormat.format(now);
		Manager manager3 = new Manager("DDO3333","manager3");
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
//		if(centerServer == null)
//			System.out.println("aaaa");
//		else
//			System.out.println("bbbb");
		centerServer.editRecord("SR10000", "coursesRegistered", "Chinese");
		
		message = manager3.name + ": Edit Record, at "+ time;
		writelog(message,file);
		System.out.println("Edit Record ");
		
		
		
		
		
	}
	
	 private static void writelog(String log, File file){

	            try {
	                FileWriter fileWriter = new FileWriter(file, true);
	                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	                bufferedWriter.newLine();
	                bufferedWriter.write(log);
	                bufferedWriter.close();
	            }catch (IOException e){
	                e.printStackTrace();
	            }
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
