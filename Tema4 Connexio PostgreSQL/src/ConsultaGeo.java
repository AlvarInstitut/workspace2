import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaGeo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://192.168.1.15:5432/geo";
        String usuari = "geo";
        String password = "geo";
        Connection con = DriverManager.getConnection(url, usuari, password);

        Statement statement = con.createStatement();

        String sentenciaSQL = "SELECT * FROM COMARQUES";
        ResultSet rs = statement.executeQuery(sentenciaSQL);

        System.out.println("Nom" + "\t" + "Província");
        System.out.println("-----------------------------------------");

        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2));
        }
    }
}