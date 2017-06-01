package records;

import java.io.Serializable;

public class TeacherRecord extends Record implements Serializable{
	private static int idCounter=10000;
	public String address;
	public String phone;
	public String specialization;
	public String location;
	
	public TeacherRecord(String firstName, String lastName, String address, String phone, String specialization,
			String location) {
		super(firstName,lastName);
		this.recordID="TR"+String.valueOf(idCounter+1);
		this.address = address;
		this.phone = phone;
		this.specialization = specialization;
		this.location = location;
	}

	public void editValue(String fieldName, String Value){

	}
}
