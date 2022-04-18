// Set B
// a) Accept ‘n’ integers from the user. Store and display integers in sorted order having
// proper collection class. The collection should not accept duplicate elements.
import java.util.*;

public class SETB1 {
    public static void main(String[] args) {
        TreeSet ts =new TreeSet();
        Scanner sc = new Scanner(System.in);
        System.out.print("How Many Integers: ");
        int n=sc.nextInt();

        for(int i=0;i<n;i++) {

            System.out.print("Enter Number: ");
            int num=sc.nextInt();
            ts.add(num);
        }
        System.out.println("Sorted Integers Without Duplication: ");
        System.out.println(ts);
    }
}
