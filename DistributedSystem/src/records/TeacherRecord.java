package records;

public class TeacherRecord extends Record{
	public String firstName;
	public String lastName;
	public String address;
	public String phone;
	public String specialization;
	public String location;
	
	public TeacherRecord(String firstName, String lastName, String address, String phone, String specialization,
			String location) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.specialization = specialization;
		this.location = location;
	}
}
