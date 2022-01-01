/*
Set C
a)
Write a Program to accept n names 
of Country and display them in
descending order

*/
import java.util.*;
public class CountrySort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Total no of Countries: ");
		int n = sc.nextInt();
		// creating array of string
		String country [ ] = new String [n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter Country No: " + (i + 1));
			country[i] = sc.nextLine();
		}
		 System.out.println("Country names without sorting");
		for (String ele : country) {
			System.out.print(" " + ele);
		}
		String temp;
		// sorting logic
/*
compareTo function compares two string on basis of unicode
so it wil compare two strings and returns positive , negative, 0 values 
according to string.
*/
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (country[i].compareTo(country[j]) < 0) {
					temp = country[i];
					country[i] = country[j];
					country[j] = temp;
				}
			}
		}
   System.out.println("\nCountries in Decending Order");
		for (String ele : country) {
			System.out.print(" " + ele);
		}
	}
}