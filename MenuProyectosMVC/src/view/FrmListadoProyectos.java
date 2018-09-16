package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class FrmListadoProyectos extends JFrame {

	private static final long serialVersionUID = 1L;
	Button botonNuevo = new Button("NUEVO");
	Button botonEliminar = new Button("ELIMINAR");
	Button botonEditar = new Button("EDITAR");
	Button botonInfo = new Button("INFO");
	public static JTable tabla;
	public static JScrollPane scrollPane;
	private final JLabel lblTituloListado = new JLabel("Listado de Proyectos");

	public FrmListadoProyectos() {
		
		int anchoV = 400;
		int altoV = 400;
		Color miColor = new Color(88, 143, 174);

		getContentPane().setLayout(null);
		setResizable(false);
		setTitle("Proyectos");
		getContentPane().setBackground(miColor);

		Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((tamPantalla.width - anchoV) / 2, (tamPantalla.height - altoV) / 2, anchoV, altoV);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		});

		botonNuevo.setBounds(50, 280, 70, 30);
		getContentPane().add(botonNuevo);
		botonNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					controller.CtrlProyectos.dialNuevoProyecto();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		botonEliminar.setBounds(130, 280, 70, 30);
		getContentPane().add(botonEliminar);
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el proyecto?", "Borrar Trabajador",
						JOptionPane.YES_NO_OPTION);

				if (resp == 0) {
					controller.CtrlProyectos.eliminaProyecto();
				}
			}
		});

		botonEditar.setBounds(210, 280, 70, 30);
		getContentPane().add(botonEditar);
		botonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlProyectos.dialEditarProyecto();

			}
		});

		botonInfo.setBounds(290, 280, 70, 30);
		getContentPane().add(botonInfo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 70, 299, 182);
		getContentPane().add(scrollPane);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		lblTituloListado.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloListado.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTituloListado.setBounds(94, 24, 216, 35);
		
		getContentPane().add(lblTituloListado);
		
		setSize(400, 400);
		setVisible(true);
	}
}