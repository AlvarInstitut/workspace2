package Programes;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import net.xqj.exist.ExistXQDataSource;

public class XML_Resum_Cat2 {

	public static void main(String[] args) throws XQException {
		XQConnection conn = new ExistXQDataSource().getConnection("admin","admin");
		
		XQPreparedExpression cons = conn.prepareExpression("for $cat in distinct-values(//cat) "
															+ "order by $cat "
															+ "return concat($cat, \": \" ,count(//categories[cat=$cat]))");
		XQResultSequence rs = cons.executeQuery();
		   
		while(rs.next())
			System.out.println(rs.getItemAsString(null));
		 
		conn.close();

	}

}
