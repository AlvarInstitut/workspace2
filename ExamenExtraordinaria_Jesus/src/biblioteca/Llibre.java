package biblioteca;

public class Llibre {
	private String isbn;
	private String titol;
	private Autor autor;
	private String editorial;
	private Soci prSoci; 
	
	public Llibre(){
		
	}
	
	public Llibre(String isbn){
		this.isbn=isbn;
	}
	
	public Llibre (String isbn,String titol, Autor autor, String editorial, Soci prSoci){
		this.isbn=isbn;
		this.titol=titol;
		this.autor=autor;
		this.editorial=editorial;
		this.prSoci=prSoci;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitol() {
		return titol;
	}
	public void setTitol(String titol) {
		this.titol = titol;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public Soci getPrSoci() {
		return prSoci;
	}
	public void setPrSoci(Soci prSoci) {
		this.prSoci = prSoci;
	}

}
