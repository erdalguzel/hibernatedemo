package com.erdal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

import com.erdal.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// Place hibernate.cfg.xml file under resources/ folder
		// Default config filename is hibernate.cfg.xml. If a different name is given,
		// that filename must be specified explicitly.

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Logger log = Logger.getLogger(Student.class);

		try {
			/*
			 * System.out.println("Creating new student object..."); Student s = new
			 * Student("Bonita", "Applebum", "bonita@abc.com");
			 * 
			 * session.beginTransaction();
			 * 
			 * session.persist(s);
			 * 
			 * session.getTransaction().commit();
			 * 
			 * System.out.println("s id: " + s.getId());
			 */

			// NEW CODE

			session = factory.getCurrentSession();

			session.beginTransaction();

			Student student = session.get(Student.class, 1);

			log.log(Level.INFO, "student name: " + student.getFirstName() + " " + student.getLastName());

			session.getTransaction().commit();

			log.log(Level.INFO, "Done...");

		} finally {
			session.close();
			factory.close();
		}
	}
}