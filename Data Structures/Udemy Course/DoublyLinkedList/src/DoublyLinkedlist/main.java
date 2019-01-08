package DoublyLinkedlist;

public class main {

	public static void main(String[] args) {

		Employee janeparker = new Employee("jane", "parker", 123);
		Employee momoman = new Employee("momo", "man", 234);
		Employee sidcros = new Employee("sid", "cros", 878);
		Employee mikewilson = new Employee("mike", "wilson", 906);

		employeeDoublyLinkedlist list = new employeeDoublyLinkedlist();
		list.addtofront(janeparker);
		list.addtofront(momoman);
		list.addtofront(sidcros);
		list.addtofront(mikewilson);

		list.printlist();
		System.out.println(list.getSize());

		Employee billend = new Employee("bill", "end", 3433);
		list.addToEnd(billend);

		list.printlist();
		System.out.println(list.getSize());

		list.removeFront();
		list.printlist();
		System.out.println(list.getSize());

		list.removeEnd();
		list.printlist();
		System.out.println(list.getSize());
	}

}
