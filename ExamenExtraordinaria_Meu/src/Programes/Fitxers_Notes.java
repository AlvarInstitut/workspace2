package Programes;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.stream.FileImageInputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Fitxers_Notes {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		DataInputStream f = new DataInputStream(new FileInputStream("notes.dat"));
		PrintWriter f1 = new PrintWriter("notes.txt");
		JSONObject arrel = (JSONObject) new JSONParser().parse(new FileReader("notes.json"));
		JSONArray alumnes = (JSONArray) arrel.get("alumnes");
		for (Object alu : alumnes){
			JSONObject a = (JSONObject) alu;
			String cadena = (String) a.get("nom") + ": ";
			JSONArray notes = (JSONArray) a.get("notes");
			float s=0;
			int compt=0;
			for (int i=0;i<notes.size();i++){
				long n = (long) notes.get(i);
				s += n;
				compt ++;
				cadena += n + " ";
			}
			int n1 = f.readInt();
			s += n1;
			compt ++;
			cadena += n1 + " ----> " + s/compt; 
			System.out.println(cadena);
			f1.println(cadena);
		}
		f1.close();
		f.close();

	}

}
