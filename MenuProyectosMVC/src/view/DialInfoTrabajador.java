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

public class DialInfoTrabajador extends JDialog {

	private static final long serialVersionUID = 1L;

	public DialInfoTrabajador() {
		setModal(true);
		getContentPane().setLayout(null);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(81, 66, 89, 22);
		getContentPane().add(lblDNI);
		
		JLabel lblValorDNI=new JLabel("");
		lblValorDNI.setText(controller.CtrlTrabajadores.DNI);
		lblValorDNI.setBounds(183, 67, 86, 20);
		getContentPane().add(lblValorDNI);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(81, 117, 71, 14);
		getContentPane().add(lblNombre);
		
		
		JLabel lblValorNombre=new JLabel("");;
		lblValorNombre.setBounds(183, 114, 86, 20);
		getContentPane().add(lblValorNombre);
		lblValorNombre.setText(controller.CtrlTrabajadores.nombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(82, 156, 70, 22);
		getContentPane().add(lblApellidos);
		
		
		JLabel lblValorApellidos=new JLabel("");
		lblValorApellidos.setBounds(183, 157, 86, 20);
		getContentPane().add(lblValorApellidos);
		lblValorApellidos.setText(controller.CtrlTrabajadores.apellidos);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(81, 202, 71, 29);
		getContentPane().add(lblGenero);
		
		
		JLabel lblValorGenero=new JLabel("");
		lblValorGenero.setBounds(183, 206, 86, 20);
		getContentPane().add(lblValorGenero);
		lblValorGenero.setText(controller.CtrlTrabajadores.genero);
		
		JButton botonEditaProyecto = new JButton("Guardar Cambios");
		botonEditaProyecto.setBounds(222, 263, 115, 29);
		getContentPane().add(botonEditaProyecto);
		
		JLabel lblNuevoProyecto = new JLabel("Informaci\u00F3n Trabajador");
		lblNuevoProyecto.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNuevoProyecto.setBounds(123, 22, 188, 22);
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