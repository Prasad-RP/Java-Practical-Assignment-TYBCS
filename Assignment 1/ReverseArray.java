/* Set A
d)
Write a Program to accept Array Elements and Display in reverse
order
*/
import java.util.*;
public class ReverseArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Total number of Elements: ");
		int n = sc.nextInt();
		int [ ] a = new int [n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter Element No: " + (i + 1));
			a[i] = sc.nextInt();
		}
				System.out.println("Array Elements");
			for (int i = 0; i < n; i++) {
			System.out.print(" " +a[i]);
		}
		System.out.println("\nArray Elements in reverse oreder");
		for (int i = a.length - 1 ; i >= 0 ; i--) {
			System.out.print(" " +a[i]);
		}

	}
}