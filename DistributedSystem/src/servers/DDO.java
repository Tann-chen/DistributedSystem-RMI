package servers;

import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class DDO {
	public static void main(String[] args) throws Exception {
		CenterServerImp center = new CenterServerImp(new File("DDO.txt"));
		Registry registry = LocateRegistry.createRegistry(3002);
		registry.bind("DDOCenter", center);
		
		System.out.println("DDO");
		

//		File file = new File("DDO.txt");
	}
}
