package classesFactura;
// Generated 20/01/2016 13:49:47 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Factura generated by hbm2java
 */
public class Factura implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numF;
	private Client client;
	private Date data;
	private Byte iva;
	private Set<LiniaFac> liniaFacs = new HashSet<LiniaFac>(0);

	public Factura() {
	}

	public Factura(int numF, Client client) {
		this.numF = numF;
		this.client = client;
	}

	public Factura(int numF, Client client, Date data, Byte iva, Set<LiniaFac> liniaFacs) {
		this.numF = numF;
		this.client = client;
		this.data = data;
		this.iva = iva;
		this.liniaFacs = liniaFacs;
	}

	public int getNumF() {
		return this.numF;
	}

	public void setNumF(int numF) {
		this.numF = numF;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Byte getIva() {
		return this.iva;
	}

	public void setIva(Byte iva) {
		this.iva = iva;
	}

	public Set<LiniaFac> getLiniaFacs() {
		return this.liniaFacs;
	}

	public void setLiniaFacs(Set<LiniaFac> liniaFacs) {
		this.liniaFacs = liniaFacs;
	}

}
