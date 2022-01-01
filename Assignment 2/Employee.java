/*
Set A)
a)
Create an employee class(id,name,deptname,salary). Define a default and
parameterized constructor. Use ‘this’ keyword to initialize instance variables.
Keep a count of objects created. Create objects using parameterized constructor
and display the object count after each object is created.(Use static member and
method). Also display the contents of each object

*/
import java.util.*;
public class Employee {
	int id;
	String name;
	String dept;
	float salary;
	static int cnt = 0;
	Emp() {
		id = 1;
		name = "Varinet";
		dept = "Time";
		salary = 6.5f;
		cnt++;
	}
	Emp(int id, String name, String dept, float salary) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		cnt++;
	}
	static void empCount() {
		System.out.println(cnt + "\n Employe Created\n");
	}
	public void display() {
		System.out.println(name + "\t" + id + "\t" + dept + "\t" + salary);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter total no of employees");
		int n = input.nextInt();
		Emp s[] = new Emp[n];//object array

		for (int i = 0; i < n; i++) {
			input.nextLine();

			System.out.println("Enter " + (i + 1) + " Employe Details");

			System.out.print("Enter Name:");
			String name = input.nextLine();
			System.out.print("Enter Dept Name:");
			String dept = input.nextLine();

			System.out.print("Enter Id No:");
			int id = input.nextInt();

			System.out.print("Enter salary:");
			float salary = input.nextFloat();
			s[i] = new Emp(id, name, dept, salary);
			empCount();
		}
		System.out.println("\n\nEmploye Details...\n\n");
		System.out.println("Name\tid\tdept\tsalary");
		for (int i = 0; i < n; i++) {
			s[i].display();

		}


	}
}