package controller;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class CtrlProyectos {


	public static String nombre,presupuesto,fechaIni,fechaFin,val;
	public static String updateNom,updatePresupuesto,updateFechaIni,updateFechaFin;
	public static TableColumn columna;

	public static void inicio() {
		new view.FrmListadoProyectos();
		refrescaDatosProyectos();	
	}

	public static void dialNuevoProyecto() throws SQLException {

		new view.DialNuevoProyecto();
	}

	/*public static void refrescaDatosProyectos(){
		try {
			// obtener datos de la BD
			CachedRowSet datos = logic.LogicProyectos.getListaProyectos();
			// convertimos los datos obtenidos en un modelo de JTable
			DefaultTableModel modelo = utils.Gui.generarModeloJTable(datos);
			// pintamos el JTable en la vista
			view.FrmListadoProyectos.tabla.setModel(modelo);
			TableColumn  columna = view.FrmListadoProyectos.tabla.getColumnModel().getColumn(0);
			columna.setMaxWidth(0);
			columna.setMinWidth(0);
			columna.setPreferredWidth(0);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}*/
	
	public static void refrescaDatosProyectos(){
	try {
		// obtener datos de la BD
		CachedRowSet datos = logic.LogicProyectos.getListaProyectos();
		// convertimos los datos obtenidos en un modelo de JTable
		DefaultTableModel modelo = utils.Gui.generarModeloJTable(datos);
		// pintamos el JTable en la vista
		view.FrmListadoProyectos.tabla.setModel(modelo);
		columna = view.FrmListadoProyectos.tabla.getColumnModel().getColumn(0);
		columna.setMaxWidth(0);
		columna.setMinWidth(0);
		columna.setPreferredWidth(0);
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
}


	public static void crearNuevoProyecto() {
		nombre = view.DialNuevoProyecto.textNombre.getText();
		presupuesto = view.DialNuevoProyecto.textPresupuesto.getText();
		fechaIni = view.DialNuevoProyecto.textFechaIni.getText();
		fechaFin = view.DialNuevoProyecto.textFechaFin.getText();

		try {
			logic.LogicProyectos.insertaProyecto(nombre, presupuesto, fechaIni, fechaFin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		refrescaDatosProyectos();

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
		int fil = view.FrmListadoProyectos.tabla.getSelectedRow();
		int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el proyecto?", "Borrar Trabajador",
				JOptionPane.YES_NO_OPTION);
		if (resp ==0) {
			if(fil>=0) {
				int col = 0;
				val = view.FrmListadoProyectos.tabla.getValueAt(fil, col).toString();
				try {
					logic.LogicProyectos.borraProyecto(val);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				refrescaDatosProyectos();
			}else {
				System.out.println("Selecciona una fila mardito");
			}}

	}

	public static void dialEditarProyecto() {
		try {
			obtenerValoresProyecto();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	public static void editarProyecto() throws SQLException {
		//int fil = view.FrmListadoProyectos.tabla.getSelectedRow();
		updateNom=view.DialEditarProyecto.textNombre.getText();
		updatePresupuesto=view.DialEditarProyecto.textPresupuesto.getText();
		updateFechaIni=view.DialEditarProyecto.textFechaIni.getText();
		updateFechaFin=view.DialEditarProyecto.textFechaFin.getText();

		logic.LogicProyectos.actualizaProyecto(val,updateNom,updatePresupuesto,updateFechaIni,updateFechaFin);
	}

	public static void obtenerValoresProyecto() throws SQLException {
		int fil = view.FrmListadoProyectos.tabla.getSelectedRow();
		if(fil>=0) {
			int col = 0;
			val = view.FrmListadoProyectos.tabla.getValueAt(fil, col).toString();

			CachedRowSet valores = logic.LogicProyectos.obtValoresProyecto(val);

			valores.next();
			nombre = valores.getString(2);
			presupuesto = valores.getString(3);
			fechaIni = valores.getString(4);
			fechaFin = valores.getString(5);
			new view.DialEditarProyecto();
			refrescaDatosProyectos();
		}else{
			System.out.println("Selecciona una fila cansina");
		}

	}

	public static void dialInfoProyecto() throws SQLException {
		int fil = view.FrmListadoProyectos.tabla.getSelectedRow();
		if(fil>=0) {
			int col = 0;
			val = view.FrmListadoProyectos.tabla.getValueAt(fil, col).toString();

			CachedRowSet valores = logic.LogicProyectos.obtValoresProyecto(val);

			valores.next();
			nombre = valores.getString(2);
			presupuesto = valores.getString(3);
			fechaIni = valores.getString(4);
			fechaFin = valores.getString(5);
			new view.DialInfoProyecto();
			refrescaDatosProyectos();
		}else{
			System.out.println("Selecciona una fila cansina");
		}

	}

	public static void obtenerNombreProyectos() throws SQLException {
			logic.LogicProyectos.getNombresProyectos();
		
	}
	

}