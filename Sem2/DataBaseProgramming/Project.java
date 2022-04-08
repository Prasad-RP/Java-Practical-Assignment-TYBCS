// Set A
// a) Create a PROJECT table with fields project_id, Project_name, Project_description,
// Project_Status. etc. Insert values in the table. Display all the details of the PROJECT
// table in a tabular format on the screen.(using swing). 

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class Project extends JFrame implements ActionListener {

    Connection con;
    ResultSet rs;
    Statement st;

    static JTable table;
    String[] columnNames = { "p_id", "p_name", "p_description", "p_status" };
    JFrame frm;
    JPanel p1;
    String p_id = "", p_name = "", p_description = "", p_status = "";
    JTextField txtid, txtname, txtdesc, textstatus;

    JButton Insert, Display, Exit;

    Insert iobj;

    Project() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("PROJECT INFO");

        p1 = new JPanel();

        p1.setLayout(new GridLayout(4, 1, 10, 10));

        Insert = new JButton("Insert");
        p1.add(Insert);

        Display = new JButton("Display");
        p1.add(Display);

        Exit = new JButton("Exit");
        p1.add(Exit);

        Insert.addActionListener(this);
        Display.addActionListener(this);
        Exit.addActionListener(this);

        add(p1, BorderLayout.CENTER);
        setVisible(true);
        setSize(300, 300);
    }// ProjectDetails

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == Display) {
            frm = new JFrame("DISPLAY");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            setLayout(new BorderLayout());
            DefaultTableModel model = new DefaultTableModel();

            model.setColumnIdentifiers(columnNames);
            table = new JTable();

            table.setModel(model);

            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

            table.setFillsViewportHeight(true);

            JScrollPane scroll = new JScrollPane(table);

            scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            try {
                Class.forName("org.postgresql.Driver");
                // Use database name & password according to your "dbname","pass"
                con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");

                st = con.createStatement();
                rs = st.executeQuery("select * from project");

                while (rs.next()) {
                    p_id = rs.getString(1);
                    p_name = rs.getString(2);
                    p_description = rs.getString(3);
                    p_status = rs.getString(4);

                    // This all coloumn names are taken from project table.
                    model.addRow(new Object[] { p_id, p_name, p_description, p_status });

                } // while
                frm.add(scroll);

                frm.setVisible(true);
                frm.setSize(400, 400);
            } // try

            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (ae.getSource() == Insert) {
            iobj = new Insert();
        }
        if (ae.getSource() == Exit) {

            System.exit(1);

        }

    }

    public static void main(String arg[]) {

        Project pd = new Project();
    }// main
}// class

class Insert extends JFrame implements ActionListener {

    JTextField txtst, txtpid, txtpname, txtdsc;
    JButton btnadd, btnclear;

    Insert() {
        setTitle("Peoject Record Inserts");
        setSize(400, 500);
        setVisible(true);
        setLayout(new GridLayout(6, 2, 40, 40));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel id = new JLabel("Enter Project Number: ");
        add(id);
        txtpid = new JTextField(10);
        add(txtpid);

        JLabel name = new JLabel("Enter Project Name: ");
        add(name);
        txtpname = new JTextField(10);
        add(txtpname);

        JLabel dsc = new JLabel("Enter Project Description: ");
        add(dsc);
        txtdsc = new JTextField(10);
        add(txtdsc);

        JLabel st = new JLabel("Enter Project Status: ");
        add(st);
        txtst = new JTextField(10);
        add(txtst);

        btnadd = new JButton("Insert");
        add(btnadd);
        btnadd.addActionListener(this);

        btnclear = new JButton("Cancel");
        add(btnclear);
        btnclear.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        // String str = ae.getActionCommand();

        int p_id = Integer.parseInt(txtpid.getText());
        String pname = (txtpname.getText());
        String ds = (txtdsc.getText());
        String st = (txtst.getText());

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // load a driver
            Class.forName("org.postgresql.Driver");

            // Establish Connection
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");

            if (ae.getSource() == btnadd) {
                pstmt = conn.prepareStatement("insert into project values(?,?,?,?)");

                pstmt.setInt(1, p_id);
                pstmt.setString(2, pname);
                pstmt.setString(3, ds);
                pstmt.setString(4, st);

                int result = pstmt.executeUpdate();
                if (result == 1) {

                    JOptionPane.showMessageDialog(null, "Succesfully Inserted", st, JOptionPane.INFORMATION_MESSAGE);
                    // System.out.println(result + " Record Inserted");
                }

                pstmt.close();
                conn.close();
            } // if of submit

            if (ae.getSource() == btnclear) {
                // System.exit(1);
                txtpid.setText("");
                txtdsc.setText("");
                txtpname.setText("");
                txtst.setText("");

            } // if of clear

        } // try
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "ERROR OCCURED", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        } // catch
    }

}// insert

