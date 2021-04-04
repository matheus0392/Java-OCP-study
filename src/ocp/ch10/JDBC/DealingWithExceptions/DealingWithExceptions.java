package ocp.ch10.JDBC.DealingWithExceptions;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DealingWithExceptions {

	public static void main(String[] args) {
		String url = "jdbc:derby:zoo";
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select not_a_column from animal")) {
			while (rs.next())
				out.println(rs.getString(1));
		} catch (SQLException e) {
			out.println(e.getMessage());
			out.println(e.getSQLState());
			out.println(e.getErrorCode());
		}
	}
}
