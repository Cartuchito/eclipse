package model;

public class Proyecto {
	private String nombre;
	private String presupuesto;
	private String fechaIni;
	private String fechaFin;
	
	public Proyecto(){
		
	}

	public Proyecto(String nombre, String presupuesto, String fechaIni, String fechaFin) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(String presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	
	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String toString() {
		return 	 nombre +" - "+presupuesto+" - "+fechaIni+" - "+fechaFin;

	}
	
}
