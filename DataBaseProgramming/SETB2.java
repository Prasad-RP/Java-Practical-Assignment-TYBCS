// SET B) b. Design a following Registration form and raise an appropriate exception if invalid
// information is entered like Birth Year ‘0000’ throw invalid date exception.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class InvalidBirthDateException extends Exception {

	String msg = "InvalidDate Exception\n";

	public String toString() {
		return msg;
	}

}

public class SETB2 extends JFrame implements ActionListener {
	JTextField adhar, byear, phone, hosp;
	JPanel p1, p2, p3, p4;
	JButton add, update, delete, view, search;
	JRadioButton r1, r2, r3, r4, r5, r6, r7, r8;
	ButtonGroup bg,bg1,bg2;
	JComboBox hos;
	String s[] = { "Tambe Hospital", "Daima Hospital", "Nighute Hospital" };

	SETB2() {
		setTitle("Cowin Registration");

		setSize(800, 600);

		setLayout(new GridLayout(8, 2, 40, 40));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel adharno = new JLabel("Adhar Card Number: ");
		add(adharno);
		adhar = new JTextField(10);
		add(adhar);

		JLabel Byear = new JLabel("Birth Year: ");
		add(Byear);
		byear = new JTextField(10);
		add(byear);

		JLabel phoneNo = new JLabel("Mobile Number: ");
		add(phoneNo);
		phone = new JTextField(10);
		add(phone);

		// Age Radio Button
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());

		JLabel Age = new JLabel("Age Group : ");
		add(Age);
		r1 = new JRadioButton("18 & above");
		p1.add(r1);
		// to get the value of radio button
		r1.setActionCommand("Above18");

		r2 = new JRadioButton("45 & above");
		r2.setActionCommand("Above45");
		p1.add(r2);
		add(p1);

		JLabel hospital = new JLabel("Select Hospital: ");
		add(hospital);

		hos = new JComboBox(s);
		add(hos);

		// Vaccines Radio Button
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());

		JLabel Vaccines = new JLabel("Vaccines : : ");
		add(Vaccines);

		r3 = new JRadioButton("Covishield");
		p2.add(r3);
		r3.setActionCommand("Covishield");

		r4 = new JRadioButton("Covaxin");
		p2.add(r4);
		r4.setActionCommand("Covaxin");

		r5 = new JRadioButton("Sputnik V");
		p2.add(r5);
		r5.setActionCommand("SputnikV");
		add(p2);

		// TimeSlot Radio Button
		p3 = new JPanel();
		p3.setLayout(new FlowLayout());

		JLabel Time = new JLabel("Time Slot : : ");
		add(Time);
		r6 = new JRadioButton("Morning");
		p3.add(r6);
		r6.setActionCommand("Morning");

		r7 = new JRadioButton("Afternoon");
		p3.add(r7);
		r7.setActionCommand("Afternoon");

		r8 = new JRadioButton("Evening");
		p3.add(r8);
		r8.setActionCommand("Evening");

		add(p3);

		// Button
		p4 = new JPanel();
		p4.setLayout(new FlowLayout());

		add = new JButton("Add");
		p4.add(add);
		update = new JButton("Update");
		p4.add(update);
		delete = new JButton("Delete");
		p4.add(delete);
		view = new JButton("View");
		p4.add(view);
		search = new JButton("Search");
		p4.add(search);
		add(p4);

		add.addActionListener(this);

		bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);

		bg1 = new ButtonGroup();
		bg1.add(r4);
		bg1.add(r3);
		bg1.add(r5);

		bg2 = new ButtonGroup();
		bg2.add(r6);
		bg2.add(r7);
		bg2.add(r8);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == add) {

			String ad = (adhar.getText());
			int y = Integer.parseInt(byear.getText());
			String ph = (phone.getText());
			String hosp = (String) (hos.getSelectedItem());
			String a=bg.getSelection().getActionCommand();
			String vax=bg1.getSelection().getActionCommand();
			String ts=bg2.getSelection().getActionCommand();


			try {
				if (y == 0000) {
					throw new InvalidBirthDateException();
				} else {
					Connection conn = null;
					PreparedStatement pstmt = null;
					try {
						// load a driver
						Class.forName("org.postgresql.Driver");

						// Establish Connection
						conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");
						pstmt = conn.prepareStatement("insert into projectdemo values(?,?,?,?,?,?,?)");

						pstmt.setString(1, ad);
						pstmt.setInt(2, y);
						pstmt.setString(3, ph);
						pstmt.setString(4, hosp);
						pstmt.setString(5, a);
						pstmt.setString(6, vax);
						pstmt.setString(7, ts);

						int result = pstmt.executeUpdate();
						if (result == 1) {

							JOptionPane.showMessageDialog(null, "Succesfully Inserted", ad,
									JOptionPane.INFORMATION_MESSAGE);
							// System.out.println(result + " Record Inserted");
						}

						pstmt.close();
						conn.close();

					} // try
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, e, "ERROR OCCURED", JOptionPane.ERROR_MESSAGE);
						System.out.println(e);
					} // catch
				}
			} catch (InvalidBirthDateException e) {
				JOptionPane.showMessageDialog(null, e, "ERROR OCCURED", JOptionPane.ERROR_MESSAGE);
				System.out.println(e);
			}

		}
	}

	public static void main(String[] args) {
		new SETB2();
	}// MAIN

}// CLASS
