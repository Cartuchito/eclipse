package databasemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DBSQLServer {

	public static String cadenaConn;

	public static void crearCadenaConexion(List<String> cfg) {
		String cadenaConn = "";

		cadenaConn += "jdbc:sqlserver://" + cfg.get(0);
		cadenaConn += ":" + cfg.get(1);
		cadenaConn += ";databaseName=" + cfg.get(2);
		cadenaConn += ";user=" + cfg.get(3);
		cadenaConn += ";password=" + cfg.get(4);

		databasemanager.DBSQLServer.cadenaConn = cadenaConn;
	}

	
	public static Connection establecerConexion() throws SQLException {
		return DriverManager.getConnection(cadenaConn);
		
	}
	
	public static CachedRowSet consultaSQL(String strSQL) throws SQLException {

		Connection c = establecerConexion();
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery(strSQL);
		RowSetFactory factory = RowSetProvider.newFactory();
		CachedRowSet rowset = factory.createCachedRowSet();
		rowset.populate(r);
		cerrarConexion(c);
		
		return rowset;
	}
	
	public static void executeDML(String strSQL) throws SQLException {

		Connection c = establecerConexion();
		Statement s = c.createStatement();
		s.executeLargeUpdate(strSQL);
		cerrarConexion(c);

	}
	
	public static void cerrarConexion(Connection conn)  throws SQLException {
		conn.close();
	}
	

	
	public static boolean testConexion() {
		boolean test = false;
		try {
			Connection c = establecerConexion();
			cerrarConexion(c);
			test = true;
		} catch(Exception e) {
			test = false;
		}
		return test;
	}


}
