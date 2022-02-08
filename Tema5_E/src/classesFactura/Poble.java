package classesFactura;
// Generated 20/01/2016 13:49:47 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Poble generated by hbm2java
 */
public class Poble implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codPob;
	private String nom;
	private String provincia;
	private Set<Client> clients = new HashSet<Client>(0);

	public Poble() {
	}

	public Poble(int codPob) {
		this.codPob = codPob;
	}

	public Poble(int codPob, String nom, String provincia, Set<Client> clients) {
		this.codPob = codPob;
		this.nom = nom;
		this.provincia = provincia;
		this.clients = clients;
	}

	public int getCodPob() {
		return this.codPob;
	}

	public void setCodPob(int codPob) {
		this.codPob = codPob;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}