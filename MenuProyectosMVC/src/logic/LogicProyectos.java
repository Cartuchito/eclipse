package logic;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;

public class LogicProyectos {
	
	public static CachedRowSet getNombresProyectos() throws SQLException {
		return databasemanager.DBSQLServer.consultaSQL("SELECT nombre FROM Proyecto_EPC");
	}


	public static CachedRowSet getListaProyectos() throws SQLException {
		return databasemanager.DBSQLServer.consultaSQL("SELECT IDPROYECTO, nombre,presupuesto,fechaIni,fechaFin FROM Proyecto_EPC");
	}

	public static void insertaProyecto(String nombre, String presupuesto, String fechaInicio, String fechaFin) throws SQLException {
		String consulta = "INSERT INTO Proyecto_EPC VALUES ('" + nombre + "','" + presupuesto + "','" + fechaInicio + "','" + fechaFin + "')";
		databasemanager.DBSQLServer.executeDML(consulta);
	}

	public static void borraProyecto(String strPK) throws SQLException {
		String consulta = "DELETE FROM Proyecto_EPC WHERE idproyecto = "+strPK;
		databasemanager.DBSQLServer.executeDML(consulta);
	}

	public static CachedRowSet obtValoresProyecto(String strPK) throws SQLException {
		return databasemanager.DBSQLServer.consultaSQL("SELECT IDPROYECTO, nombre,presupuesto,fechaIni,fechaFin FROM Proyecto_EPC WHERE IDPROYECTO = " + strPK);
	}
	
	public static void actualizaProyecto(String strPK,String nombre,String presupuesto,String fechaIni, String fechaFin) throws SQLException {
		String upNombre = "UPDATE Proyecto_EPC set nombre = '"+nombre+"'WHERE idproyecto = "+strPK;
		String upPresupuesto = "UPDATE Proyecto_EPC set presupuesto = '"+presupuesto+"'WHERE idproyecto = "+strPK;
		String upfechaIni = "UPDATE Proyecto_EPC set fechaIni = '"+fechaIni+"'WHERE idproyecto = "+strPK;
		String upFechaFin = "UPDATE Proyecto_EPC set fechaFin = '"+fechaFin+"'WHERE idproyecto = "+strPK;
		
		databasemanager.DBSQLServer.executeDML(upNombre);
		databasemanager.DBSQLServer.executeDML(upPresupuesto);
		databasemanager.DBSQLServer.executeDML(upfechaIni);
		databasemanager.DBSQLServer.executeDML(upFechaFin);
	}

}