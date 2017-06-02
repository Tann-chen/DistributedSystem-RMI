package servers;

import records.Record;
import records.StudentRecord;
import records.TeacherRecord;
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class CenterServerImp extends UnicastRemoteObject implements CenterServer {

    private HashMap<Character,ArrayList<Record>> storedRecords = new HashMap<>();
    private File loggingFile;
   
    
    public CenterServerImp(File loggingFile)throws Exception{
        this.loggingFile=loggingFile;
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
    public int getRecordCounts() throws RemoteException {
        String log=(new Date().toString()+" - get records number ");
        writelog(log);
        return getLocalRecordsCount();
    }

    @Override
    public void editRecord(String recordID, String fieldName, String newValue) throws RemoteException {
        Record targetRecord=null;

        Collection<ArrayList<Record>> arrayListsSet=storedRecords.values();
        for(ArrayList<Record> recordArrayListSet :arrayListsSet){
            for(Record record:recordArrayListSet){
                if(record.recordID.equalsIgnoreCase(recordID))
                    targetRecord=record;
            }
        }

        if(targetRecord!=null){
            if(targetRecord instanceof TeacherRecord)
                ((TeacherRecord)targetRecord).setValue(fieldName,newValue);
            else
                ((StudentRecord)targetRecord).setValue(fieldName,newValue);
        }
//        String log=(new Date().toString()+" - editing a record - "+targetRecord.recordID);
 //       writelog(log);
    }

    private void storingRecord(Record record){
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

    public int getLocalRecordsCount(){
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
    }


