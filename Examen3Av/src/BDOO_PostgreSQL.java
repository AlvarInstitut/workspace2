
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDOO_PostgreSQL {

	public static void main(String[] args) throws SQLException {
		Connection bd = DriverManager.getConnection("jdbc:postgresql://80.35.84.29:5432/factura_obj","factura_obj","factura_obj");
		
		ResultSet rs = bd.createStatement().executeQuery("SELECT numF,data,(cli).nom,liniesFac FROM FACTURA ORDER BY numF");
		
		while (rs.next()){
			System.out.println("Factura número: " + rs.getInt(1) + ". Data: " + rs.getString(2) + ". Client: " + rs.getString(3));
			ResultSet rs_l = rs.getArray(4).getResultSet();
			while (rs_l.next())
				System.out.println("   ---> " + rs_l.getString(2));
			rs_l.close();
		}
		rs.close();
		bd.close();

	}

}
