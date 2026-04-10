package Employee.Management;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class App {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeService service=context.getBean(EmployeeService.class);
		service.addEmployee(101,"Bhargav","CSE");
		service.addEmployee(102,"Dolly","ECE");
		service.addEmployee(103,"Ganesh","EEE");
		System.out.print("All Employees:");
		service.getEmployees().forEach(System.out::println);
		System.out.println("\nFind Employee 102:");
		System.out.println(service.getEmployee(102));
		System.out.println("\nDelete Employee 101:");
		System.out.println("Deleted?"+service.removeEmployee(101));
		System.out.println("\nAll Employees After Delete:");
	    service.getEmployees().forEach(System.out::println);
	    
	}
}