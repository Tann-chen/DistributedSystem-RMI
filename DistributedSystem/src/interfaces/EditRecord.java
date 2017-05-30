package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EditRecord extends Remote{
	public void editRecord(String recordID, String fieldName, String newValue) throws RemoteException;
}
