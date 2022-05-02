package com.erdal.hibernate.demo;

import com.erdal.hibernate.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// Place hibernate.cfg.xml file under resources/ folder
		// Default config filename is hibernate.cfg.xml. If a different name is given,
		// that filename must be specified explicitly.

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

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

			/*
			 * session = factory.getCurrentSession(); session.beginTransaction();
			 * 
			 * Student student = session.get(Student.class, 1);
			 * 
			 * System.out.println("student name: " + student.getFirstName() + " " +
			 * student.getLastName());
			 * 
			 * session.getTransaction().commit();
			 * 
			 * System.out.println("Done...");
			 */
		} finally {
			// session.close();
			factory.close();
		}
	}
}