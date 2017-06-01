package servers;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CenterServer extends Remote{

     void createTRecord(String firstName, String lastName, String address, String phone, String specialization,
                              String location) throws RemoteException;

     void createSRecord(String firstName, String lastName, String coursesRegistered, String status, String date)
            throws RemoteException;

     int  getRecordCounts()throws RemoteException;

     void editRecord(String recordID, String firstName, String newValue)throws RemoteException;

}
