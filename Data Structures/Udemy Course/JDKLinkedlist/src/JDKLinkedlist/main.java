package JDKLinkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class main {

	public static void main(String[] args) {

		Employee janeparker = new Employee("jane", "parker", 123);
		Employee momoman = new Employee("momo", "man", 234);
		Employee sidcros = new Employee("sid", "cros", 878);
		Employee mikewilson = new Employee("mike", "wilson", 906);
		Employee billend = new Employee("bill", "end", 3433);
		
		LinkedList<Employee> list = new LinkedList<Employee>();
		list.addFirst(janeparker);
		list.addFirst(momoman);
		list.addFirst(sidcros);
		list.addFirst(mikewilson);
		
		Iterator<Employee> iter = list.iterator();
		System.out.println("HEAD->");
		while(iter.hasNext()){
			System.out.print(iter.next());
			System.out.print("<=>");
		}
		System.out.println("null");
		
		list.addLast(billend);
		
		iter = list.iterator();
		System.out.println("HEAD->");
		while(iter.hasNext()){
			System.out.print(iter.next());
			System.out.print("<=>");
		}
		System.out.println("null");
		
		
		
	}

}
