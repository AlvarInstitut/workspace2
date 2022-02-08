package Programes;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Alu_Pract {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		String url = "jdbc:postgresql://80.35.84.29:5432/autoescola";

		Connection con = DriverManager.getConnection(url, "autoescola", "autoescola");

		ResultSet rs = con.createStatement().executeQuery("select nom from ALUMNE order by nom");
		ResultSet rs2= con.createStatement().executeQuery("select data from PRACTIQUES");
		ResultSet rs3 = con.createStatement().executeQuery("select km from PRACTIQUES");

		while (rs.next()) {
	          System.out.println(rs.getString(1)+" ("+rs2+" ---> "+rs3+" km");
	         
		}
		rs.close();
		rs2.close();
		rs3.close();
		con.close();
	}
}
