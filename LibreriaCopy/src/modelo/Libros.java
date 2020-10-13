package modelo;

public class Libros {

	private String Isbn;
	private String Títolo, Author, editorial;
	private double Price;
	private String formato;
	private String estado;

	public Libros(String isbn, String título, String author, String editorial,
			double price, String formato,String estado) {
		super();
		this.Isbn = isbn;
		this.Títolo = título;
		this.Author = author;
		this.editorial = editorial;
		this.Price = price;
		this.formato = formato;
		this.estado = estado;
	}

	public String getIsbn() {
		return Isbn;
	}

	public String getTítulo() {
		return Títolo;
	}

	public String getAuthor() {
		return Author;
	}

	public String getEditorial() {
		return editorial;
	}

	public double getPrice() {
		return Price;
	}
	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ISBN:" + Isbn + "\nTitulo: " + Títolo + "\nAutor: " + Author + "\nEditorial: " 
				+ editorial +"\nFormato: " + formato+ "\nEstado: " + estado	+ "\nPrecio: " + Price + "€";
	}

}
