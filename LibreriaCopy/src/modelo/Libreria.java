package modelo;

import java.util.HashMap;

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

	public HashMap<String, Libros> getLibros() {
		return LibreriaHashMap;
	}

	public void llenarTabla(JTable table) {

		String nombresColumnas[] = { "ISBN", "TITULO", "EDITORIAL", "AUTOR", "PRECIO", "Formato", "Estado" };
		String[][] filasTabla = new String[this.LibreriaHashMap.size()][7];
		int i = 0;
		for (HashMap.Entry<String, Libros> entry : LibreriaHashMap.entrySet()) {

			filasTabla[i][0] = entry.getKey();
			// filasTabla[i][1] = entry.getValue().getTítulo();
			filasTabla[i][2] = entry.getValue().getEditorial();
			filasTabla[i][3] = entry.getValue().getAuthor();
			filasTabla[i][4] = String.valueOf(entry.getValue().getPrice());
			filasTabla[i][5] = entry.getValue().getFormato();
			filasTabla[i][6] = entry.getValue().getEstado();

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

}
