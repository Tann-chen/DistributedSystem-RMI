package servers;

import records.Record;
import records.StudentRecord;
import records.TeacherRecord;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class CenterServerImp extends UnicastRemoteObject implements CenterServer {

    private HashMap<Character,ArrayList<Record>> storedRecords = new HashMap<>();
    private File loggingFile;
    private String centerName;
   
    
    public CenterServerImp(File loggingFile,String centerName)throws Exception{
        this.loggingFile=loggingFile;
        this.centerName = centerName;
    }

    @Override
    public boolean createTRecord(String firstName, String lastName, String address, String phone, String specialization, String location) throws RemoteException {
    	TeacherRecord teacherRecord = new TeacherRecord(firstName, lastName, address, phone, specialization, location);
    	int beforeNum=getLocalRecordsCount();
        storingRecord(teacherRecord);
        int afterNum=getLocalRecordsCount();

        String log=(new Date().toString()+" - creating a teacher record - "+teacherRecord.recordID);
        writelog(log);
        return beforeNum+1==afterNum;
    }

    @Override
    public boolean createSRecord(String firstName, String lastName, String coursesRegistered, String status, String date) throws RemoteException {
    	StudentRecord studentRecord = new StudentRecord(firstName, lastName, coursesRegistered, status, date);
        int beforeNum=getLocalRecordsCount();
        storingRecord(studentRecord);
        int afterNum=getLocalRecordsCount();
        String log=(new Date().toString()+" - creating a student record - "+studentRecord.recordID);
        writelog(log);
        return beforeNum+1==afterNum;

    }

    @Override
    public String getRecordCounts() throws RemoteException {

        String DDONum ;
        String LVLNum ;
        String MTLNum ;
        if(centerName == "MTL"){
        	DDONum = sentMessage(6789);
        	LVLNum = sentMessage(6790);
        	MTLNum=String.valueOf(getLocalRecordsCount());
        }
        else if(centerName == "LVL"){
        	DDONum = sentMessage(6789);
        	MTLNum = sentMessage(6791);
        	LVLNum = String.valueOf(getLocalRecordsCount());
        }
        else{
        	MTLNum = sentMessage(6791);
        	LVLNum = sentMessage(6790);
        	DDONum=String.valueOf(getLocalRecordsCount());
        }

        String log=(new Date().toString()+" - get records number ");
        writelog(log);
        
        return "Records Count: DDO:"+DDONum+" | LVL:"+LVLNum+" | MTL:"+MTLNum;
    }

    @Override
    public synchronized void editRecord(String recordID, String fieldName, String newValue) throws RemoteException {
        Record targetRecord=null;

        Collection<ArrayList<Record>> arrayListsSet=storedRecords.values();
        for(ArrayList<Record> recordArrayListSet :arrayListsSet){
            for(Record record:recordArrayListSet){
                if(record.recordID.equalsIgnoreCase(recordID))
                  targetRecord=record;
            }
        }
     
        System.out.println(targetRecord);

        if(targetRecord!=null){
            if(targetRecord instanceof TeacherRecord){
                ((TeacherRecord)targetRecord).setValue(fieldName,newValue);
                System.out.println(targetRecord);
            }
            else {
                ((StudentRecord)targetRecord).setValue(fieldName,newValue);
                System.out.println(targetRecord);
            }
        }
        
        String log=(new Date().toString()+" - editing a record ");
        writelog(log);
        
    }

    private synchronized void storingRecord(Record record){
        char cap=record.lastName.charAt(0);
        if(!storedRecords.containsKey(cap)){
            ArrayList<Record> newArray=new ArrayList<Record>();
            newArray.add(record);
            storedRecords.put(cap,newArray);
        }
        else{
            ArrayList<Record> theArray= storedRecords.get(cap);
            theArray.add(record);
        }

    }

    public synchronized int getLocalRecordsCount(){
        int count=0;
        Collection<ArrayList<Record>> arrayListsSet=storedRecords.values();
        for(ArrayList<Record> recordArrayListSet :arrayListsSet){
            for(Record record:recordArrayListSet){
                count++;
            }
        }
        return count;
    }

    public void writelog(String log){
        if(!loggingFile.exists())
            return;
            try {
                FileWriter fileWriter = new FileWriter(loggingFile, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(log);
                bufferedWriter.newLine();
                bufferedWriter.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    
    public String sentMessage(int port){
    	DatagramSocket datagramSocket = null;
        try {
        	datagramSocket = new DatagramSocket();
        	byte[] message = "Get Record Counts".getBytes();
        	InetAddress host = InetAddress.getByName("localhost");
        	
        	DatagramPacket request = new DatagramPacket(message, "Get Record Counts".length(),host, port);
        	datagramSocket.send(request);
        	
        	//get message
        	byte[] buffer = new byte[1000];
        	DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
        	datagramSocket.receive(reply);
        	System.out.println(new String(reply.getData()));
        	return new String(reply.getData());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(datagramSocket != null)
				datagramSocket.close();
		}
		return "-1";
    }
	
    }


