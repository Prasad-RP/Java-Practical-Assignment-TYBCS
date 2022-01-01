/*
Set A)
b)
Define Student class(roll_no, name, percentage) to create n objects of theStudent class. Accept details from the user for each object. Define a static
method “sortStudent” which sorts the array on the basis of percentage.


*/

import java.util.*;
class student {
	int rollno;
	String name;
	double per;
	void setData(int rollno, String name, double per) {
		this.rollno = rollno;
		this.name = name;
		this.per = per;
	}
	void display() {
		System.out.println(name + "\t" + rollno + "\t" + per + "\t");
	}
	static void sortData(student s[], int n) {
		int i, j;
		student temp = new student();
		for (i = 0; i < n; i++) {
			for (j = i + 1; j < n; j++) {
				if (s[i].per < s[j].per) {
					temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}//if
			}//j
		}//i
	}//sortData
}//  student
public class SortStudent {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter total no of students");
		int n = input.nextInt();
		student s[] = new student[n];//object array

		for (int i = 0; i < n; i++) {
			input.nextLine();

			s[i] = new student();

			System.out.println("Enter " + (i + 1) + " Student Details");

			System.out.print("Enter Name:");
			String name = input.nextLine();

			System.out.print("Enter Roll No:");
			int roll = input.nextInt();

			System.out.print("Enter Per:");
			double per = input.nextDouble();

			s[i].setData(roll, name, per);
		}
		System.out.println("unsorted Student Details...");
		System.out.println("Name\tRollno\tper");
		for (int i = 0; i < n; i++) {
			s[i].display();
		}

		System.out.println("sorted Student Details...");
		student.sortData(s, n);
		for (int i = 0; i < n; i++) {
			s[i].display();
		}

	}

}
