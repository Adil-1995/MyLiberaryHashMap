package controllador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
		textISBN.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				textISBN.setForeground(Color.RED);
				if (validaciones.validateISBN(textISBN.getText())) {
					textISBN.setForeground(Color.GREEN);
				}
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validaciones.validateISBN(textISBN.getText()) && validaciones.validateLetters(textAutor.getText())
						&& validaciones.validateLetters(textEditorial.getText())
						&& validaciones.isNumber(textPrecio.getText())) {

					crearLibro();
					libreria.rellenarTabla(tablaLibros);

					vaciarCampos();

					JOptionPane.showMessageDialog(null, "Perfect");

				} else {
					JOptionPane.showConfirmDialog(null, "Campos erroneos");
				}

			}
		});

		btnBorrarCantidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = tablaLibros.getSelectedRow();
				if (indice < 0) {
					JOptionPane.showMessageDialog(null, "Ningun libro selecionado");
				} else {
					String cantidad = JOptionPane.showInputDialog("¿Cunatas Cantidades Quieres Borrar?");
					if (cantidad != null && !cantidad.equals("") && Integer.valueOf(cantidad) > 0) {
						libreria.borrarEjemplares((String) tablaLibros.getValueAt(indice, 0),
								Integer.valueOf(cantidad));
						libreria.rellenarTabla(tablaLibros);
						JOptionPane.showMessageDialog(null, "Se han Borrado correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a cero");

					}

				}

			}

		});

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libreria.borrarLibros(libreria.obtenerIdSelecionado(tablaLibros));
				libreria.rellenarTabla(tablaLibros);
				JOptionPane.showMessageDialog(null, "Libro Borrado");
			}
		});
		tablaLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, getLibroSeleccionado(tablaLibros));
			}
		});

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
 
				tabbedPane.setSelectedIndex(0);
				mostrarCampos(libreria.getLibroConcreto(libreria.obtenerISBNconcreto(tablaLibros.getSelectedRow())));
				textISBN.setEnabled(false);
				libreria.borrarLibros(libreria.obtenerISBNconcreto(tablaLibros.getSelectedRow()));
				//textISBN.setEnabled(true);
				
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

		btnAnadirCantidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = tablaLibros.getSelectedRow();
				if (indice < 0) {
					JOptionPane.showMessageDialog(null, "Ningun libro selecionado");
				} else {
					String cantidad = JOptionPane.showInputDialog("¿Cunatas Cantidades Quieres Añadir?");
					if (cantidad != null && !cantidad.equals("") && Integer.valueOf(cantidad) > 0) {
						libreria.anadirEjemplares((String) tablaLibros.getValueAt(indice, 0),
								Integer.valueOf(cantidad));
						libreria.rellenarTabla(tablaLibros);
						JOptionPane.showMessageDialog(null, "Se han añadido correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a cero");

					}

				}

			}
		});

	}

	private void crearLibro() {
		Libros libro = new Libros(textISBN.getText(), textTitulo.getText(), textAutor.getText(),
				textEditorial.getText(), Float.parseFloat(textPrecio.getText()), getRadioButtonFormato(),
				getRadioButtonEstado(), Integer.parseInt(Spinner.getValue().toString()));
		libreria.anadirLibros(textISBN.getText(), libro);
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
		rdbtnCartone.setSelected(true);
		Spinner.setValue(0);

	}

	private void mostrarCampos(Libros libro) {
		textISBN.setText(libro.getIsbn());
		textAutor.setText(libro.getAuthor());
		textTitulo.setText(libro.getTítulo());
		textEditorial.setText(libro.getEditorial());
		textPrecio.setText(String.valueOf(libro.getPrice()));
		rdbtnCartone.setSelected(true);
		Spinner.setValue(0);

	}

}
