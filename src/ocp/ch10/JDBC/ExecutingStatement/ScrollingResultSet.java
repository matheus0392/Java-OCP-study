package ocp.ch10.JDBC.ExecutingStatement;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollingResultSet {

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:zoo");

		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("select id from species order by id");
		rs.afterLast();
		out.println(rs.previous()); // true
		out.println(rs.getInt(1)); // 2
		out.println(rs.previous()); // true
		out.println(rs.getInt(1)); // 1
		out.println(rs.last()); // true
		out.println(rs.getInt(1)); // 2
		out.println(rs.first()); // true
		out.println(rs.getInt(1)); // 1
		rs.beforeFirst();
		/** out.println(rs.getInt(1)); */ // throws SQLException
		out.println();

		rs = stmt.executeQuery("select id from species where id = -99");
		out.println(rs.first()); // false
		out.println(rs.last()); // false
		out.println();

		rs = stmt.executeQuery("select id from animal order by id");
		out.println(rs.absolute(2)); // true
		out.println(rs.getString("id")); // 2
		out.println(rs.absolute(0)); // false
		out.println(rs.absolute(5)); // true
		out.println(rs.getString("id")); // 5
		out.println(rs.absolute(-2)); // true //backward, counting from the end
		out.println(rs.getString("id")); // 4
		out.println();

		rs = stmt.executeQuery("select id from animal order by id");
		out.println(rs.next()); // true
		out.println(rs.getString("id")); // 1
		out.println(rs.relative(2)); // true
		out.println(rs.getString("id")); // 3
		out.println(rs.relative(-1)); // true
		out.println(rs.getString("id")); // 2
		out.println(rs.relative(4)); // false
	}

}
