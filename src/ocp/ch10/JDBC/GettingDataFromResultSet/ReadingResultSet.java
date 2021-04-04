package ocp.ch10.JDBC.GettingDataFromResultSet;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class ReadingResultSet {

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
		Statement stmt = conn.createStatement();

		Map<Integer, String> idToNameMap = new HashMap<>();
		Map<Integer, String> idToNameMap2 = new HashMap<>();
		ResultSet rs = stmt.executeQuery("select id, name from species");

		// rs.next() = false -> rs.get... -> java.sql.SQLException

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			idToNameMap.put(id, name);

			// same result
			int id2 = rs.getInt(1);
			String name2 = rs.getString(2);
			idToNameMap2.put(id2, name2);

			/** id = rs. getInt (0); */ // java.sql.SQLException
		}
		out.println(idToNameMap); // {1=African Elephant, 2=Zebra}
		out.println(idToNameMap2); // {1=African Elephant, 2=Zebra}
		
		
		rs = stmt.executeQuery("select count(*) from animal");
		/**rs.getInt(1); */ // no next() java.sqlSQLException
		
		rs = stmt.executeQuery("select id from animal");
		rs.next();
		/** rs.getInt("badColumn"); */ // java.sqlSQLException
	}

}
