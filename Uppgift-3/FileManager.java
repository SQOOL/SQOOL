package FileManager;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class FileManager {
	
	Desktop desktop = Desktop.getDesktop();
	 
	
	/*----------EXCEL FILES A--------*/
	File Excel1 = new File("/Users/Dennis/Downloads/01.SYSB13-ER-Modellering-Normalisering.pdf");
	File Excel2 = new File("");
	File Excel3 = new File("");
	File Excel4 = new File("");
	File Excel5 = new File("");
	File Excel6 = new File("");
	File Excel7 = new File("");
	
	/*---------ACCESS FILES A--------*/
	File Access1 = new File("");
	File Access2 = new File("");
	File Access3 = new File("");
	File Access4 = new File("");
	File Access5 = new File("");
	File Access6 = new File("");
	File Access7 = new File("");
	
	/*---------SQL FILES A----------*/
	File Sql1 = new File("");
	File Sql2 = new File("");
	File Sql3 = new File("");
	File Sql4 = new File("");
	File Sql5 = new File("");
	File Sql6 = new File("");
	File Sql7 = new File("");
	
	
	/*---------EXCEL FORM FILES --------*/
	File ExcelForm1 = new File("");
	File ExcelForm2 = new File("");
	
	/*--------ACCESS FORM FILES---------*/
	File AccessForm1 = new File("");
	File AccessForm2 = new File("");
	
	/*--------WORD FORM FILES----------*/
	File WordForm1 = new File("");
	File WordForm2 = new File("");
	
	
	/*-------OPEN EXCEL FILES A--------*/
	public void openExcel1(){
		 if(Excel1.exists())
				try {
					desktop.open(Excel1);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openExcel2(){
		 if(Excel2.exists())
				try {
					desktop.open(Excel2);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}

	public void openExcel3(){
		 if(Excel3.exists())
				try {
					desktop.open(Excel3);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openExcel4(){
		 if(Excel4.exists())
				try {
					desktop.open(Excel4);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openExcel5(){
		 if(Excel5.exists())
				try {
					desktop.open(Excel5);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openExcel6(){
		 if(Excel6.exists())
				try {
					desktop.open(Excel6);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openExcel7(){
		 if(Excel7.exists())
				try {
					desktop.open(Excel7);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	/*----------OPEN ACCESS FILES---------*/
	
	public void openAccess1(){
		 if(Access1.exists())
				try {
					desktop.open(Access1);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openAccess2(){
		 if(Access2.exists())
				try {
					desktop.open(Access2);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openAccess3(){
		 if(Access3.exists())
				try {
					desktop.open(Access3);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openAccess4(){
		 if(Access4.exists())
				try {
					desktop.open(Access4);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openAccess5(){
		 if(Access5.exists())
				try {
					desktop.open(Access5);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openAccess6(){
		 if(Access6.exists())
				try {
					desktop.open(Access6);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openAccess7(){
		 if(Access7.exists())
				try {
					desktop.open(Access7);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	/*------------ OPEN SQL FILES -------*/
	public void openSql1(){
		 if(Sql1.exists())
				try {
					desktop.open(Sql1);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openSql2(){
		 if(Sql2.exists())
				try {
					desktop.open(Sql2);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openSql3(){
		 if(Sql3.exists())
				try {
					desktop.open(Sql3);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openSql4(){
		 if(Sql4.exists())
				try {
					desktop.open(Sql4);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openSql5(){
		 if(Sql5.exists())
				try {
					desktop.open(Sql5);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openSql6(){
		 if(Sql6.exists())
				try {
					desktop.open(Sql6);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openSql7(){
		 if(Sql7.exists())
				try {
					desktop.open(Sql7);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	/*----------OPEN EXCEL FORMS--------*/
	public void openExcelForm1(){
		 if(ExcelForm1.exists())
				try {
					desktop.open(ExcelForm1);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openExcelForm2(){
		 if(ExcelForm2.exists())
				try {
					desktop.open(ExcelForm2);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	/*----------OPEN ACCESS FORMS-------*/
	public void openAccessForm1(){
		 if(AccessForm1.exists())
				try {
					desktop.open(AccessForm1);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openAccessForm2(){
		 if(AccessForm2.exists())
				try {
					desktop.open(AccessForm2);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	/*----------OPEN WORD FORMS---------*/
	public void openWordForm1(){
		 if(WordForm1.exists())
				try {
					desktop.open(WordForm1);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void openWordForm2(){
		 if(WordForm2.exists())
				try {
					desktop.open(WordForm2);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
}




