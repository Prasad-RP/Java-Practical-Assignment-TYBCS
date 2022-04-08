import java.sql.*;

public class Student {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// load a driver
			Class.forName("org.postgresql.Driver");

			// Establish Connection
			conn = DriverManager.getConnection("jdbc:postgresql://localhost/bcs", "postgres", "");

			// create stament and execute queries
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString("sname") + "\t" + rs.getFloat("per"));
			} // while

			// close resultset,stmt & connection Object
			rs.close();
			stmt.close();
			conn.close();

		} // try
		catch (Exception e) {
			System.out.println(e);
		} // catch
	}// main
}// class
