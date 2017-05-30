package managementSystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CreateTRecord extends Remote {
	public boolean createTRecord(String firstName, String lastName, String address, String phone,
			String specialization, String location) throws RemoteException;
}
