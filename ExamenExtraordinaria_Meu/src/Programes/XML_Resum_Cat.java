package Programes;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import net.xqj.exist.ExistXQDataSource;

public class XML_Resum_Cat {

	public static void main(String[] args) throws XQException {
		XQConnection conn = new ExistXQDataSource().getConnection("admin","admin");
		
		XQPreparedExpression cons = conn.prepareExpression("distinct-values(//cat)");
		XQResultSequence rs = cons.executeQuery();
		   
		while(rs.next()){
			String categoria = rs.getItemAsString(null);
			XQResultSequence rs1 = conn.prepareExpression("count(//categories[cat=\"" + categoria + "\"])").executeQuery();
			rs1.next();
			System.out.println(categoria + ": " + rs1.getInt());
		} 
		conn.close();

	}

}
