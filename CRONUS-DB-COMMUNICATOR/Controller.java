package controller;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

import dataAccessLayer.DAL;

public class Controller {

	public DAL dal;
	
	public Controller() throws SQLException {
		dal = new DAL();
	}
	
	public DefaultTableModel getEmployeeContent(DefaultTableModel dataModel) throws SQLException {
		return dal.getEmployeeContent(dataModel);
	}
	public DefaultTableModel getEmployeeMetaData(DefaultTableModel dataModel) throws SQLException {
		return dal.getEmployeeMetaData(dataModel);
	}
	public DefaultTableModel getDatabaseKeys(DefaultTableModel dataModel) throws SQLException {
		return dal.getDatabaseKeys(dataModel);
	}
	public DefaultTableModel getDatabaseIndexes(DefaultTableModel dataModel) throws SQLException {
		return dal.getDatabaseIndexes(dataModel);
	}
	public DefaultTableModel getTableConstraints(DefaultTableModel dataModel) throws SQLException {
		return dal.getTableConstraints(dataModel);
	}
	public DefaultTableModel getAllTables(DefaultTableModel dataModel) throws SQLException {
		return dal.getAllTables(dataModel);
	}
	public DefaultTableModel getAllTables2(DefaultTableModel dataModel) throws SQLException {
		return dal.getAllTables2(dataModel);
	}
	public DefaultTableModel getAllColumns(DefaultTableModel dataModel) throws SQLException {
		return dal.getAllColumns(dataModel);
	}
	public DefaultTableModel getAllColumns2(DefaultTableModel dataModel) throws SQLException {
		return dal.getAllColumns2(dataModel);
	}
	public DefaultTableModel getTableMostRows(DefaultTableModel dataModel) throws SQLException {
		return dal.getTableMostRows(dataModel);
	}
	public DefaultTableModel getAbsenceContent(DefaultTableModel dataModel) throws SQLException {
		return dal.getAbsenceContent(dataModel);
	}
	public DefaultTableModel getRelativeContent(DefaultTableModel dataModel) throws SQLException {
		return dal.getRelativeContent(dataModel);
	}
	public DefaultTableModel getQualificationContent(DefaultTableModel dataModel) throws SQLException {
		return dal.getQualificationContent(dataModel);
	}
	public DefaultTableModel getAbsenceMetadata(DefaultTableModel dataModel) throws SQLException {
		return dal.getAbsenceMetadata(dataModel);
	}
	public DefaultTableModel getRelativeMetadata(DefaultTableModel dataModel) throws SQLException {
		return dal.getRelativeMetadata(dataModel);
	}
	public DefaultTableModel getQualificationMetadata(DefaultTableModel dataModel) throws SQLException {
		return dal.getQualificationMetadata(dataModel);
	}

	}
