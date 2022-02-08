import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQResultSequence;

import net.xqj.exist.ExistXQDataSource;

public class XML_ResumHorari {

	public static void main(String[] args) throws XQException {
		XQConnection bd = new ExistXQDataSource().getConnection("admin","admin");
		
		XQResultSequence rs1 = bd.createExpression().executeQuery("//dia/numdia/xs:int(text())");
		String[] dies = {"Dilluns", "Dimarts", "Dimecres" , "Dijous" , "Divendres"};
		while(rs1.next()){
			int dia = rs1.getInt();
			XQResultSequence rs2 = bd.createExpression().executeQuery("count(//dia[numdia=" + dia + "]/tasca)");
			rs2.next();
			System.out.println(dies[dia-1] + ". Tasques: " + rs2.getInt() + "\n");
		}
		
	}

}
