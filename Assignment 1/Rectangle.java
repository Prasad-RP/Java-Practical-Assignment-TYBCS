/*Set A
b)
Write a program to calculate
 perimeter and area of rectangle.
(hint : area = length * breadth ,
 perimeter=2*(length+breadth))
*/
import java.util.*;
public class Rectangle {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		   System.out.println("To calculate area and perimeter of rectangle");
		System.out.println("Enter Length: ");
		int length = ip.nextInt();
		System.out.println("Enter Length: ");
		int breadth = ip.nextInt();
        float area= length*breadth;
        float perimeter=2* (length*breadth);
           System.out.println("Area: " +area);   
           System.out.println("Perimeter: " +perimeter);
    
	}
}