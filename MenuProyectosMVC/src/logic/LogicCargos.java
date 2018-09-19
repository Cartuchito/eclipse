package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class LogicCargos {
	public static CachedRowSet getNombresCargos() throws SQLException {
		return databasemanager.DBSQLServer.consultaSQL("SELECT cargo FROM Cargo_EPC");
	}

}