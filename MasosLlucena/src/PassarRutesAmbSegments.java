import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PassarRutesAmbSegments {

	public static void main(String[] args)
			throws SAXException, IOException, ParserConfigurationException, SQLException {

		Connection bd = DriverManager.getConnection("jdbc:postgresql://89.36.214.106/MasosRutesLlucena","postgres", "p0stgr3s");
			Statement st = bd.createStatement();
			//Era per a recuperar la ruta 5 
			String nom_f = "assud-ahicart.GPX";
			Document doc1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("rutas/" + nom_f);
			NodeList segments = doc1.getElementsByTagName("trkseg");

			for (int j = 0; j < segments.getLength(); j++) {
				Element s = (Element) segments.item(j);
				NodeList punts = s.getElementsByTagName("trkpt");
				for (int k = 0; k < punts.getLength(); k++) {
					Element p = (Element) punts.item(k);
					String sent3 = "INSERT INTO PUNTS VALUES (" + 5 + "," + (j+1) + "," + (k + 1) + ",' ','" + p.getAttribute("lat") + "','" + p.getAttribute("lon") + "')";
					System.out.println("\t\tPunt " + sent3);
					st.executeUpdate(sent3);

				}

			}
		

	}

}
