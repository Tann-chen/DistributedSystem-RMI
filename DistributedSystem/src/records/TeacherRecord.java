package records;

public class TeacherRecord extends Record{
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String specialization;
	private String location;
	
	public TeacherRecord(String firstName, String lastName, String address, String phone, String specialization,
			String location) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.specialization = specialization;
		this.location = location;
	}
}
