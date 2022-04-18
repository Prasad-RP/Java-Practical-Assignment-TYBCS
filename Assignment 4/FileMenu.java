import java.io.*;
import java.util.*;

public class FileMenu {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("num.txt");
			FileReader fr = new FileReader("num.txt");
			Scanner sc = new Scanner(System.in);
			int choice;
			int num[ ] = new int[10];
			do {

				System.out.println("\n\n\tFile Menu\n");
				System.out.println("1. Generate and Disply Numbers");
				System.out.println("2. Save Numbers in file");
				System.out.println("3. View File Content");
				System.out.println("4. Exit");
				System.out.println("Enter Your Choice");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					Random r = new Random();
					for (int i = 0; i < 10; i++) {
						num[i] = r.nextInt(20);
						System.out.print(num[i] + " ");
					}
					break;
				case 2:
					for (int i = 0; i < 10; i++) {
						fw.write(num[i]);
					}
					System.out.println("\n\tFile Content Saved");
					fw.close();
					break;
				case 3:
					int ch;
			   System.out.println("\n\tFile Content\n");		
					while ((ch = fr.read()) != -1) {
						System.out.print(ch + " ");
					}
					fr.close();
					break;
				case 4:
					break;
				}//switch
			} while (choice != 4);
		} catch (Exception e) {
			System.out.println(e);

		}
	}
}