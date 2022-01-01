/*
Set A)
b)
 Write a program to read a text file “sample.txt” and display the contents of a file in

reverse order and also original contents change the case (display in upper case).

*/
import java.io.*;

public class ReveseFileContent {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("a.txt");
			int ch;
			String rev="",org="";
			char chr;
			   System.out.println("Original Content Of File:\n");
			while ((ch = fin.read()) != -1) {
			
		    System.out.printf("%c",ch);
		    org +=(char)(ch);
			}
	StringBuffer sbf=new StringBuffer(org);
	   System.out.println("\nReverse File Content: "+sbf.reverse());

			
			
			/*
			// reverse Logic
		   for (int i=0; i<org.length(); i++)
      {
        chr= org.charAt(i); 
        rev=chr+rev;
      }	
      
	   System.out.println("\nReversed file Content: \n"+rev);	
	   */
	   System.out.println("\nOriginal file Content In Upper case: \n"+org.toUpperCase());
			
			
			fin.close();
		}// try
		catch (Exception e) {
			System.out.println("File Error:");
			System.out.println(e);
		}

	}
}