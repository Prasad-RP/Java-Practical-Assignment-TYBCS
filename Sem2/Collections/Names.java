//SET B
// b) Write a java program to read ‘n’ names of your friends, store it into linked list, also
// display contents of the same
import java.util.*;
public class Names {
    public static void main(String[] args) {
        
        LinkedList ll = new LinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("How Many Students: ");
        int n=sc.nextInt();

        for(int i=0;i<n;i++) {

            System.out.print("Enter Student Name: ");
            sc.next();
            String name=sc.nextLine();
            ll.add(name);
        }
        System.out.println("Students");
        System.out.println(ll);
    }
}
