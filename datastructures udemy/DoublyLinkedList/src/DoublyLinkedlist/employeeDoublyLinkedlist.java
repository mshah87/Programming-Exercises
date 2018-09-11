package DoublyLinkedlist;

public class employeeDoublyLinkedlist {
	
	private employeenode head;
	private employeenode tail;
	private int size;
	
	public void addtofront(Employee employee){
		employeenode node = new employeenode(employee);
		
		//if list empty, set tail to the node we are adding
		if(head == null){
			tail = node;
		} else{
			//else set previous node of current head to the node we are adding 
			head.setPrevious(node);
			node.setNext(head);

		}
		
		head = node;
		size++;
	}
	
	public void addToEnd(Employee employee){
		employeenode node = new employeenode(employee);
		if(tail == null) {
			head= node;
		} else {
			tail.setNext(node);
			node.setPrevious(tail);
		}
		
		tail=node;
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
		
		//if heads next field is null, there is only one node in list, so set the tail to null
		if(head.getNext()==null){
			tail=null;
		} else{
			head.getNext().setPrevious(null);
		}
		
		
		head = head.getNext();
		size--;
		removednode.setNext(null);
		return removednode;
	}
	
	public employeenode removeEnd(){
		if(isEmpty()){
			return null;
		}
		
		employeenode removednode = tail;
		
		if(tail.getPrevious() == null){
			head=null;
		} else {
			tail.getPrevious().setNext(null);
		}
		
		tail = tail.getPrevious();
		size--;
		removednode.setPrevious(null);
		return removednode;
	}
	 
	public void printlist(){
		employeenode current = head;
		System.out.print("HEAD->");
		
		while(current != null){
			System.out.print(current);
			System.out.print("<=>");
			current=current.getNext();
		}
		
		System.out.println("null");

	}
}
