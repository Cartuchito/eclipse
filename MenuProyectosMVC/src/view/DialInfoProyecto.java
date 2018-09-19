package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DialInfoProyecto extends JDialog {

	private static final long serialVersionUID = 1L;

	public DialInfoProyecto() {
		setModal(true);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(81, 66, 89, 22);
		getContentPane().add(lblNombre);
		
		JLabel lblValorNombre=new JLabel("");
		lblValorNombre.setText(controller.CtrlProyectos.nombre);
		lblValorNombre.setBounds(183, 67, 86, 20);
		getContentPane().add(lblValorNombre);
		
		JLabel lblPresupuesto = new JLabel("Presupuesto");
		lblPresupuesto.setBounds(81, 117, 71, 14);
		getContentPane().add(lblPresupuesto);
		
		
		JLabel lblValorPresupuesto=new JLabel("");;
		lblValorPresupuesto.setBounds(183, 114, 86, 20);
		getContentPane().add(lblValorPresupuesto);
		lblValorPresupuesto.setText(controller.CtrlProyectos.presupuesto);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(82, 156, 70, 22);
		getContentPane().add(lblFechaInicio);
		
		
		JLabel lblValorFechaInicio=new JLabel("");
		lblValorFechaInicio.setBounds(183, 157, 86, 20);
		getContentPane().add(lblValorFechaInicio);
		lblValorFechaInicio.setText(controller.CtrlProyectos.fechaIni);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(81, 202, 71, 29);
		getContentPane().add(lblFechaFin);
		
		
		JLabel lblValorFechaFin=new JLabel("");
		lblValorFechaFin.setBounds(183, 206, 86, 20);
		getContentPane().add(lblValorFechaFin);
		lblValorFechaFin.setText(controller.CtrlProyectos.fechaFin);
		
		JButton botonEditaProyecto = new JButton("Guardar Cambios");
		botonEditaProyecto.setBounds(222, 263, 115, 29);
		getContentPane().add(botonEditaProyecto);
		
		JLabel lblNuevoProyecto = new JLabel("Información Proyecto");
		lblNuevoProyecto.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNuevoProyecto.setBounds(123, 22, 156, 22);
		getContentPane().add(lblNuevoProyecto);
		
		botonEditaProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					controller.CtrlProyectos.editarProyecto();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Cambios guardados!");
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
