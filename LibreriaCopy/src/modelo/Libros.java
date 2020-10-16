package modelo;

public class Libros {

	private String Isbn;
	private String T�tolo, Author, editorial;
	private double Price;
	private String formato;
	private String estado;
	private int cantidad;

	public Libros(String isbn, String t�tulo, String author, String editorial,
			double price, String formato,String estado, int cantidad) {
		super();
		this.Isbn = isbn;
		this.T�tolo = t�tulo;
		this.Author = author;
		this.editorial = editorial;
		this.Price = price;
		this.formato = formato;
		this.estado = estado;
		this.cantidad = cantidad;
	}

	public String getIsbn() {
		return Isbn;
	}

	public String getT�tulo() {
		return T�tolo;
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
	public int getCantidad() {
		return cantidad;
	}

     public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
    
     public void sumarCantidad(int cant) {
 		cantidad += cant;
 		
 	}
     public void restarCantidad(int cant) {
 		cantidad -= cant;
 		
 	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ISBN:" + Isbn + "\nTitulo: " + T�tolo + "\nAutor: " + Author + "\nEditorial: " 
				+ editorial +"\nFormato: " + formato+ "\nEstado: " + estado	+"\nCantidad: "+cantidad +"\nPrecio: " + Price + "�";
	}

	



}
