package app.modelo;

import java.sql.Date;

public class Personas {

	private String dni;
	private String nombre;
	private Date fecnac;
	private String dir;
	private int tfno;
	
	public Personas() {}
	
	public Personas(String dni, String nombre, Date fecnac, String dir, int tfno){
		this.dni = dni;
		this.nombre = nombre;
		this.fecnac = fecnac;
		this.dir = dir;
		this.tfno = tfno;
	}


	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecnac() {
		return fecnac;
	}

	public void setFecnac(Date fecnac) {
		this.fecnac = fecnac;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public int getTfno() {
		return tfno;
	}

	public void setTfno(int tfno) {
		this.tfno = tfno;
	}

	
	@Override
    public String toString() {
        return "Personas{" 	
				+ " dni=" + dni 
				+ " nombre=" + nombre 
				+ " fecnac=" + fecnac
				+ " dir=" + dir 
				+ " tfno=" + tfno 
				+ '}';
    }
	
}
