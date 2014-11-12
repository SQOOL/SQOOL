
package view;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.Controller;
import controller.ErrorHandler;

@SuppressWarnings("serial")
public class MainGUI extends javax.swing.JFrame {

	private Controller controller;
	private ErrorHandler errorHandler;
	private DefaultTableModel StudentModel; // Defines the JTable student model...
	private DefaultTableModel CourseModel; // Defines the JTable course model...
	private boolean isStudentRowSelected; // Used as a logical selector for keeping track of selected table rows...
	private boolean isCourseRowSelected; //  - !! -
	private String errorVariable; // Used for keeping track of error cause!

	public MainGUI() throws SQLException {
		
		initializeComponents();

		controller = new Controller();
		errorHandler = new ErrorHandler();

		isStudentRowSelected = false; // Set the logical selector as "not selected"!
		isCourseRowSelected = false; //  - !! -
		
		errorVariable = null;
		
	}

	private void initializeComponents() {

		/*----------------------------------------------------------------------------------------------------------*/
		/*--------------------------------------------- DECLARE OBJECTS! -------------------------------------------*/
		/*----------------------------------------------------------------------------------------------------------*/

		AddDialog = new javax.swing.JDialog();
		AddTabbedPane = new javax.swing.JTabbedPane();
		StudentsPanel = new javax.swing.JPanel();
		AddFirstNameTextField = new javax.swing.JFormattedTextField();
		AddLastNameTextField = new javax.swing.JFormattedTextField();
		AddSocNmbrTextField = new javax.swing.JFormattedTextField();
		AddAddressTextField = new javax.swing.JFormattedTextField();
		AddCityTextField = new javax.swing.JFormattedTextField();
		AddZipTextField = new javax.swing.JFormattedTextField();
		AddPhoneNmbrTextField = new javax.swing.JFormattedTextField();
		AddEmailTextField = new javax.swing.JFormattedTextField();
		AddStudentButton = new javax.swing.JButton();
		ClearStudentButton = new javax.swing.JButton();
		CloseWindow1Button = new javax.swing.JButton();
		CoursesPanel = new javax.swing.JPanel();
		AddCourseCodeTextField = new javax.swing.JFormattedTextField();
		AddCourseNameTextField = new javax.swing.JFormattedTextField();
		AddCourseCreditsTextField = new javax.swing.JFormattedTextField();
		AddCourseButton = new javax.swing.JButton();
		ClearCourseFieldsButton = new javax.swing.JButton();
		CloseWindow2Button = new javax.swing.JButton();
		FirstNameTextField = new javax.swing.JFormattedTextField();
		LastNameTextField = new javax.swing.JFormattedTextField();
		SocNmbrTextField = new javax.swing.JFormattedTextField();
		CourseNameTextField = new javax.swing.JFormattedTextField();
		CourseCodeTextField = new javax.swing.JFormattedTextField();
		StudentLabel = new javax.swing.JLabel();
		CoursesLabel = new javax.swing.JLabel();
		StudentTableScrollPane = new javax.swing.JScrollPane();	
		CourseTableScrollPane = new javax.swing.JScrollPane();
		CourseTable = new javax.swing.JTable();
		StudentTable = new javax.swing.JTable();
		StudentModel = new javax.swing.table.DefaultTableModel();
		CourseModel = new javax.swing.table.DefaultTableModel();
		InfoBoxPane = new javax.swing.JScrollPane();
		SearchStudentButton = new javax.swing.JButton();
		AddButton = new javax.swing.JButton();
		RegisterButton = new javax.swing.JButton();
		SeachByStudentLabel = new javax.swing.JLabel();
		SearchByCourseLabel = new javax.swing.JLabel();
		HelpButton = new javax.swing.JButton();
		SearchCourseButton = new javax.swing.JButton();
		DeleteStudentButton = new javax.swing.JButton();
		DeleteCourseButton = new javax.swing.JButton();
		GradeStudentButton = new javax.swing.JButton();
		StudentHistoryButton = new javax.swing.JButton();
		CurrentCoursesButton = new javax.swing.JButton();
		CourseHistoryButton = new javax.swing.JButton();
		CurrentStudentsButton = new javax.swing.JButton();

		this.setTitle("SQOOL Student & Course Management System");
		
		/*----------------------------------------------------------------------------------------------------------*/
		/*-------------------------------------------------- BUTTONS! ----------------------------------------------*/
		/*----------------------------------------------------------------------------------------------------------*/

		SearchStudentButton.setText("Search for student(s)");
		SearchStudentButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				try {
					SearchStudentButtonActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		HelpButton.setText("Help!");
		HelpButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				HelpButtonActionPerformed(evt);
			}
		});

		RegisterButton.setText("Register student on course");
		RegisterButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				errorVariable = "register";
				try {
					RegisterButtonActionPerformed(evt); 
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, errorHandler.getErrorMessage(e, errorVariable), 
														"Something went wrong!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		SearchCourseButton.setText("Search for course(s)");
		SearchCourseButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				try {
					SearchCourseButtonActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		DeleteStudentButton.setText("Delete student");
		DeleteStudentButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				errorVariable = "deleteStudent";
				try {
					DeleteStudentButtonActionPerformed(evt); 
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, errorHandler.getErrorMessage(e, errorVariable), 
														"Something went wrong!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		DeleteCourseButton.setText("Delete course");
		DeleteCourseButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				errorVariable = "deleteCourse";
				try {
					DeleteCourseButtonActionPerformed(evt); // .. perform action! ...
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, errorHandler.getErrorMessage(e, errorVariable), 
														"Something went wrong!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		GradeStudentButton.setText("Grade student");
		GradeStudentButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				errorVariable = "gradeStudent";
				try {
					GradeStudentButtonActionPerformed(evt); 
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, errorHandler.getErrorMessage(e, errorVariable), 
														"Something went wrong!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		StudentHistoryButton.setText("Student history");
		StudentHistoryButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				errorVariable = "studentHistory";
				try {
					StudentHistoryButtonActionPerformed(evt); 
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, errorHandler.getErrorMessage(e, errorVariable), 
														"Something went wrong!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		CurrentCoursesButton.setText("Current courses");
		CurrentCoursesButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				errorVariable = "currentCourses";
				try {
					CurrentCoursesButtonActionPerformed(evt); 
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, errorHandler.getErrorMessage(e, errorVariable), 
														"Something went wrong!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		CourseHistoryButton.setText("Course history");
		CourseHistoryButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				errorVariable = "courseHistory";
				try {
					CourseHistoryButtonActionPerformed(evt); 
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, errorHandler.getErrorMessage(e, errorVariable), 
														"Something went wrong!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		CurrentStudentsButton.setText("Current students");
		CurrentStudentsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				errorVariable = "currentStudents";
				try {
					CurrentStudentsButtonActionPerformed(evt);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, errorHandler.getErrorMessage(e, errorVariable), 
														"Something went wrong!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		AddButton.setText("Add student or course");
		AddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AddButtonActionPerformed(evt);
			}
		});

		AddStudentButton.setText("Add student");
		AddStudentButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				try {
					AddStudentButtonActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		ClearStudentButton.setText("Clear fields");
		ClearStudentButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ClearStudentButtonActionPerformed(evt);
			}
		});

		CloseWindow1Button.setText("Close");
		CloseWindow1Button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CloseWindow1ButtonActionPerformed(evt);
			}
		});

		AddCourseButton.setText("Add course");
		AddCourseButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				try {
					AddCourseButtonActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		ClearCourseFieldsButton.setText("Clear fields");
		ClearCourseFieldsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ClearCourseFieldsButtonActionPerformed(evt);
			}
		});

		CloseWindow2Button.setText("Close");
		CloseWindow2Button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CloseWindow2ButtonActionPerformed(evt);
			}
		});

		/*----------------------------------------------------------------------------------------------------------*/
		/*-----------------------------------------------  TEXT FIELDS!  -------------------------------------------*/
		/*----------------------------------------------------------------------------------------------------------*/

		FirstNameTextField.setText("First name");
		FirstNameTextField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
		FirstNameTextField.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				FNameTextFieldMouseClicked(evt);
			}
		});

		LastNameTextField.setText("Last name");
		LastNameTextField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
		LastNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				LNameTextFieldFocusGained(evt);
			}
		});
		SocNmbrTextField.setText("Soc. number");
		SocNmbrTextField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
		SocNmbrTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt){
				SocNmbrTextFieldFocusGained(evt);
			}
		});

		CourseNameTextField.setText("Course name");
		CourseNameTextField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
		CourseNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt){
				CourseNameTextFieldFocusGained(evt);
			}
		});

		CourseCodeTextField.setText("Course code");
		CourseCodeTextField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
		CourseCodeTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt){
				CourseCodeTextFieldFocusGained(evt);
			}
		});

		AddFirstNameTextField.setText("First name");
		AddFirstNameTextField.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				AddFirstNameTextFieldMouseClicked(evt);
			}
		});

		AddLastNameTextField.setText("Last name");
		AddLastNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				AddLastNameTextFieldFocusGained(evt);
			}
		});

		AddSocNmbrTextField.setText("Social security number");
		AddSocNmbrTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				AddSocNmbrTextFieldFocusGained(evt);
			}
		});

		AddAddressTextField.setText("Address");
		AddAddressTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				AddAddressTextFieldFocusGained(evt);
			}
		});

		AddCityTextField.setText("City");
		AddCityTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				AddCityTextFieldFocusGained(evt);
			}
		});

		AddZipTextField.setText("Zip code");
		AddZipTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				AddZipTextFieldFocusGained(evt);
			}
		});

		AddPhoneNmbrTextField.setText("Telepphone number");
		AddPhoneNmbrTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				AddPhoneNmbrTextFieldFocusGained(evt);
			}
		});

		AddEmailTextField.setText("E-mail");
		AddEmailTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				AddEmailTextFieldFocusGained(evt);
			}
		});

		AddCourseCodeTextField.setText("Course code");
		AddCourseCodeTextField.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				AddCourseCodeTextFieldMouseClicked(evt);
			}
		});

		AddCourseNameTextField.setText("Course name");
		AddCourseNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				AddCourseNameTextFieldFocusGained(evt);
			}
		});

		AddCourseCreditsTextField.setText("Course credits");
		AddCourseCreditsTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				AddCourseCreditsTextFieldFocusGained(evt);
			}
		});

		/*----------------------------------------------------------------------------------------------------------*/
		/*------------------------------------------------ PANES! --------------------------------------------------*/
		/*----------------------------------------------------------------------------------------------------------*/

		AddTabbedPane.addTab("Student", StudentsPanel);
		AddTabbedPane.addTab("Course", CoursesPanel);

		/*----------------------------------------------------------------------------------------------------------*/
		/*------------------------------------------------ LABELS! -------------------------------------------------*/
		/*----------------------------------------------------------------------------------------------------------*/

		StudentLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		StudentLabel.setText("STUDENTS");
		CoursesLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		CoursesLabel.setText("COURSES");
		SeachByStudentLabel.setText("Search by:");
		SearchByCourseLabel.setText("Search by:");

		/*----------------------------------------------------------------------------------------------------------*/
		/*----------------------------------------------- INFO BOX! ------------------------------------------------*/
		/*----------------------------------------------------------------------------------------------------------*/

		InfoBox = new JTextArea("Welcome to SQOOL! \n\n"
							  + "If you need instructions on \n"
							  + "how to use this program, \n"
							  + "press the help button!");
		
		InfoBoxPane.setViewportView(InfoBox);

		/*----------------------------------------------------------------------------------------------------------*/
		/*--------------------------------------------- STUDENT TABLE! ---------------------------------------------*/
		/*----------------------------------------------------------------------------------------------------------*/

		StudentTable.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
		StudentTable.setModel(StudentModel = new DefaultTableModel(new Object [][] {},
				
		new String [] {"First name:", "Last name:", "Soc. number:", "Address:", "City:", "Zip code:", "Tel number:", "E-mail:"}) { 
			
			@SuppressWarnings("rawtypes")
			Class[] types = new Class [] { java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, 
										   java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class };
			
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int columnIndex) {
			return types [columnIndex];
		}});
		
		StudentTable.getTableHeader().setReorderingAllowed(false);
		StudentTableScrollPane.setViewportView(StudentTable);
		StudentTable.getColumnModel().getColumn(0).setHeaderValue("First name:");
		StudentTable.getColumnModel().getColumn(1).setHeaderValue("Last name:");
		StudentTable.getColumnModel().getColumn(2).setHeaderValue("Soc. number:");
		StudentTable.getColumnModel().getColumn(3).setHeaderValue("Address:");
		StudentTable.getColumnModel().getColumn(4).setHeaderValue("City:");
		StudentTable.getColumnModel().getColumn(5).setHeaderValue("Zip code:");
		StudentTable.getColumnModel().getColumn(6).setHeaderValue("Telephone number:");
		StudentTable.getColumnModel().getColumn(7).setHeaderValue("E-mail:");
		
		StudentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				errorVariable = null;
				isStudentRowSelected = true;
				if(StudentTable.getSelectedRow() > -1 && CourseTable.getSelectedRow() > -1) {	
					try {
						StudentRowSelected(evt);
					} catch (SQLException e) {
						InfoBox.setText(errorHandler.getErrorMessage(e, errorVariable));
					}
				}
			}
		});

		/*----------------------------------------------------------------------------------------------------------*/
		/*---------------------------------------------- COURSE TABLE! ---------------------------------------------*/
		/*----------------------------------------------------------------------------------------------------------*/

		CourseTable.setFont(new java.awt.Font("Dialog", 0, 10));
		CourseTable.setModel(CourseModel = new DefaultTableModel(
				new Object [][] {}, 
							 	
		new String [] {"Name:", "Code:", "Credits:"}) {

		@SuppressWarnings("rawtypes")
		Class[] types = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.Integer.class};

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int columnIndex) {return types [columnIndex];}});

		CourseTableScrollPane.setViewportView(CourseTable);
		CourseTable.getColumnModel().getColumn(0).setHeaderValue("Name:");
		CourseTable.getColumnModel().getColumn(1).setHeaderValue("Code:");
		CourseTable.getColumnModel().getColumn(2).setHeaderValue("Credits:");
		
		InfoBox.setEditable(false);
		InfoBox.setColumns(20);
		InfoBox.setRows(5);

		CourseTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				errorVariable = null;
				isCourseRowSelected = true; // Course table
				if(CourseTable.getSelectedRow() > -1) {				
					try {
						CourseRowSelected(evt);
					} catch (SQLException e) {
						InfoBox.setText(errorHandler.getErrorMessage(e, errorVariable));
					}
				}
			}
		});

		/*----------------------------------------------------------------------------------------------------------*/
		/*------------------------------------------------- LAYOUTS! -----------------------------------------------*/
		/*----------------------------------------------------------------------------------------------------------*/

		// Student panel horizontal layout!
		
		javax.swing.GroupLayout StudentsPanelLayout = new javax.swing.GroupLayout(StudentsPanel);
		StudentsPanel.setLayout(StudentsPanelLayout);
		StudentsPanelLayout.setHorizontalGroup(StudentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(StudentsPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(StudentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(AddFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(AddLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(AddSocNmbrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(AddAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addGroup(StudentsPanelLayout.createSequentialGroup()
			.addGroup(StudentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(AddCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(AddZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(AddPhoneNmbrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(AddEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addGap(30, 30, 30)
			.addGroup(StudentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(CloseWindow1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(ClearStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(AddStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
			.addContainerGap(179, Short.MAX_VALUE)));

		// Student panel vertical layout!
		
		StudentsPanelLayout.setVerticalGroup(StudentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(StudentsPanelLayout.createSequentialGroup()
			.addGap(29, 29, 29)
			.addComponent(AddFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(AddLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(AddSocNmbrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(AddAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(AddCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(StudentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			.addComponent(AddZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(AddStudentButton))
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(StudentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			.addComponent(AddPhoneNmbrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(ClearStudentButton))
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(StudentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			.addComponent(AddEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(CloseWindow1Button))
			.addContainerGap(24, Short.MAX_VALUE)));

		// Course panel horizontal layout!
		
		javax.swing.GroupLayout CoursesPanelLayout = new javax.swing.GroupLayout(CoursesPanel);
		CoursesPanel.setLayout(CoursesPanelLayout);
		CoursesPanelLayout.setHorizontalGroup(CoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(CoursesPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(CoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(AddCourseCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(AddCourseNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(AddCourseCreditsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CoursesPanelLayout.createSequentialGroup()
			.addContainerGap(202, Short.MAX_VALUE)
			.addGroup(CoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(ClearCourseFieldsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(AddCourseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(CloseWindow2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addGap(179, 179, 179)));

		// Course panel vertical layout!
		
		CoursesPanelLayout.setVerticalGroup(CoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(CoursesPanelLayout.createSequentialGroup()
			.addGap(29, 29, 29)
			.addComponent(AddCourseCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(AddCourseNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(AddCourseCreditsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
			.addComponent(AddCourseButton)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(ClearCourseFieldsButton)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(CloseWindow2Button)
			.addGap(25, 25, 25)));

		// Dialog group layout!
		
		javax.swing.GroupLayout AddDialogLayout = new javax.swing.GroupLayout(AddDialog.getContentPane());
		AddDialog.getContentPane().setLayout(AddDialogLayout);
		AddDialogLayout.setHorizontalGroup(
		AddDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(AddTabbedPane));

		// Dialog vertical layout!
		
		AddDialogLayout.setVerticalGroup(AddDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(AddTabbedPane));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		// Main frame horizontal layout!
		
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
			.addGap(4, 4, 4)
			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
			.addGroup(layout.createSequentialGroup()
			.addGap(187, 187, 187)
			.addComponent(StudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
			.addComponent(FirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addGap(36, 36, 36)
			.addComponent(LastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addComponent(SeachByStudentLabel))
			.addGap(31, 31, 31)
			.addComponent(SocNmbrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(SearchStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addGroup(layout.createSequentialGroup()
			.addComponent(DeleteStudentButton)
			.addGap(18, 18, 18)
			.addComponent(StudentHistoryButton)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(CurrentCoursesButton))
			.addComponent(StudentTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
			.addComponent(DeleteCourseButton)
			.addGap(11, 11, 11)
			.addComponent(CourseHistoryButton)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(CurrentStudentsButton))
			.addComponent(SearchByCourseLabel)
			.addGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
			.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
			.addComponent(CourseNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
			.addComponent(CoursesLabel)
			.addGroup(layout.createSequentialGroup()
			.addComponent(CourseCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addGap(25, 25, 25)
			.addComponent(SearchCourseButton))))
			.addComponent(CourseTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addGap(18, 18, 18)
			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
			.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
			.addComponent(HelpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(AddButton, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
			.addComponent(InfoBoxPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
			.addComponent(GradeStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(RegisterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
			.addContainerGap(62, Short.MAX_VALUE)));
		
		// Main frame panel vertical layout!
		
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
			.addGap(18, 18, 18)
			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			.addComponent(CoursesLabel)
			.addComponent(StudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addGap(18, 18, 18)
			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			.addComponent(SeachByStudentLabel)
			.addComponent(SearchByCourseLabel))
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			.addComponent(FirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(SocNmbrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(LastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(CourseNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(SearchStudentButton)
			.addComponent(SearchCourseButton)
			.addComponent(CourseCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addGap(25, 25, 25)
			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
			.addComponent(HelpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(InfoBoxPane, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addGap(13, 13, 13)
			.addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(GradeStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addComponent(CourseTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(StudentTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addGap(18, 18, 18)
			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			.addComponent(DeleteStudentButton)
			.addComponent(DeleteCourseButton)
			.addComponent(StudentHistoryButton)
			.addComponent(CurrentCoursesButton)
			.addComponent(CurrentStudentsButton)
			.addComponent(CourseHistoryButton))
			.addContainerGap(84, Short.MAX_VALUE)));
	
			pack();
	}

	/*----------------------------------------------------------------------------------------------------------*/
	/*----------------------------------------------- METHODS! -------------------------------------------------*/
	/*----------------------------------------------------------------------------------------------------------*/

	private void FNameTextFieldMouseClicked(java.awt.event.MouseEvent evt) {
		FirstNameTextField.setText("");
	}

	private void LNameTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		LastNameTextField.setText("");
	}

	private void SocNmbrTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		SocNmbrTextField.setText("");
	}

	private void CourseNameTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		CourseNameTextField.setText("");
	}

	private void CourseCodeTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		CourseCodeTextField.setText("");
	}

	private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {
		AddDialog.setVisible(true);
		AddDialog.setSize(350,370);
	}

	private void SearchStudentButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {

		StudentModel.setRowCount(0);
		InfoBox.setText("Student(s) retrieved!");
		isStudentRowSelected = false; // Clear student logical selection!

		if( 	   (SocNmbrTextField.getText().equals("") || SocNmbrTextField.getText().equals("Soc. number"))
				& (LastNameTextField.getText().equals("") || LastNameTextField.getText().equals("Last name"))
			   & (FirstNameTextField.getText().equals("") || FirstNameTextField.getText().equals("First name"))) {
			
			StudentTable.setModel(controller.getAllStudents(StudentModel));
		}

		else if(   	  (SocNmbrTextField.getText().equals("") || SocNmbrTextField.getText().equals("Soc. number"))
				  & (FirstNameTextField.getText().equals("") || FirstNameTextField.getText().equals("First name"))) {	
			
			String searchLastName = LastNameTextField.getText();
			StudentTable.setModel(controller.getStudentByLastName(searchLastName, StudentModel));
		}

		else if( (FirstNameTextField.getText().equals("") || FirstNameTextField.getText().equals("First name"))
				& (LastNameTextField.getText().equals("") || LastNameTextField.getText().equals("Last name"))) {
			
			String searchSocNmbr = SocNmbrTextField.getText();
			StudentTable.setModel(controller.getStudentBySocNmbr(searchSocNmbr, StudentModel));
		}

		else {
			String searchFirstName = FirstNameTextField.getText();
			StudentTable.setModel(controller.getStudentByFirstName(searchFirstName, StudentModel));

		}
	}		

	private void SearchCourseButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {

		CourseModel.setRowCount(0);
		InfoBox.setText("Course(s) retrieved!");
		isCourseRowSelected = false; // Clear course logical selection!

		if (	   (CourseCodeTextField.getText().equals("") || CourseCodeTextField.getText().equals("Course code"))
				&& (CourseNameTextField.getText().equals("") || CourseNameTextField.getText().equals("Course name"))) {
			
			CourseTable.setModel(controller.getAllCourses(CourseModel)); 
		}
		
		else if( CourseCodeTextField.getText().equals("") || CourseCodeTextField.getText().equals("Course Code")) {
			
			String courseSearchName = CourseNameTextField.getText();
			CourseTable.setModel(controller.getCourseByName(courseSearchName, CourseModel));
		}

		else {
			String courseCode = CourseCodeTextField.getText();
			CourseTable.setModel(controller.getCourseByCode(courseCode, CourseModel)); 
		}
	}

	private void HelpButtonActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null, "Welcome to SQOOL!\n\n Here are a few tips on how to use this software: \n\n" +
											"The tables for student and courses functions as a source for data aswell \n" +
											"as for interacting with objects. Search for a student, click on it, search for a course,\n" +
											"click on it and then finally select an action such as registering, grading or searching \n" +
											"for the selected objects history or current interactors. \n\n" +
											"Got any more questions? Please contact support@sqool.com. \n\n\n\n\n\n\n\n" +
											"Developed by MOND Consulting AB \n\n" +
											"Mattias Rasch, Olof Kindblad, Nima Masroor, Dennis Olsson");
	}

	private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {

		String socNmbr = (String)StudentTable.getValueAt(StudentTable.getSelectedRow(), 2);
		String courseCode = (String)CourseTable.getValueAt(CourseTable.getSelectedRow(), 1);
		String firstName = (String)StudentTable.getValueAt(StudentTable.getSelectedRow(), 0);
		String lastName = (String)StudentTable.getValueAt(StudentTable.getSelectedRow(), 1);
		String courseName = (String)CourseTable.getValueAt(CourseTable.getSelectedRow(), 0);

		if (controller.registerStudentOnCourseCheckIfTaken(socNmbr, courseCode) == true){
			JOptionPane.showMessageDialog(null, "Student " + firstName + " " + lastName + " has already taken course " + courseName,
												"Something went wrong!", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (controller.registerStudentOnCourseCheckIfTaking(socNmbr, courseCode) == true) {
			JOptionPane.showMessageDialog(null, "Student " + firstName + " " + lastName + " is already taking course " + courseName,
												"Something went wrong!", JOptionPane.ERROR_MESSAGE);
		}
		
		else if(controller.registerStudentOnCourseCheckCredits(socNmbr, courseCode) == false){
			JOptionPane.showMessageDialog(null, "Total student credit is too high for " + courseName,
												 "Something went wrong!", JOptionPane.ERROR_MESSAGE);
		}
		
		else {
			controller.registerStudentOnCourse(socNmbr, courseCode);
			JOptionPane.showMessageDialog(null, "Student " + firstName + " " + lastName + " is now registered on course " + courseName,
												"Success!", JOptionPane.PLAIN_MESSAGE);
		}
	}

	private void DeleteStudentButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {

		String firstName = (String)StudentTable.getValueAt(StudentTable.getSelectedRow(),0);
		String lastName = (String)StudentTable.getValueAt(StudentTable.getSelectedRow(), 1);
		String socNmbr = (String)StudentTable.getValueAt(StudentTable.getSelectedRow(),2);

		controller.removeStudent(socNmbr);
		StudentModel.setRowCount(0);
		controller.getAllStudents(StudentModel);

		JOptionPane.showMessageDialog(null, "Student " + firstName + " " + lastName + " has been removed!",
											"Student removed!", JOptionPane.PLAIN_MESSAGE);
	}

	private void DeleteCourseButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException{

		String courseName = (String)CourseTable.getValueAt(CourseTable.getSelectedRow(), 0);
		String courseCode = (String)CourseTable.getValueAt(CourseTable.getSelectedRow(), 1);

		controller.removeCourse(courseCode);
		CourseModel.setRowCount(0);
		controller.getAllCourses(CourseModel);

		JOptionPane.showMessageDialog(null, "Course " + courseName + " with code " + courseCode + " has been deleted from the system!",
											"Course removed!",
											JOptionPane.PLAIN_MESSAGE);
	}

	private void GradeStudentButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {

		String firstName = (String)StudentTable.getValueAt(StudentTable.getSelectedRow(), 0);
		String lastName = (String)StudentTable.getValueAt(StudentTable.getSelectedRow(), 1);
		String courseName = (String)CourseTable.getValueAt(CourseTable.getSelectedRow(), 0);
		String courseCode = (String)CourseTable.getValueAt(CourseTable.getSelectedRow(), 1);
		String socNmbr = (String)StudentTable.getValueAt(StudentTable.getSelectedRow(), 2);

		Object[] possibilities = {"--- Please select grade! ---", "A", "B", "C", "D", "E", "U"};
		String grade = (String)JOptionPane.showInputDialog(null, "Grade student" + firstName + " " + lastName+ " on course " + courseName
															   + " with grade: ", "Grade student!", JOptionPane.PLAIN_MESSAGE, null, possibilities, null);
			
		if(grade != null) { // Restricts nullPointerException error!
		
			if(grade.equals("--- Please select grade! ---")) {
				JOptionPane.showMessageDialog(null, "Please choose a valid grade!",
													"Something went wrong!", JOptionPane.ERROR_MESSAGE);
			}

			else if(controller.gradeStudentOnCourseCheckIfTaking(socNmbr, courseCode) == true) {
				
				controller.gradeStudentOnCourse(socNmbr, courseCode, grade);
				JOptionPane.showMessageDialog(null, "Student " + firstName+ " "+ lastName +" has been graded!" ,
													"Success!", JOptionPane.PLAIN_MESSAGE);
				
				CourseModel.setRowCount(0); // Refresh student table!
				CourseTable.setModel(controller.getAllCourses(CourseModel));
			}
			
			else if(controller.gradeStudentOnCourseCheckIfTaking(socNmbr, courseCode) == false & controller.gradeStudentOnCourseCheckIfGradeIsU(socNmbr, courseCode, grade) == false){
				JOptionPane.showMessageDialog(null, "Students can not be graded on courses they are currently not taking and \n"
												   + "can only be regraded if they previously got U.", "Something went wrong!", JOptionPane.ERROR_MESSAGE);
			}

			else if(controller.gradeStudentOnCourseCheckIfGradeIsU(socNmbr, courseCode, grade) == true) {
				
				controller.reGradeStudentOnCourse(socNmbr, courseCode, grade);
				JOptionPane.showMessageDialog(null, "Student grade has been updated!", 
													"Success!", JOptionPane.PLAIN_MESSAGE);
				
				CourseModel.setRowCount(0); 
				CourseTable.setModel(controller.getAllCourses(CourseModel));
			}

			else if (controller.gradeStudentOnCourseCheckIfGradeIsU(socNmbr, courseCode, grade) == false ) {
				JOptionPane.showMessageDialog(null, "Students can only be regraded if they previously got U!" ,
						"Something went wrong!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void StudentHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		CourseModel.setRowCount(0);
		InfoBox.setText("Student history retrieved!");
		String socNmbr = (String)StudentTable.getValueAt(StudentTable.getSelectedRow(), 2);
		CourseTable.setModel(controller.getStudentPastCourses(socNmbr, CourseModel)); 
	}

	private void CurrentCoursesButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		CourseModel.setRowCount(0);
		InfoBox.setText("Current courses retireved!");
		String socNmbr = (String)StudentTable.getValueAt(StudentTable.getSelectedRow(), 2);
		CourseTable.setModel(controller.getStudentActiveCourses(socNmbr, CourseModel)); 	
	}

	private void CourseHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		StudentModel.setRowCount(0);
		InfoBox.setText("Course history retireved!");
		String courseCode = (String)CourseTable.getValueAt(CourseTable.getSelectedRow(), 1);
		StudentTable.setModel(controller.getCoursePastStudents(courseCode, StudentModel)); 
	}

	private void CurrentStudentsButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException{
		StudentModel.setRowCount(0);
		InfoBox.setText("Current studens retrieved!");
		String courseCode = (String)CourseTable.getValueAt(CourseTable.getSelectedRow(), 1);
		StudentTable.setModel(controller.getCourseActiveStudents(courseCode, StudentModel)); 
	}

	private void StudentRowSelected(ListSelectionEvent evt) throws SQLException {

		if(isCourseRowSelected == true) {

			String socNmbr = (String)StudentTable.getValueAt(StudentTable.getSelectedRow(), 2);
			String courseCode = (String)CourseTable.getValueAt(CourseTable.getSelectedRow(), 1);
			Integer gradeAPercentage = controller.getHighGradePercentage(courseCode);
			Integer courseThroughput = controller.getCourseThroughput(courseCode);
			String grade = controller.getStudentGrade(socNmbr, courseCode, StudentModel);
			InfoBox.setText("Students with grade A: " + gradeAPercentage + "% \n\n" +
							"Course throughput: " + courseThroughput + " % \n\n" +
							"Student (" + socNmbr + ") has grade: \n\n" + grade);
		} 
	}

	private void CourseRowSelected(ListSelectionEvent evt) throws SQLException {
		
		if(isStudentRowSelected == true) {

			String socNmbr = (String)StudentTable.getValueAt(StudentTable.getSelectedRow(), 2);
			String courseCode = (String)CourseTable.getValueAt(CourseTable.getSelectedRow(), 1);
			Integer gradeAPercentage = controller.getHighGradePercentage(courseCode);
			Integer courseThroughput = controller.getCourseThroughput(courseCode);
			String grade = controller.getStudentGrade(socNmbr, courseCode, StudentModel);
			InfoBox.setText("Students with grade A: " + gradeAPercentage + "% \n\n" +
							"Course throughput: " + courseThroughput + " % \n\n" +
							"Student (" + socNmbr + ") has grade: \n\n" + grade);
		}

		else {

			String courseCode = (String)CourseTable.getValueAt(CourseTable.getSelectedRow(), 1);
			Integer gradeAPercentage = controller.getHighGradePercentage(courseCode);
			Integer courseThroughput = controller.getCourseThroughput(courseCode);
			InfoBox.setText("Students with grade A: " + gradeAPercentage + "%" + "\n\n" +
							"Course throughput: " + courseThroughput + "%"); 
		}
	}

	private void CloseWindow1ButtonActionPerformed(java.awt.event.ActionEvent evt) {
		AddDialog.setVisible(false);
	}

	private void CloseWindow2ButtonActionPerformed(java.awt.event.ActionEvent evt) {
		AddDialog.setVisible(false);
	}

	private void ClearStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {
		AddFirstNameTextField.setText("First name");
		AddLastNameTextField.setText("Last name");
		AddSocNmbrTextField.setText("Social security number");
		AddAddressTextField.setText("Address");
		AddCityTextField.setText("City");
		AddZipTextField.setText("Zip code");
		AddPhoneNmbrTextField.setText("Telephone number");
		AddEmailTextField.setText("E-mail");
	}

	private void ClearCourseFieldsButtonActionPerformed(java.awt.event.ActionEvent evt) {
		AddCourseCodeTextField.setText("Course code");
		AddCourseNameTextField.setText("Course name");
		AddCourseCreditsTextField.setText("Course credits");
	}

	private void AddFirstNameTextFieldMouseClicked(java.awt.event.MouseEvent evt) {
		AddFirstNameTextField.setText("");
	}

	private void AddLastNameTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		AddLastNameTextField.setText("");
	}

	private void AddSocNmbrTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		AddSocNmbrTextField.setText("");
	}

	private void AddAddressTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		AddAddressTextField.setText("");
	}

	private void AddCityTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		AddCityTextField.setText("");
	}

	private void AddZipTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		AddZipTextField.setText("");
	}

	private void AddPhoneNmbrTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		AddPhoneNmbrTextField.setText("");
	}

	private void AddEmailTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		AddEmailTextField.setText("");
	}

	private void AddCourseCodeTextFieldMouseClicked(java.awt.event.MouseEvent evt) {
		AddCourseCodeTextField.setText("");
	}

	private void AddCourseNameTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		AddCourseNameTextField.setText("");
	}

	private void AddCourseCreditsTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		AddCourseCreditsTextField.setText("");
	}

	private void AddStudentButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {

		String firstName = AddFirstNameTextField.getText();
		String lastName = AddLastNameTextField.getText();
		String socNmbr = AddSocNmbrTextField.getText();
		String adress = AddAddressTextField.getText();
		String city = AddCityTextField.getText();
		String zipCode = AddZipTextField.getText();
		String telNmbr = AddPhoneNmbrTextField.getText();
		String eMail = AddEmailTextField.getText();
		
		if(	AddFirstNameTextField.getText().equals("") || AddFirstNameTextField.getText().equals("First name") 			 ||
			 AddLastNameTextField.getText().equals("") || AddLastNameTextField.getText().equals("Last name")			 ||
			  AddSocNmbrTextField.getText().equals("") || AddSocNmbrTextField.getText().equals("Social security number") ||
			  AddAddressTextField.getText().equals("") || AddAddressTextField.getText().equals("Address") 				 ||
				 AddCityTextField.getText().equals("") || AddCityTextField.getText().equals("City")						 ||
				  AddZipTextField.getText().equals("") || AddZipTextField.getText().equals("Zip code")					 ||
			AddPhoneNmbrTextField.getText().equals("") || AddPhoneNmbrTextField.getText().equals("Telephone number") 	 ||
				AddEmailTextField.getText().equals("") || AddEmailTextField.getText().equals("E-mail")) {

			JOptionPane.showMessageDialog(null, "Make sure you filled out the form correctly!","Something went wrong!", JOptionPane.ERROR_MESSAGE);
		}

		else if(controller.registerStudentCheckSocNmbr(socNmbr) == true) {
			JOptionPane.showMessageDialog(null, "There is already a student with this soc. number in the system!","Something went wrong!", JOptionPane.ERROR_MESSAGE);
		}

		else if (controller.registerStudentCheckPhoneNmbr(telNmbr) == true) {
			JOptionPane.showMessageDialog(null, "There is already a student with this phone number in the system.","Something went wrong!", JOptionPane.ERROR_MESSAGE);
		}

		else if (controller.registerStudentCheckEmail(eMail) == true) {
			JOptionPane.showMessageDialog(null, "There is already a student with this e-mail in the system.","Something went wrong!", JOptionPane.ERROR_MESSAGE);
		}


		else {
			
			try {
				controller.registerStudent(firstName, lastName, socNmbr, adress, city, zipCode);
				controller.registerStudentTelNmbr(telNmbr, socNmbr);
				controller.registerStudentEmail(eMail, socNmbr);
				JOptionPane.showMessageDialog(null, "Student registered!!","Success!", JOptionPane.PLAIN_MESSAGE);
				StudentModel.setRowCount(0);
				controller.getAllStudents(StudentModel);
			}
			catch(SQLException e) {
				JOptionPane.showMessageDialog(null, errorHandler.getErrorMessage(e, errorVariable),
													"Something went wrong!", JOptionPane.ERROR_MESSAGE);
			}
			
			AddFirstNameTextField.setText("First name");
			AddLastNameTextField.setText("Last name");
			AddSocNmbrTextField.setText("Social security number");
			AddAddressTextField.setText("Address");
			AddCityTextField.setText("City");
			AddZipTextField.setText("Zip code");
			AddPhoneNmbrTextField.setText("Telephone number");
			AddEmailTextField.setText("E-mail"); 
		}
	}
	
	private void AddCourseButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException{

		errorVariable = "checkCourse";
		
		try {
		
		String courseName = AddCourseNameTextField.getText();
		String courseCode = AddCourseCodeTextField.getText().toUpperCase();
		String courseCredits = AddCourseCreditsTextField.getText();
		int credits = Integer.parseInt(courseCredits);

		if(		AddCourseCodeTextField.getText().equals("") || AddCourseCodeTextField.getText().equals("Course Code") ||
				AddCourseNameTextField.getText().equals("") || AddCourseNameTextField.getText().equals("Course Name") ||
			 AddCourseCreditsTextField.getText().equals("") || AddCourseCreditsTextField.getText().equals("Course Credits")) {

			JOptionPane.showMessageDialog(null, "Make sure You filled out the form correctly!","Something went wrong!", JOptionPane.ERROR_MESSAGE);
		}

		if(credits > 30 || credits < 1){
			JOptionPane.showMessageDialog(null, "A course can not be greater than 30 credits or less than 1!","Something went wrong!", JOptionPane.ERROR_MESSAGE);
		}

		else if(controller.registerCourseCheckCourseCode(courseCode) == true) {
			JOptionPane.showMessageDialog(null, "There is already a course with that code in the systen!","Something went wrong!", JOptionPane.ERROR_MESSAGE);
		}
		
		else {
			controller.registerCourse(courseName, courseCode, credits);
			CourseModel.setRowCount(0);
			controller.getAllCourses(CourseModel);
			JOptionPane.showMessageDialog(null, "Course " + courseName + " registered!","Success!", JOptionPane.PLAIN_MESSAGE);
			AddCourseCodeTextField.setText("Course code");
			AddCourseNameTextField.setText("Course name");
			AddCourseCreditsTextField.setText("Course credits");
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, errorHandler.getErrorMessage(e, errorVariable),"Something went wrong!", JOptionPane.ERROR_MESSAGE);
		}
	
	}

	/*----------------------------------------------------------------------------------------------------------*/
	/*------------------------------------------- OBJECT CREATION! ---------------------------------------------*/
	/*----------------------------------------------------------------------------------------------------------*/

	private javax.swing.JFormattedTextField AddAddressTextField;
	private javax.swing.JButton AddButton;
	private javax.swing.JFormattedTextField AddCityTextField;
	private javax.swing.JButton AddCourseButton;
	private javax.swing.JFormattedTextField AddCourseCodeTextField;
	private javax.swing.JFormattedTextField AddCourseCreditsTextField;
	private javax.swing.JFormattedTextField AddCourseNameTextField;
	private javax.swing.JDialog AddDialog;
	private javax.swing.JFormattedTextField AddEmailTextField;
	private javax.swing.JFormattedTextField AddFirstNameTextField;
	private javax.swing.JFormattedTextField AddLastNameTextField;
	private javax.swing.JFormattedTextField AddPhoneNmbrTextField;
	private javax.swing.JFormattedTextField AddSocNmbrTextField;
	private javax.swing.JButton AddStudentButton;
	private javax.swing.JTabbedPane AddTabbedPane;
	private javax.swing.JFormattedTextField AddZipTextField;
	private javax.swing.JButton ClearCourseFieldsButton;
	private javax.swing.JButton ClearStudentButton;
	private javax.swing.JButton CloseWindow1Button;
	private javax.swing.JButton CloseWindow2Button;
	private javax.swing.JFormattedTextField CourseCodeTextField;
	private javax.swing.JButton CourseHistoryButton;
	private javax.swing.JFormattedTextField CourseNameTextField;
	private javax.swing.JTable CourseTable;
	private javax.swing.JScrollPane CourseTableScrollPane;
	private javax.swing.JLabel CoursesLabel;
	private javax.swing.JPanel CoursesPanel;
	private javax.swing.JButton CurrentCoursesButton;
	private javax.swing.JButton CurrentStudentsButton;
	private javax.swing.JButton DeleteCourseButton;
	private javax.swing.JButton DeleteStudentButton;
	private javax.swing.JFormattedTextField FirstNameTextField;
	private javax.swing.JButton GradeStudentButton;
	private javax.swing.JScrollPane InfoBoxPane;
	private javax.swing.JFormattedTextField LastNameTextField;
	private javax.swing.JButton RegisterButton;
	private javax.swing.JLabel SeachByStudentLabel;
	private javax.swing.JLabel SearchByCourseLabel;
	private javax.swing.JButton SearchCourseButton;
	private javax.swing.JButton SearchStudentButton;
	private javax.swing.JFormattedTextField SocNmbrTextField;
	private javax.swing.JButton StudentHistoryButton;
	private javax.swing.JLabel StudentLabel;
	private javax.swing.JTable StudentTable;
	private javax.swing.JScrollPane StudentTableScrollPane;
	private javax.swing.JPanel StudentsPanel;
	private javax.swing.JButton HelpButton;
	private javax.swing.JTextArea InfoBox;
}
