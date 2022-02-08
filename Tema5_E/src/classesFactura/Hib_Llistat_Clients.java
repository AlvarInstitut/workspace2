package classesFactura;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

public class Hib_Llistat_Clients {

	public static void main(String[] args) {
		Session con = SessionFactoryUtil.getSessionFactory().openSession();
		Query q = con.createQuery("from Client where poble.nom='CASTELLON' order by nom");
		for (Client c : (ArrayList<Client>) q.list()){
			System.out.println(c.getNom() + " (" + c.getPoble().getNom() + "). Número de factures: " + c.getFacturas().size());
		}
		con.close();
	}

}
