// SET C
//b) Create the following tables and relations, for an INVESTMENT firm EMP(empid
// empname, empaddress, empcontact, empage) INVESTOR(invno, invname , invdate,
// invamt) An employee may invest in one or more investments, hence he can be an
// investor. But an investor need not be an employee of the firm. Insert sufficient
// number of records in the relations / tables with appropriate values.
// i. Display the List the distinct names of person who are either employees, or
// investors or both.
// ii. List the names of employees who are not investors

import java.sql.*;

public class SETC2 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // load a driver
            Class.forName("org.postgresql.Driver");

            // Establish Connection
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/bcs", "postgres", "");

            // names of person who are either employees or investors or both
            stmt = conn.createStatement();
            rs = stmt.executeQuery(
                    "select empname from emp union select invname from investor");

            System.out.println("names of person who are either employees or investors or both");
            while (rs.next()) {
                System.out.println(rs.getString("empname") + "\t" + rs.getString("invname"));
            } // while

            // names of employees who are not investors
            System.out.println("names of employees who are not investors");
            
            rs = stmt.executeQuery("select empname from emp minus select invname from investor");
            while (rs.next()) {
                System.out.println(rs.getString("empname"));
            } // while

            // close resultset,stmt & connection Object
            rs.close();
            stmt.close();
            conn.close();

        } // try
        catch (Exception e) {
            System.out.println(e);
        } // catch

    }
}
