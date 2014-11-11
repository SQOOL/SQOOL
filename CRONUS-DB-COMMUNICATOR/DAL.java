package dataAccessLayer;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class DAL {
	
	Connection con;

	public DAL() throws SQLException {

		driverCheck();

	}

	/* --------------------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------- GET ALL EMPLOYEE CONTENT! -------------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */

	public DefaultTableModel getEmployeeContent(DefaultTableModel dataModel) throws SQLException  { // Finds all employees!

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT No_ , [First Name], [Last Name], Initials, [Job Title], [Search Name]  FROM [Demo Database NAV (5-0)].[dbo].[CRONUS Sverige AB$Employee]");
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              
		
			int i = 1;
			while(i <= numberOfColumns) {
				
				String employeeNmbr = resSet.getString(i++);
				String firstName = resSet.getString(i++);
				String lastName = resSet.getString(i++);
				String initials = resSet.getString(i++);
				String jobTitle = resSet.getString(i++);
				String searchName = resSet.getString(i++);
				
				Object[] employeeData = {employeeNmbr, firstName, lastName, initials, jobTitle, searchName};
				
				dataModel.addRow(employeeData);
			}
		}
		return dataModel;  		
	}

	/* --------------------------------------------------------------------------------------------------------------- */
	/* --------------------------------------------- GET ALL EMPLOYEE METADATA! ------------------------------------------------ */
	/* --------------------------------------------------------------------------------------------------------------- */
	public DefaultTableModel getEmployeeMetaData(DefaultTableModel dataModel) throws SQLException  { // Finds all employee metadata!

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT [TABLE_CATALOG], [TABLE_SCHEMA], [TABLE_NAME], [COLUMN_NAME], [DATA_TYPE]  FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee'");	
		ResultSet resSet = prepStmnt.executeQuery();
		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();
		
		while (resSet.next()) {              
			
			int i = 1;
			while(i <= numberOfColumns) {
				String tableCatalog = resSet.getString(i++);
				String tableSchema = resSet.getString(i++);
				String tableName = resSet.getString(i++);
				String columnName = resSet.getString(i++);
				String dataType = resSet.getString(i++);
				
				Object[] employeeData = {tableCatalog, tableSchema, tableName, columnName, dataType};
				
				dataModel.addRow(employeeData);
			}
		}
		
		return dataModel; 

	}
	
	/* --------------------------------------------------------------------------------------------------------------- */
	/* --------------------------------------------- GET ALL DATABASE KEYS! ------------------------------------------------ */
	/* --------------------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getDatabaseKeys(DefaultTableModel dataModel) throws SQLException  { // Finds all Database Keys!

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT OBJECT_NAME(OBJECT_ID),SCHEMA_NAME(schema_id),OBJECT_NAME(parent_object_id),type_desc FROM sys.objects WHERE type_desc IN ('FOREIGN_KEY_CONSTRAINT','PRIMARY_KEY_CONSTRAINT')");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              
		
			int i = 1;
			while(i <= numberOfColumns) {
				
				String nameofConstraint = resSet.getString(i++);
				String schemaName = resSet.getString(i++);
				String tableName = resSet.getString(i++);
				String constraintType = resSet.getString(i++);
				
				Object[] databaseKeys = {nameofConstraint, schemaName, tableName, constraintType,};
				
				dataModel.addRow(databaseKeys);
			}
		}
		
		return dataModel; 
	}
	
	/* --------------------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------------- GET ALL DATABASE INDEXES! ---------------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getDatabaseIndexes(DefaultTableModel dataModel) throws SQLException  { // Finds all Database Indexes!

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT so.name, si.name, si.type_desc FROM sys.indexes si JOIN sys.objects so ON si.[object_id] = so.[object_id] WHERE so.type = 'U' ORDER BY so.name, si.type");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              
		
			int i = 1;
			while(i <= numberOfColumns) {
				
				String tableName = resSet.getString(i++);
				String indexName = resSet.getString(i++);
				String indexType = resSet.getString(i++);
				
				Object[] databaseIndexes = {tableName, indexName, indexType};
				
				dataModel.addRow(databaseIndexes);
			}
		}
		
		return dataModel; 
	}
	
	
	
	/* --------------------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------------- GET ALL TABLE CONSTRAINTS! ---------------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getTableConstraints(DefaultTableModel dataModel) throws SQLException  { // Finds all TABLE CONSTRAINTS!

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              
		
			int i = 1;
			while(i <= numberOfColumns) {
				
				String constraintName = resSet.getString(i++);
				String constraintType = resSet.getString(i++);
				String tableName = resSet.getString(i++);
				
				Object[] tableConstraints = {constraintName, constraintType, tableName};
				
				dataModel.addRow(tableConstraints);
			}
		}
		
		return dataModel; 
	}
	
	/* --------------------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------------- GET ALL TABLES! ---------------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getAllTables(DefaultTableModel dataModel) throws SQLException  { // Finds all TABLES

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT * FROM INFORMATION_SCHEMA.TABLES");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              
		
			int i = 1;
			while(i <= numberOfColumns) {
				
				String tableCatalog = resSet.getString(i++);
				String tableSchema = resSet.getString(i++);
				String tableName = resSet.getString(i++);
				String tableType = resSet.getString(i++);
				
				Object[] allTables = {tableCatalog, tableSchema, tableName, tableType};
				
				dataModel.addRow(allTables);
			}
		}
		
		return dataModel; 
	}
	
	/* --------------------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------------- GET ALL TABLES - 2! ---------------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getAllTables2(DefaultTableModel dataModel) throws SQLException  { // Finds all TABLES

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT name, object_id, [type_desc] FROM sys.tables");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              
		
			int i = 1;
			while(i <= numberOfColumns) {
				
				String name = resSet.getString(i++);
				String object_Id = resSet.getString(i++);
				String typeDesc = resSet.getString(i++);
				
				
				Object[] allTables2 = {name, object_Id, typeDesc};
				
				dataModel.addRow(allTables2);
			}
		}
		
		return dataModel; 
	}
	
	/* --------------------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------------- GET ALL COLUMNS! ---------------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */
	public DefaultTableModel getAllColumns(DefaultTableModel dataModel) throws SQLException  { // Finds all COLUMNS

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT name FROM sys.columns  WHERE object_id = OBJECT_ID ('CRONUS Sverige AB$Employee') ORDER BY column_id");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              
		
			int i = 1;
			while(i <= numberOfColumns) {
				
				String columnNames = resSet.getString(i++);
				
				
				Object[] allColumns = {columnNames};
				
				dataModel.addRow(allColumns);
			}
		}
		
		return dataModel; 
	}
	
	
	/* --------------------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------------- GET ALL COLUMNS - 2! ---------------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */
	public DefaultTableModel getAllColumns2(DefaultTableModel dataModel) throws SQLException  { // Finds all COLUMNS

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT COLUMN_NAME AS 'All columns' FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME ='CRONUS Sverige AB$Employee'");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              
		
			int i = 1;
			while(i <= numberOfColumns) {
				
				String columnNames = resSet.getString(i++);
				
				
				Object[] allColumns = {columnNames};
				
				dataModel.addRow(allColumns);
			}
		}
		
		return dataModel; 
	}
	
	/* --------------------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------------- GET TABLE WITH MOST ROWS! ---------------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getTableMostRows(DefaultTableModel dataModel) throws SQLException  { // Finds table with most rows

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT top 1 [TableName] = so.name, [RowCount] = MAX(si.rows)  FROM sysobjects so, sysindexes si  WHERE so.xtype = 'U' AND si.id = OBJECT_ID(so.name) GROUP BY so.name ORDER BY 2 DESC");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              
		
			int i = 1;
			while(i <= numberOfColumns) {
				
				
				
				String TableName = resSet.getString(i++);
				String RowCount = resSet.getString(i++);
				
				
				Object[] tableMostRows = {TableName, RowCount};
				
				dataModel.addRow(tableMostRows);
			}
		}
		
		return dataModel; 
	}
	
	/* --------------------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------------- GET ABSENCE CONTENT! ---------------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getAbsenceContent(DefaultTableModel dataModel) throws SQLException  { // Finds table with most rows

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT [Employee No_], [From Date], [To Date], [Cause of Absence Code], [Description] FROM [CRONUS Sverige AB$Employee Absence] ");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              
		
			int i = 1;
			while(i <= numberOfColumns) {
				
				String employeeNo = resSet.getString(i++);
				String fromDate = resSet.getString(i++);
				String toDate = resSet.getString(i++);
				String causeOfAbsence = resSet.getString(i++);
				String description = resSet.getString(i++);
				
				Object[] absenceContent = {employeeNo, fromDate, toDate, causeOfAbsence, description};
				
				dataModel.addRow(absenceContent);
			}
		}
		
		return dataModel; 
	}
	
	
	
	/* --------------------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------------- GET RELATIVE CONTENT! ---------------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */
	public DefaultTableModel getRelativeContent(DefaultTableModel dataModel) throws SQLException  { // Finds table with most rows

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT [Employee No_], [Relative Code], [First Name], [Last Name], [Birth Date] FROM [CRONUS Sverige AB$Employee Relative]");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              
		
			int i = 1;
			while(i <= numberOfColumns) {
				
				String employeeNo = resSet.getString(i++);
				String relativeCode = resSet.getString(i++);
				String firstName = resSet.getString(i++);
				String lastName = resSet.getString(i++);
				String birthDate = resSet.getString(i++);
				
				Object[] relativeContent = {employeeNo, relativeCode, firstName, lastName, birthDate};
				
				dataModel.addRow(relativeContent);
			}
		}
		
		return dataModel; 
	}
	
	
	/* --------------------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------------- GET QUALIFICATION CONTENT! ---------------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */
	public DefaultTableModel getQualificationContent(DefaultTableModel dataModel) throws SQLException  { // Finds table with most rows

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT [Employee No_], [Qualification Code], [From Date], [To Date], [Description] FROM [CRONUS Sverige AB$Employee Qualification]");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              
		
			int i = 1;
			while(i <= numberOfColumns) {
				
				String employeeNo = resSet.getString(i++);
				String qualificationCode = resSet.getString(i++);
				String fromDate = resSet.getString(i++);
				String toDate = resSet.getString(i++);
				String description = resSet.getString(i++);
				
				
				Object[] qualificationContent = {employeeNo, qualificationCode, fromDate, toDate, description};
				
				dataModel.addRow(qualificationContent);
			}
		}
		
		return dataModel; 
	}
	
	/* --------------------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------------- GET ABSENCE METADATA! ---------------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */
	public DefaultTableModel getAbsenceMetadata(DefaultTableModel dataModel) throws SQLException  { // Finds table with most rows

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT [TABLE_CATALOG], [TABLE_SCHEMA], [TABLE_NAME], [COLUMN_NAME], [DATA_TYPE]  FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee Absence'");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              
		
			int i = 1;
			while(i <= numberOfColumns) {
			
				String tableCatalog = resSet.getString(i++);
				String tableSchema = resSet.getString(i++);
				String tableName = resSet.getString(i++);
				String columnName = resSet.getString(i++);
				String dataType = resSet.getString(i++);
				
				Object[] absenceMetadata = {tableCatalog, tableSchema, tableName, columnName, dataType};
				
				dataModel.addRow(absenceMetadata);
			}
		}
		
		return dataModel; 
	}
	
	/* --------------------------------------------------------------------------------------------------------------- */
	/* ---------------------------------------------- GET RELATIVE METADATA! ---------------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */
	public DefaultTableModel getRelativeMetadata(DefaultTableModel dataModel) throws SQLException  { // Finds table with most rows

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT [TABLE_CATALOG], [TABLE_SCHEMA], [TABLE_NAME], [COLUMN_NAME], [DATA_TYPE]  FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee Relative'");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              
		
			int i = 1;
			while(i <= numberOfColumns) {
						
				String tableCatalog = resSet.getString(i++);
				String tableSchema = resSet.getString(i++);
				String tableName = resSet.getString(i++);
				String columnName = resSet.getString(i++);
				String dataType = resSet.getString(i++);
				
				Object[] relativeMetadata = {tableCatalog, tableSchema, tableName, columnName, dataType};
				
				dataModel.addRow(relativeMetadata);
			}
		}
		
		return dataModel; 
	}
	
	/* --------------------------------------------------------------------------------------------------------------- */
	/* ----------------------------------------- GET QUALIFICATION METADATA! ----------------------------------------- */
	/* --------------------------------------------------------------------------------------------------------------- */
	
	public DefaultTableModel getQualificationMetadata(DefaultTableModel dataModel) throws SQLException  { // Finds table with most rows

		con = connectionTest();
		
		PreparedStatement prepStmnt = con.prepareStatement("SELECT [TABLE_CATALOG], [TABLE_SCHEMA], [TABLE_NAME], [COLUMN_NAME], [DATA_TYPE]  FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee Qualification'");
		
		ResultSet resSet = prepStmnt.executeQuery();

		ResultSetMetaData metadata = resSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		while (resSet.next()) {              
		
			int i = 1;
			while(i <= numberOfColumns) {
								
				String tableCatalog = resSet.getString(i++);
				String tableSchema = resSet.getString(i++);
				String tableName = resSet.getString(i++);
				String columnName = resSet.getString(i++);
				String dataType = resSet.getString(i++);

				Object[] qualificationMetadata = {tableCatalog, tableSchema, tableName, columnName, dataType};
				
				dataModel.addRow(qualificationMetadata);
			}
		}
		
		return dataModel; 
	}
	
	
	/* ------------------------------------ */
	/* ------ DATABASE DRIVER CHECK! ------ */
	/* ------------------------------------ */

	public void driverCheck() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		}

		catch (ClassNotFoundException cnfe) {
			System.out.println("Driver is not functioning properly! " +
							   "Error message:" + cnfe.getMessage());
		}
	}
	
	/* ------------------------------------ */
	/* -------- CONNECTION TESTING! ------- */
	/* ------------------------------------ */

	public Connection connectionTest() {

		try { 
			con = DriverManager.getConnection("jdbc:sqlserver://NIMA\\MSSQLSERVER;" + 
		                                  "database=Demo Database NAV (5-0);" + 
		                                  "user=Gruppen2;" + 
		                                  "password=Lund1234"); 
		}

		catch (Exception e) {

			System.out.println("Error establishing connection! Please try again later...");
			e.printStackTrace();
			System.out.println(e.getMessage()); 
		}

		return con;
	}
	
	/* ------------------------------------ */
}
