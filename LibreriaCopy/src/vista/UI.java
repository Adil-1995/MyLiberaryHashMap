package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class UI extends JFrame {

	private static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	protected JTextField textTitulo;
	protected JTextField textAutor;
	protected JTextField textEditorial;
	protected JTextField textPrecio;
	protected JTextField textISBN;
	protected JButton btnGuardar;
	protected JTable tablaLibros;
	protected JButton btnSalir;
	protected JButton btnBorrar;
	protected JButton btnConsultar;
	protected JRadioButton rdbtnCartone;
	protected JRadioButton rdbtnRustica;
	protected JRadioButton rdbtnGrapada;
	protected JRadioButton rdbtnEspiral;
	protected JRadioButton rdbtnReedicion;
	protected JRadioButton rdbtnNovidad;

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelArriba = new JPanel();
		panelArriba.setBackground(Color.ORANGE);
		contentPane.add(panelArriba, BorderLayout.NORTH);

		JLabel lblLbreriaAdil = new JLabel("Libreria Adil");
		lblLbreriaAdil.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelArriba.add(lblLbreriaAdil);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.GRAY);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		// add image
		JLabel labelicon = new JLabel("");
		labelicon.setIcon(new ImageIcon(UI.class.getResource("/image/libro.png")));

		JPanel panelLibro = new JPanel();
		panelLibro.setBackground(Color.CYAN);
		tabbedPane.addTab("LIBRO", null, panelLibro, null);

		JLabel lblIsbn = new JLabel("ISBN :");
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 11));

		textTitulo = new JTextField();
		textTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textTitulo.setColumns(10);

		JLabel lblTitulo = new JLabel("T\u00EDtulo :");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));

		textAutor = new JTextField();
		textAutor.setColumns(10);

		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblAutor = new JLabel("Autor :");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 11));

		textEditorial = new JTextField();
		textEditorial.setColumns(10);

		textISBN = new JTextField();
		textISBN.setColumns(10);

		textPrecio = new JTextField();
		textPrecio.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel label = new JLabel("");

		JPanel panelFormato = new JPanel();
		panelFormato.setBorder(new LineBorder(Color.MAGENTA, 1, true));

		JLabel lblFortmato = new JLabel("Fortmato:");
		lblFortmato.setFont(new Font("Tahoma", Font.BOLD, 12));

		JPanel panelEstado = new JPanel();
		panelEstado.setBorder(new LineBorder(Color.MAGENTA, 1, true));

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));

		GroupLayout gl_panelLibro = new GroupLayout(panelLibro);
		gl_panelLibro.setHorizontalGroup(
			gl_panelLibro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLibro.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panelLibro.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panelLibro.createSequentialGroup()
								.addGroup(gl_panelLibro.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblTitulo)
									.addComponent(lblIsbn))
								.addGap(1))
							.addComponent(lblPrecio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label, Alignment.LEADING))
						.addComponent(lblEditorial)
						.addComponent(lblAutor)
						.addComponent(lblFortmato)
						.addComponent(lblEstado))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addComponent(panelFormato, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addComponent(panelEstado, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING)
								.addComponent(textPrecio, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
								.addComponent(textEditorial, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
								.addComponent(textAutor, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
								.addComponent(textTitulo, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
								.addComponent(textISBN, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
							.addGap(99)
							.addComponent(labelicon, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addGap(74))))
		);
		gl_panelLibro.setVerticalGroup(
			gl_panelLibro.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelLibro.createSequentialGroup()
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIsbn)
								.addComponent(textISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTitulo)
								.addComponent(textTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(14)
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
								.addComponent(textAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAutor))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEditorial))
							.addGap(18)
							.addGroup(gl_panelLibro.createParallelGroup(Alignment.BASELINE)
								.addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrecio)))
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addComponent(labelicon, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(10)
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, gl_panelLibro.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
							.addComponent(lblFortmato, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelFormato, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelLibro.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelLibro.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14))
		);

		rdbtnReedicion = new JRadioButton("Reedici\u00F3n");
		panelEstado.add(rdbtnReedicion);

		rdbtnNovidad = new JRadioButton("Novidad");
		panelEstado.add(rdbtnNovidad);

		rdbtnCartone = new JRadioButton("Carton\u00E9");

		rdbtnRustica = new JRadioButton("R\u00FAstica");

		rdbtnGrapada = new JRadioButton("Grapada");

		rdbtnEspiral = new JRadioButton("Espiral");
		
		ButtonGroup grupoFormato = new ButtonGroup();
		grupoFormato.add(rdbtnCartone);
		grupoFormato.add(rdbtnEspiral);
		grupoFormato.add(rdbtnGrapada);
		grupoFormato.add(rdbtnRustica);
		
		ButtonGroup grupoEstado = new ButtonGroup();
		grupoEstado.add(rdbtnReedicion);
		grupoEstado.add(rdbtnNovidad);
		
		panelFormato.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelFormato.add(rdbtnCartone);
		panelFormato.add(rdbtnRustica);
		panelFormato.add(rdbtnGrapada);
		panelFormato.add(rdbtnEspiral);
		panelLibro.setLayout(gl_panelLibro);

		JPanel panelEstenteria = new JPanel();
		tabbedPane.addTab("ESTENTERIA", null, panelEstenteria, null);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelEstenteria = new GroupLayout(panelEstenteria);
		gl_panelEstenteria.setHorizontalGroup(gl_panelEstenteria.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE));
		gl_panelEstenteria.setVerticalGroup(gl_panelEstenteria.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE));

		tablaLibros = new JTable(){

			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		scrollPane.setViewportView(tablaLibros);
		panelEstenteria.setLayout(gl_panelEstenteria);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.ORANGE);
		contentPane.add(panel_3, BorderLayout.SOUTH);

		btnGuardar = new JButton("GUARDAR");

		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnBorrar = new JButton("BORRAR");

		btnConsultar = new JButton("CONSULTAR");
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_3.add(btnGuardar);
		panel_3.add(btnConsultar);
		panel_3.add(btnBorrar);
		panel_3.add(btnSalir);
	}
}
