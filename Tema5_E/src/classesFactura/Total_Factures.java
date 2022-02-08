package classesFactura;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

public class Total_Factures {

	public static void main(String[] args) {
		Session con = SessionFactoryUtil.getSessionFactory().openSession();
		Query q = con.createQuery("from Factura where data>='2010-01-01' and data<='2010-01-31'");
		
		for (Factura f : (ArrayList<Factura>) q.list()){
			double total=0;
			for (LiniaFac l : f.getLiniaFacs())
				total += l.getPreu().doubleValue() * l.getQuant();
			System.out.println(" Factura: " + f.getNumF() + ". Client: " + f.getClient().getNom() + " Data: " + f.getData() + ". Total: "+ total );
		}	

	}

}
