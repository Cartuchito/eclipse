package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class FrmPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

	public static JTable tabla;

	public FrmPrincipal() {
		creaMenu();
		crearVentana();
	}

	private void creaMenu() {
		MenuBar barraMenu = new MenuBar();
		Menu menuBase = new Menu("BASE");
		Menu menuGestion = new Menu("GESTION");
		MenuItem itemProyectos = new MenuItem("1. Proyectos");
		MenuItem itemTrabajadores = new MenuItem("2. Trabajadores");
		MenuItem itemEquipos = new MenuItem("1. Equipos");
		menuBase.add(itemProyectos);
		menuBase.add(itemTrabajadores);
		menuGestion.add(itemEquipos);
		
		barraMenu.add(menuBase);
		barraMenu.add(menuGestion);
		menuBase.addSeparator(); // Añade linea horizontal para separar
		setMenuBar(barraMenu);

		itemProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlPrincipal.opcProyectos();
			}
		});
		itemTrabajadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlPrincipal.opcTrabajadores();
			}
		});

		itemEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlPrincipal.opcEquipos();
			}
		});

		MenuItem opcionSalir = new MenuItem("Salir");
		opcionSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Abandonar Aplicación",
						JOptionPane.YES_NO_OPTION);
				if (resp == 0)
					System.exit(0);
			}
		});
		menuBase.add(opcionSalir);
	}
	
	private void crearVentana() {

		int anchoV = 400;
		int altoV = 400;

		getContentPane().setLayout(null);
		setVisible(true);
		setResizable(false);
		setTitle("PROYECTOS");
		Color miColor = new Color(88, 143, 174);
		getContentPane().setBackground(miColor);
		
		JLabel lblAvanteIco = new JLabel("");
		lblAvanteIco.setIcon(new ImageIcon("avante.jpg"));
		lblAvanteIco.setBounds(82, 92, 227, 175);
		getContentPane().add(lblAvanteIco);

		Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((tamPantalla.width - anchoV) / 2, (tamPantalla.height - altoV) / 2, anchoV, altoV);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}
}