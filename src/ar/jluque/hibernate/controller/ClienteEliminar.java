package ar.jluque.hibernate.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ar.jluque.hibernate.dto.Cliente;
import ar.jluque.hibernate.dto.DetallesCliente;

public class ClienteEliminar {

	public static void main(String[] args) {

		Cliente clienteDB;

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class).buildSessionFactory();
		Session ss = sf.openSession();

		try {
			ss.beginTransaction();
			clienteDB = ss.get(Cliente.class, 5);

			if (clienteDB != null) {
				System.out.println("Se eliminara el registro id: " + clienteDB.getId());
				ss.delete(clienteDB);
			} else {
				System.out.println("No se encontro el registro ");
			}
			ss.getTransaction().commit();

			if (clienteDB != null) {
				System.out.println("Registro elimando correctamente. Id: " + clienteDB.getId());
			} else {
				System.out.println("No se realizaron cambios en la base de datos...");
			}

			ss.beginTransaction();
			List<Cliente> clienteList = ss.createQuery("from Cliente").getResultList();
			for (Cliente c : clienteList) {
				System.out.println(c);
			}
			ss.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("XXX Error en la transaccion...");
		} finally {
			ss.close();
			sf.close();
		}

	}

}
