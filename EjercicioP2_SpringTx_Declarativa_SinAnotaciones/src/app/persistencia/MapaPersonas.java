package app.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import app.modelo.Personas;

public class MapaPersonas implements RowMapper<Personas>{
	
	public Personas mapRow(ResultSet rs, int i) throws SQLException{
		Personas personas = new Personas();
		personas.setDni(rs.getString("DNI"));
		personas.setNombre(rs.getString("NOMBRE"));
		personas.setFecnac(rs.getDate("FECNAC"));
		personas.setDir(rs.getString("DIR"));
		personas.setTfno(rs.getInt("TFNO"));
		return personas;
	}
}
