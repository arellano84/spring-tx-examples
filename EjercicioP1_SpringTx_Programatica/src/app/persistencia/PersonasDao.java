package app.persistencia;

import java.sql.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import app.modelo.Personas;

public class PersonasDao {

	 private JdbcTemplate plantilla;
	 private RowMapper<Personas> mapapersonas;
	 private TransactionTemplate txTemplate;
	 
	 public List<Personas> selectPersonas(){
		 
		 String querysql="Select * from PERSONAS";
		 return plantilla.query(querysql,  mapapersonas);
	 }
	 
	 public Personas buscaPersonas(String dni){
		 
		 final String dni_aux = dni;
		 return txTemplate.execute(new TransactionCallback<Personas>() {
			 
	         @Override
	         public Personas doInTransaction(TransactionStatus ts) {
	        	 try {
	        		 String querysql="Select * from PERSONAS where dni= ?";
		       		 return plantilla.queryForObject(querysql, new Object[] {dni_aux}, mapapersonas);
		       		
	        	 }catch (Exception e) {
	        		 System.out.println("Selecion KO ------------");
//	        		 throw new RuntimeException("Error buscando personas ",e);
	        		 e.printStackTrace();
	        		 return null;
	         	 }
	         }
		});
	 }
	 
	 public void insertaPersonas(Personas personas){
		 
		 /*String querysql="insert into PERSONAS values(?,?,?,?,?)";
		 plantilla.update(querysql, personas.getDni(), personas.getNombre(), personas.getFecnac(), personas.getDir(), personas.getTfno());*/
		 
        final Personas personas_aux = personas;
        txTemplate.execute(new TransactionCallbackWithoutResult() {
        	
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus ts) {
                try{
                	String querysql="insert into PERSONAS values(?,?,?,?,?)";
           		 	plantilla.update(querysql, personas_aux.getDni(), personas_aux.getNombre(), personas_aux.getFecnac(), personas_aux.getDir(), personas_aux.getTfno());
           		 	
                    System.out.println("Se hace el commit --------------");
                    
                }catch(Exception ex){
                    ts.setRollbackOnly();
                    System.out.println("Se hace el rollback ------------");
                    ex.printStackTrace();
                }
            }
        });
	 }
	 
	 public void actualizaPersonas(Personas personas){
		 
        final Personas personas_aux = personas;
        txTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus ts) {
                try{
                	String querysql="update PERSONAS set nombre=?, fecnac=?, dir=?, tfno=? where dni=?";
           		 	plantilla.update(querysql, personas_aux.getNombre(), personas_aux.getFecnac(), personas_aux.getDir(), personas_aux.getTfno(), personas_aux.getDni());
           		 	
                    System.out.println("Se hace el commit --------------");
                    
                }catch(Exception ex){
                    ts.setRollbackOnly();
                    System.out.println("Se hace el rollback ------------");
                    ex.printStackTrace();
                }
            }
        });
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
	
    public TransactionTemplate getTxTemplate() {
        return txTemplate;
    }
    
    public void setTxTemplate(TransactionTemplate txTemplate) {
        this.txTemplate = txTemplate;
    }
    
}
