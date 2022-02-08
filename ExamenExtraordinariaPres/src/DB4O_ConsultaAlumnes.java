

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class DB4O_ConsultaAlumnes {

	public static void main(String[] args) {
		ObjectContainer bd = Db4oEmbedded.openFile("AutoEscola.db4o");
		ObjectSet<Alumne> alumnes = bd.queryByExample(new Alumne());
		for (Alumne a : alumnes){
			if (a.getProf()==null)
				System.out.println(a.getNom() + " (encara no té professor assignat)");
			else
				System.out.println(a.getNom() + " (Professor " + a.getProf().getNom() + "): " + a.getLlPractiques().size() + " pràctiques");
		}
		bd.close();

	}

}
