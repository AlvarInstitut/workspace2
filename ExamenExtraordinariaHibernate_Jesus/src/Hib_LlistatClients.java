
import classesVideoClub.*;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pri
 */
public class Hib_LlistatClients {

    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();// new Configuration().configure().buildSessionFactory();
        Session sessio = sf.openSession();

        Query q = sessio.createQuery("from Client order by Nom");
        List<Client> llista = q.list();
        Iterator<Client> it = llista.iterator();
        while (it.hasNext()) {
            Client cli = it.next();
            System.out.println("Nom client: " + cli.getNom() + " Adreça: " + cli.getAdreca());
            System.out.println("Pel·licules prestades:");
            //-----------------------------------------------------------------------------
            

            
        
        }
    }
}
