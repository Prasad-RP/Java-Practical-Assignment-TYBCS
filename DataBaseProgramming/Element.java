import java.sql.*;
import java.util.*;

public class Element {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        try {
            // load a driver
            Class.forName("org.postgresql.Driver");

            // Establish Connection
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/bcs", "postgres", "");
            // commond line input
            String ch = args[0];
            switch (ch) {
                case R:
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("select * from Element");
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
                    }

                    break;
                case U:

                    String SQL = "Update Element set atomic_no=? where atom_name=?";
                    pstmt = conn.prepareStatement(SQL);

                    System.out.println("Enter Atom name: ");
                    String mname = sc.nextLine();
                    pstmt.setString(1, name);

                    System.out.println("Enter Atomic No for Update Record: ");
                    int ano = sc.nextInt();
                    pstmt.setInt(2, ano);

                    pstmt.executeUpdate();
                    break;

            }
            st.close();
            conn.close();

        } // try
        catch (Exception e) {
            System.out.println(e);
        } // catch

    }
}
