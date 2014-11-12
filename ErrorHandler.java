package controller;

import java.sql.SQLException;

public class ErrorHandler {

	String errorMessage;
	
	public ErrorHandler() {
		errorMessage = "";
	}
	
	
	public String getErrorMessage(Exception e, String errorVariable) {
			
			if((e instanceof SQLException) && e.getMessage().startsWith("String or binary data would be truncated")) {
				return errorMessage = "Zip code can only be 5 characters! \n"
									+ "Soc. nmbr can only be 11 characters!"; 
			}
			
			if((e instanceof SQLException) && e.getMessage().startsWith("Divide by zero")) {
				return errorMessage = "Data not available! \n"
									+ "No one has taken this course!"; 
			}
			
			if(e instanceof IndexOutOfBoundsException && errorVariable.equals("register")) {
				return errorMessage = "You need to select a student and a course in order to register it!";
			}
			
			if(e instanceof IndexOutOfBoundsException && errorVariable.equals("deleteStudent")) {
				return errorMessage = "You need to select a student in order to delete it!";
			}
			
			if(e instanceof IndexOutOfBoundsException && errorVariable.equals("deleteCourse")) {
				return errorMessage = "You need to select a course in order to delete it!";
			}
			
			if(e instanceof IndexOutOfBoundsException && errorVariable.equals("gradeStudent")) {
				return errorMessage = "You need to select a student and a course in order to grade it!";
			}
			
			if(e instanceof IndexOutOfBoundsException && errorVariable.equals("studentHistory")) {
				return errorMessage = "You need to select a student in order to show its course history!";
			}
			
			if(e instanceof IndexOutOfBoundsException && errorVariable.equals("currentCourses")) {
				return errorMessage = "You need to select a student in order to show its current courses!";
			}
			
			if(e instanceof IndexOutOfBoundsException && errorVariable.equals("currentStudents")) {
				return errorMessage = "You need to select a course in order to show its current students!";
			}
		
			if(e instanceof IndexOutOfBoundsException && errorVariable.equals("courseHistory")) {
				return errorMessage = "You need to select a course in order to show its student history!";
			}
			
			if(e instanceof SQLException && errorVariable.equals("addCourse") && e.getMessage().startsWith("Violation of PRIMARY KEY constraint")) {
				return errorMessage = "There is already a course with this course code!";
			}
			
			if(e instanceof NumberFormatException && errorVariable.equals("checkCourse")) {
				return errorMessage = "Credits must be assigned numbers!";
			}
					
		return errorMessage;
	}
}
