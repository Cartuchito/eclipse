package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;


public class FrmPrincipalEquipos extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JTable tablaProyect;
	public static JScrollPane scrollPaneProyec;
	public static JScrollPane scrollPaneTrab;
	public static JTable tableTrabajadores;
	public static JTable tableCargos;

	public FrmPrincipalEquipos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		int anchoV = 400;
		int altoV = 400;
		Color miColor = new Color(88, 143, 174);
		setResizable(false);
		setTitle("Equipos");
		getContentPane().setBackground(miColor);
		getContentPane().setLayout(null);
	
		try {
			controller.CtrlProyectos.obtenerNombreProyectos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel lblProyectos = new JLabel("Proyectos");
		lblProyectos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProyectos.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblProyectos.setBounds(138, 25, 118, 16);
		getContentPane().add(lblProyectos);
		
		JButton btnSeleccionaTrabajador = new JButton("A\u00F1adir Trabajador");
		btnSeleccionaTrabajador.setBounds(23, 153, 147, 23);
		getContentPane().add(btnSeleccionaTrabajador);
		
		btnSeleccionaTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlTrabajadores.seleccionaTrabajador();
			}

		});

		
		
		JButton btnAadirCargo = new JButton("A\u00F1adir Cargo");
		btnAadirCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.CtrlCargos.seleccionaCargo();
			}
		});
		btnAadirCargo.setBounds(243, 153, 125, 23);
		getContentPane().add(btnAadirCargo);
		
		scrollPaneTrab = new JScrollPane();
		scrollPaneTrab.setBounds(52, 198, 155, 100);
		getContentPane().add(scrollPaneTrab);
		
		tableTrabajadores = new JTable();
		scrollPaneTrab.setViewportView(tableTrabajadores);
		
		scrollPaneProyec = new JScrollPane();
		scrollPaneProyec.setBounds(82, 52, 228, 89);
		getContentPane().add(scrollPaneProyec);

		tablaProyect = new JTable();
		scrollPaneProyec.setViewportView(tablaProyect);
		
		JScrollPane scrollPaneCargos = new JScrollPane();
		scrollPaneCargos.setBounds(208, 198, 155, 100);
		getContentPane().add(scrollPaneCargos);
		
		tableCargos = new JTable();
		scrollPaneCargos.setViewportView(tableCargos);
		
		JButton btnNewButton = new JButton("Crear Equipo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//controller.CtrlEquipos.crearEquipo();
				//dispose();
			}
		});
		btnNewButton.setBounds(138, 320, 118, 30);
		getContentPane().add(btnNewButton);

		Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((tamPantalla.width - anchoV) / 2, (tamPantalla.height - altoV) / 2, anchoV, altoV);
		setVisible(true);
	}
}
