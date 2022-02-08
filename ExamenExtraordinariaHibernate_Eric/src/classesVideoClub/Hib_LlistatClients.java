package classesVideoClub;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Hib_LlistatClients {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SessionFactory sfact = SessionFactoryUtil.getSessionFactory();
        Session sessio = sfact.openSession();
        Client com = (Client) sessio.load(Client.class, "");
        System.out.print("Nom " + com.getNom() + ": ");
        sessio.close();

	}

}
