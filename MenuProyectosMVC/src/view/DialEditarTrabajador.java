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
import javax.swing.JTextField;

public class DialEditarTrabajador extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JTextField textDNI;
	public static JTextField textNombre;
	public static JTextField textApellidos;
	public static JTextField textGenero;

	public DialEditarTrabajador() {
		setModal(true);
		getContentPane().setLayout(null);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(81, 66, 89, 22);
		getContentPane().add(lblDNI);
		
		textDNI = new JTextField();
		textDNI.setText(controller.CtrlTrabajadores.DNI);
		textDNI.setBounds(183, 67, 86, 20);
		getContentPane().add(textDNI);
		textDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(81, 117, 71, 14);
		getContentPane().add(lblNombre);
		
		
		textNombre = new JTextField();
		textNombre.setBounds(183, 114, 86, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		textNombre.setText(controller.CtrlTrabajadores.nombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(82, 156, 70, 22);
		getContentPane().add(lblApellidos);
		
		
		textApellidos = new JTextField();
		textApellidos.setBounds(183, 157, 86, 20);
		getContentPane().add(textApellidos);
		textApellidos.setColumns(10);
		textApellidos.setText(controller.CtrlTrabajadores.apellidos);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(81, 202, 71, 29);
		getContentPane().add(lblGenero);
		
		
		textGenero = new JTextField();
		textGenero.setBounds(183, 206, 86, 20);
		getContentPane().add(textGenero);
		textGenero.setColumns(10);
		textGenero.setText(controller.CtrlTrabajadores.genero);
		
		JButton botonEditaTrabajador = new JButton("Guardar Cambios");
		botonEditaTrabajador.setBounds(222, 263, 115, 29);
		getContentPane().add(botonEditaTrabajador);
		
		JLabel lblNuevoTrabajador = new JLabel("Modificar Trabajador");
		lblNuevoTrabajador.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNuevoTrabajador.setBounds(123, 22, 156, 22);
		getContentPane().add(lblNuevoTrabajador);
		
		botonEditaTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					controller.CtrlTrabajadores.editarTrabajador();
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
