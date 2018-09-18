package controller;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class CtrlTrabajadores {

	public static String DNI,nombre,apellidos,genero,val;
	public static String updateDNI,updateNombre,updateApellidos,updateGenero;

	public static void inicio() {
		new view.FrmListadoTrabajadores();
		refrescaDatosTrabajador();	
	}

	public static void dialNuevoTrabajador() throws SQLException {

		new view.DialNuevoTrabajador();
	}

	public static void refrescaDatosTrabajador(){
		try {
			// obtener datos de la BD
			CachedRowSet datos = logic.LogicTrabajadores.getDatosTrabajadores();
			// convertimos los datos obtenidos en un modelo de JTable
			DefaultTableModel modelo = utils.Gui.generarModeloJTable(datos);
			// pintamos el JTable en la vista
			view.FrmListadoTrabajadores.tabla.setModel(modelo);
			TableColumn  columna = view.FrmListadoTrabajadores.tabla.getColumnModel().getColumn(0);
			columna.setMaxWidth(0);
			columna.setMinWidth(0);
			columna.setPreferredWidth(0);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void crearNuevoTrabajador() {
		DNI = view.DialNuevoTrabajador.textDNI.getText();
		nombre = view.DialNuevoTrabajador.textNombre.getText();
		apellidos = view.DialNuevoTrabajador.textApellidos.getText();
		genero = view.DialNuevoTrabajador.textGenero.getText();

		try {
			logic.LogicTrabajadores.insertaTrabajador(DNI, nombre, apellidos, genero);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		refrescaDatosTrabajador();

	}

	public static void vaciarCamposTrabajador() {
		view.DialNuevoTrabajador.textDNI.getText();
		view.DialNuevoTrabajador.textDNI.setText("");
		view.DialNuevoTrabajador.textNombre.getText();
		view.DialNuevoTrabajador.textNombre.setText("");
		view.DialNuevoTrabajador.textApellidos.getText();
		view.DialNuevoTrabajador.textApellidos.setText("");
		view.DialNuevoTrabajador.textGenero.getText();
		view.DialNuevoTrabajador.textGenero.setText("");
	}

	public static void eliminaTrabajador() {
		int fil = view.FrmListadoTrabajadores.tabla.getSelectedRow();
		int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Trabajador?", "Borrar Trabajador",
				JOptionPane.YES_NO_OPTION);
		if (resp ==0) {
			if(fil>=0) {
				int col = 0;
				val = view.FrmListadoTrabajadores.tabla.getValueAt(fil, col).toString();
				try {
					logic.LogicTrabajadores.borraTrabajador(val);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				refrescaDatosTrabajador();
			}else {
				System.out.println("Selecciona una fila mardito");
			}}

	}

	public static void dialEditarTrabajador() {
		try {
			obtenerValoresTrabajador();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	public static void editarTrabajador() throws SQLException {
		updateDNI=view.DialEditarTrabajador.textDNI.getText();
		updateNombre=view.DialEditarTrabajador.textNombre.getText();
		updateApellidos=view.DialEditarTrabajador.textApellidos.getText();
		updateGenero=view.DialEditarTrabajador.textGenero.getText();

		logic.LogicTrabajadores.actualizaTrabajador(val,updateDNI,updateNombre,updateApellidos,updateGenero);
	}

	public static void obtenerValoresTrabajador() throws SQLException {
		int fil = view.FrmListadoTrabajadores.tabla.getSelectedRow();
		if(fil>=0) {
			int col = 0;
			val = view.FrmListadoTrabajadores.tabla.getValueAt(fil, col).toString();

			CachedRowSet valores = logic.LogicTrabajadores.obtValoresTrabajador(val);

			valores.next();
			DNI = valores.getString(2);
			nombre = valores.getString(3);
			apellidos = valores.getString(4);
			genero = valores.getString(5);
			new view.DialEditarTrabajador();
			refrescaDatosTrabajador();
		}else{
			System.out.println("Selecciona una fila cansina");
		}

	}
	
	public static void dialInfoTrabajador() throws SQLException {
		int fil = view.FrmListadoTrabajadores.tabla.getSelectedRow();
		if(fil>=0) {
			int col = 0;
			val = view.FrmListadoTrabajadores.tabla.getValueAt(fil, col).toString();

			CachedRowSet valores = logic.LogicTrabajadores.obtValoresTrabajador(val);

			valores.next();
			DNI = valores.getString(2);
			nombre = valores.getString(3);
			apellidos = valores.getString(4);
			genero = valores.getString(5);
			new view.DialInfoTrabajador();
			refrescaDatosTrabajador();
		}else{
			System.out.println("Selecciona una fila cansina");
		}

	}

	public static void seleccionaTrabajador() {
		new view.FrmSeleccionaTrabajador();

		try {
			CachedRowSet datos = logic.LogicTrabajadores.getNombresTrabajadores();
			DefaultTableModel modelo = utils.Gui.generarModeloJTable(datos);
			view.FrmSeleccionaTrabajador.tablaTrabajadores.setModel(modelo);

			// Para centrar el texto en la tabla

			DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
			modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
			view.FrmSeleccionaTrabajador.tablaTrabajadores.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
			view.FrmSeleccionaTrabajador.tablaTrabajadores.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}


