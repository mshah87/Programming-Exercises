package DoublyLinkedlist;

public class employeenode {
	
	private Employee employee; 
	private employeenode next;
	private employeenode previous;
	
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
	
	
	public employeenode getPrevious() {
		return previous;
	}

	public void setPrevious(employeenode previous) {
		this.previous = previous;
	}

	public String toString(){
		return employee.toString();
	}
	
	
	
	

}
