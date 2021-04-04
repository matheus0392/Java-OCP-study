package ocp.ch10.JDBC.ObtainingStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChoosingResultSetTypeMode {

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
		
		// type TYPE_SCROLL_INSENSITIVE and TYPE_SCROLL_SENSITIVE
		// mode CONCUR_UPDATABLE and CONCUR_READ_ONLY 
		Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
	}
}
