package Programes;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Fitxers_Notes {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONObject arrel = (JSONObject) new JSONParser().parse(new FileReader ("notes.json"));
		JSONArray alumnes = (JSONArray) arrel.get("alumnes");
		DataInputStream f = new DataInputStream(new FileInputStream("notes.dat"));
		for (Object a : alumnes){
			float s=0;
			int c=0;
			JSONObject alu = (JSONObject) a;
			System.out.print(alu.get("nom") + ". ");
			JSONArray notes = (JSONArray) alu.get("notes");
			for (int i=0;i<notes.size();i++){
				long not = (long) notes.get(i);
				s +=not;
				c++;
				System.out.print(not + " ");
			}
			int nota = f.readInt();
			s += nota;
			c++;
			System.out.println(nota + " ----> " + s/c);
		}

	}

}
