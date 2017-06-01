package servers;

import records.Record;
import records.StudentRecord;
import records.TeacherRecord;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

public class CenterServerImp extends UnicastRemoteObject implements CenterServer {

    private HashMap<Character,ArrayList<Record>> storedRecords = new HashMap<>();
    static ArrayList<Record> arrayList = new ArrayList<>();



    public CenterServerImp()throws Exception{}

    @Override
    public boolean createTRecord(String firstName, String lastName, String address, String phone, String specialization, String location) throws RemoteException {
    	TeacherRecord teacherRecord = new TeacherRecord(firstName, lastName, address, phone, specialization, location);
		char cap = lastName.charAt(0);
		arrayList.add(teacherRecord);
		storedRecords.put(cap, arrayList);
    	return false;

    }

    @Override
    public boolean createSRecord(String firstName, String lastName, String coursesRegistered, String status, String date) throws RemoteException {
    	StudentRecord studentRecord = new StudentRecord(firstName, lastName, coursesRegistered, status, date);
    	char cap = lastName.charAt(0);
		arrayList.add(studentRecord);
		storedRecords.put(cap, arrayList);
		return false;

    }

    @Override
    public int getRecordCounts() throws RemoteException {
        return 0;
    }

    @Override
    public void editRecord(String recordID, String firstName, String newValue) throws RemoteException {

    }
}
