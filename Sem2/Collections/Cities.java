//SET A
// a) Write a java program to accept names of ‘n’ cities, insert same into array list
// collection and display the contents of same array list, also remove all these elements.

import java.util.*;

public class Cities {
    public static void main(String[] args) {

        ArrayList al = new ArrayList();
        Scanner sc = new Scanner(System.in);
        System.out.print("How Many Cities: ");
        int n=sc.nextInt();

        for(int i=0;i<n;i++) {

            System.out.print("Enter City Name: ");
            sc.next();
            String name=sc.nextLine();
            al.add(name);
        }
        System.out.println("Cities");
        System.out.println(al);

        System.out.println("List After Removing All Items");
        al.removeAll(al);

    }
}
