package records;

import java.io.Serializable;

public class StudentRecord extends Record implements Serializable{

	private static int idCounter=10000;

	public String coursesRegistered;
	public String status;
	public String date;
	
	public StudentRecord(String firstName, String lastName, String coursesRegistered, String status, String date){
		super(firstName,lastName);
		this.recordID="SR"+String.valueOf(idCounter+1);
		this.coursesRegistered = coursesRegistered;
		this.status = status;
		this.date = date;
	}

	public void editValue(String fieldName, String Value){
		
	}
	
	
}
