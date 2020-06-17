package ar.jluque.hibernate.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ar.jluque.hibernate.dto.Cliente;
import ar.jluque.hibernate.dto.DetallesCliente;

public class ClienteObtener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class).buildSessionFactory();
		Session ss = sf.openSession();

		try {
			ss.beginTransaction();

			DetallesCliente dc = ss.get(DetallesCliente.class, 2);
			System.out.println(dc);
			System.out.println(dc.getCliente());
			ss.getTransaction().commit();
			ss.close();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sf.close();
		}

	}

}
