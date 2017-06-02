package servers;

import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Montreal {
	public static void main(String[] args) throws Exception {

		File logFile=new File("mrl.txt");
		CenterServerImp center = new CenterServerImp(logFile);

		Registry registry = LocateRegistry.createRegistry(3000);
		registry.bind("MTLCenter", center);

		System.out.println("MTL");
	}

}
