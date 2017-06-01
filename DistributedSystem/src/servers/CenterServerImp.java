package servers;

import records.Record;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Map;

public class CenterServerImp extends UnicastRemoteObject implements CenterServer {

    private Map<Character,ArrayList<Record>> storedRecords;



    public CenterServerImp()throws Exception{}

    @Override
    public void createTRecord(String firstName, String lastName, String address, String phone, String specialization, String location) throws RemoteException {

    }

    @Override
    public void createSRecord(String firstName, String lastName, String coursesRegistered, String status, String date) throws RemoteException {

    }

    @Override
    public int getRecordCounts() throws RemoteException {
        return 0;
    }

    @Override
    public void editRecord(String recordID, String firstName, String newValue) throws RemoteException {

    }
}
