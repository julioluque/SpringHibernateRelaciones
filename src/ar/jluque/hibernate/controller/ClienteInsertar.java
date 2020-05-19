package ar.jluque.hibernate.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ar.jluque.hibernate.dto.Cliente;
import ar.jluque.hibernate.dto.DetallesCliente;

public class ClienteInsertar {

	public static void main(String[] args) {

		Cliente cliente = new Cliente("Brenda", "Luque", "Amoreti 2234");
		DetallesCliente detalles = new DetallesCliente("www.brenda.com.ar", "115930293",
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
			System.out.println("Registros agregados a la BD. " + cliente.getNombre());

			ss.beginTransaction();
			System.out.println("<<<<<<<<<<< RECUPERANDO LISTADO");
			List <Cliente> clienteList = ss.createQuery("from Cliente").getResultList();
			for (Cliente c : clienteList) {
				System.out.println(c);
			}
			ss.getTransaction().commit();
			ss.close();

		} catch (Exception e) {
			System.out.println("XXX Error en la transaccion");
			e.printStackTrace();
		} finally {

			sf.close();
		}
	}

}
