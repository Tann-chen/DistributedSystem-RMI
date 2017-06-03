package client;


public class ManagerClient {

	public static void main(String[] args) throws Exception {
		Manager manager1=new Manager("MTL1111","chen");
		manager1.createSRecord("en","chen","math","active","2008-10-01");
		manager1.createSRecord("en","liu","computer","active","2008-10-01");

		Manager manager2=new Manager("DDO1111","chen");
		manager2.createSRecord("biu","ding","music","active","2008-10-01");

		Manager manager3=new Manager("LVL1111","chen");
		manager3.createSRecord("hong","cai","math","inactive","2008-10-01");

		Manager manager4=new Manager("MTL2222","li");
		manager4.createTRecord("li","wei","lvl","1122","xxx","lvl");
		manager4.createSRecord("lii","weii","math","active","2016-09-01");

		Manager manager5=new Manager("DDO2222","li");
		manager5.createTRecord("li","wei","lvl","1122","xxx","lvl");
		manager5.getRecordCounts();
	}
}
