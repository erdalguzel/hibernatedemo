package com.erdal.hibernate.demo;

import com.erdal.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

import java.util.List;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// Place hibernate.cfg.xml file under resources/ folder
		// Default config filename is hibernate.cfg.xml. If a different name is given,
		// that filename must be specified explicitly.

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Logger log = Logger.getLogger(Student.class);

		try (Session session = factory.getCurrentSession()) {
			session.beginTransaction();

			List<Student> studentList = session.createQuery("from Student").getResultList();

			displayStudents(log, studentList);

			// use class attribute name on where clause, not database column name
			studentList = session.createQuery("from Student s where s.firstName='John'").getResultList();

			displayStudents(log, studentList);

			session.getTransaction().commit();
		}
	}

	private static void displayStudents(Logger log, List<Student> studentList) {
		for (Student s : studentList)
			log.log(Level.INFO, s.getFirstName() + " " + s.getLastName());
	}
}