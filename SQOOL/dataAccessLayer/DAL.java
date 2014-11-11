package dataAccessLayer;

import java.sql.*;

import javax.swing.table.DefaultTableModel;

public class DAL {

	Connection con;

	public DAL() throws SQLException {
		driverCheck();
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	/* The basic functionality of this DAL is centered around the conversion of a result set. This means
	 * that the object actually sent back to the GUI (or any other instance calling for the DAL) will not
	 * receive an SQL result set but a finished JTable model. We chose this method mainly because it keeps
	 * the GUI clean of any SQL result set conversion code and found it to be very effective.
	/* -------------------------------------------------------------------------------------------------- */
	
	/* -------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------- REGISTER STUDENT! --------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */

	public void registerStudent(String firstName, String lastName, String socNmbr, String adress, String city, String zipCode) throws SQLException {	// Registers a specific student!	

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("INSERT INTO Student "
														 + "VALUES(?,?,?,?,?,?)");
		
		prepStmnt.setString(1, firstName);
		prepStmnt.setString(2, lastName);
		prepStmnt.setString(3, socNmbr);
		prepStmnt.setString(4, adress);
		prepStmnt.setString(5, city);
		prepStmnt.setString(6, zipCode);
		
		prepStmnt.executeUpdate();
	}

	/* -------------------------------------------------------------------------------------------------- */
	
	public void registerStudentEmail(String eMail, String socNmbr) throws SQLException {

		con = connectionTest();

		PreparedStatement prepStmnt = con.prepareStatement("INSERT INTO Email "
														 + "VALUES(?,?)");

		prepStmnt.setString(1, eMail);
		prepStmnt.setString(2, socNmbr);
		
		prepStmnt.executeUpdate();
	}
	
	/* -------------------------------------------------------------------------------------------------- */

	public void registerStudentTelNmbr(String telNmbr, String socNmbr) throws SQLException {
		
		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("INSERT INTO Telephone "
														 + "VALUES(?,?)");
		
		prepStmnt.setString(1, telNmbr);
		prepStmnt.setString(2, socNmbr);
		
		prepStmnt.executeUpdate();
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------- CHECK STUDENT! ------------------------------------------ */
	/* -------------------------------------------------------------------------------------------------- */
	
	public boolean registerStudentCheckSocNmbr(String socNmbr) throws SQLException {

		con = connectionTest();
		PreparedStatement prepPreStmnt = con.prepareStatement("SELECT socNmbr "
															+ "FROM Student "
															+ "WHERE socNmbr = ?");
		
		prepPreStmnt.setString(1, socNmbr);
		ResultSet resSet = prepPreStmnt.executeQuery();

		if (resSet.next()) {
			String socNmbrCheck = resSet.getString(1);
			if (socNmbrCheck.equals(socNmbr)) {
				return true;
			}
		}
		return false;
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	
	public boolean registerStudentCheckEmail(String eMail) throws SQLException {

		con = connectionTest();
		PreparedStatement prepPreStmnt = con.prepareStatement("SELECT eMail "
															+ "FROM eMail "
															+ "WHERE eMail = ?");
		
		prepPreStmnt.setString(1, eMail);
		ResultSet resSet = prepPreStmnt.executeQuery();

		if (resSet.next() ){
			String eMailCheck = resSet.getString(1);
			if (eMailCheck.equals(eMail)) {
				return true;
			}
		}
		return false;
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	
	public boolean registerStudentCheckPhoneNmbr(String telNmbr) throws SQLException {

		con = connectionTest();
		PreparedStatement prepPreStmnt = con.prepareStatement("SELECT telNmbr "
															+ "FROM Telephone "
															+ "WHERE telNmbr = ?");
		prepPreStmnt.setString(1, telNmbr);
		ResultSet resSet = prepPreStmnt.executeQuery();

		if (resSet.next() ){
			String telNmbrCheck = resSet.getString(1);
			if (telNmbrCheck.equals(telNmbr)) {
				return true;
			}
		}
		return false;
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* ------------------------------------------ GET STUDENT! ------------------------------------------ */
	/* -------------------------------------------------------------------------------------------------- */

	public DefaultTableModel getStudentByFirstName(String searchFirstName, DefaultTableModel StudentTable) throws SQLException { 

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT S.*, T.telNmbr, E.email "
														 + "FROM Student S, Telephone T, Email E "
														 + "WHERE S.socNmbr = T.socNmbr "
														 + "AND S.socNmbr = E.socNmbr AND "
														 + "S.firstName LIKE ? "
														 + "ORDER BY S.firstName");
		
		prepStmnt.setString(1, searchFirstName + "%");
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int columnNbr = metadata.getColumnCount();

		while (resSet.next()) {              
			int i = 1;
			while(i <= columnNbr) {

				String firstName = resSet.getString(i++);
				String lastName = resSet.getString(i++);
				String socNmbr = resSet.getString(i++);
				String address = resSet.getString(i++);
				String city = resSet.getString(i++);
				String zipCode = resSet.getString(i++);
				String telNmbr = resSet.getString(i++);
				String eMail = resSet.getString(i++);

				Object[] studentData = {firstName, lastName, socNmbr, address, city, zipCode, telNmbr, eMail};

				StudentTable.addRow(studentData);	
			}
		}
		return StudentTable;
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getStudentByLastName(String searchLastName, DefaultTableModel StudentTable) throws SQLException { 

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT S.*, T.telNmbr, E.email "
														 + "FROM Student S, Telephone T, Email E "
														 + "WHERE S.socNmbr = T.socNmbr "
														 + "AND S.socNmbr = E.socNmbr "
														 + "AND S.lastName LIKE ?");
		
		prepStmnt.setString(1, "%" + searchLastName + "%");
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int columnNbr = metadata.getColumnCount();

		while (resSet.next()) {              
			int i = 1;
			while(i <= columnNbr) {

				String firstName = resSet.getString(i++);
				String lastName = resSet.getString(i++);
				String socNmbr = resSet.getString(i++);
				String address = resSet.getString(i++);
				String city = resSet.getString(i++);
				String zipCode = resSet.getString(i++);
				String telNmbr = resSet.getString(i++);
				String eMail = resSet.getString(i++);

				Object[] studentData = {firstName, lastName, socNmbr, address, city, zipCode, telNmbr, eMail};

				StudentTable.addRow(studentData);	
			}
		}
		return StudentTable;
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getStudentBySocNmbr(String searchSocNmbr, DefaultTableModel StudentTable) throws SQLException {

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT S.*, T.telNmbr, E.email "
														 + "FROM Student S, Telephone T, Email E "
														 + "WHERE s.socNmbr = t.socNmbr "
														 + "AND S.socNmbr = E.socNmbr "
														 + "AND s.socNmbr LIKE ? ORDER BY s.socNmbr");
		
		prepStmnt.setString(1, searchSocNmbr +"%");
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int columnNbr = metadata.getColumnCount();

		while (resSet.next()) {              
			int i = 1;
			while(i <= columnNbr) {

				String firstName = resSet.getString(i++);
				String lastName = resSet.getString(i++);
				String socNmbr = resSet.getString(i++);
				String address = resSet.getString(i++);
				String city = resSet.getString(i++);
				String zipCode = resSet.getString(i++);
				String telNmbr = resSet.getString(i++);
				String eMail = resSet.getString(i++);

				Object[] studentData = {firstName, lastName, socNmbr, address, city, zipCode, telNmbr, eMail};

				StudentTable.addRow(studentData);	
			}
		}
		return StudentTable;
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getAllStudents(DefaultTableModel StudentModel) throws SQLException  {

		con = connectionTest();

		PreparedStatement prepStmnt = con.prepareStatement("SELECT S.*, T.telNmbr, E.email "
														 + "FROM Student S, Telephone T, Email E "
														 + "WHERE S.socNmbr = T.socNmbr "
														 + "AND s.socNmbr = E.socNmbr "
														 + "ORDER BY S.firstName");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              

			int i = 1;
			while(i <= numberOfColumns) {

				String firstName = resSet.getString(i++);
				String lastName = resSet.getString(i++);
				String socNmbr = resSet.getString(i++);
				String address = resSet.getString(i++);
				String city = resSet.getString(i++);
				String zipCode = resSet.getString(i++);
				String telNmbr = resSet.getString(i++);
				String eMail = resSet.getString(i++);

				Object[] studentData = {firstName, lastName, socNmbr, address, city, zipCode, telNmbr, eMail};

				StudentModel.addRow(studentData);
			}
		}
		return StudentModel;  		
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	/* ----------------------------------------- REMOVE STUDENT! ---------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */

	public void removeStudent(String socNmbr) throws SQLException {

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("DELETE Student "
														 + "FROM Student "
														 + "WHERE socNmbr = ?");
		
		prepStmnt.setString(1, socNmbr);
		prepStmnt.executeUpdate();
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* -------------------------------------- OTHER STUDENT METHODS! ------------------------------------ */
	/* -------------------------------------------------------------------------------------------------- */

	public DefaultTableModel getStudentActiveCourses(String socNmbr, DefaultTableModel CourseTable) throws SQLException { 

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT C.* "
														 + "FROM Course C "
														 + "WHERE C.courseCode "
														 + "IN (SELECT courseCode FROM Studies WHERE socNmbr = ?) "
														 + "OR C.courseCode "
														 + "IN (SELECT courseCode FROM Studied WHERE socNmbr = ? AND grade = ?)");
		
		prepStmnt.setString(1, socNmbr);
		prepStmnt.setString(2, socNmbr);
		prepStmnt.setString(3, "U");
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int columnNbr = metadata.getColumnCount();

		while (resSet.next()) {              
			int i = 1;
			while(i <= columnNbr) {

				String courseName = resSet.getString(i++);
				String courseCode = resSet.getString(i++);
				int credits = resSet.getInt(i++);

				Object[] courseData = {courseName, courseCode, credits};

				CourseTable.addRow(courseData);
			}
		}
		return CourseTable;
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getStudentPastCourses(String socNmbr, DefaultTableModel CourseTable) throws SQLException { 

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT C.* "
														 + "FROM Course C"
														 + "INNER JOIN Studied S "
														 + "ON C.courseCode = S.courseCode "
														 + "WHERE S.socNmbr = ?");
		
		prepStmnt.setString(1, socNmbr);
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int columnNbr = metadata.getColumnCount();

		while (resSet.next()) {              
			int i = 1;
			while(i <= columnNbr) {

				String courseName = resSet.getString(i++);
				String courseNumber = resSet.getString(i++);
				int credits = resSet.getInt(i++);

				Object[] courseData = {courseName, courseNumber, credits};

				CourseTable.addRow(courseData);
			}
		}
		return CourseTable;
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	
	public String getStudentGrade(String socNmbr, String courseCode, DefaultTableModel StudentTable) throws SQLException {

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT Grade "
														 + "FROM Studied "
														 + "WHERE courseCode = ? "
														 + "AND socNmbr = ?");
		prepStmnt.setString(1, courseCode);
		prepStmnt.setString(2, socNmbr);
		ResultSet resSet = prepStmnt.executeQuery();

		String grade = "No grade found!";

		int i = 1;
		while (resSet.next()) {
			grade = resSet.getString(i++);
		}
		return grade;
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------- REGISTER COURSE! ---------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */
	
	public void registerCourse(String courseName, String courseCode, int credits) throws SQLException {	

		PreparedStatement prepStmnt = con.prepareStatement("INSERT INTO Course "
														 + "VALUES(?,?,?)");
		
		prepStmnt.setString(1, courseName);
		prepStmnt.setString(2, courseCode);
		prepStmnt.setInt(3, credits);

		prepStmnt.executeUpdate();
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* ------------------------------------------ CHECK COURSE! ----------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */
	
	public boolean registerCourseCheckCourseCode(String courseCode) throws SQLException {

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT courseCode "
														 + "FROM Course "
														 + "WHERE courseCode = ?");
		
		prepStmnt.setString(1, courseCode);
		ResultSet resSet = prepStmnt.executeQuery();

		if (resSet.next() ){
			String courseCodeCheck = resSet.getString(1);
			if (courseCodeCheck.equals(courseCode)) {
				return true;
			}	 
		}
		return false;
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------- GET COURSE! ----------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getCourseByCode(String courseCode, DefaultTableModel CourseTable) throws SQLException { 

		con = connectionTest();

		PreparedStatement prepStmnt = con.prepareStatement("SELECT * "
														 + "FROM Course "
														 + "WHERE courseCode = ?");
		prepStmnt.setString(1, courseCode);
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int columnNbr = metadata.getColumnCount();

		while (resSet.next()) {              
			int i = 1;
			while(i <= columnNbr) {
				
				String courseName = resSet.getString(i++);
				String courseNumber = resSet.getString(i++);
				int credits = resSet.getInt(i++);

				Object[] courseData = {courseName, courseNumber, credits};

				CourseTable.addRow(courseData);
			}
		}
		return CourseTable;
	}

	/* -------------------------------------------------------------------------------------------------- */

	public DefaultTableModel getCourseByName(String courseSearchName, DefaultTableModel CourseTable) throws SQLException {

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT * "
														 + "FROM Course "
														 + "WHERE courseName "
														 + "LIKE ?");
		
		prepStmnt.setString(1, courseSearchName +"%");
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int columnNbr = metadata.getColumnCount();

		while (resSet.next()) {              
			int i = 1;
			while(i <= columnNbr) {
				String courseName = resSet.getString(i++);
				String courseNumber = resSet.getString(i++);
				int credits = resSet.getInt(i++);

				Object[] courseData = {courseName, courseNumber, credits};

				CourseTable.addRow(courseData);
			}
		}

		return CourseTable;
	}

	/* -------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getAllCourses(DefaultTableModel CourseTable) throws SQLException {

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT * "
														 + "FROM Course "
														 + "ORDER BY courseName");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int columnNbr = metadata.getColumnCount();

		while (resSet.next()) {              
			int i = 1;
			while(i <= columnNbr) {
				String courseName = resSet.getString(i++);
				String courseNumber = resSet.getString(i++);
				int credits = resSet.getInt(i++);

				Object[] courseData = {courseName, courseNumber, credits};

				CourseTable.addRow(courseData);
			}
		}
		return CourseTable;
	}
	
	/* -------------------------------------------------------------------------------------------------- */

	public Integer getCourseCredits(String courseCode) throws SQLException {

		con = connectionTest();

		PreparedStatement prepStmnt = con.prepareStatement("SELECT courseCredits "
														 + "FROM Course "
														 + "WHERE courseCode = ?");
		
		prepStmnt.setString(1, courseCode);
		ResultSet resSet = prepStmnt.executeQuery();

		int totalStudentCredits = 0;

		int i = 1;
		while (resSet.next()) {
			totalStudentCredits = totalStudentCredits + resSet.getInt(i++);
		}
		return totalStudentCredits;
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* ----------------------------------------- REMOVE COURSE! ----------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */
	
	public void removeCourse(String courseCode) throws SQLException {

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("DELETE Course "
														 + "FROM Course "
														 + "WHERE courseCode = ?");
		
		prepStmnt.setString(1, courseCode);
		prepStmnt.executeUpdate();
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	/* ----------------------------------- OTHER COURSE METHODS COURSE! --------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getCourseActiveStudents(String courseCode, DefaultTableModel StudentTable) throws SQLException { // Gets students who aren't finishied! 

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT S.*, E.Email, T.TelNmbr "
														 + "FROM Student S "
														 + "INNER JOIN Email E "
														 + "ON S.socNmbr = E.SocNMbr "
														 + "INNER JOIN Telephone T "
														 + "ON E.SocNmbr = T.socNmbr "
														 + "WHERE S.socNmbr "
														 + "IN (SELECT socNmbr FROM Studies WHERE courseCode = ?) "
														 + "OR S.socNmbr "
														 + "IN (SELECT socNmbr FROM Studied WHERE courseCode = ? AND grade = ?)");
		
		prepStmnt.setString(1, courseCode);
		prepStmnt.setString(2, courseCode);
		prepStmnt.setString(3, "U");
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int columnNbr = metadata.getColumnCount();

		while (resSet.next()) {              
			int i = 1;
			while(i <= columnNbr) {

				String firstName = resSet.getString(i++);
				String lastName = resSet.getString(i++);
				String socNmbr = resSet.getString(i++);
				String address = resSet.getString(i++);
				String city = resSet.getString(i++);
				String zipCode = resSet.getString(i++);
				String telNmbr = resSet.getString(i++);
				String eMail = resSet.getString(i++);


				Object[] studentData = {firstName, lastName, socNmbr, address, city, zipCode, telNmbr, eMail};

				StudentTable.addRow(studentData);
			}
		}
		return StudentTable;
	}

	/* -------------------------------------------------------------------------------------------------- */

	public DefaultTableModel getCoursePastStudents(String courseCode, DefaultTableModel StudentTable) throws SQLException { // Finds students who took the course and their grade!

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT S.*, T.TelNmbr, E.Email "
														 + "FROM Student S "
														 + "INNER JOIN Studied U "
														 + "ON S.socNmbr = U.socNmbr "
														 + "INNER JOIN Telephone T "
														 + "ON U.SocNmbr = T.SocNmbr "
														 + "INNER JOIN Email E "
														 + "ON T.SocNmbr = E.SocNmbr "
														 + "WHERE U.courseCode = ?");
		
		prepStmnt.setString(1, courseCode);
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int columnNbr = metadata.getColumnCount();

		while (resSet.next()) {              
			int i = 1;
			while(i <= columnNbr) {

				String firstName = resSet.getString(i++);
				String lastName = resSet.getString(i++);
				String socNmbr = resSet.getString(i++);
				String address = resSet.getString(i++);
				String city = resSet.getString(i++);
				String zipCode = resSet.getString(i++);
				String telNmbr = resSet.getString(i++);
				String eMail = resSet.getString(i++);

				Object[] studentData = {firstName, lastName, socNmbr, address, city, zipCode, telNmbr, eMail };

				StudentTable.addRow(studentData);	
			}
		}
		return StudentTable;
	}

	/* -------------------------------------------------------------------------------------------------- */

	public Integer getHighGradePercentage(String courseCode) throws SQLException { 

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT 100 * "
														 + "(SELECT COUNT(*) FROM Studied WHERE courseCode = ? AND Grade = 'A') "
														 + "/ (SELECT COUNT (*) FROM Studied WHERE courseCode = ?) "
														 + "AS Percentage");
		
		prepStmnt.setString(1, courseCode);
		prepStmnt.setString(2, courseCode);
		ResultSet resSet = prepStmnt.executeQuery();

		int gradePercentage = 0;

		int i = 1;
		while (resSet.next()) {
			gradePercentage = resSet.getInt(i++);
		}
		return gradePercentage;
	}

	/* -------------------------------------------------------------------------------------------------- */
	
	public Integer getCourseThroughput(String courseCode) throws SQLException { // Ranks all courses by highest throughput (students who has taken a course with at least grade 'E'!

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT 100 * "
														 + "(SELECT COUNT(*) FROM Studied WHERE courseCode = ? AND Grade != ?) "
														 + "/ (SELECT COUNT (*) FROM Studied WHERE courseCode = ?) "
														 + "AS Percentage");
		prepStmnt.setString(1, courseCode);
		prepStmnt.setString(2, "U");
		prepStmnt.setString(3, courseCode);
		ResultSet resSet = prepStmnt.executeQuery();

		int courseThroughput = 0;

		int i = 1;
		while (resSet.next()) {
			courseThroughput = resSet.getInt(i++);
		}
		return courseThroughput;
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* ------------------------------------ REGISTER STUDENT ON COURSE! --------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */

	public Integer getTotalStudentCredits(String socNmbr) throws SQLException {

		con = connectionTest();

		PreparedStatement prepStmnt = con.prepareStatement("SELECT SUM(C.courseCredits) "
														 + "FROM Course C "
														 + "INNER JOIN Studies S "
														 + "ON C.courseCode = S.courseCode "
														 + "WHERE socNmbr = ?");
		
		prepStmnt.setString(1, socNmbr);
		ResultSet resSet = prepStmnt.executeQuery();

		int totalStudentCredits = 0;

		int i = 1;	
		while (resSet.next()) {
			totalStudentCredits = totalStudentCredits + resSet.getInt(i++);
		}
		return totalStudentCredits;
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* ------------------------------------ REGISTER STUDENT ON COURSE! --------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */

	public void registerStudentOnCourse(String socNmbr, String courseCode) throws SQLException { // Adds a student to a course!

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("INSERT INTO Studies "
														 + "VALUES(?,?)");
		
		prepStmnt.setString(1, socNmbr);  
		prepStmnt.setString(2, courseCode);
		prepStmnt.executeUpdate();
	}

	/* -------------------------------------------------------------------------------------------------- */
	
	public boolean registerStudentOnCourseCheckIfTaking (String socNmbr, String courseCode) throws SQLException {

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT socNmbr "
														 + "FROM Studies "
														 + "WHERE socNmbr = ? "
														 + "AND courseCode = ?");
		
		prepStmnt.setString(1, socNmbr);
		prepStmnt.setString(2, courseCode);
		ResultSet resSet = prepStmnt.executeQuery();

		if (resSet.next()){
			String socNmbrCheck = resSet.getString(1);

			if(socNmbrCheck.equals(socNmbr)){
				return true;
			}
		}
		return false;
	}

	/* -------------------------------------------------------------------------------------------------- */
	
	public boolean registerStudentOnCourseCheckIfTaken (String socNmbr, String courseCode) throws SQLException {

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT socNmbr "
														 + "FROM Studied "
														 + "WHERE socNmbr = ? "
														 + "AND courseCode = ?");
		
		prepStmnt.setString(1, socNmbr);
		prepStmnt.setString(2, courseCode);
		ResultSet resSet = prepStmnt.executeQuery();

		if (resSet.next()){
			String socNmbrCheck = resSet.getString(1);
			if(socNmbrCheck.equals(socNmbr)){
				return true;
			}
		}
		return false;
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* ------------------------------------- GRADE STUDENT ON COURSE! ----------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */

	public void gradeStudentOnCourse (String socNmbr, String courseCode, String grade) throws SQLException {
		
		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("INSERT INTO Studied "
														 + "VALUES(?,?,?)");
		
		prepStmnt.setString(1, socNmbr);  
		prepStmnt.setString(2, courseCode);
		prepStmnt.setString(3, grade);
		prepStmnt.executeUpdate();

		con = connectionTest();
		PreparedStatement prepStmnt2 = con.prepareStatement("DELETE FROM Studies "
														  + "WHERE SocNmbr = ? "
														  + "AND CourseCode = ?");
		
		prepStmnt2.setString(1,socNmbr);
		prepStmnt2.setString(2, courseCode);
		prepStmnt2.executeUpdate();
	}

	/* -------------------------------------------------------------------------------------------------- */
	
	
	public boolean gradeStudentOnCourseCheckIfTaking (String socNmbr, String courseCode) throws SQLException {

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT socNmbr "
														 + "FROM Studies "
														 + "WHERE socNmbr = ? "
														 + "AND courseCode = ?");
		prepStmnt.setString(1, socNmbr);
		prepStmnt.setString(2, courseCode);
		ResultSet resSet = prepStmnt.executeQuery();

		if (resSet.next()){
			String socNmbrCheck = resSet.getString(1);

			if(socNmbrCheck.equals(socNmbr)){
				return true;
			}
		}
		return false;
	}
	
	/* -------------------------------------------------------------------------------------------------- */

	public boolean gradeStudentOnCourseCheckIfGradeIsU (String socNmbr, String courseCode, String grade) throws SQLException {
		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT socNmbr, grade "
														 + "FROM Studied "
														 + "WHERE socNmbr = ? "
														 + "AND courseCode = ?");
		prepStmnt.setString(1, socNmbr);
		prepStmnt.setString(2, courseCode);
		ResultSet resSet = prepStmnt.executeQuery();

		if(resSet.next()){
			String gradeCheck = resSet.getString(2);
			if (gradeCheck.equals("U")){
				return true;
			}
		}
		return false;
	}

	/* -------------------------------------------------------------------------------------------------- */
	
	public void reGradeStudentOnCourse (String socNmbr, String courseCode, String grade) throws SQLException {
		con = connectionTest();
		PreparedStatement prepStmnt3 = con.prepareStatement("UPDATE Studied "
														  + "SET grade = ? "
														  + "WHERE socNmbr = ? "
														  + "AND courseCode = ?");
		
		prepStmnt3.setString(1, grade);  
		prepStmnt3.setString(2, socNmbr);
		prepStmnt3.setString(3, courseCode);
		prepStmnt3.executeUpdate();	
	}

	/* -------------------------------------------------------------------------------------------------- */
	/* --------------------------------- DRIVER CHECK AND CONNECTION TEST! ------------------------------ */
	/* -------------------------------------------------------------------------------------------------- */

	public void driverCheck() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		}

		catch (ClassNotFoundException cnfe) {
			System.out.println("Driver is not functioning properly! \n\n" +
							   "Error message:" + cnfe.getMessage());
		}
	}

	/* -------------------------------------------------------------------------------------------------- */
	
	public Connection connectionTest() {

		try { 
			con = DriverManager.getConnection("jdbc:sqlserver://NIMA\\MSSQLSERVER;" + 
											  "database = SQOOL_db;" + 
											  "user = Gruppen2;" + 
											  "password = Lund1234"); 
		}

		catch (Exception e) {
			System.out.println("Error establishing connection! Please try again later...");
			e.printStackTrace();
			System.out.println(e.getMessage()); 
		}
		return con;
	}
	
	/* -------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------------------------------------------------------------- */

}
