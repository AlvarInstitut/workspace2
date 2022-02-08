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

public class PassarUnaRutaAmbSegments {

	public static void main(String[] args)
			throws SAXException, IOException, ParserConfigurationException, SQLException {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("rutas.xml");
		NodeList rutes = doc.getElementsByTagName("ruta");

		for (int i = 0; i < rutes.getLength(); i++) {
			Connection bd = DriverManager.getConnection("jdbc:postgresql://89.36.214.106/MasosRutesLlucena","postgres", "p0stgr3s");
			Statement st = bd.createStatement();
			Element ruta = (Element) rutes.item(i);
			String nom_r = ruta.getElementsByTagName("name").item(0).getTextContent();
			String nom_f = ruta.getElementsByTagName("file").item(0).getTextContent();
			String sent1 = "INSERT INTO RUTES(num_r,nom_r) VALUES(" + (i+1) +",'" + nom_r + "')";
			System.out.println(sent1);
			st.executeUpdate(sent1);
			Document doc1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("rutas/" + nom_f);
			NodeList segments = doc1.getElementsByTagName("trkseg");

			for (int j = 0; j < segments.getLength(); j++) {
				Element s = (Element) segments.item(j);
				String sent2 = "INSERT INTO SEGMENTS (num_r,num_s) VALUES(" + (i+1) + "," + (j+1) + ")";
				System.out.println("\t" + sent2);
				st.executeUpdate(sent2);
				NodeList punts = s.getElementsByTagName("trkpt");
				for (int k = 0; k < punts.getLength(); k++) {
					Element p = (Element) punts.item(k);
					String sent3 = "INSERT INTO PUNTS VALUES (" + (i+1) + "," + (j+1) + "," + (k + 1) + ",'" + p.getAttribute("lat") + "','" + p.getAttribute("lon") + "')";
					System.out.println("\t\tPunt " + sent3);
					st.executeUpdate(sent3);

				}

			}
		}

	}

}
