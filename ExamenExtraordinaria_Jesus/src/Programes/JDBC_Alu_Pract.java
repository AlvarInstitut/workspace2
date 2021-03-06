/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Pri
 */
public class JDBC_Alu_Pract {

    static String driver = "org.postgresql.Driver";
    static String connectString = "jdbc:postgresql://80.35.84.29:5432/autoescola";
    static String user = "autoescola";
    static String password = "autoescola";

    public static void main(String[] args) {
        try {
            //Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            Statement stmt = con.createStatement();
            Statement stmt_p = con.createStatement();
            Statement stmt_k = con.createStatement();

            //  System.out.println(" result set ");
            ResultSet rs = stmt.executeQuery("SELECT * FROM alumne order by nom");

            while (rs.next()) {
                
                String dni = rs.getString("DNI");

                ResultSet rs_p = stmt_p.executeQuery("SELECT COUNT(*) FROM practiques WHERE DNI = "+"'"+dni+"'");
                rs_p.next();
                
                ResultSet rs_k = stmt_k.executeQuery("SELECT SUM(KM) FROM practiques WHERE DNI = "+"'"+dni+"'");
                rs_k.next();
                
                
                System.out.println(rs.getString("NOM") + "   (" + rs_p.getInt(1)+" --> "+rs_k.getInt(1)+")");
            }

            stmt.close();
            stmt_p.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
