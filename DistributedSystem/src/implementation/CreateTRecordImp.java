package implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import interfaces.CreateTRecord;
import records.TeacherRecord;

public class CreateTRecordImp extends UnicastRemoteObject implements CreateTRecord{

	protected CreateTRecordImp() throws RemoteException {
		super();
	}

	public boolean createTRecord(String firstName, String lastName, String address, String phone, String specialization,
			String location) throws RemoteException {
		TeacherRecord teacherRecord = new TeacherRecord(firstName, lastName, address, phone, specialization, location);
		
		return false;
	}

}
