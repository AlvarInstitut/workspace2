package preparacio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OmplirDat {

	public static void main(String[] args) throws IOException {
		DataOutputStream f = new DataOutputStream(new FileOutputStream("Notes.dat"));
		f.writeInt(7);
		f.writeInt(8);
		f.writeInt(8);
		f.close();
	}

}
