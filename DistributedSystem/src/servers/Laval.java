package servers;

import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Laval {
	public static void main(String[] args) throws Exception {
		File logFile =new File("/log/lvl.txt");
		CenterServerImp center = new CenterServerImp(logFile);
		Registry registry = LocateRegistry.createRegistry(3001);
		registry.bind("LVLCenter", center);
		System.out.println("LVL");
	}
}
