import java.sql.*;

public class S1 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;

        ResultSet rs = null;
        try {

            // load a driver
            Class.forName("org.postgresql.Driver");

            // Establish Connection
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/bcs", "postgres", "");

            // create stament and execute queries
            stmt = conn.createStatement();
            String SQL = "Update student set=90 where rno=5";
            pstmt.executeUpdate();

            rs = stmt.executeQuery("select * from student");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString("sname") + "\t" + rs.getFloat("per"));
            } // while

            // close resultset,stmt & connection Object
            rs.close();
            stmt.close();
            pstmt.close();
            conn.close();

        } // try
        catch (Exception e) {
            System.out.println(e);
        } // catch
    }// main
}// class
