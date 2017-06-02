package servers;

import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class DDO {
	public static void main(String[] args) throws Exception {
		File logFile = new File("ddo.txt");
		CenterServerImp center = new CenterServerImp(logFile);
		Registry registry = LocateRegistry.createRegistry(3002);
		registry.bind("DDOCenter", center);
		
		System.out.println("DDO");
	}
}
