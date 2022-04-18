// SET B
//c) Write a program that loads names and phone numbers from a text file where the data
// is organized as one line per record and each field in a record are separated by a tab
// (\t).it takes a name or phone number as input and prints the corresponding other value
// from the hash table (hint: use hash tables)

import java.util.*;
import java.io.*;

public class SETB3 {
    public static void main(String arg[]) {
        try {
            File f = new File("Setb3.txt");
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(f));

            Hashtable<String, String> table = new Hashtable<>();

            Scanner sc = new Scanner(System.in);

            String line = "";
            while ((line = br.readLine()) != null) {

                String[] parts = line.split("\t");
                String name = parts[0].trim();
                String num = parts[1].trim();
                if (!name.equals("") && !num.equals("")) {
                    table.put(name, num);
                }

            } // while
              // main logic
            System.out.print("Enter Name: ");
            String key = sc.nextLine();

            if (table.containsKey(key)) {
                System.out.println(table.get(key));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
