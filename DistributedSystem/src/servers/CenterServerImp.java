package servers;

import com.sun.org.apache.regexp.internal.RE;
import records.Record;
import records.StudentRecord;
import records.TeacherRecord;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CenterServerImp extends UnicastRemoteObject implements CenterServer {

    private HashMap<Character,ArrayList<Record>> storedRecords = new HashMap<>();

    public CenterServerImp()throws Exception{}

    @Override
    public boolean createTRecord(String firstName, String lastName, String address, String phone, String specialization, String location) throws RemoteException {
    	TeacherRecord teacherRecord = new TeacherRecord(firstName, lastName, address, phone, specialization, location);
        storingRecord(teacherRecord);
        return true;
    }

    @Override
    public boolean createSRecord(String firstName, String lastName, String coursesRegistered, String status, String date) throws RemoteException {
    	StudentRecord studentRecord = new StudentRecord(firstName, lastName, coursesRegistered, status, date);
        storingRecord(studentRecord);
        return true;
    }

    @Override
    public int getRecordCounts() throws RemoteException {
        return 0;
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
}
