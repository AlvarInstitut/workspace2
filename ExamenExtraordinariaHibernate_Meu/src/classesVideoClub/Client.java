package classesVideoClub;
// Generated 14/06/2016 10:00:33 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Client generated by hbm2java
 */
public class Client implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dni;
	private String nom;
	private String telefon;
	private String adreca;
	private String poblacio;
	private Set<Lloguer> lloguers = new HashSet<Lloguer>(0);

	public Client() {
	}

	public Client(String dni) {
		this.dni = dni;
	}

	public Client(String dni, String nom, String telefon, String adreca, String poblacio, Set<Lloguer> lloguers) {
		this.dni = dni;
		this.nom = nom;
		this.telefon = telefon;
		this.adreca = adreca;
		this.poblacio = poblacio;
		this.lloguers = lloguers;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdreca() {
		return this.adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	public String getPoblacio() {
		return this.poblacio;
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}

	public Set<Lloguer> getLloguers() {
		return this.lloguers;
	}

	public void setLloguers(Set<Lloguer> lloguers) {
		this.lloguers = lloguers;
	}

}
