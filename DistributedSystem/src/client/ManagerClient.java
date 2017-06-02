package client;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;

import servers.CenterServer;

public class ManagerClient {

	public static void main(String[] args) throws Exception {
		Manager manager1=new Manager("MTL1111","chen");
		manager1.createSRecord("chen","en","math","active","2008-10-01");


		Manager manager2=new Manager("DDO1111","chen");
		manager2.createSRecord("chen","en","math","active","2008-10-01");
		manager2.getRecordCounts();

		Manager manager3=new Manager("LVL1111","chen");
		manager3.createSRecord("chen","en","math","active","2008-10-01");
		manager3.getRecordCounts();

		Manager manager4=new Manager("MTL2222","li");
		manager4.createTRecord("li","wei","lvl","1122","xxx","lvl");
		manager4.getRecordCounts();

		Manager manager5=new Manager("DDO2222","li");
		manager5.createTRecord("li","wei","lvl","1122","xxx","lvl");
		manager5.getRecordCounts();
	}
}
