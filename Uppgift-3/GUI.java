package View;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;

public class GUI {
	
	public JFrame mainFrame = new JFrame("MOND Consulting");
	private CardLayout cardLayout = new CardLayout(); 
	private Container contentPane = mainFrame.getContentPane(); 
	
	Controller controller;
	
	public GUI() throws SQLException {
		
		controller = new Controller();

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		mainFrame.setSize(490, 440);

		contentPane.setLayout(cardLayout);
		contentPane.setPreferredSize(new Dimension(mainFrame.getWidth(), mainFrame.getHeight())); 
		
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------------- Creates the MAIN panel! -------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/* ---- PANEL! ---- */

		JPanel mainPanel = new JPanel(); 
		mainPanel.setLayout(null); 
		contentPane.add(mainPanel, "mainPanel"); 
		
		/* ---- LISTS! ---- */
		
		List queriesList = new List();
		queriesList.setBounds(30, 10, 200, 150);
		mainPanel.add(queriesList);
		queriesList.add("1) 100 Nok");
		queriesList.add("2) Mest SEK");
		queriesList.add("3) Fotograferna AB");
		queriesList.add("4) Sjuka anställda");
		queriesList.add("5) Släktingar");
		queriesList.add("6) Andreas Berglund");
		queriesList.add("7) Bankkonto");
		
		
		List formsList = new List();
		formsList.setBounds(260, 10, 200, 150);
		mainPanel.add(formsList);
		formsList.add("1) Customer");
		formsList.add("2) Employee");
		
		

	
		/* ---- LABELS! ---- */
		
		
		JLabel openWith1Label = new JLabel();
		openWith1Label.setText("OPEN QUERIES WITH:");
		openWith1Label.setBounds(70, 180, 200, 50);
		mainPanel.add(openWith1Label);
		
		
		JLabel openWith2Label = new JLabel();
		openWith2Label.setText("OPEN FORMS WITH:");
		openWith2Label.setBounds(300, 180, 200, 50);
		mainPanel.add(openWith2Label);

		
		/* ---- BUTTONS! SET 1! ---- */

		JButton msExcel1Button = new JButton("MS Excel"); 
		msExcel1Button.setBounds(30, 240, 200, 50); 
		mainPanel.add(msExcel1Button);

		JButton msAccess1Button = new JButton("MS Access");
		msAccess1Button.setBounds(30, 300, 200, 50);
		mainPanel.add(msAccess1Button);

		JButton msSqlButton = new JButton("MS SQL Manager");
		msSqlButton.setBounds(30, 360, 200, 50);
		mainPanel.add(msSqlButton);
		

		/* ---- BUTTONS! SET 2! ---- */
		
		JButton msExcel2Button = new JButton("MS Excel");
		msExcel2Button.setBounds(260, 240, 200, 50);
		mainPanel.add(msExcel2Button);
		
		JButton msAccess2Button = new JButton("MS Access");
		msAccess2Button.setBounds(260, 300, 200, 50);
		mainPanel.add(msAccess2Button);
		
		JButton msWordButton = new JButton("MS Word");
		msWordButton.setBounds(260, 360, 200, 50);
		mainPanel.add(msWordButton);
	
		
		/* ---- ACTION LISTENERS! ---- */

		msExcel1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(queriesList.getSelectedItem() != null){
					int selectedIndex = queriesList.getSelectedIndex();
					
					switch(selectedIndex){
					case 0: controller.openExcel1();
							break;
					case 1: controller.openExcel2();
							break;
					case 2: controller.openExcel3();
							break;
					case 3: controller.openExcel4();
							break;
					case 4: controller.openExcel5();
							break;
					case 5: controller.openExcel6();
							break;
					case 6: controller.openExcel7();
							break;
					}
				}
				}	
		});

		msAccess1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(queriesList.getSelectedItem() != null){
					int selectedIndex = queriesList.getSelectedIndex();
					
					switch(selectedIndex){
					case 0: controller.openAccess1();
							break;
					case 1: controller.openAccess2();
							break;
					case 2: controller.openAccess3();
							break;
					case 3: controller.openAccess4();
							break;
					case 4: controller.openAccess5();
							break;
					case 5: controller.openAccess6();
							break;
					case 6: controller.openAccess7();
							break;
					}
				}
				
			}
		});

		msSqlButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(queriesList.getSelectedItem() != null){
					int selectedIndex = queriesList.getSelectedIndex();
					
					switch(selectedIndex){
					case 0: controller.openSql1();
							break;
					case 1: controller.openSql2();
							break;
					case 2: controller.openSql3();
							break;
					case 3: controller.openSql4();
							break;
					case 4: controller.openSql5();
							break;
					case 5: controller.openSql6();
							break;
					case 6: controller.openSql7();
							break;
					}
				}
				
			}
		});

		msExcel2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(queriesList.getSelectedItem() != null){
					int selectedIndex = queriesList.getSelectedIndex();
					
					switch(selectedIndex){
					case 0: controller.openExcelForm1();
							break;
					case 1: controller.openExcelForm2();
							break;
				
					}
				}
			}
		});             
		
		msAccess2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(queriesList.getSelectedItem() != null){
					int selectedIndex = queriesList.getSelectedIndex();
					
					switch(selectedIndex){
					case 0: controller.openAccessForm1();
							break;
					case 1: controller.openAccessForm2();
							break;
				
					}
				}
			}
		});   
		
		msWordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(queriesList.getSelectedItem() != null){
					int selectedIndex = queriesList.getSelectedIndex();
					
					switch(selectedIndex){
					case 0: controller.openWordForm1();
							break;
					case 1: controller.openWordForm2();
							break;
				
					}
				}
			}
				
		});   
		
		
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/*Standard frame settings! */
		
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);

	}



	/* -------------------------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------------------------------------------------------------------------------- */

}
