package app;

import java.text.SimpleDateFormat;
import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.negocio.NegocioPersonas;

public class Main {

	public static void main(String[] args) throws Exception{
		
		System.out.println("EjercicioP1_SpringTx_Programatica");
		
		ApplicationContext contenedor =
                new ClassPathXmlApplicationContext("spring.xml");
		
		NegocioPersonas negociopersonas = (NegocioPersonas) contenedor.getBean("negocioPersonas");
		System.out.println("----------------------------------------------------------------------------------------------Busca Todos");
		negociopersonas.damePersonas();
		System.out.println("----------------------------------------------------------------------------------------------Busca Uno");
		negociopersonas.buscaPersonas("100");
		System.out.println("----------------------------------------------------------------------------------------------Agregar Personas");
		String source="10/11/2014";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date d= new java.sql.Date(format.parse(source).getTime());
		negociopersonas.agregaPersonas("31", "Luis", d, "Total", 777);
		System.out.println("----------------------------------------------------------------------------------------------Actualizar Personas");
		negociopersonas.actualizaPersonas("25", "NombreModificado", d, "Total", 777);
	}

}
