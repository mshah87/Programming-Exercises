package Singlylinkedlist;

public class employeelinkedlist {
	
	private employeenode head;
	private int size;
	
	public void addtofront(Employee employee){
		employeenode node = new employeenode(employee);
		node.setNext(head);
		head = node;
		size++;
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public employeenode removeFront(){
		if(isEmpty()){
			return null;
		} 
		
		employeenode removednode = head;
		head = head.getNext();
		size--;
		removednode.setNext(null);
		return removednode;
		
	}
	 
	public void printlist(){
		employeenode current = head;
		System.out.print("HEAD->");
		
		while(current != null){
			System.out.print(current);
			System.out.print("->");
			current=current.getNext();
		}
		
		System.out.println("null");

	}
}
