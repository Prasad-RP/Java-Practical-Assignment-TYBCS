import java.sql.*;
import java.util.*;

public class StudentMenu {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// load a driver
			Class.forName("org.postgresql.Driver");

			// Establish Connection
			conn = DriverManager.getConnection("jdbc:postgresql://localhost/bcs", "postgres", "");

			pstmt = conn.prepareStatement("insert into student values(?,?,?)");
			Scanner sc = new Scanner(System.in);
			System.out.println("\nStudent records\n");
			System.out.println("1.Insert Record \n2.Update Record\n3.Delete Record\4.Display Record\n5Exit");
			System.out.println("Enter Your Choice: ");
			int ch = sc.nextInt();
			switch (ch) {
				case 1:
					System.out.println("Enter Roll No : ");
					int r = sc.nextInt();
					pstmt.setInt(1, r);

					sc.nextLine();
					System.out.println("Enter Student Name: ");
					String name = sc.nextLine();
					pstmt.setString(2, name);

					System.out.println("Enter Percentage : ");
					float per = sc.nextFloat();
					pstmt.setFloat(3, per);

					int result = pstmt.executeUpdate();
					System.out.println(result + "  Inserted");
					break;

				case 2:
					String SQL = "Update student set=? where rno=?";
					System.out.println("Enter Roll No for Update Record: ");
					int rn = sc.nextInt();
					pstmt.setInt(1, rn);

					System.out.println("Enter Percentage for Update: ");
					float percent = sc.nextFloat();
					pstmt.setFloat(3, percent);
			}

			pstmt.close();
			conn.close();

		} // try
		catch (Exception e) {
			System.out.println(e);
		} // catch
	}// main
}// class
