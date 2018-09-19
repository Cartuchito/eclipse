package controller;

import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class CtrlEquipos {
	public static TableColumn columna;

	public static void inicio() {
		new view.FrmPrincipalEquipos();
		refrescaDatos();
	}

	private static void refrescaDatos() {
		try {
			// obtener datos de la BD
			CachedRowSet datos = logic.LogicProyectos.getNombresProyectos();
			// convertimos los datos obtenidos en un modelo de JTable
			DefaultTableModel modelo = utils.Gui.generarModeloJTable(datos);
			// pintamos el JTable en la vista
			view.FrmPrincipalEquipos.tablaProyect.setModel(modelo);
			columna = view.FrmListadoProyectos.tabla.getColumnModel().getColumn(0);
			columna.setMaxWidth(30);
			columna.setMinWidth(30);
			columna.setPreferredWidth(30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void seleccionTrabajador() {
		int fila = view.FrmSeleccionaTrabajador.tablaTrabajadores.getSelectedRow();

		try {
			CachedRowSet datos = logic.LogicTrabajadores.getSelectedTrabajador(fila);
			System.out.println(fila);
			DefaultTableModel modelo = utils.Gui.generarModeloJTable(datos);
			view.FrmPrincipalEquipos.tableTrabajadores.setModel(modelo);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void seleccionCargo() {
		int fila = view.FrmSeleccionaCargo.tablaCargos.getSelectedRow();
		fila++;

		try {
			CachedRowSet datos = logic.LogicTrabajadores.getSelectedCargo(fila);
			DefaultTableModel modelo = utils.Gui.generarModeloJTable(datos);
			view.FrmPrincipalEquipos.tableCargos.setModel(modelo);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void crearEquipo() {
		
	}
}
