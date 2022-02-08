package Preparacio;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CrearNotesDat {

	public static void main(String[] args) throws IOException {
		DataOutputStream f = new DataOutputStream(new FileOutputStream("notes.dat"));
		f.writeInt(8);
		f.writeInt(7);
		f.writeInt(8);
		f.close();
	}

}
