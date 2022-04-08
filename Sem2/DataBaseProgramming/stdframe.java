import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class stdframe extends JFrame implements ActionListener {
	JTextField txtroll, txtname, txtper;
	JButton btnadd, btnclear;

	stdframe() {
		setTitle("Student Information");

		setSize(400, 500);
		setVisible(true);
		setLayout(new GridLayout(4, 2, 40, 40));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel rollno = new JLabel("Enter Roll Number: ");
		add(rollno);
		txtroll = new JTextField(10);
		add(txtroll);

		JLabel stdname = new JLabel("Enter Student Name: ");
		add(stdname);
		txtname = new JTextField(10);
		add(txtname);

		JLabel per = new JLabel("Enter Student Percentage: ");
		add(per);
		txtper = new JTextField(10);
		add(txtper);

		btnadd = new JButton("Submit");
		add(btnadd);
		btnadd.addActionListener(this);

		btnclear = new JButton("Update");
		add(btnclear);
		btnclear.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();

		int rn = Integer.parseInt(txtroll.getText());

		String name = (txtname.getText());

		float per = Float.parseFloat(txtper.getText());

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// load a driver
			Class.forName("org.postgresql.Driver");

			// Establish Connection
			conn = DriverManager.getConnection("jdbc:postgresql://localhost/bcs", "postgres", "");
			if (str.equals("Submit")) {
				pstmt = conn.prepareStatement("insert into student values(?,?,?)");

				pstmt.setInt(1, rn);
				pstmt.setString(2, name);
				pstmt.setFloat(3, per);

				int result = pstmt.executeUpdate();
				System.out.println(result + "  Record Inserted");

				txtroll.setText("");
				txtname.setText("");
				txtper.setText("");

			}
			if (str.equals("Update")) {
				String SQL = "Update student set per=? where rno=?";
				pstmt = conn.prepareStatement(SQL);

				pstmt.setFloat(1, per);

				pstmt.setInt(2, rn);

				int update = pstmt.executeUpdate();
				System.out.println(update + " Record updated");

				txtroll.setText("");
				txtname.setText("");
				txtper.setText("");
			} // if

			pstmt.close();
			conn.close();
		} // try
		catch (Exception e) {
			System.out.println(e);
		} // catch
	}

	public static void main(String[] args) {
		stdframe fr = new stdframe();
	}
}// main
