package Programes;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Fitxers_Notes {

    public static void main(String[] args) throws IOException, ParseException {

        DataInputStream f = new DataInputStream(new FileInputStream("notes.dat"));
        Reader r_json = new FileReader("notes.json");
        PrintWriter f_out = new PrintWriter(new FileWriter("notes.txt"));
        
        JSONObject arrel = (JSONObject) (new JSONParser().parse(r_json));        
        JSONArray alumnes = (JSONArray) arrel.get("alumnes");        

	        for (Object e : alumnes) {
	            JSONObject emp = (JSONObject) e;

	            System.out.println("Nom: "+emp.get("nom")+" Notes: "+emp.get("notes")+f.readInt());

	        }

		f.close();
		f_out.close();

    }

}