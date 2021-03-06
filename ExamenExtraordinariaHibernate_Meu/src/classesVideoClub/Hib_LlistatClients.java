package classesVideoClub;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Hib_LlistatClients {

	public static void main(String[] args) {
		 Session sessio = new Configuration().configure().buildSessionFactory().openSession();
		 Query q = sessio.createQuery("from Client order by nom");
         for (Client c : (List<Client>) q.list()){
        	 System.out.println("Nom client: " + c.getNom() + ". Adreça: " + c.getAdreca());
        	 System.out.println("   Pel·lícules prestades:");
        	 for (Lloguer l : c.getLloguers())
        		 System.out.println("   ----> " + l.getPelLicula().getTitol() + ". Data préstec: " + l.getDataP());
        	 System.out.println();
         }
         sessio.close();
	}

}
