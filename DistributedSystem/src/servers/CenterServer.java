package servers;

import java.rmi.Remote;

public interface CenterServer extends Remote{

    public void createTRecord();
    public void createSRecord();
    public int  getRecordCounts();
    public void editRecord();

}
