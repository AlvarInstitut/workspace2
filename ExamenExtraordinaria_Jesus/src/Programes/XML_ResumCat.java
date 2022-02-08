/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programes;

import java.util.ArrayList;
import java.util.Collections;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.xqj.exist.ExistXQDataSource;

/**
 *
 * @author Pri
 */
public class XML_ResumCat {

    public static void main(String[] args) throws XQException {
        XQDataSource s = new ExistXQDataSource();
        s.setProperty("serverName", "localhost");
        s.setProperty("port", "8080");
        s.setProperty("user", "admin");
        s.setProperty("password", "admin");

        XQConnection conn = s.getConnection();
        // System.out.println("Connexió feta");

        String sent = "//categories/cat/xs:string(text())";

        XQPreparedExpression cons = conn.prepareExpression(sent);
        XQResultSequence rs = cons.executeQuery();
        ArrayList<String> cat = new ArrayList<String>();
        while (rs.next()) {
             // System.out.println(rs.getItemAsString(null));
             cat.add(rs.getItemAsString(null));
        }
        
        Collections.sort(cat);
        
        Set<String> quipu = new HashSet<String>(cat);
        for (String key : quipu) {
            System.out.println(key + " : " + Collections.frequency(cat, key));
        }
        
        
        // System.out.println(cat);
        
        
        
        conn.close();


        
    }
}
