import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class DB4O_TotalPractiques {

	public static void main(String[] args) {
		 ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"AutoEscola.db4o");
		 
		 ObjectSet<Alumne> llAlum = bd.queryByExample(new Alumne());
		 
		 for (Alumne a : llAlum){
			 System.out.println(a.getNom());
			 int numPract=0;
			 int totKm=0;
			 for (Practica p : a.getLlPractiques()){
				 numPract++;
				 totKm += p.getKm();
			 }
			 System.out.println("\t Num. pràctiques: " + numPract + ". Total quilòmetres: " + totKm + "\n");
		 }
		 bd.close();

	}

}
