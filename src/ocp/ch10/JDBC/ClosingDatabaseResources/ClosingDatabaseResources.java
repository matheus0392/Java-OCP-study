package ocp.ch10.JDBC.ClosingDatabaseResources;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClosingDatabaseResources {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:derby:zoo";
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select count(*) from animal")) {
			
			if (rs.next())
				out.println(rs.getInt(1));
			ResultSet rs2 = stmt.executeQuery("select count(*) from animal"); //close rs resultset
			int num = stmt.executeUpdate("update animal set name = 'clear' where name = 'other'"); //close rs2 resultset
			
		}// close stmt and conn
	}
}
