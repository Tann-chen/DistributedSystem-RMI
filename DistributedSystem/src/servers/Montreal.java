package servers;

import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Montreal {
	public static void main(String[] args) throws Exception {
		CenterServerImp center = new CenterServerImp();
		Registry registry = LocateRegistry.createRegistry(3000);
		registry.bind("MTLCenter", center);
		
//		File file = new File("Montreal.txt");
		
	}

}
