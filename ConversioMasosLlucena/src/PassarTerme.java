import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PassarTerme {

	public static void main(String[] args) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException, SQLException {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(new FileInputStream("masos_bac.xml"));
        Element arrel = (Element) doc.getChildNodes().item(0);
        NodeList llista = arrel.getElementsByTagName("mas");
        
        Connection bd = DriverManager.getConnection("jdbc:postgresql://89.36.214.106/MasosLlucena", "postgres", "p0stgr3s");
        String sql = "INSERT INTO MASOS(nom,latitud,longitud,id_oscar) VALUES(?,?,?,?)";
        PreparedStatement st = bd.prepareStatement(sql);
        for (int i=0;i<llista.getLength();i++){
        	Element e = (Element) llista.item(i);
        	String nom= e.getElementsByTagName("NOMP").item(0).getTextContent();
        	if (nom == "")
        		nom = e.getElementsByTagName("NORMAL").item(0).getTextContent();
        	if (nom != ""){
        		st.setString(1,nom);
        		st.setDouble(2,Double.parseDouble(e.getElementsByTagName("lat").item(0).getTextContent()));
        		st.setDouble(3,Double.parseDouble(e.getElementsByTagName("lon").item(0).getTextContent()));
        		st.setInt(4,Integer.parseInt(e.getElementsByTagName("id").item(0).getTextContent()));
        		st.execute();
        		System.out.println(nom);
        	}
        }
        bd.close();

	}

}
