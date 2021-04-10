package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();

		try {
			// Create the objects
			/*
			 * Instructor tempInstructor = new Instructor("Chad", "Darby",
			 * "darby@luv2code.com");
			 * 
			 * InstructorDetail tempInstructorDetail = new
			 * InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");
			 * 
			 */
			Instructor tempInstructor = new Instructor("Savvy", "Lalit", "Savvy@savvy.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.savvy.com/youtube",
																		"Savvy code!!!");		
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save instructor
			//
			// This will ALSO save the details object becase of : CascadeType.ALL
			//
			System.out.println("Saving instructor: "+tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally{
			factory.close();
		}
	}

}
