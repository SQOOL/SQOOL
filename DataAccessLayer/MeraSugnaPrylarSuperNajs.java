/* --------------------------------------------------------------------------------------------------------------- */
	/* -------------------------------------- ADD STUDENT TO COURSE CHECK RECORDS! ----------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */
	public void registerStudentOnCourseCheckRecords(String socNmbr, String courseCode) throws SQLException { //Checks student course records!
	
		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("SELECT socNmbr FROM Studied WHERE courseCode = ?");
		prepStmnt.setString(1, courseCode);
		ResultSet resSet = prepStmnt.executeQuery();
		resSet.next();
		String socNmbrCheck = resSet.getString(1);
	
		
		if ( !socNmbrCheck.equals(socNmbr)){
			con = connectionTest();
			PreparedStatement prepStmnt2 = con.prepareStatement("INSERT INTO Studies VALUES(?,?)");
			prepStmnt2.setString(1, socNmbr);  
			prepStmnt2.setString(2, courseCode);
			prepStmnt2.executeUpdate();
			
			System.out.println("Student added to course!");
			
			
			}
		
		else{
			System.out.println("Student has already taken this course.");
		}
			
		}
		
			/* --------------------------------------------------------------------------------------------------------------- */
	/* ------------------------------------------------ REMOVE COURSE! ----------------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */

	public void removeCourse(String courseCode) throws SQLException { // Removes a specific course!

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("DELETE Course from Course WHERE courseCode = ?");
		prepStmnt.setString(1, courseCode);
		prepStmnt.executeUpdate();

		System.out.println("Course removed!");
	}

	/* --------------------------------------------------------------------------------------------------------------- */
	/* ------------------------------------------GRADE STUDENT ON COURSE! -------------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */

	public void gradeStudentOnCourse(String socNmbr, String courseCode, String grade) throws SQLException { // Adds a student to a course!
		
		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("INSERT INTO Studied VALUES(?,?,?)");
		prepStmnt.setString(1, socNmbr);  
		prepStmnt.setString(2, courseCode);
		prepStmnt.setString(3, grade);
		prepStmnt.executeUpdate();
		
		con = connectionTest();
		PreparedStatement prepStmnt2 = con.prepareStatement("DELETE FROM Studies WHERE SocNmbr = ? AND CourseCode = ?");
		prepStmnt2.setString(1,socNmbr);
		prepStmnt2.setString(2, courseCode);
		prepStmnt2.executeUpdate();
		
		System.out.println("Student graded on course!");
	}
	
		/* --------------------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------------- REMOVE STUDENT! ------------------------------------------------ */
	/* --------------------------------------------------------------------------------------------------------------- */

	public void removeStudent(String socNmbr) throws SQLException { // Removes a specific student!

		con = connectionTest();
		PreparedStatement prepStmnt = con.prepareStatement("DELETE Student from Student WHERE socNmbr = ?");
		prepStmnt.setString(1, socNmbr);
		prepStmnt.executeUpdate();
		
		System.out.println("Student removed!");
	}
