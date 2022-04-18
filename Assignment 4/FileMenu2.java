import java.io.*;
import java.util.*;

public class FileMenu2 {
	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("num2.txt");
			FileReader fr = new FileReader("num2.txt");
			Scanner sc = new Scanner(System.in);
			int choice,n;
			String num= "";
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
						n= r.nextInt(20);
						num+=n+" ";
						System.out.print(n + " ");
					}
					break;
				case 2:
				byte b[ ] =num.getBytes();						fout.write(b);
					System.out.println("\n\tFile Content Saved");
					fout.close();
					break;
				case 3:
					int ch;
			   System.out.println("\n\tFile Content\n");	
			   
					while ((ch = fr.read()) != -1) {
						System.out.print((char)ch );
					}
					fin.close();
				
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