package ocp.ch10.JDBC.ExecutingStatement;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecutingStatement {

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
		Statement stmt = conn.createStatement();

		// int executeUpdate(sql)
		int result = stmt.executeUpdate("insert into species values(10, 'Deer', 3)");
		out.println(result); // 1
		result = stmt.executeUpdate("update species set name = '' where name = 'None'");
		out.println(result); // 0
		result = stmt.executeUpdate("delete from species where id = 10");
		out.println(result); // 1

		// ResultSet executeQuery(sql)
		ResultSet rs = stmt.executeQuery("select * from species");

		String sql="select * from species";
		boolean isResultSet = stmt.execute(sql); // SELECT -> true
		
		if (isResultSet) {
			rs = stmt.getResultSet();
			out.println("ran a query"+rs);
		} else {
			result = stmt.getUpdateCount();
			out.println("ran an update"+result);
		}
		
		//result = stmt.executeUpdate("select * from species"); // java.sql.SQLException: 
		// rs = stmt.executeQuery("insert into species values(10, 'Deer', 3)"); // java.sql.SQLException: 

	}

}
