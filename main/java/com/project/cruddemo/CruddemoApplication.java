package com.project.cruddemo;

import com.project.cruddemo.dao.StudentDAO;
import com.project.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {

			/*CREATE OBJECTS

			createStudent(studentDAO);*/

			createMultipleStudents(studentDAO);


			/*READ OBJECTS

			readStudent(studentDAO);

			queryStudents(studentDAO);

			queryLastName(studentDAO);*/


			/*UPDATE OBJECTS

			updateStudent(studentDAO);*/


			/*DELETE OBJECTS

			deleteStudent(studentDAO);

			deleteAllStudents(studentDAO);*/

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Number of rows deleted: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student...");
		myStudent.setFirstName("Paul");

		studentDAO.update(myStudent);

		System.out.println(myStudent);

	}

	private void queryLastName(StudentDAO studentDAO) {
		List<Student> Students = studentDAO.findByLastName("Doe");

		for (Student tempStudent :
				Students) {
			System.out.println(tempStudent);
		}
	}

	private void queryStudents(StudentDAO studentDAO) {
		List<Student> Students = studentDAO.findAll();

		for (Student tempStudent :
				Students) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating a student object ...");
		Student tempStudent = new Student("Daniel", "Black", "blackDannye@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 students objects ...");
		Student tempStudent1 = new Student("John", "Doe", "JohnDoe@gmail.com");
		Student tempStudent2 = new Student("Jane", "Doe", "JaneDoe@gmail.com");
		Student tempStudent3 = new Student("Josh", "Public", "JoshPublic@gmail.com");

		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved student. Generated id: " + tempStudent3.getId());

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "PaulDoe@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}

}
