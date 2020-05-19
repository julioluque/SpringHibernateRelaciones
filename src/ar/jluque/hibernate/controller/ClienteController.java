package ar.jluque.hibernate.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ar.jluque.hibernate.dto.Cliente;
import ar.jluque.hibernate.dto.DetallesCliente;

public class ClienteController {

	public static void main(String[] args) {

		Cliente cliente = new Cliente("Sofia", "Luque", "Amoreti 2234");
		DetallesCliente detalles = new DetallesCliente("www.julio.com.ar", "115930293",
				"Aca va la descripcion y comentarios");
		
		cliente.setDetallesCliente(detalles);
//		Asociar los objetos.
		

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class).buildSessionFactory();
		Session ss = sf.openSession();

		try {
			ss.beginTransaction();
			ss.save(cliente);
			ss.getTransaction().commit();
			ss.close();
			System.out.println("Registros agregados a la BD");

		} catch (Exception e) {
			System.out.println("XXX Error en la transaccion");
			e.printStackTrace();
		} finally {

			sf.close();
		}
	}

}
