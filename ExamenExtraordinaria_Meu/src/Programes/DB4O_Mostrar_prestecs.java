package Programes;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import biblioteca.Llibre;
import biblioteca.Soci;

public class DB4O_Mostrar_prestecs {

	public static void main(String[] args) {
		ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "Biblioteca.db4o");
		ObjectSet<Soci> llista = bd.queryByExample(new Soci());
		for (Soci s : llista){
			if (s.getLlPrestecs().size()==0)
				System.out.println(s.getNumSoci() + ".-" + s.getNom() + " (no té préstecs)");
			else {
				System.out.println(s.getNumSoci() + ".-" + s.getNom());
				for (Llibre ll : s.getLlPrestecs())
					System.out.println(" ---> " + ll.getIsbn() + " " + ll.getTitol() + " (" + ll.getAutor().getNom() + ")");
			}
			System.out.println();
		}
		bd.close();
	}

}
