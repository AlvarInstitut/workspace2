package biblioteca;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;



public class DB4O_Mostrar_prestecs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "Biblioteca.db4o");

		Soci f = new Soci();
		Llibre l = new Llibre();

		ObjectSet<Soci> llista = bd.queryByExample(f);
		ObjectSet<Llibre> llista2 = bd.queryByExample(l);
		Llibre ll = null;
		int i = 1;
		for (Soci e : llista) {
			System.out.println(i+".-" + e.getNom()+"("+e.getLlPrestecs().size()+" prestecs)");
			i++;
			if(e.getLlPrestecs().size()==0){
				System.out.println("(No te prestecs)");
				
			}else{
				for(i=0;i<e.getLlPrestecs().size();i++){
					System.out.println("--> (Te prestecs)");
				}
			}

		}
		bd.close();
	}

}
