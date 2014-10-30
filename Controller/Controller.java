package Controller;

import java.sql.*;
import java.util.ArrayList;

import DataAccessLayer.DAL;

public class Controller {

	DAL dal;
	
	public Controller() {
	
		DAL dal = new DAL();
		
	}
	
	public void registerStudent(String firstName, String lastName, String socNmbr, String adress, String city, String zipCode) {	// Registers a specific student!
		dal.registerStudent(firstName, lastName, socNmbr, adress, city, zipCode);
	}
	
	public ArrayList<String> getStudent(String socNmbr) { // Finds a specific student!
		return dal.getStudent(socNmbr);
	}
	
	public ArrayList<String> getStudentResult(String socNmbr, String courseCode) { // Shows a specific students result on a specific course!
		return dal.getStudentResult(socNmbr, courseCode);
	}
	
	public void updateStudent(String firstName, String lastName, String socNmbr, String adress, String city, String zipCode) { // Updates a specific student!
		dal.updateStudent(firstName, lastName, socNmbr, adress, city, zipCode);
	}
	
	public void removeStudent(String socNmbr) { // Removes a specific student!
		dal.removeStudent(socNmbr);
	}
	
	
	
	
	
	public void registerCourse(String courseName, String courseCode, int credits) {	// Registers a specific course!
		dal.registerCourse(courseName, courseCode, credits);
	}
	
	public ArrayList<String> getCourse(String courseCode) { // Finds a specific course!
		return dal.getCourse(courseCode);
	}
	
	public ArrayList<String> getCourseResult(String courseCode) { // Finds students who took the course and their grade!
		return dal.getCourseResult(courseCode);
	}
	
	public void updateCourse(String courseName, String courseCode, int credits) { // Updates a specific course!
		dal.updateCourse(courseName, courseCode, credits);
	}
	
	public void removeCourse(String courseCode) { // Removes a specific course!
		dal.removeCourse(courseCode);
	}
	
	public void getHighGradePercentage(String courseCode) { // Gets the percentage for students who got A on a specific course!
		dal.getHighGradePercentage(courseCode);
	}
	
	public ArrayList<String> getCourseThroughput() { // Ranks all courses by highest throughput (students who has taken a course with at least grade 'E'!
		dal.getCourseThroughput();
		return null;
	}
	
	
	
	
	public ArrayList<String> getAllStudents() { // Finds all students!
		return null;
	}
	
	public ArrayList<String> getAllCourses() { // Finds all courses!
		return null;
	}
	
	
	
	
	public void addStudentToCourse(String socNmbr, String courseCode) { // Adds a student to a course!
		dal.addStudentToCourse(socNmbr, courseCode);
	}
	
	public void removeStudentFromCourse(String socNmbr, String courseCode) { // Removes a student from a course!
		dal.removeStudentFromCourse(socNmbr, courseCode);
	}
	
}
