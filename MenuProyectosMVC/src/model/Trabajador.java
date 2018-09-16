package model;

public class Trabajador {
	private String DNI;
	private String nombre;
	private String apellidos;
	private String genero;
	
	public Trabajador() {
	}

	public Trabajador(String DNI, String nombre, String apellidos, String genero) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		this.DNI = DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return 	 nombre +" - "+apellidos+" - "+genero+" - "+DNI;
	}
	
}
