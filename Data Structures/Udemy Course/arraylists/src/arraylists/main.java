package arraylists;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		
		//default capacity is 10
		List<Employee> employeelist= new ArrayList<Employee>();
		employeelist.add(new Employee("jane", "parker", 123));
		employeelist.add(new Employee("momo", "man", 234));
		employeelist.add(new Employee("sid", "cros", 878));
		employeelist.add(new Employee("mike", "wilson", 906));

		//iterate through list
		employeelist.forEach(employee -> System.out.println(employee));
		
		System.out.println(employeelist.get(1));
		System.out.println(employeelist.isEmpty());
		
		//change employee at index 1
		employeelist.set(1, new Employee("john", "adams", 24885));
//		System.out.println(employeelist.size());
		
		Employee[] employeearray = employeelist.toArray(new Employee[employeelist.size()]);
		for(Employee employee: employeearray){
			System.out.println(employee);
		}
	}
	

}
