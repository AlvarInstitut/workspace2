import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class DB4O_LlistatProfAlum {

	public static void main(String[] args) {
		 ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"AutoEscola.db4o");
		 
		 ObjectSet<Professor> llProf = bd.queryByExample(new Professor());
		 for (Professor p: llProf){
			 System.out.println(p.getNom());
			 for (Alumne a : p.getLlAlumnes())
				 System.out.println("   ---> " + a.getNom());
		 }
		 bd.close();

	}

}
