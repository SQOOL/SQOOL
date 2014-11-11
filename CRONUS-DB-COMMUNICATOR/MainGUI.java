package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.Controller;

public class MainGUI {
	
	public JFrame mainFrame = new JFrame("CRONUS DB COMMUNICATOR");
	private CardLayout cardLayout = new CardLayout(); 
	private Container contentPane = mainFrame.getContentPane(); 
	
	Controller controller;
	
	public MainGUI() throws SQLException {
		
		controller = new Controller();

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		mainFrame.setSize(1000, 600);

		contentPane.setLayout(cardLayout);
		contentPane.setPreferredSize(new Dimension(mainFrame.getWidth(), mainFrame.getHeight())); 
		
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------------- Creates the MAIN panel! -------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/* ---- PANEL! ---- */

		final JPanel mainPanel = new JPanel(); 
		mainPanel.setLayout(null); 
		contentPane.add(mainPanel, "mainPanel"); 

		/* ------ JTABLE ------ */
		
		String tableColumns[] = {"Column 1", "Column 2", "Column 3", "Column 4", "Column 5"}; 
		final DefaultTableModel dataModel = new DefaultTableModel(tableColumns, 0); 
		final JTable dataTable = new JTable(dataModel); 
		dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 

		final JScrollPane tablePane = new JScrollPane(dataTable); 
		tablePane.setBounds(10, 10, 980, 200); 
		mainPanel.add(tablePane); 
		
		/* ---- LABELS! ---- */
		
		JLabel employeeLabel = new JLabel();
		employeeLabel.setText("EMPLOYEE");
		employeeLabel.setBounds(250, 220, 200, 50);
		mainPanel.add(employeeLabel);
		
		JLabel contentLabel = new JLabel();
		contentLabel.setText("CONTENT");
		contentLabel.setBounds(140, 260, 200, 50);
		mainPanel.add(contentLabel);
		
		JLabel empMetadataLabel = new JLabel();
		empMetadataLabel.setText("METADATA");
		empMetadataLabel.setBounds(360, 260, 200, 50);
		mainPanel.add(empMetadataLabel);
		
		JLabel cronusLabel = new JLabel();
		cronusLabel.setText("CRONUS");
		cronusLabel.setBounds(700, 220, 200, 50);
		mainPanel.add(cronusLabel);
		
		JLabel cronusMetadataLabel = new JLabel();
		cronusMetadataLabel.setText("METADATA");
		cronusMetadataLabel.setBounds(700, 260, 200, 50);
		mainPanel.add(cronusMetadataLabel);

		
		/* ---- BUTTONS! SET 1! ---- */

		JButton empContButton = new JButton("Get employees"); 
		empContButton.setBounds(60, 320, 200, 50); 
		mainPanel.add(empContButton);

		JButton absContButton = new JButton("Get absence");
		absContButton.setBounds(60, 380, 200, 50);
		mainPanel.add(absContButton);

		JButton relContButton = new JButton("Get relatives");
		relContButton.setBounds(60, 440, 200, 50);
		mainPanel.add(relContButton);

		JButton qualiContButton = new JButton("Get quality");
		qualiContButton.setBounds(60, 500, 200, 50);
		mainPanel.add(qualiContButton);
		
		JButton empMDButton = new JButton("Show employee metadata"); 
		empMDButton.setBounds(280, 320, 200, 50); 
		mainPanel.add(empMDButton); 

		JButton absMDButton = new JButton("Show absence metadata");
		absMDButton.setBounds(280, 380, 200, 50);
		mainPanel.add(absMDButton);

		JButton relMDButton = new JButton("Show relatives metadata");
		relMDButton.setBounds(280, 440, 200, 50);
		mainPanel.add(relMDButton);

		JButton qualiMDButton = new JButton("Show quality metadata");
		qualiMDButton.setBounds(280, 500, 200, 50);
		mainPanel.add(qualiMDButton);

		/* ---- BUTTONS! SET 2! ---- */
		
		JButton DBKeysButton = new JButton("Show database keys");
		DBKeysButton.setBounds(520, 320, 200, 50);
		mainPanel.add(DBKeysButton);
		
		JButton DBindexButton = new JButton("Show database indexes");
		DBindexButton.setBounds(520, 380, 200, 50);
		mainPanel.add(DBindexButton);
		
		JButton tableConstrButton = new JButton("Show table constraints");
		tableConstrButton.setBounds(520, 440, 200, 50);
		mainPanel.add(tableConstrButton);
		
		JButton tableMostRowsButton = new JButton("Show table with most rows");
		tableMostRowsButton.setBounds(520, 500, 200, 50);
		mainPanel.add(tableMostRowsButton);
		
		JButton allTablesButton = new JButton("Show all tables");
		allTablesButton.setBounds(740, 320, 200, 50);
		mainPanel.add(allTablesButton);
		
		JButton allTables2Button = new JButton("Show all tables (2)");
		allTables2Button.setBounds(740, 380, 200, 50);
		mainPanel.add(allTables2Button);
		
		JButton empColumnButton = new JButton("Show employee columns");
		empColumnButton.setBounds(740, 440, 200, 50);
		mainPanel.add(empColumnButton);
		
		JButton empColumn2Button = new JButton("Show employee columns (2)");
		empColumn2Button.setBounds(740, 500, 200, 50);
		mainPanel.add(empColumn2Button);
		

		
		/* ---- ACTION LISTENERS! ---- */

		empContButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {
					String tableColumn[] = {"Employee NO:", "First name:", "Last name:", "Initials:", "Job title:", "Search name:"};
					dataModel.setColumnIdentifiers(tableColumn);
					dataTable.setModel(controller.getEmployeeContent(dataModel));
				} catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
				} 				
			}
		});

		absContButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {
					String tableColumn[] = {"Employee NO:", "From (date):", "To (date):", "Cause of absence:", "Description:"};
					dataModel.setColumnIdentifiers(tableColumn);
					dataTable.setModel(controller.getAbsenceContent(dataModel));
				}
				catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
				}
			}
		});

		relContButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {
					String tableColumn[] = {"Employee NO:", "Relative code:", "First name:", "Last name:", "Birth date:"};
					dataModel.setColumnIdentifiers(tableColumn);
					dataTable.setModel(controller.getRelativeContent(dataModel));
				}
				catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
				}
			}
		});

		qualiContButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {
					String tableColumn[] = {"Employee NO:", "Qualification code:", "From date:", "To date:", "Description:"};
					dataModel.setColumnIdentifiers(tableColumn);
					dataTable.setModel(controller.getQualificationContent(dataModel));
				}
				catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
				}
			}
		});             
		
		empMDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {

					String tableColumn[] = {"Table catalog:", "Table schema:", "Table name:", "Column name:", "Data type:"};
					dataModel.setColumnIdentifiers(tableColumn);					
					dataTable.setModel(controller.getEmployeeMetaData(dataModel));
				}
				catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
				}
			}
		});   
		
		absMDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {
					String tableColumn[] = {"Table catalog:", "Table schema:", "Table name", "Column name", "Data type"};
					dataModel.setColumnIdentifiers(tableColumn);
					dataTable.setModel(controller.getAbsenceMetadata(dataModel));
				}
				catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
				}
			}
		});   
		
		relMDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {
					String tableColumn[] = {"Table catalog:", "Table schema:", "Table name", "Column name", "Data type"};
					dataModel.setColumnIdentifiers(tableColumn);
					dataTable.setModel(controller.getRelativeMetadata(dataModel));
				}
				catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
				}
			}
		});   
		
		qualiMDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {
					String tableColumn[] = {"Table catalog:", "Table schema:", "Table name:", "Column name:", "Data type:"};
					dataModel.setColumnIdentifiers(tableColumn);
					dataTable.setModel(controller.getQualificationMetadata(dataModel));
				}
				catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
				}
			}
		});   
		
		DBKeysButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {
					String tableColumn[] = {"Name of constraint:", "Schema name:", "Table name:", "Constraint type:"};
					dataModel.setColumnIdentifiers(tableColumn);
					dataTable.setModel(controller.getDatabaseKeys(dataModel));
				}
				catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
				}
			}
		});   
		
		DBindexButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {
					String tableColumn[] = {"Table name:", "Index name:", "Index type:"};
					dataModel.setColumnIdentifiers(tableColumn);
					dataTable.setModel(controller.getDatabaseIndexes(dataModel));
				}
				catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
				}
			}
		});   
		
		tableConstrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {
					String tableColumn[] = {"Constraint name:", "Constraint type:", "Table name:"};
					dataModel.setColumnIdentifiers(tableColumn);
					dataTable.setModel(controller.getTableConstraints(dataModel));
				}
				catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
				}
			}
		});   
		
		allTablesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {
					String tableColumn[] = {"Table catalog:", "Table schema:", "Table name:", "Table type:"};
					dataModel.setColumnIdentifiers(tableColumn);
					dataTable.setModel(controller.getAllTables(dataModel));
				}
				catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
				}
			}
		});   
		
		allTables2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {
					String tableColumn[] = {"Table name:", "Object id:", "Type description:"};
					dataModel.setColumnIdentifiers(tableColumn);
					dataTable.setModel(controller.getAllTables2(dataModel));
				}
				catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
				}
			}
		});  
		
		empColumnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {
					String tableColumn[] = {"Column names:"};
					dataModel.setColumnIdentifiers(tableColumn);
					dataTable.setModel(controller.getAllColumns(dataModel));
				}
				catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
				}
			}
		});   
		
		empColumn2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {
					String tableColumn[] = {"Column names:"};
					dataModel.setColumnIdentifiers(tableColumn);
					dataTable.setModel(controller.getAllColumns2(dataModel));
				}
				catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
				}
			}
		});  
		
		tableMostRowsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModel.setRowCount(0);
				try {
					String tableColumn[] = {"Table name:", "Row count:"};
					dataModel.setColumnIdentifiers(tableColumn);
					dataTable.setModel(controller.getTableMostRows(dataModel));
				}
				catch (SQLException SQLErr) {
					SQLErr.printStackTrace();
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
