package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_ConsultaClients {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:sqlite:Factura.sqlite");
		
		Statement st = con.createStatement();
		String sql = "SELECT CLIENT.cod_cli,nom,COUNT(DISTINCT FACTURA.num_f),ROUND(SUM(quant*preu),2) "
						+ "FROM CLIENT,FACTURA,LINIA_FAC "
						+ "WHERE CLIENT.cod_cli=FACTURA.cod_cli AND FACTURA.num_f=LINIA_FAC.num_f "
						+ "GROUP BY 1,2 "
						+ "ORDER BY 1";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()){
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + ": " + rs.getInt(3) + " factures. " + rs.getDouble(4) + "€");
		}
		rs.close();
		st.close();
		con.close();
	}

}
