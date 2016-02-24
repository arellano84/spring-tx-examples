package app.negocio;

import java.sql.Date;

import app.modelo.Personas;
import app.persistencia.PersonasDao;

public class NegocioPersonas {

	private PersonasDao dao;
	
	
	public void damePersonas(){
		for (Personas personas: dao.selectPersonas())
			System.out.println(personas);
	}
	
	public void buscaPersonas(String dni){
		System.out.println(dao.buscaPersonas(dni));
	}
	
	public void agregaPersonas(String dni, String nombre, Date fecnac, String direccion, int tfno){
		
		Personas personas = new Personas(dni, nombre, fecnac, direccion, tfno);
		dao.insertaPersonas(personas);
		System.out.println(personas);
	}
	
	public void actualizaPersonas(String dni, String nombre, Date fecnac, String direccion, int tfno){
		
		Personas personas = new Personas(dni, nombre, fecnac, direccion, tfno);
		dao.actualizaPersonas(personas);
		System.out.println(personas);
	}
	
	public PersonasDao getDao() {
		return dao;
	}

	public void setDao(PersonasDao dao) {
		this.dao = dao;
	}
	
}
