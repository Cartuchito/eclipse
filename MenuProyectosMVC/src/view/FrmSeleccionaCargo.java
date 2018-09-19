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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class FrmSeleccionaCargo extends JFrame{

	private static final long serialVersionUID = 1L;
	Button botonSelecciona = new Button("Seleccionar");

	public static JTable tablaCargos;
	public static JScrollPane scrollPane;
	private final JLabel lblTituloListado = new JLabel("Listado de Cargos");

	public FrmSeleccionaCargo() {

		getContentPane().setLayout(null);
		
		int anchoV = 400;
		int altoV = 400;
		Color miColor = new Color(88, 143, 174);
		setResizable(false);
		setTitle("Cargos en la Empresa");
		getContentPane().setBackground(miColor);

		Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((tamPantalla.width - anchoV) / 2, (tamPantalla.height - altoV) / 2, anchoV, altoV);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		});

		botonSelecciona.setBounds(118, 221, 70, 30);
		getContentPane().add(botonSelecciona);
		botonSelecciona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//nada
			}
		});	

		scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 57, 221, 152);
		getContentPane().add(scrollPane);

		tablaCargos = new JTable();
		scrollPane.setViewportView(tablaCargos);
		
		lblTituloListado.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloListado.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTituloListado.setBounds(43, 11, 216, 35);

		getContentPane().add(lblTituloListado);

		setSize(300, 300);
		setVisible(true);
	}

}

