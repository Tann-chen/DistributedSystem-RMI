package servers;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CenterServer extends Remote{

     boolean createTRecord(String firstName, String lastName, String address, String phone, String specialization,
                              String location) throws RemoteException;

     boolean createSRecord(String firstName, String lastName, String coursesRegistered, String status, String date)
            throws RemoteException;

     int  getRecordCounts()throws RemoteException;

     void editRecord(String recordID, String fieldName, String newValue)throws RemoteException;

}
