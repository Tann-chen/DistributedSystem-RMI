package records;

import java.io.Serializable;

public class StudentRecord extends Record implements Serializable{
	public String firstName;
	public String lastName;
	public String coursesRegistered;
	public String status;
	public String date;
	
	public StudentRecord(String firstName, String lastName, String coursesRegistered, String status, String date) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.coursesRegistered = coursesRegistered;
		this.status = status;
		this.date = date;
	}
	
	
}
