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

public class PassarMasos {

	public static void main(String[] args) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException, SQLException {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(new FileInputStream("terme.xml"));
        Element arrel = (Element) doc.getChildNodes().item(0);
        NodeList llista = arrel.getElementsByTagName("trkpt");
        
        Connection bd = DriverManager.getConnection("jdbc:postgresql://89.36.214.106/MasosLlucena_ws", "postgres", "p0stgr3s");
        String sql = "INSERT INTO TERME(latitud,longitud) VALUES(?,?)";
        PreparedStatement st = bd.prepareStatement(sql);
        for (int i=0;i<llista.getLength();i++){
        	Element e = (Element) llista.item(i);
        	st.setDouble(1,Double.parseDouble(e.getElementsByTagName("lat").item(0).getTextContent()));
        	st.setDouble(2,Double.parseDouble(e.getElementsByTagName("lon").item(0).getTextContent()));
        	st.execute();
        }
        bd.close();

	}

}
