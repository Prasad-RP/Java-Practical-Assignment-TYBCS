import java.sql.*;
import java.util.*;

public class Student1 {
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

			// close resultset,stmt & connection Object
			pstmt.close();
			conn.close();

		} // try
		catch (Exception e) {
			System.out.println(e);
		} // catch
	}// main
}// class
