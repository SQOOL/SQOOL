package Controller;

import java.sql.SQLException;

import FileManager.FileManager;

public class Controller {

	public FileManager filMan;

	public Controller() throws SQLException {
		filMan = new FileManager();
	}

	/*----------------OPEN EXCEL FILES--------------*/
	public void openExcel1() {
		filMan.openExcel1();
	}

	public void openExcel2() {
		filMan.openExcel2();
	}

	public void openExcel3() {
		filMan.openExcel3();
	}

	public void openExcel4() {
		filMan.openExcel4();
	}

	public void openExcel5() {
		filMan.openExcel5();
	}

	public void openExcel6() {
		filMan.openExcel6();
	}

	public void openExcel7() {
		filMan.openExcel7();
	}

	/*------------OPEN ACCESS FILES-------------*/
	public void openAccess1() {
		filMan.openAccess1();
	}

	public void openAccess2() {
		filMan.openAccess2();
	}

	public void openAccess3() {
		filMan.openAccess3();
	}

	public void openAccess4() {
		filMan.openAccess4();
	}

	public void openAccess5() {
		filMan.openAccess5();
	}

	public void openAccess6() {
		filMan.openAccess6();
	}

	public void openAccess7() {
		filMan.openAccess7();
	}

	/*-----------OPEN SQL FILES-----------*/
	public void openSql1() {
		filMan.openSql1();
	}

	public void openSql2() {
		filMan.openSql2();
	}

	public void openSql3() {
		filMan.openSql3();
	}

	public void openSql4() {
		filMan.openSql4();
	}

	public void openSql5() {
		filMan.openSql5();
	}

	public void openSql6() {
		filMan.openSql6();
	}

	public void openSql7() {
		filMan.openSql7();
	}

	/*----------OPEN EXCEL FORMS---------*/
	public void openExcelForm1() {
		filMan.openExcelForm1();
	}

	public void openExcelForm2() {
		filMan.openExcelForm2();
	}

	/*----------OPEN ACCESS FORMS---------*/
	public void openAccessForm1() {
		filMan.openAccessForm1();
	}

	public void openAccessForm2() {
		filMan.openAccessForm2();
	}

	/*---------OPEN WORD FORMS-----------*/
	public void openWordForm1() {
		filMan.openWordForm1();
	}

	public void openWordForm2() {
		filMan.openWordForm2();
	}

}
