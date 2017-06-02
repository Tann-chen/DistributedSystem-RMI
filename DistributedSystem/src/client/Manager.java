package client;

import records.StudentRecord;
import records.TeacherRecord;
import servers.CenterServer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class Manager {
	private String managerID;
	private String name;
	private Registry registry;
	private CenterServer centerServer;
	private static File loggingFile=new File("Manager.txt");

	public Manager(String managerID, String name){
		this.managerID = managerID;
		this.name = name;
		//distributing server
		int port;
		String portName;
		if(this.managerID.startsWith("MTL")){
			port=3000;
			portName="MTLCenter";
		}
		else if(this.managerID.startsWith("LVL")){
			port=3001;
			portName="LVLCenter";
		}
		else if(this.managerID.startsWith("DDO")){
			port=3002;
			portName="DDOCenter";
		}
		else{
			System.out.println("Error:invalid managerID");
			return;
		}
		try {
			registry = LocateRegistry.getRegistry(port);
			centerServer= (CenterServer) registry.lookup(portName);
		}catch (Exception e){
			e.getStackTrace();
		}
	}

	public void createTRecord(String firstName, String lastName, String address, String phone, String specialization, String location){
		boolean flag=false;
		try {
			flag=centerServer.createTRecord(firstName, lastName, address, phone, specialization, location);
		}catch (RemoteException re){
			re.getStackTrace();
		}
		String log=(new Date().toString())+" | "+this.name + "- create teacher record - "+ String.valueOf(flag);
		writelog(log);
	}

	public void createSRecord(String firstName, String lastName, String coursesRegistered, String status, String date){
		boolean flag=false;
		try{
			flag=centerServer.createSRecord(firstName, lastName, coursesRegistered, status, date);
		}catch (RemoteException re) {
			re.getStackTrace();
		}
		String log=(new Date().toString())+" | "+this.name + "- create student record - "+ flag;
		writelog(log);
	}

	public int  getRecordCounts() throws RemoteException {
		int result=0;
		try{
			result=centerServer.getRecordCounts();
		}catch (RemoteException re){
			re.getStackTrace();
		}
		String log=(new Date().toString())+" | "+this.name + "- get records count - "+ result;
		writelog(log);
		return result;
	}

	public void editRecord(String recordID, String fieldName, String newValue) throws RemoteException {
		boolean flag=false;
		try {
			centerServer.editRecord(recordID, fieldName, newValue);
		}catch (RemoteException re){
			re.getStackTrace();
		}
		String log=(new Date().toString())+" | "+this.name + "- edit record - ";
		writelog(log);
	}

	private static void writelog(String log){
		try {
			FileWriter fileWriter = new FileWriter(loggingFile, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.newLine();
			bufferedWriter.write(log);
			bufferedWriter.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
