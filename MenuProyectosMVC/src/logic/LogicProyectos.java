package logic;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;

public class LogicProyectos {

	public static CachedRowSet getListaProyectos() throws SQLException {
		return databasemanager.DBSQLServer.consultaSQL("SELECT nombre,presupuesto,fechaIni,fechaFin FROM PROYECTO_EPC");
	}

	public static void insertaProyecto(String nombre, String presupuesto, String fechaIni, String fechaFin) throws SQLException {
		String consulta = "INSERT INTO PROYECTO_EPC VALUES ('" + nombre + "','" + presupuesto + "','" + fechaIni + "','" + fechaFin + "')";
		databasemanager.DBSQLServer.executeDML(consulta);
	}

	public static void borraProyecto(int fila) throws SQLException {
		fila++;	
		String consulta = "DELETE FROM PROYECTO_EPC WHERE idproyecto = "+fila;
		databasemanager.DBSQLServer.executeDML(consulta);
	}

	public static CachedRowSet obtValoresProyecto(int fila) throws SQLException {
		fila++;
		return databasemanager.DBSQLServer.consultaSQL("SELECT nombre,presupuesto,fechaIni,fechaFin FROM PROYECTO_EPC WHERE IDPROYECTO = " + fila);
	}
}