package Singlylinkedlist;

public class employeenode {
	
	private Employee employee; 
	private employeenode next;
	
	public employeenode(Employee employee){
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public employeenode getNext() {
		return next;
	}

	public void setNext(employeenode next) {
		this.next = next;
	}
	
	public String toString(){
		return employee.toString();
	}
	
	
	
	

}
