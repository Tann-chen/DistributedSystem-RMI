package managementSystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GetRecordCounts extends Remote {
	public int getRecordCounts() throws RemoteException;
}
