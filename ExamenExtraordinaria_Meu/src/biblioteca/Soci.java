package biblioteca;

import java.util.ArrayList;
import java.util.Date;

public class Soci {
	private int numSoci;
	private String dni;
	private String nom;
	private String adreca;
	private int cp;
	private String poblacio;
	private String telefon;
	private Date dataN;
	private Date dataS;
	private ArrayList<Llibre> llPrestecs;
	
	public Soci(){
		
	}
	
	public Soci(int numSoci){
		this.numSoci=numSoci;
	}
	
	public Soci(int numSoci,String dni,String nom,String adreca,int cp,String poblacio,String telefon,
					Date dataN,Date dataS, ArrayList<Llibre> llPrestecs){
		this.numSoci=numSoci;
		this.dni=dni;
		this.nom=nom;
		this.adreca=adreca;
		this.cp=cp;
		this.poblacio=poblacio;
		this.telefon=telefon;
		this.dataN=dataN;
		this.dataS=dataS;
		this.llPrestecs=llPrestecs;
	}
	public Soci(int numSoci,String dni,String nom,String adreca,int cp,String poblacio,String telefon,
			Date dataN,Date dataS){
		this.numSoci=numSoci;
		this.dni=dni;
		this.nom=nom;
		this.adreca=adreca;
		this.cp=cp;
		this.poblacio=poblacio;
		this.telefon=telefon;
		this.dataN=dataN;
		this.dataS=dataS;
	}
	public int getNumSoci() {
		return numSoci;
	}
	public void setNumSoci(int numSoci) {
		this.numSoci = numSoci;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdreca() {
		return adreca;
	}
	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getPoblacio() {
		return poblacio;
	}
	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public Date getDataN() {
		return dataN;
	}
	public void setDataN(Date dataN) {
		this.dataN = dataN;
	}
	public Date getDataS() {
		return dataS;
	}
	public void setDataS(Date dataS) {
		this.dataS = dataS;
	}
	public ArrayList<Llibre> getLlPrestecs() {
		return llPrestecs;
	}
	public void setLlPrestecs(ArrayList<Llibre> llPrestecs) {
		this.llPrestecs = llPrestecs;
	}
	
}
