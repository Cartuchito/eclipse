package controller;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;

public class CtrlProyectos {

	public static void inicio() {
		new view.FrmListadoProyectos();
		refrescaDatos();	
	}

	public static void dialNuevoProyecto() throws SQLException {
		
		new view.DialNuevoProyecto();
	}
	
	public static void refrescaDatos(){
		try {
			// obtener datos de la BD
			CachedRowSet datos = logic.LogicProyectos.getListaProyectos();
			// convertimos los datos obtenidos en un modelo de JTable
			DefaultTableModel modelo = utils.Gui.generarModeloJTable(datos);
			// pintamos el JTable en la vista
	
			view.FrmListadoProyectos.tabla.setModel(modelo);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void crearNuevoProyecto() {
		String nombre = view.DialNuevoProyecto.textNombre.getText();
		String presupuesto = view.DialNuevoProyecto.textPresupuesto.getText();
		String fechaIni = view.DialNuevoProyecto.textFechaIni.getText();
		String fechaFin = view.DialNuevoProyecto.textFechaFin.getText();
		
		try {
			logic.LogicProyectos.insertaProyecto(nombre, presupuesto, fechaIni, fechaFin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		refrescaDatos();
		
	}

	public static void vaciarCamposProyecto() {
		view.DialNuevoProyecto.textNombre.getText();
		view.DialNuevoProyecto.textNombre.setText("");
		view.DialNuevoProyecto.textPresupuesto.getText();
		view.DialNuevoProyecto.textPresupuesto.setText("");
		view.DialNuevoProyecto.textFechaIni.getText();
		view.DialNuevoProyecto.textFechaIni.setText("");
		view.DialNuevoProyecto.textFechaFin.getText();
		view.DialNuevoProyecto.textFechaFin.setText("");
	}

	public static void eliminaProyecto() {
		int fila = view.FrmListadoProyectos.tabla.getSelectedRow();
		
			try {
				logic.LogicProyectos.borraProyecto(fila);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			refrescaDatos();

	}

	public static void dialEditarProyecto() {
		new view.DialEditarProyecto();
		
	}

	public static void editarProyecto() {
		
	}

	public static void obtenerValoresProyecto() throws SQLException {
		int fila = view.FrmListadoProyectos.tabla.getSelectedRow();
		CachedRowSet valores = logic.LogicProyectos.obtValoresProyecto(fila);
		ResultSetMetaData md = valores.getMetaData();
		
		int col =md.getColumnCount();

		int f = valores.getRow();
		System.out.println(col);
		
		//refrescaDatos();
		//rerutn valores;
	}

}