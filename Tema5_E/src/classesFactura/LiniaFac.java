package classesFactura;
// Generated 20/01/2016 13:49:47 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * LiniaFac generated by hbm2java
 */
public class LiniaFac implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numL;
	private Factura factura;
	private Article article;
	private Integer quant;
	private BigDecimal preu;

	public LiniaFac() {
	}

	public LiniaFac(int numL, Article article) {
		this.numL = numL;
		this.article = article;
	}

	public LiniaFac(int numL, Factura factura, Article article, Integer quant, BigDecimal preu) {
		this.numL = numL;
		this.factura = factura;
		this.article = article;
		this.quant = quant;
		this.preu = preu;
	}

	public int getNumL() {
		return this.numL;
	}

	public void setNumL(int numL) {
		this.numL = numL;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getQuant() {
		return this.quant;
	}

	public void setQuant(Integer quant) {
		this.quant = quant;
	}

	public BigDecimal getPreu() {
		return this.preu;
	}

	public void setPreu(BigDecimal preu) {
		this.preu = preu;
	}

}
