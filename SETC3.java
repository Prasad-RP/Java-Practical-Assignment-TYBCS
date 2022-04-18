//SET C 
//c) Read a text file, specified by the first command line argument, into a list. The
// program should then display a menu which performs the following operations on the
// list:
// 1. Insert line 2. Delete line 3. Append line 4. Modify line 5. Exit
// When the user selects Exit, save the contents of the list to the file and end the
// program.

import java.util.*;
import java.io.*;

public class SETC3 {
    public static void main(String arg[]) {
        try {
            File f = new File("Setb3.txt");
            BufferedReader br = null;

            br = new BufferedReader(new FileReader(f));
            FileOutputStream fout = new FileOutputStream("Setc3.txt");
            int ch;
            ArrayList al = new ArrayList();

            Scanner sc = new Scanner(System.in);

            String line = "";
            while ((line = br.readLine()) != null) {
                al.add(line);

            } // while
              // main logic
            do {
                System.out.println("1.Insert Line\n2.Delete Line\n3.Append Line\n4.Modify Line\n5.Exit");
                System.out.println("Enter choice: ");
                ch = sc.nextInt();
                String l1 = "This is a new Line\n";
                switch (ch) {
                    case 1:
                        al.add(l1);
                        break;

                    case 2:
                        al.remove(l1);
                        break;

                    case 3:
                    //Append line also means add it in list
                        al.add(l1);
                        break;

                    case 4:
                        int n = al.size() - 1;
                        al.set(n, "Updated line");

                        break;
                    case 5:
                        ListIterator li = al.listIterator();
                        while (li.hasNext()) {
                            String l2 = (String) li.next();
                            byte b[] = l2.getBytes();
                            fout.write(b);

                        }
                        fout.close();
                        br.close();
                        System.exit(1);
                        break;

                }
            } while (ch < 6);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
