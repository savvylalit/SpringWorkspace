package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// delete the student
			// System.out.println("Deleting student "+myStudent);
			// session.delete(myStudent);
			
			// delete student id=2 with update approach
			System.out.println("Deleting student id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			// commit the transaction
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
