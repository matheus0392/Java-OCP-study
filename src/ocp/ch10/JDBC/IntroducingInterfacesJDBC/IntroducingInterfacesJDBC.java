package ocp.ch10.JDBC.IntroducingInterfacesJDBC;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IntroducingInterfacesJDBC {

	public static void main(String[] args) {

		// DriverManager	getConnection(url)
		// Connection		createStatement()
		// Statement		executeQuery(sql)
	}
}

class MyFirstDatabaseConnection {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:derby:zoo";
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select name from animal")) {
			while (rs.next())
				out.println(rs.getString(1));
		}
	}
}