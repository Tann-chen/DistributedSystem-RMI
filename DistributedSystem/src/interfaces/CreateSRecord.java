package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CreateSRecord extends Remote {
	public boolean createSRecord(String firstName, String lastName, String courseRegistered, 
			String status, String statusDate) throws RemoteException;
}
