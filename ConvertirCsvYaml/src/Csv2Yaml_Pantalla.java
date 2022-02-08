import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Csv2Yaml_Pantalla extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JFileChooser fc = new JFileChooser();
	JFileChooser fs = new JFileChooser();

	JLabel et_f = new JLabel("Fitxer:");
	JTextField fitxer = new JTextField(25);
	JButton obrir = new JButton("Obrir");
	JButton guardar = new JButton("Guardar");
	JButton convertir = new JButton("Convertir");
	JLabel et_a = new JLabel("Contingut:");
	// JTextArea areaCsv = new JTextArea(15, 25);
	JTable areaCsv = new JTable(1, 3);
	JScrollPane scrollPaneCsv = new JScrollPane(areaCsv);
	JTextArea areaYaml = new JTextArea(15, 25);
	JScrollPane scrollPaneYaml = new JScrollPane(areaYaml);

	// en iniciar posem un contenidor per als elements anteriors
	public void iniciar() {
		getContentPane().setLayout(new GridLayout());
		setTitle("Conversor de CSV a YAML");

		JPanel panellPr = new JPanel(new BorderLayout());
		JPanel panell1 = new JPanel(new FlowLayout());
		panellPr.add(panell1, BorderLayout.NORTH);
		panell1.add(et_f);
		panell1.add(fitxer);
		panell1.add(obrir);

		JPanel panell2 = new JPanel(new GridLayout(1, 2));

		panell2.add(scrollPaneCsv);
		// areaCsv.setEditable(true);
		panell2.add(scrollPaneYaml);
		areaYaml.setEditable(true);

		panellPr.add(panell2, BorderLayout.CENTER);

		JPanel panell3 = new JPanel(new FlowLayout());
		panellPr.add(panell3, BorderLayout.SOUTH);
		panell3.add(convertir);
		panell3.add(guardar);

		getContentPane().add(panellPr);
		setVisible(true);
		pack();
		obrir.addActionListener(this);
		convertir.addActionListener(this);
		guardar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == obrir) {

			int r = fc.showOpenDialog(this);
			if (r == JFileChooser.APPROVE_OPTION) {
				fitxer.setText(fc.getSelectedFile().getName());
				BufferedReader f1;
				ArrayList<String[]> valsProv = new ArrayList<String[]>();
				try {
					f1 = new BufferedReader(new FileReader(fc.getSelectedFile()));
					String[] caps = f1.readLine().split(",");
					
					String linia = f1.readLine();
					while (linia != null) {
						valsProv.add(linia.split(","));
						linia = f1.readLine();
					}
					f1.close();
					String[][] vals = new String[valsProv.size()][caps.length];
					//vals = (String[][]) valsProv.toArray();
					int i=0;
					for (String[] v : valsProv)
						vals[i++]=v;
					areaCsv.setModel(new javax.swing.table.DefaultTableModel(vals,caps));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else
				System.out.println("No s'ha seleccionat res");
		}
		if (e.getSource() == guardar) {
			fs.setSelectedFile(new File(fc.getSelectedFile().getAbsolutePath(),fc.getSelectedFile().getName().replaceAll(".csv", ".yaml")));
			int r = fs.showSaveDialog(this);
			if (r == JFileChooser.APPROVE_OPTION){
				try {
					PrintWriter f2 = new PrintWriter(fs.getSelectedFile());
					f2.print(areaYaml.getText());
					f2.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		
		if (e.getSource() == convertir) {
			areaYaml.setText("");
			areaYaml.append("---\n");
			areaYaml.append(":global:\n");
			Set<Integer> conjunt = new HashSet<Integer>();
			//Comprovar si una columna té el mateix valor en totes les files
			for (int j=1;j<areaCsv.getColumnCount();j++){
				String valor=(String) areaCsv.getModel().getValueAt(0, j);
				boolean igual=true;
				for (int i=1;i<areaCsv.getRowCount();i++)
					if (!valor.equals(areaCsv.getModel().getValueAt(i, j)))
						igual=false;
				if (igual){
					areaYaml.append("  :host_"+areaCsv.getColumnName(j)+": "+ valor + "\n");
					conjunt.add(j);
				}
			}
			areaYaml.append(":cases:\n");
//			String linia=f1.readLine();
			for (int i=0;i<areaCsv.getRowCount();i++){
				areaYaml.append("- tt_members: " + areaCsv.getModel().getValueAt(i, 0) + "\n");
				for (int j=1;j<areaCsv.getModel().getColumnCount();j++)
					if (!conjunt.contains(j))
						areaYaml.append("  :host_"+areaCsv.getColumnName(j)+": "+areaCsv.getModel().getValueAt(i, j) + "\n");
			}

		}

	}

}