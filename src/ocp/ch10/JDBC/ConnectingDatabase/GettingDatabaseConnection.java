package ocp.ch10.JDBC.ConnectingDatabase;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GettingDatabaseConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
		out.println(conn);

		// DriverManager getConnection(url,user,pass)

		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ocp-book", "username", "password");
		out.println(conn);

		// old way
		Class.forName("org.postgresql.Driver"); // load a classe
		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ocp-book", "username", "password");
	}
}
