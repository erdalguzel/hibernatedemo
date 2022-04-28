package com.erdal.hibernate.demo;

import com.erdal.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {

        // Place hibernate.cfg.xml file under resources/ folder
        // Default config filename is hibernate.cfg.xml. If a different name is given, that filename must be specified explicitly.

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new student object...");
            Student s = new Student("Erdal", "Guzel", "erdal@abc.com");

            session.beginTransaction();

            session.save(s);

            session.getTransaction().commit();

            System.out.println("Done...");
        } finally {
            factory.close();
        }
    }
}