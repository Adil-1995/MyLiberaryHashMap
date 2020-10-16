package modelo;

import java.util.HashMap;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Libreria {

	private HashMap<String, Libros> LibreriaHashMap = new HashMap<String, Libros>();

	public void anadirLibros(String ISBN, Libros libro) {
		LibreriaHashMap.put(ISBN, libro);
	}

	public void borrarLibros(String ISBN) {
		LibreriaHashMap.remove(ISBN);
	}

	public void anadirEjemplares(String isbn, int cantidad) {
		Libros libro = LibreriaHashMap.get(isbn);
		libro.sumarCantidad(cantidad);

	}

	public void borrarEjemplares(String isbn, int cantidad) {
		Libros libro = LibreriaHashMap.get(isbn);
		libro.restarCantidad(cantidad);

	}

	public HashMap<String, Libros> getLibros() {
		return LibreriaHashMap;
	}

	public void rellenarTabla(JTable table) {

		String nombresColumnas[] = { "ISBN", "TITULO", "EDITORIAL", "AUTOR", "PRECIO", "Formato", "Estado",
				"Cantidad" };
		String[][] filasTabla = new String[this.LibreriaHashMap.size()][nombresColumnas.length];
		int i = 0;
		for (HashMap.Entry<String, Libros> entry : LibreriaHashMap.entrySet()) {

			filasTabla[i][0] = entry.getKey();
			filasTabla[i][1] = entry.getValue().getTítulo();
			filasTabla[i][2] = entry.getValue().getEditorial();
			filasTabla[i][3] = entry.getValue().getAuthor();
			filasTabla[i][4] = String.valueOf(entry.getValue().getPrice());
			filasTabla[i][5] = entry.getValue().getFormato();
			filasTabla[i][6] = entry.getValue().getEstado();
			filasTabla[i][7] = String.valueOf(entry.getValue().getCantidad());

		}
		DefaultTableModel tablaCompleta = new DefaultTableModel(filasTabla, nombresColumnas);
		table.setModel(tablaCompleta);

	}

	public String obtenerIdSelecionado(JTable tablaLibros) {
		int i = 0;
		for (HashMap.Entry<String, Libros> entry : LibreriaHashMap.entrySet()) {
			if (tablaLibros.getSelectedRow() == i) {
				return entry.getKey();
			}
			i++;
		}
		return null;
	}

	public boolean comprobabIsbn(String Isbn) {
		if (LibreriaHashMap.containsKey(Isbn)) {
			return true;
		}
		return false;
	}

	public Libros getLibro(String Isbn) {
		return LibreriaHashMap.get(Isbn);
	}
	
	public Libros getLibroConcreto(String ISBN) { 
		return LibreriaHashMap.get(ISBN);
		}
	public String obtenerISBNconcreto(int index) {
        Set<String> conjunto = this.LibreriaHashMap.keySet();
        Object[] array = conjunto.toArray();
        String ISBN = (String) array[index];
        return ISBN;
    }



}
