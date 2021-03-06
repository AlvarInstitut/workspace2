package Programes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Alu_Pract {

	public static void main(String[] args) throws SQLException {
		Connection bd = DriverManager.getConnection("jdbc:postgresql://80.35.84.29/autoescola", "autoescola", "autoescola");
		Statement st = bd.createStatement();
		ResultSet rs = st.executeQuery("SELECT NOM, COUNT(*),SUM(km) FROM ALUMNE INNER JOIN PRACTIQUES USING(dni) GROUP BY nom ORDER BY nom");
		while (rs.next())
			System.out.println(rs.getString(1) + "(" + rs.getInt(2) + " ---> " + rs.getLong(3) + " km)");
		rs.close();
		st.close();
		bd.close();
	}

}
