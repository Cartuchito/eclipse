package principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

public class Inicio {

	public static void main(String[] args) {
		Inicio app = new Inicio();
		try {
			app.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() throws FileNotFoundException, IOException {
		List<String> cfg = null;
		try {
			cfg = utils.Fichero.cargaFicheroCfg();
			databasemanager.DBSQLServer.crearCadenaConexion(cfg);
			if (databasemanager.DBSQLServer.testConexion()) {
				controller.CtrlPrincipal.iniciaApp();
			} else {
				JOptionPane.showMessageDialog(null, "No se puede establecer la conexión con el servidor.",
						"ERROR DE CONEXION", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {

		}
	}

}