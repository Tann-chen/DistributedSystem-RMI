package servers;

import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Laval {
	public static void main(String[] args) throws Exception {
		CenterServerImp center = new CenterServerImp();
		Registry registry = LocateRegistry.createRegistry(3001);
		registry.bind("LavalCenter", center);
		
//		File file = new File("Laval.txt");
	}
}
