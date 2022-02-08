package biblioteca;

import java.util.Date;

public class Autor {
	private int codAut;
	private String nom;
	private Date dataN;
	
	public Autor(){
		
	}
	
	public Autor(int codAutor){
		this.codAut=codAutor;
	}
	
	public Autor(int codAut,String nom, Date dataN){
		this.codAut=codAut;
		this.nom=nom;
		this.dataN=dataN;
	}
	
	public int getCodAut() {
		return codAut;
	}
	public void setCodAut(int codAut) {
		this.codAut = codAut;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDataN() {
		return dataN;
	}
	public void setDataN(Date dataN) {
		this.dataN = dataN;
	}

}
