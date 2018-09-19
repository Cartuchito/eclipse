package controller;

import javax.sql.rowset.CachedRowSet;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CtrlCargos extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void seleccionaCargo() {
		new view.FrmSeleccionaCargo();
		
		try {
			CachedRowSet datos = logic.LogicCargos.getNombresCargos();
			DefaultTableModel modelo = utils.Gui.generarModeloJTable(datos);
			view.FrmSeleccionaCargo.tablaCargos.setModel(modelo);

			// Para centrar el texto en la tabla

			DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
			modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
			view.FrmSeleccionaCargo.tablaCargos.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
