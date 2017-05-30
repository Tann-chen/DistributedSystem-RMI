package managementSystem;

import java.sql.Date;

public class StudentRecord extends Record{
	private String firstName;
	private String lastName;
	private String coursesRegistered;
	private String status;
	private String date;
	
	public StudentRecord(String firstName, String lastName, String coursesRegistered, String status, String date) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.coursesRegistered = coursesRegistered;
		this.status = status;
		this.date = date;
	}
	
	
}
