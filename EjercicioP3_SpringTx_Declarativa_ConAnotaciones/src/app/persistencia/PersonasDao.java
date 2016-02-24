package app.persistencia;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.modelo.Personas;

public class PersonasDao {

	 private JdbcTemplate plantilla;
	 private RowMapper<Personas> mapapersonas;
	 
	 public List<Personas> selectPersonas(){
		 
		 String querysql="Select * from PERSONAS";
		 return plantilla.query(querysql,  mapapersonas);
	 }
	 
	 public Personas buscaPersonas(String dni){
		 
		 String querysql="Select * from PERSONAS where dni= ?";
		 return plantilla.queryForObject(querysql, new Object[] {dni}, mapapersonas);
		 
	 }
	 
	 @Transactional(rollbackFor=SQLException.class, 
			       isolation=Isolation.SERIALIZABLE, 
			       propagation=Propagation.REQUIRED)
	 public void insertaPersonas(Personas personas){
		 
		 String querysql="insert into PERSONAS values(?,?,?,?,?)";
		 plantilla.update(querysql, personas.getDni(), personas.getNombre(), personas.getFecnac(), personas.getDir(), personas.getTfno());
		 
		 System.out.println("Se hace el commit --------------");
	 }
	 
	 @Transactional(rollbackFor=SQLException.class, 
		       isolation=Isolation.SERIALIZABLE, 
		       propagation=Propagation.REQUIRED)
	 public void actualizaPersonas(Personas personas){
		 
    	String querysql="update PERSONAS set nombre=?, fecnac=?, dir=?, tfno=? where dni=?";
	 	plantilla.update(querysql, personas.getNombre(), personas.getFecnac(), personas.getDir(), personas.getTfno(), personas.getDni());
	 	
	 	System.out.println("Se hace el commit --------------");
	 }
	 
	public JdbcTemplate getPlantilla() {
		return plantilla;
	}
	public void setPlantilla(JdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}
	public RowMapper<Personas> getMapapersonas() {
		return mapapersonas;
	}
	public void setMapapersonas(RowMapper<Personas> mapapersonas) {
		this.mapapersonas = mapapersonas;
	} 
	
}
