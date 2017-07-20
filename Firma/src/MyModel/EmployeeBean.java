package MyModel;

public class EmployeeBean {
	private int employee_id;
	private String firstname;
	private String lastname;
	private float wage;
	private int position_id;
	private int branch_id;
	private int supervisor_id;
	
	public EmployeeBean(int _employee_id, String _firstname, String _lastname, float _wage, int _position_id, int _branch_id, int _supervisor_id)
	{
		employee_id = _employee_id;
		firstname = _firstname;
		lastname = _lastname;
		wage = _wage;
		position_id = _position_id;
		branch_id = _branch_id;
		supervisor_id = _supervisor_id;
	}
	
	public int getEmployeeID() {
		return employee_id;
	}
	public void setEmployeeID(int _employee_id) {
		employee_id = _employee_id;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String _lastname) {
		lastname = _lastname;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String _firstname) {
		firstname = _firstname;
	}
	public float getWage() {
		return wage;
	}
	public void setWage(float _wage) {
		wage = _wage;
	}
	public int getPositionID() {
		return position_id;
	}
	public void setPositionID(int _positon_id) {
		position_id = _positon_id;
	}
	public int getBranchID() {
		return branch_id;
	}
	public void setBranchID(int _branch_id) {
		branch_id = _branch_id;
	}
	public int getSupervisorID() {
		return supervisor_id;
	}
	public void setSupervisorID(int _supervisor_id) {
		supervisor_id = _supervisor_id;
	}
}
