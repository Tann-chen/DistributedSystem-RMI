package servers;

import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Laval {
	private static CenterServer centerServer;
	public static void main(String[] args) throws Exception {

		File logFile =new File("lvl.txt");
		 centerServer = new CenterServerImp(logFile);

		Registry registry = LocateRegistry.createRegistry(3001);
		registry.bind("LVLCenter", centerServer);
		System.out.println("LVL");
	}
}
