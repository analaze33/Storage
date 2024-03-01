package Project;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DBConnection {
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/online_ordering", "root", "");
			JOptionPane.showMessageDialog(null, "Connected with the db!");
		}
		catch(Exception e) {
			System.out.println("The error was: "+ e);
			
		}
		return con;
	}
}
