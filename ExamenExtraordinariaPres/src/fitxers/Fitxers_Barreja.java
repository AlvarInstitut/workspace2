package fitxers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Fitxers_Barreja {

	public static void main(String[] args) throws IOException {
		BufferedReader f1 = new BufferedReader(new FileReader("entrada1.txt"));
		DataInputStream f2 = new DataInputStream (new FileInputStream("entrada2.dat"));
		PrintWriter f3 = new PrintWriter("eixida.txt");
		
		int s=0;
		String linia = f1.readLine();
		while (linia != null) {
			s += Integer.parseInt(linia);
			f3.println(linia);
			linia = f1.readLine();
		}
		
		f1.close();
		
		while(f2.available()>0){
			int num = f2.readInt();
			s += num;
			f3.println(num);
		}
		f2.close();
		f3.println("Total: " + s);
		f3.close();
	}

}
