package controller;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

import dataAccessLayer.DAL;

public class Controller {

	public DAL dal;

	public Controller() throws SQLException {
		dal = new DAL();
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------- REGISTER STUDENT! --------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */

	public void registerStudent(String firstName, String lastName, String socNmbr, String adress, String city, String zipCode) throws SQLException {	
		dal.registerStudent(firstName, lastName, socNmbr, adress, city, zipCode);
	}

	public void registerStudentEmail(String eMail, String socNmbr) throws SQLException {
		dal.registerStudentEmail(eMail, socNmbr);
	}

	public void registerStudentTelNmbr(String telNmbr, String socNmbr) throws SQLException {
		dal.registerStudentTelNmbr(telNmbr, socNmbr);
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------- CHECK STUDENT! ------------------------------------------ */
	/* -------------------------------------------------------------------------------------------------- */

	public boolean registerStudentCheckSocNmbr(String socNmbr) throws SQLException {
		return dal.registerStudentCheckSocNmbr(socNmbr);
	}
	
	public boolean registerStudentCheckEmail(String eMail) throws SQLException {
		return dal.registerStudentCheckEmail(eMail);
	}

	public boolean registerStudentCheckPhoneNmbr(String telNmbr) throws SQLException {	
		return dal.registerStudentCheckPhoneNmbr(telNmbr);
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* ------------------------------------------ GET STUDENT! ------------------------------------------ */
	/* -------------------------------------------------------------------------------------------------- */

	public DefaultTableModel getStudentByFirstName(String firstName, DefaultTableModel StudentModel) throws SQLException { 
		return dal.getStudentByFirstName(firstName, StudentModel);
	}

	public DefaultTableModel getStudentByLastName(String lastName, DefaultTableModel StudentModel) throws SQLException {
		return dal.getStudentByLastName(lastName, StudentModel);
	}

	public DefaultTableModel getStudentBySocNmbr(String socNmbr, DefaultTableModel StudentModel) throws SQLException { 
		return dal.getStudentBySocNmbr(socNmbr, StudentModel);
	}

	public DefaultTableModel getAllStudents(DefaultTableModel StudentModel) throws SQLException {
		return dal.getAllStudents(StudentModel);
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* ----------------------------------------- REMOVE STUDENT! ---------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */

	public void removeStudent(String socNmbr) throws SQLException {
		dal.removeStudent(socNmbr);
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* -------------------------------------- OTHER STUDENT METHODS! ------------------------------------ */
	/* -------------------------------------------------------------------------------------------------- */

	public DefaultTableModel getStudentActiveCourses(String socNmbr, DefaultTableModel CourseModel) throws SQLException {
		return dal.getStudentActiveCourses(socNmbr, CourseModel);
	}

	public DefaultTableModel getStudentPastCourses(String socNmbr, DefaultTableModel CourseModel) throws SQLException {
		return dal.getStudentPastCourses(socNmbr, CourseModel);
	}

	public String getStudentGrade(String socNmbr, String courseCode, DefaultTableModel StudentModel) throws SQLException { 
		return dal.getStudentGrade(socNmbr, courseCode, StudentModel);
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------- REGISTER COURSE! ---------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */

	public void registerCourse(String courseName, String courseCode, int credits) throws SQLException {	
		dal.registerCourse(courseName, courseCode, credits);
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	/* ------------------------------------------ CHECK COURSE! ----------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */
	
	public boolean registerCourseCheckCourseCode(String courseCode) throws SQLException {
		return dal.registerCourseCheckCourseCode(courseCode);
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------- GET COURSE! ----------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */
		
	public DefaultTableModel getCourseByCode(String courseCode, DefaultTableModel StudentModel) throws SQLException { 
		return dal.getCourseByCode(courseCode, StudentModel);
	}
	
	public DefaultTableModel getCourseByName(String courseSearchName, DefaultTableModel CourseModel) throws SQLException { 
		return dal.getCourseByName(courseSearchName, CourseModel);
	}
	
	public DefaultTableModel getAllCourses(DefaultTableModel CourseModel) throws SQLException {
		return dal.getAllCourses(CourseModel);
	}
	
	public Integer getCourseCredtis(String courseCode) throws SQLException {
		return dal.getCourseCredits(courseCode);
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* ----------------------------------------- REMOVE COURSE! ----------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */

	public void removeCourse(String courseCode) throws SQLException { // Removes a specific course!
		dal.removeCourse(courseCode);
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	/* ----------------------------------- OTHER COURSE METHODS COURSE! --------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getCourseActiveStudents(String courseCode, DefaultTableModel StudentModel) throws SQLException {
		return dal.getCourseActiveStudents(courseCode, StudentModel);
	}	
	
	public DefaultTableModel getCoursePastStudents(String courseCode, DefaultTableModel StudentModel) throws SQLException { 
		return dal.getCoursePastStudents(courseCode, StudentModel);
	}
	
	public Integer getHighGradePercentage(String courseCode) throws SQLException { 
		return dal.getHighGradePercentage(courseCode);
	}

	public Integer getCourseThroughput(String courseCode) throws SQLException { 
		return dal.getCourseThroughput(courseCode);
	}
		
	/* -------------------------------------------------------------------------------------------------- */
	/* ------------------------------------ REGISTER STUDENT ON COURSE! --------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */

	public void registerStudentOnCourse(String socNmbr, String courseCode) throws SQLException {
		dal.registerStudentOnCourse(socNmbr, courseCode);
	}
	
	public boolean registerStudentOnCourseCheckCredits(String socNmbr, String courseCode) throws SQLException {
		
		// Checks if student credits, including the course it is about to be registered on, exceeds 45 credits...
		
		if ((dal.getTotalStudentCredits(socNmbr) + dal.getCourseCredits(courseCode)) <= 45) {
			return true;
		}
		return false;
	}
	
	public boolean registerStudentOnCourseCheckIfTaking (String socNmbr, String courseCode) throws SQLException {
		return dal.registerStudentOnCourseCheckIfTaking(socNmbr, courseCode);
	}

	public boolean registerStudentOnCourseCheckIfTaken (String socNmbr, String courseCode) throws SQLException {
		return dal.registerStudentOnCourseCheckIfTaken(socNmbr, courseCode);
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	/* ------------------------------------- GRADE STUDENT ON COURSE! ----------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */
	
	public void gradeStudentOnCourse(String socNmbr, String courseCode, String grade) throws SQLException {
		dal.gradeStudentOnCourse(socNmbr, courseCode, grade);
	}

	public boolean gradeStudentOnCourseCheckIfTaking(String socNmbr, String courseCode) throws SQLException {
		return dal.gradeStudentOnCourseCheckIfTaking(socNmbr, courseCode);
	}

	public boolean gradeStudentOnCourseCheckIfGradeIsU(String socNmbr, String courseCode, String grade) throws SQLException {
		return dal.gradeStudentOnCourseCheckIfGradeIsU(socNmbr, courseCode, grade);
	}
	
	public void reGradeStudentOnCourse (String socNmbr, String courseCode, String grade) throws SQLException {
		dal.reGradeStudentOnCourse(socNmbr, courseCode, grade);
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */
	
}
