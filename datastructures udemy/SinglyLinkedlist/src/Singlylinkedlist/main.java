package Singlylinkedlist;

public class main {

	public static void main(String[] args) {
		
		Employee janeparker = new Employee("jane", "parker", 123);
		Employee momoman= new Employee("momo", "man", 234);
		Employee sidcros = new Employee("sid", "cros", 878);
		Employee mikewilson = new Employee("mike", "wilson", 906);

		employeelinkedlist list = new employeelinkedlist();
		
		System.out.println(list.isEmpty());
		
		list.addtofront(janeparker);
		list.addtofront(momoman);
		list.addtofront(sidcros);
		list.addtofront(mikewilson);
		
		System.out.println(list.getSize());
		
		list.printlist();

		list.removeFront();
		
		System.out.println(list.getSize());
		
		list.printlist();
		
	}
	

}
