package ocp.ch10.JDBC.ExecutingStatement;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class GettingDataForColumn {

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select date_born from animal where name = 'Elsa'");
		if (rs.next()) {
			java.sql.Date sqlDate = rs.getDate(1);
			LocalDate localDate = sqlDate.toLocalDate();
			out.println(localDate); // 2001―05―06

			java.sql.Time sqlTime = rs.getTime(1);
			LocalTime localTime = sqlTime.toLocalTime();
			out.println(localTime); // 02:15

			java.sql.Timestamp sqlTimeStamp = rs.getTimestamp(1);
			LocalDateTime localDateTime = sqlTimeStamp.toLocalDateTime();
			out.println(localDateTime); // 2001―05―06T02:15
		}

		rs = stmt.executeQuery("select id, name from species");
		while (rs.next()) {
			Object idField = rs.getObject("id");
			Object nameField = rs.getObject("name");
			if (idField instanceof Integer) {
				int id = (Integer) idField;
				out.println(id);
			}
			if (nameField instanceof String) {
				String name = (String) nameField;
				out.println(name);
			}
		}

	}

}
