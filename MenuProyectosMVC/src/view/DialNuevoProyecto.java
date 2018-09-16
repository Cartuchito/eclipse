package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DialNuevoProyecto extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JTextField textNombre;
	public static JTextField textPresupuesto;
	public static JTextField textFechaIni;
	public static JTextField textFechaFin;

	public DialNuevoProyecto() {
		setModal(true);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(81, 66, 89, 22);
		getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(183, 67, 86, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblPresupuesto = new JLabel("Presupuesto");
		lblPresupuesto.setBounds(81, 117, 71, 14);
		getContentPane().add(lblPresupuesto);
		
		textPresupuesto = new JTextField();
		textPresupuesto.setBounds(183, 114, 86, 20);
		getContentPane().add(textPresupuesto);
		textPresupuesto.setColumns(10);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(82, 156, 70, 22);
		getContentPane().add(lblFechaInicio);
		
		textFechaIni = new JTextField();
		textFechaIni.setBounds(183, 157, 86, 20);
		getContentPane().add(textFechaIni);
		textFechaIni.setColumns(10);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(81, 202, 71, 29);
		getContentPane().add(lblFechaFin);
		
		textFechaFin = new JTextField();
		textFechaFin.setBounds(183, 206, 86, 20);
		getContentPane().add(textFechaFin);
		textFechaFin.setColumns(10);
		
		JButton botonNuevoProyecto = new JButton("Crear");
		botonNuevoProyecto.setBounds(248, 269, 89, 23);
		getContentPane().add(botonNuevoProyecto);
		
		JLabel lblNuevoProyecto = new JLabel("Nuevo Proyecto");
		lblNuevoProyecto.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNuevoProyecto.setBounds(132, 22, 126, 22);
		getContentPane().add(lblNuevoProyecto);
		
		botonNuevoProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.CtrlProyectos.crearNuevoProyecto();
				JOptionPane.showMessageDialog(null,"Proyecto Creado!");
				controller.CtrlProyectos.vaciarCamposProyecto();
				//dispose();
			}
		});
		
		int anchoV = 400;
		int altoV = 400;
		Color miColor = new Color(88, 143, 174);
		getContentPane().setBackground(miColor);

		Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((tamPantalla.width - anchoV) / 2, (tamPantalla.height - altoV) / 2, anchoV, altoV);
		
		setVisible(true);

	}
}
