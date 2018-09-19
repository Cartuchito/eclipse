package utils;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class Tablas {

	public static void centrarValorTabla(String tabla) {
	     DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
         modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
       //  view.FrmSeleccionaTrabajador.tabla.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
	}
}

