package LateShipmentProject;

public class Employee_class {

	private int employee_id;
	private String employee_name;
	private String employee_email;
	private long employee_phone_number;
	private String department;
	private String skills;
	
	public String getEmployee_name() {
		return employee_name;
	}
	
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	
	public String getEmployee_email() {
		return employee_email;
	}
	
	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}
	
	public long getEmployee_phone_number() {
		return employee_phone_number;
	}
	
	public void setEmployee_phone_number(long employee_phone_number) {
		this.employee_phone_number = employee_phone_number;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getSkills() {
		return skills;
	}
	
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public void setSkills(String convert) {
		this.skills = convert;
	}

	@Override
	public String toString() {
		return "Employee_class [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_email="
				+ employee_email + ", employee_phone_number=" + employee_phone_number + ", department=" + department
				+ ", skills=" + skills + "]";
	}

}

	
	
	
	
	
