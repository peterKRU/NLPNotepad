package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import opennlp.tools.util.InvalidFormatException;

import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class SystemView {

	private JFrame frame;
	private JTextField consoleField;
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//---Set look and feel---
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemView window = new SystemView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SystemView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frame = new JFrame();
		//!Add feature: Change window size; small frame: frame.setBounds(100, 100, 800, 540);
		frame.setBounds(100, 100, 1400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {100, 500, 500, 10};
		gridBagLayout.rowHeights = new int[]{30, 205, 0, 110, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JToolBar toolBarTop = new JToolBar();
		GridBagConstraints gbc_toolBarTop = new GridBagConstraints();
		gbc_toolBarTop.anchor = GridBagConstraints.WEST;
		gbc_toolBarTop.gridwidth = 2;
		gbc_toolBarTop.insets = new Insets(0, 0, 5, 0);
		gbc_toolBarTop.gridx = 1;
		gbc_toolBarTop.gridy = 0;
		frame.getContentPane().add(toolBarTop, gbc_toolBarTop);
		
		JLabel labelIcons = new JLabel("Icons (WiP)");
		toolBarTop.add(labelIcons);
		
		JPanel fileExplorerPanel = new JPanel();
		fileExplorerPanel.setBorder(null);
		GridBagConstraints gbc_fileExplorerPanel = new GridBagConstraints();
		gbc_fileExplorerPanel.weightx = 0.9;
		gbc_fileExplorerPanel.anchor = GridBagConstraints.WEST;
		gbc_fileExplorerPanel.gridheight = 7;
		gbc_fileExplorerPanel.insets = new Insets(0, 5, 0, 5);
		gbc_fileExplorerPanel.fill = GridBagConstraints.BOTH;
		gbc_fileExplorerPanel.gridx = 0;
		gbc_fileExplorerPanel.gridy = 0;
		frame.getContentPane().add(fileExplorerPanel, gbc_fileExplorerPanel);
		fileExplorerPanel.setLayout(new BorderLayout(0, 0));
		
		fileExplorerPanel.setVisible(true);
		
		JTree fileExplorerTree = new JTree();
		fileExplorerTree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Folder") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Subfolder");
						node_1.add(new DefaultMutableTreeNode("OLOLO"));
						node_1.add(new DefaultMutableTreeNode("ALALA"));
						node_1.add(new DefaultMutableTreeNode("ELELE"));
						node_1.add(new DefaultMutableTreeNode("LOLOLO"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Subfolder 2");
						node_1.add(new DefaultMutableTreeNode("OLOLO"));
						node_1.add(new DefaultMutableTreeNode("OLO"));
						node_1.add(new DefaultMutableTreeNode("OL"));
						node_1.add(new DefaultMutableTreeNode("OLOLO"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Subfolder 3");
						node_1.add(new DefaultMutableTreeNode("ELELE"));
						node_1.add(new DefaultMutableTreeNode("ELE"));
						node_1.add(new DefaultMutableTreeNode("ELELE"));
						node_1.add(new DefaultMutableTreeNode("ALALA"));
					add(node_1);
				}
			}
		));
		fileExplorerPanel.add(fileExplorerTree, BorderLayout.CENTER);
		
		JTabbedPane inputAreaMain = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_inputAreaMain = new GridBagConstraints();
		gbc_inputAreaMain.fill = GridBagConstraints.BOTH;
		gbc_inputAreaMain.insets = new Insets(0, 5, 5, 5);
		gbc_inputAreaMain.gridx = 1;
		gbc_inputAreaMain.gridy = 1;
		frame.getContentPane().add(inputAreaMain, gbc_inputAreaMain);
		
		JScrollPane inputAreaMainScrollPane1 = new JScrollPane();
		inputAreaMainScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		inputAreaMainScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		inputAreaMain.addTab("Input Text Area", null, inputAreaMainScrollPane1, null);
		
		JTextArea inputAreaMainTextArea1 = new JTextArea();
		inputAreaMainTextArea1.setLineWrap(true);
		inputAreaMainTextArea1.setAlignmentX(Component.LEFT_ALIGNMENT);
		inputAreaMainTextArea1.setWrapStyleWord(true);
		//textArea.setLineWrap(true);
		inputAreaMainScrollPane1.setViewportView(inputAreaMainTextArea1);
		
		JScrollPane inputAreaMainScrollPane2 = new JScrollPane();
		inputAreaMainScrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		inputAreaMainScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		inputAreaMain.addTab("Tab 2", null, inputAreaMainScrollPane2, null);
		
		JTextArea inputAreaMainTextArea2 = new JTextArea();
		inputAreaMainTextArea2.setWrapStyleWord(true);
		inputAreaMainTextArea2.setLineWrap(true);
		inputAreaMainTextArea2.setAlignmentX(0.0f);
		inputAreaMainScrollPane2.setViewportView(inputAreaMainTextArea2);
		
		JTabbedPane outputAreaMain = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_outputAreaMain = new GridBagConstraints();
		gbc_outputAreaMain.fill = GridBagConstraints.BOTH;
		gbc_outputAreaMain.insets = new Insets(0, 0, 5, 0);
		gbc_outputAreaMain.gridx = 2;
		gbc_outputAreaMain.gridy = 1;
		frame.getContentPane().add(outputAreaMain, gbc_outputAreaMain);
		
		JScrollPane outputAreaMainScrollPane = new JScrollPane();
		outputAreaMainScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		outputAreaMain.addTab("Sentences", null, outputAreaMainScrollPane, null);
		
		JTextArea outputAreaMainTextArea = new JTextArea();
		outputAreaMainTextArea.setEditable(false);
		outputAreaMainTextArea.setLineWrap(true);
		outputAreaMainTextArea.setWrapStyleWord(true);
		outputAreaMainScrollPane.setViewportView(outputAreaMainTextArea);
		
		JScrollPane outputAreaTokens = new JScrollPane();
		outputAreaTokens.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		outputAreaMain.addTab("Tokens", null, outputAreaTokens, null);
		
		JTextArea outputAreaTokensTextArea = new JTextArea();
		outputAreaTokensTextArea.setEditable(false);
		outputAreaTokensTextArea.setLineWrap(true);
		outputAreaTokensTextArea.setWrapStyleWord(true);
		outputAreaTokens.setViewportView(outputAreaTokensTextArea);
		
		JPanel panel_2 = new JPanel();
		outputAreaMain.addTab("Tab 2", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		outputAreaMain.addTab("Tab 3", null, panel_3, null);
		
		JToolBar toolBarMid = new JToolBar();
		GridBagConstraints gbc_toolBarMid = new GridBagConstraints();
		gbc_toolBarMid.fill = GridBagConstraints.HORIZONTAL;
		gbc_toolBarMid.anchor = GridBagConstraints.WEST;
		gbc_toolBarMid.gridwidth = 4;
		gbc_toolBarMid.insets = new Insets(0, 0, 5, 0);
		gbc_toolBarMid.gridx = 1;
		gbc_toolBarMid.gridy = 2;
		frame.getContentPane().add(toolBarMid, gbc_toolBarMid);
		
		JCheckBox toggleFileExplorerPanel = new JCheckBox("Show/Hide File Explorer");
		toggleFileExplorerPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int[] compressedColumnWidths = new int[] {0, 500, 500, 10};
				int[] expandedColumnWidths = new int[] {100, 500, 500, 10};
				
				if(toggleFileExplorerPanel.isSelected()) {
					fileExplorerPanel.setVisible(true);
					gridBagLayout.columnWidths = expandedColumnWidths;
				}
				else {
					fileExplorerPanel.setVisible(false);
					//gridBagLayout.columnWidths(compressedColumnWidths);
					gridBagLayout.columnWidths = compressedColumnWidths;
				}
			
			}
		});
		toggleFileExplorerPanel.setHorizontalAlignment(SwingConstants.CENTER);
		toggleFileExplorerPanel.setSelected(true);
		toolBarMid.add(toggleFileExplorerPanel);
		
		JPanel consoleArea = new JPanel();
		GridBagConstraints gbc_consoleArea = new GridBagConstraints();
		gbc_consoleArea.insets = new Insets(0, 5, 5, 0);
		gbc_consoleArea.gridwidth = 2;
		gbc_consoleArea.fill = GridBagConstraints.BOTH;
		gbc_consoleArea.gridx = 1;
		gbc_consoleArea.gridy = 3;
		frame.getContentPane().add(consoleArea, gbc_consoleArea);
		consoleArea.setLayout(new BoxLayout(consoleArea, BoxLayout.X_AXIS));
		
		JScrollPane consoleAreaMainScrollPane1 = new JScrollPane();
		consoleAreaMainScrollPane1.setAlignmentY(Component.TOP_ALIGNMENT);
		consoleAreaMainScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		consoleAreaMainScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		consoleArea.add(consoleAreaMainScrollPane1);
		
		JTextArea logMainArea = new JTextArea();
		logMainArea.setEditable(false);
		logMainArea.setLineWrap(true);
		consoleAreaMainScrollPane1.setViewportView(logMainArea);
		//Fix later: Innit console in another class
		Console cns = new Console();
		logMainArea.append(Console.log("info", "version") + "\n");
		logMainArea.append(Console.log("state", "run") + "\n");
		
		JLabel labelConsole = new JLabel("Console");
		GridBagConstraints gbc_labelConsole = new GridBagConstraints();
		gbc_labelConsole.anchor = GridBagConstraints.WEST;
		gbc_labelConsole.insets = new Insets(0, 5, 5, 5);
		gbc_labelConsole.gridx = 1;
		gbc_labelConsole.gridy = 4;
		frame.getContentPane().add(labelConsole, gbc_labelConsole);
		
		consoleField = new JTextField();
		GridBagConstraints gbc_consoleField = new GridBagConstraints();
		gbc_consoleField.ipady = 20;
		gbc_consoleField.gridwidth = 2;
		gbc_consoleField.insets = new Insets(0, 5, 5, 0);
		gbc_consoleField.fill = GridBagConstraints.HORIZONTAL;
		gbc_consoleField.gridx = 1;
		gbc_consoleField.gridy = 5;
		frame.getContentPane().add(consoleField, gbc_consoleField);
		consoleField.setColumns(10);
		
		JToolBar toolBarBottom = new JToolBar();
		GridBagConstraints gbc_toolBarBottom = new GridBagConstraints();
		gbc_toolBarBottom.anchor = GridBagConstraints.WEST;
		gbc_toolBarBottom.gridwidth = 2;
		gbc_toolBarBottom.gridx = 1;
		gbc_toolBarBottom.gridy = 6;
		frame.getContentPane().add(toolBarBottom, gbc_toolBarBottom);
		
		JLabel lblNewLabel_1 = new JLabel("App Version");
		toolBarBottom.add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu optionFile = new JMenu("File");
		menuBar.add(optionFile);
					
		//File -> Open Text File
		JMenuItem optionOpenTextFile = new JMenuItem("Open Text File");
		optionOpenTextFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				logMainArea.append(Console.log("state", "start") + "\n");
				logMainArea.append(Console.log("process", "openFile") + "\n");
				
				Model.openFileChoser();
				inputAreaMainTextArea1.append(Model.fileText.toString());
				
				logMainArea.append(Console.log("state", "done") + "\n");
			}
		});
		optionFile.add(optionOpenTextFile);
		//
		
		//File -> Save Text File
		JMenuItem optionSaveTextFile = new JMenuItem("Save Text File");
		optionSaveTextFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//! Fix later: Remove doubled output
				Model.outputText = inputAreaMainTextArea1.getText();
				
				Model.saveFileChoser();
			
			}
		});
		optionFile.add(optionSaveTextFile);
		//
		
		//File -> Refresh
		JMenuItem optionRefresh = new JMenuItem("Refresh");
		optionRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				logMainArea.setText("");
				logMainArea.append(Console.log("info", "version") + "\n");
				logMainArea.append(Console.log("state", "run") + "\n");
			}
		});
		optionFile.add(optionRefresh);
		//
		
		//File -> Exit
		JMenuItem optionExit = new JMenuItem("Exit");
		optionExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			
			}
		});
		optionFile.add(optionExit);
		//
		
		
		JMenu optionProcess = new JMenu("Process");
		menuBar.add(optionProcess);
		
		//Process -> Tokenize Text
		JMenuItem optionTokenizeText = new JMenuItem("Tokenize Text");
		optionTokenizeText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					Model.tokenizeText(Model.fileText.toString(), Model.modelTest);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for(int i = 0; i < Model.tokenizerOutput.length; i++) {
					outputAreaTokensTextArea.append("[" + i + "]" + Model.tokenizerOutput[i] + " ");	
				}
				outputAreaMain.setSelectedIndex(1);
				
			}
		});
		optionProcess.add(optionTokenizeText);
		//
		
		//Process -> Detect sentences
		JMenuItem optionSentDetect = new JMenuItem("Detect Sentences");
		optionSentDetect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Model.detectSentences();
				} catch (InvalidFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				for(int i = 0; i < Model.sentDetectOutput.size(); i++) {
					outputAreaMainTextArea.append(Model.sentDetectOutput.get(i) + "\n");
				}
				
				outputAreaMain.setSelectedIndex(0);
				
			}
		});
		optionProcess.add(optionSentDetect);
		//
		
		JMenu optionTools = new JMenu("Tools");
		menuBar.add(optionTools);
		
		JMenu optionSearch = new JMenu("Search");
		menuBar.add(optionSearch);
		
		JMenu optionSettings = new JMenu("Settings");
		menuBar.add(optionSettings);
		
		JMenu optionHelp = new JMenu("Help");
		menuBar.add(optionHelp);
		
		JMenu optionAbout = new JMenu("About");
		menuBar.add(optionAbout);
	
		
	
	}
	
		
		
		
		
}
