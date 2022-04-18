//SET B
// b) Write a program to sort HashMap by keys and display the details before sorting and
// after sorting.

import java.util.*;
public class SETB2{

public static void main(String arg[]){

HashMap<String,Integer> map= new HashMap<>();
map.put("p",10);
map.put("b",3);
map.put("c",2);
map.put("d",5);

System.out.println("HasMap before sorting: \n"+map);
TreeMap tm= new TreeMap(map);

System.out.println("HasMap after sorting: \n"+tm);

}
}
