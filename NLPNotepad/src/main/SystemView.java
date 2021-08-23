package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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

public class SystemView {

	private JFrame frame;
		
	
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
		frame.setBounds(100, 100, 800, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{500, 500, 0};
		gridBagLayout.rowHeights = new int[]{30, 205, 0, 110, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JToolBar toolBarTop = new JToolBar();
		GridBagConstraints gbc_toolBarTop = new GridBagConstraints();
		gbc_toolBarTop.anchor = GridBagConstraints.WEST;
		gbc_toolBarTop.gridwidth = 2;
		gbc_toolBarTop.insets = new Insets(0, 0, 5, 0);
		gbc_toolBarTop.gridx = 0;
		gbc_toolBarTop.gridy = 0;
		frame.getContentPane().add(toolBarTop, gbc_toolBarTop);
		
		JTabbedPane inputAreaMain = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_inputAreaMain = new GridBagConstraints();
		gbc_inputAreaMain.fill = GridBagConstraints.BOTH;
		gbc_inputAreaMain.insets = new Insets(0, 5, 5, 5);
		gbc_inputAreaMain.gridx = 0;
		gbc_inputAreaMain.gridy = 1;
		frame.getContentPane().add(inputAreaMain, gbc_inputAreaMain);
		
		JScrollPane inputAreaMainScrollPane = new JScrollPane();
		inputAreaMainScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		inputAreaMainScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		inputAreaMain.addTab("New tab", null, inputAreaMainScrollPane, null);
		
		JTextArea inputAreaMainTextArea = new JTextArea();
		inputAreaMainTextArea.setLineWrap(true);
		inputAreaMainTextArea.setAlignmentX(Component.LEFT_ALIGNMENT);
		inputAreaMainTextArea.setWrapStyleWord(true);
		//textArea.setLineWrap(true);
		inputAreaMainScrollPane.setViewportView(inputAreaMainTextArea);
		
		JTabbedPane outputAreaMain = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_outputAreaMain = new GridBagConstraints();
		gbc_outputAreaMain.fill = GridBagConstraints.BOTH;
		gbc_outputAreaMain.insets = new Insets(0, 0, 5, 0);
		gbc_outputAreaMain.gridx = 1;
		gbc_outputAreaMain.gridy = 1;
		frame.getContentPane().add(outputAreaMain, gbc_outputAreaMain);
		
		JScrollPane outputAreaMainScrollPane = new JScrollPane();
		outputAreaMainScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		outputAreaMain.addTab("New tab", null, outputAreaMainScrollPane, null);
		
		JTextArea outputAreaMainTextArea = new JTextArea();
		outputAreaMainTextArea.setEditable(false);
		outputAreaMainTextArea.setLineWrap(true);
		outputAreaMainTextArea.setWrapStyleWord(true);
		outputAreaMainScrollPane.setViewportView(outputAreaMainTextArea);
		
		JPanel panel_1 = new JPanel();
		outputAreaMain.addTab("New tab", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		outputAreaMain.addTab("New tab", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		outputAreaMain.addTab("New tab", null, panel_3, null);
		
		JToolBar toolBarMid = new JToolBar();
		GridBagConstraints gbc_toolBarMid = new GridBagConstraints();
		gbc_toolBarMid.anchor = GridBagConstraints.WEST;
		gbc_toolBarMid.gridwidth = 2;
		gbc_toolBarMid.insets = new Insets(0, 0, 5, 0);
		gbc_toolBarMid.gridx = 0;
		gbc_toolBarMid.gridy = 2;
		frame.getContentPane().add(toolBarMid, gbc_toolBarMid);
		
		JPanel outputAreaSecondary = new JPanel();
		GridBagConstraints gbc_outputAreaSecondary = new GridBagConstraints();
		gbc_outputAreaSecondary.insets = new Insets(0, 0, 5, 0);
		gbc_outputAreaSecondary.gridwidth = 2;
		gbc_outputAreaSecondary.fill = GridBagConstraints.BOTH;
		gbc_outputAreaSecondary.gridx = 0;
		gbc_outputAreaSecondary.gridy = 3;
		frame.getContentPane().add(outputAreaSecondary, gbc_outputAreaSecondary);
		outputAreaSecondary.setLayout(new BoxLayout(outputAreaSecondary, BoxLayout.X_AXIS));
		
		JToolBar toolBarBottom = new JToolBar();
		GridBagConstraints gbc_toolBarBottom = new GridBagConstraints();
		gbc_toolBarBottom.anchor = GridBagConstraints.WEST;
		gbc_toolBarBottom.gridwidth = 2;
		gbc_toolBarBottom.insets = new Insets(0, 0, 0, 5);
		gbc_toolBarBottom.gridx = 0;
		gbc_toolBarBottom.gridy = 4;
		frame.getContentPane().add(toolBarBottom, gbc_toolBarBottom);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu optionFile = new JMenu("File");
		menuBar.add(optionFile);
		
		JMenuItem optionImportTextFile = new JMenuItem("Inport Text File");
		optionFile.add(optionImportTextFile);
		
		
		
		JMenuItem optionSaveTextFile = new JMenuItem("Save Text File");
		optionFile.add(optionSaveTextFile);
		
		JMenuItem optionExportOutput = new JMenuItem("Export Output");
		optionFile.add(optionExportOutput);
		
		JMenuItem optionExit = new JMenuItem("Exit");
		optionFile.add(optionExit);
		
		JMenu optionEdit = new JMenu("Edit");
		menuBar.add(optionEdit);
		
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
