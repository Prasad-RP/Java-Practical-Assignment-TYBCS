/*
Set A
c) Accept the names of two files and copy the contents of the first to the second.

First file having Book name and Author name in file. Second file having the contents

of First file and also add the comment ‘end of file’ at the end of file
*/
import java.io.*;
import java.util.*;
public class FileCopy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name of File 1:  ");
		String f1 = sc.nextLine();
		System.out.println("Enter Name of File 2:  ");
		String f2 = sc.nextLine();

		try {

			FileInputStream fin = new FileInputStream(f1);
			FileOutputStream fout = new FileOutputStream(f2);
			int ch;

			while ((ch = fin.read()) != -1) {
				fout.write(ch);
			}
			String end = "End of File";
			byte b[ ] = end.getBytes();

			fout.write(b);
			System.out.println("File Content Copied\n");

			fin.close();
			fout.close();

		}// try
		catch (Exception e) {
			System.out.println("File Error:");
			System.out.println(e);
		}



	}
}