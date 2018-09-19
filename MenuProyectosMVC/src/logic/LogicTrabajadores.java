package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class LogicTrabajadores {
	public static CachedRowSet getDatosTrabajadores() throws SQLException {
		return databasemanager.DBSQLServer.consultaSQL("SELECT idTrabajador, DNI, nombre, apellidos, genero FROM Trabajador_EPC");
	}
	
	public static CachedRowSet getNombresTrabajadores() throws SQLException {
		return databasemanager.DBSQLServer.consultaSQL("SELECT nombre, apellidos FROM Trabajador_EPC");
	}

	public static void insertaTrabajador(String DNI, String nombre, String apellidos, String genero) throws SQLException {
		System.out.println(DNI+","+nombre+","+apellidos+","+genero);
		String consulta = "INSERT INTO Trabajador_EPC VALUES ('" + DNI + "','" + nombre + "','" + apellidos + "','" + genero + "')";
		databasemanager.DBSQLServer.executeDML(consulta);
	}

	public static void borraTrabajador(String strPK) throws SQLException {
		String consulta = "DELETE FROM Trabajador_EPC WHERE idtrabajador = "+strPK;
		databasemanager.DBSQLServer.executeDML(consulta);
	}

	public static CachedRowSet obtValoresTrabajador(String strPK) throws SQLException {
		return databasemanager.DBSQLServer.consultaSQL("SELECT idTrabajador, DNI,nombre,apellidos,genero FROM Trabajador_EPC WHERE IDTRABAJADOR = " + strPK);
	}

	public static void actualizaTrabajador(String strPK,String DNI,String nombre,String apellidos, String genero) throws SQLException {
		String upDNI = "UPDATE Trabajador_EPC set DNI = '"+DNI+"'WHERE idtrabajador = "+strPK;
		String upNombre = "UPDATE Trabajador_EPC set nombre = '"+nombre+"'WHERE idtrabajador = "+strPK;
		String upApellidos = "UPDATE Trabajador_EPC set apellidos = '"+apellidos+"'WHERE idtrabajador = "+strPK;
		String upGenero = "UPDATE Trabajador_EPC set genero = '"+genero+"'WHERE idtrabajador= "+strPK;

		databasemanager.DBSQLServer.executeDML(upDNI);
		databasemanager.DBSQLServer.executeDML(upNombre);
		databasemanager.DBSQLServer.executeDML(upApellidos);
		databasemanager.DBSQLServer.executeDML(upGenero);
	}


}