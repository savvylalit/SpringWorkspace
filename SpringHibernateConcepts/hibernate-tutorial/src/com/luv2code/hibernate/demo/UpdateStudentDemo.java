package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;
			// start a transaction
			session.beginTransaction();
			

			// retrieve student based on id
			System.out.println("\nGetting student with id: "+studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Update student... ");
			myStudent.setFirstName("Scooby");
			
			// commit the transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update email for all students");
			
			session.createQuery("update Student set email = 'foo@gmail.com'")
					.executeUpdate();
			session.getTransaction().commit();			
			
			System.out.println("Done!");
			
		}finally{
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
	}

}
