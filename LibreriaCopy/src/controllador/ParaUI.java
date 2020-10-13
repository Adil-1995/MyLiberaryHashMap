package controllador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import modelo.Libreria;
import modelo.Libros;
import utiles.validaciones;
import vista.UI;

public class ParaUI extends UI {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Libreria libreria = new Libreria();
	Libros libro;
	public ParaUI() {

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validaciones.validateISBN(textISBN.getText()) && validaciones.
						validateLetters(textAutor.getText())&& validaciones.
						validateLetters(textEditorial.getText())
						&& validaciones.isNumber(textPrecio.getText())) {

					libreria.anadirLibros(textISBN.getText(), libro);
					libreria.llenarTabla(tablaLibros);
					crearLibro();
					vaciarCampos();

					JOptionPane.showMessageDialog(null, "Perfect");

				} else {
					JOptionPane.showConfirmDialog(null, "Campos erroneos");
				}

			}
		});

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libreria.borrarLibros(libreria.obtenerIdSelecionado(tablaLibros));
				libreria.llenarTabla(tablaLibros);
				JOptionPane.showMessageDialog(null, "Libro Borrado");
			}
		});
		tablaLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, getLibroSeleccionado(tablaLibros));
			}
		});

		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ISBNsel = JOptionPane.showInputDialog("Introduce ISBN");
				if (libreria.comprobabIsbn(ISBNsel)) {
					JOptionPane.showMessageDialog(null, libreria.getLibro(ISBNsel).toString());
				} else
					JOptionPane.showMessageDialog(null, "El libro no existe");
			}
		});

	}

	private void crearLibro() {
	 Libros libro = new Libros(textISBN.getText(), textTitulo.getText(), textAutor.getText(),
			textEditorial.getText(), Float.parseFloat(textPrecio.getText()), getRadioButtonFormato(),
				getRadioButtonEstado());
		libreria.anadirLibros(textISBN.getText(),libro);
	}

	public String getRadioButtonFormato() {
		if (rdbtnCartone.isSelected()) {
			return rdbtnCartone.getText();
		}
		if (rdbtnEspiral.isSelected()) {
			return rdbtnEspiral.getText();
		}
		if (rdbtnGrapada.isSelected()) {
			return rdbtnGrapada.getText();
		}
		if (rdbtnRustica.isSelected()) {
			return rdbtnRustica.getText();
		}

		return null;
	}

	public String getRadioButtonEstado() {
		if (rdbtnNovidad.isSelected()) {
			return rdbtnNovidad.getText();
		}
		if (rdbtnReedicion.isSelected()) {
			return rdbtnReedicion.getText();
		}

		return null;
	}

	public String getLibroSeleccionado(JTable table) {

		int i = 0;
		for (HashMap.Entry<String, Libros> entry : libreria.getLibros().entrySet()) {
			if (table.getSelectedRow() == i) {
				return "ISBN: " + entry.getKey() + "\n" + entry.getValue().toString();
			}
			i++;
		}
		return null;

	}

	private void vaciarCampos() {
		textISBN.setText("");
		textAutor.setText("");
		textTitulo.setText("");
		textPrecio.setText("");
		textEditorial.setText("");
		rdbtnCartone.setSelected(false);

	}

}
