package client;


public class ManagerClient {

	public static void main(String[] args) throws Exception {
		Manager manager1=new Manager("MTL1111","manager1");
		manager1.createSRecord("chen1","A","Math","active","2008-10-02");
		manager1.getRecordCounts();

		Manager manager2=new Manager("DDO1111","manager2");
		manager2.createSRecord("chen2","B","English","active","2008-10-03");

		Manager manager3=new Manager("LVL1111","manager3");
		manager3.createSRecord("chen3","C","French","active","2008-10-04");
		manager3.getRecordCounts();

		Manager manager4=new Manager("MTL2222","manager4");
		manager4.createTRecord("li4","D","Tupper street","123456789","Math","LVL");
		manager4.createSRecord("li5","E","math","active","2016-09-01");

		Manager manager5=new Manager("DDO2222","manager5");
		manager5.createTRecord("li6","F","Du fort","987654321","English","MTL");
		manager5.getRecordCounts();
		
		Manager manager6=new Manager("LVL1111","manager6");
		manager6.editRecord("SR10001", "coursesRegistered", "Spanish");
		
		manager1.createTRecord("li7","G","Guy","1357924680","Chinese","MTL");
		manager1.getRecordCounts();
	}
}
