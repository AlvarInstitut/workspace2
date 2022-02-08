package exist;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import org.w3c.dom.Element;

import net.xqj.exist.ExistXQDataSource;

public class Exist_ResumTallers {

	public static void main(String[] args) throws XQException {
		XQDataSource s = new ExistXQDataSource();
		   s.setProperty("serverName", "localhost");
		   s.setProperty("port", "8080");
		   s.setProperty("user", "admin");
		   s.setProperty("password", "admin");
		 
		   XQConnection conn = s.getConnection();
		   //String sent ="for $t in //taller return concat($t/nom,\": \",count($t//ordinador))";
		   String sent = "//taller";
		   XQPreparedExpression cons = conn.prepareExpression(sent);
		   XQResultSequence rs = cons.executeQuery();
		   
		while(rs.next()){
			Element taller = (Element) rs.getObject();
			System.out.println(taller.getElementsByTagName("nom").item(0).getTextContent() + ": " + taller.getElementsByTagName("ordinador").getLength() + " ordinadors");
		}
		   conn.close();
		

	}

}
