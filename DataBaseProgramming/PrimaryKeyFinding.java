import java.sql.*;

public class PrimaryKeyFinding {
    
     // required for other operations
    public Connection con = null;
    public PreparedStatement ps = null;
    public Statement st = null;
    public ResultSet rs = null;
    public DatabaseMetaData dbmd = null;

    PrimaryKeyFinding() {
        try {
            // load a driver
            Class.forName("org.postgresql.Driver");

            // Establish Connection
            con = DriverManager.getConnection("jdbc:postgresql://localhost/bcs", "postgres", "12345");
            //to find primary key of table
            dbmd=con.getMetaData();
            rs=dbmd.getTables(null, null, "test", new String[]{"TABLES"});
            rs=dbmd.getPrimaryKeys(null, null, "test");
            while(rs.next()){
                System.out.println("Primary key: "+rs.getString(4));
            }

            //to find foreign key
            rs=dbmd.getExportedKeys(null, null, "our_table_name");
            while(rs.next()){
                System.out.println("foreign key: "+rs.getString(4));
            }

        } // try
        catch (Exception e) {
            System.out.println(e);
        } // catch

    }// PrimaryKeyFinding()

    public static void main(String[] args) {
        new PrimaryKeyFinding();
    }

}
