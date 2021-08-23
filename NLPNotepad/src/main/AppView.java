package main;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;

public class AppView extends JFrame {
	
	private JFrame mainFrame;
	private GridBagLayout gridBagLayout;
	private JToolBar toolBarTop;
	private GridBagConstraints gbc_toolBarTop;
	private JTabbedPane inputAreaMain;
	private JScrollPane inputAreaMainScrollPane;
	private JTextArea inputAreaMainTextArea;
	private JTabbedPane outputAreaMain;
	private JScrollPane outputAreaMainScrollPane;
	private JTextArea outputAreaMainTextArea;
	
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	
	private JToolBar toolBarMid;
	private GridBagConstraints gbc_toolBarMid;
	
	private JPanel outputAreaSecondary;
	private GridBagConstraints gbc_outputAreaSecondary;
	
	private JToolBar toolBarBottom;
	private GridBagConstraints gbc_toolBarBottom;
	
	private JMenuBar menuBar;
	private JMenu optionFile;
	private JMenuItem optionImportTextFile;
	private JMenuItem optionSaveTextFile;
	private JMenuItem optionExportOutput;
	private JMenuItem optionExit;
	
	private JMenu optionEdit;
	private JMenu optionTools;
	private JMenu optionSearch;
	private JMenu optionSettings;
	private JMenu optionHelp;
	private JMenu optionAbout;
	
	public AppView(){
		
		//mainFrame
		setMainFrame(new JFrame());
		getMainFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getMainFrame().setBounds(100, 100, 800, 540);
		
		//layoutManager
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{500, 500, 0};
		gridBagLayout.rowHeights = new int[]{30, 205, 0, 110, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getMainFrame().getContentPane().setLayout(gridBagLayout);
		
		//toolBarTop
		toolBarTop = new JToolBar();
		gbc_toolBarTop = new GridBagConstraints();
		gbc_toolBarTop.anchor = GridBagConstraints.WEST;
		gbc_toolBarTop.gridwidth = 2;
		gbc_toolBarTop.insets = new Insets(0, 0, 5, 0);
		gbc_toolBarTop.gridx = 0;
		gbc_toolBarTop.gridy = 0;
		getMainFrame().getContentPane().add(toolBarTop, gbc_toolBarTop);
		
		//inputAreaMain
		inputAreaMain = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_inputAreaMain = new GridBagConstraints();
		gbc_inputAreaMain.fill = GridBagConstraints.BOTH;
		gbc_inputAreaMain.insets = new Insets(0, 5, 5, 5);
		gbc_inputAreaMain.gridx = 0;
		gbc_inputAreaMain.gridy = 1;
		getMainFrame().getContentPane().add(inputAreaMain, gbc_inputAreaMain);
		
		//inputAreaMain: ScrollPane
		inputAreaMainScrollPane = new JScrollPane();
		inputAreaMainScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		inputAreaMainScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		inputAreaMain.addTab("New tab", null, inputAreaMainScrollPane, null);
		
		//inputAreaMain: ScrollPane: TextArea
		inputAreaMainTextArea = new JTextArea();
		inputAreaMainTextArea.setLineWrap(true);
		inputAreaMainTextArea.setAlignmentX(Component.LEFT_ALIGNMENT);
		inputAreaMainTextArea.setWrapStyleWord(true);
		inputAreaMainScrollPane.setViewportView(inputAreaMainTextArea);
		
		//outputAreaMain
		outputAreaMain = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_outputAreaMain = new GridBagConstraints();
		gbc_outputAreaMain.fill = GridBagConstraints.BOTH;
		gbc_outputAreaMain.insets = new Insets(0, 0, 5, 5);
		gbc_outputAreaMain.gridx = 1;
		gbc_outputAreaMain.gridy = 1;
		getMainFrame().getContentPane().add(outputAreaMain, gbc_outputAreaMain);
		
		//outputAreaMain: ScrollPane
		outputAreaMainScrollPane = new JScrollPane();
		outputAreaMainScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		outputAreaMain.addTab("New tab", null, outputAreaMainScrollPane, null);
	
		//outputAreaMain: ScrollPane: TextArea
		outputAreaMainTextArea = new JTextArea();
		outputAreaMainTextArea.setEditable(false);
		outputAreaMainTextArea.setLineWrap(true);
		outputAreaMainTextArea.setWrapStyleWord(true);
		outputAreaMainScrollPane.setViewportView(outputAreaMainTextArea);
		
		//outputAreaMain: Panel 1
		panel_1 = new JPanel();
		outputAreaMain.addTab("New tab", null, panel_1, null);
		
		//outputAreaMain: Panel 2
		panel_2 = new JPanel();
		outputAreaMain.addTab("New tab", null, panel_2, null);
		//outputAreaMain: Panel 3
		panel_3 = new JPanel();
		outputAreaMain.addTab("New tab", null, panel_3, null);
		
		//toolBarMid
		toolBarMid = new JToolBar();
		gbc_toolBarMid = new GridBagConstraints();
		gbc_toolBarMid.anchor = GridBagConstraints.WEST;
		gbc_toolBarMid.gridwidth = 2;
		gbc_toolBarMid.insets = new Insets(0, 0, 5, 0);
		gbc_toolBarMid.gridx = 0;
		gbc_toolBarMid.gridy = 2;
		getMainFrame().getContentPane().add(toolBarMid, gbc_toolBarMid);
		
		//outputAreaSecondary
		outputAreaSecondary = new JPanel();
		gbc_outputAreaSecondary = new GridBagConstraints();
		gbc_outputAreaSecondary.insets = new Insets(0, 0, 5, 0);
		gbc_outputAreaSecondary.gridwidth = 2;
		gbc_outputAreaSecondary.fill = GridBagConstraints.BOTH;
		gbc_outputAreaSecondary.gridx = 0;
		gbc_outputAreaSecondary.gridy = 3;
		getMainFrame().getContentPane().add(outputAreaSecondary, gbc_outputAreaSecondary);
		outputAreaSecondary.setLayout(new BoxLayout(outputAreaSecondary, BoxLayout.X_AXIS));
		
		//toolBarBottom
		toolBarBottom = new JToolBar();
		gbc_toolBarBottom = new GridBagConstraints();
		gbc_toolBarBottom.anchor = GridBagConstraints.WEST;
		gbc_toolBarBottom.gridwidth = 2;
		gbc_toolBarBottom.insets = new Insets(0, 0, 0, 5);
		gbc_toolBarBottom.gridx = 0;
		gbc_toolBarBottom.gridy = 4;
		getMainFrame().getContentPane().add(toolBarBottom, gbc_toolBarBottom);
		
		//menuBar
		menuBar = new JMenuBar();
		getMainFrame().setJMenuBar(menuBar);
		
		//menuBar: Option File
		optionFile = new JMenu("File");
		menuBar.add(optionFile);
		
		//menuBar: Option File: Item optionImportTextFile 
		optionImportTextFile = new JMenuItem("Inport Text File");
		optionFile.add(optionImportTextFile);
		
		//menuBar: Option File: Item optionSaveTextFile
		optionSaveTextFile = new JMenuItem("Save Text File");
		optionFile.add(optionSaveTextFile);
		
		//menuBar: Option File: Item optionExportOutput
		optionExportOutput = new JMenuItem("Export Output");
		optionFile.add(optionExportOutput);
		
		//menuBar: Option File: Item optionExit
		optionExit = new JMenuItem("Exit");
		optionFile.add(optionExit);
		
		//menuBar: Option Edit
		optionEdit = new JMenu("Edit");
		menuBar.add(optionEdit);
		
		//menuBar: Option Tools
		optionTools = new JMenu("Tools");
		menuBar.add(optionTools);
		
		//menuBar: Option Search
		optionSearch = new JMenu("Search");
		menuBar.add(optionSearch);
		
		//menuBar: Option Settings
		optionSettings = new JMenu("Settings");
		menuBar.add(optionSettings);
		
		//menuBar: Option Help
		optionHelp = new JMenu("Help");
		menuBar.add(optionHelp);
		
		//menuBar: Option About
		optionAbout = new JMenu("About");
		menuBar.add(optionAbout);
		
	}
	
	//Getters and Setters
	
	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public GridBagLayout getGridBagLayout() {
		return gridBagLayout;
	}

	public void setGridBagLayout(GridBagLayout gridBagLayout) {
		this.gridBagLayout = gridBagLayout;
	}

	public JToolBar getToolBarTop() {
		return toolBarTop;
	}

	public void setToolBarTop(JToolBar toolBarTop) {
		this.toolBarTop = toolBarTop;
	}

	public GridBagConstraints getGbc_toolBarTop() {
		return gbc_toolBarTop;
	}

	public void setGbc_toolBarTop(GridBagConstraints gbc_toolBarTop) {
		this.gbc_toolBarTop = gbc_toolBarTop;
	}

	public JTabbedPane getInputAreaMain() {
		return inputAreaMain;
	}

	public void setInputAreaMain(JTabbedPane inputAreaMain) {
		this.inputAreaMain = inputAreaMain;
	}

	public JScrollPane getInputAreaMainScrollPane() {
		return inputAreaMainScrollPane;
	}

	public void setInputAreaMainScrollPane(JScrollPane inputAreaMainScrollPane) {
		this.inputAreaMainScrollPane = inputAreaMainScrollPane;
	}

	public JTextArea getInputAreaMainTextArea() {
		return inputAreaMainTextArea;
	}

	public void setInputAreaMainTextArea(JTextArea inputAreaMainTextArea) {
		this.inputAreaMainTextArea = inputAreaMainTextArea;
	}

	public JTabbedPane getOutputAreaMain() {
		return outputAreaMain;
	}

	public void setOutputAreaMain(JTabbedPane outputAreaMain) {
		this.outputAreaMain = outputAreaMain;
	}

	public JScrollPane getOutputAreaMainScrollPane() {
		return outputAreaMainScrollPane;
	}

	public void setOutputAreaMainScrollPane(JScrollPane outputAreaMainScrollPane) {
		this.outputAreaMainScrollPane = outputAreaMainScrollPane;
	}

	public JTextArea getOutputAreaMainTextArea() {
		return outputAreaMainTextArea;
	}

	public void setOutputAreaMainTextArea(JTextArea outputAreaMainTextArea) {
		this.outputAreaMainTextArea = outputAreaMainTextArea;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public JPanel getPanel_2() {
		return panel_2;
	}

	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}

	public JPanel getPanel_3() {
		return panel_3;
	}

	public void setPanel_3(JPanel panel_3) {
		this.panel_3 = panel_3;
	}

	public JToolBar getToolBarMid() {
		return toolBarMid;
	}

	public void setToolBarMid(JToolBar toolBarMid) {
		this.toolBarMid = toolBarMid;
	}

	public GridBagConstraints getGbc_toolBarMid() {
		return gbc_toolBarMid;
	}

	public void setGbc_toolBarMid(GridBagConstraints gbc_toolBarMid) {
		this.gbc_toolBarMid = gbc_toolBarMid;
	}

	public JPanel getOutputAreaSecondary() {
		return outputAreaSecondary;
	}

	public void setOutputAreaSecondary(JPanel outputAreaSecondary) {
		this.outputAreaSecondary = outputAreaSecondary;
	}

	public GridBagConstraints getGbc_outputAreaSecondary() {
		return gbc_outputAreaSecondary;
	}

	public void setGbc_outputAreaSecondary(GridBagConstraints gbc_outputAreaSecondary) {
		this.gbc_outputAreaSecondary = gbc_outputAreaSecondary;
	}

	public JToolBar getToolBarBottom() {
		return toolBarBottom;
	}

	public void setToolBarBottom(JToolBar toolBarBottom) {
		this.toolBarBottom = toolBarBottom;
	}

	public GridBagConstraints getGbc_toolBarBottom() {
		return gbc_toolBarBottom;
	}

	public void setGbc_toolBarBottom(GridBagConstraints gbc_toolBarBottom) {
		this.gbc_toolBarBottom = gbc_toolBarBottom;
	}


	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getOptionFile() {
		return optionFile;
	}

	public void setOptionFile(JMenu optionFile) {
		this.optionFile = optionFile;
	}

	public JMenuItem getOptionImportTextFile() {
		return optionImportTextFile;
	}

	public void setOptionImportTextFile(JMenuItem optionImportTextFile) {
		this.optionImportTextFile = optionImportTextFile;
	}

	public JMenuItem getOptionSaveTextFile() {
		return optionSaveTextFile;
	}

	public void setOptionSaveTextFile(JMenuItem optionSaveTextFile) {
		this.optionSaveTextFile = optionSaveTextFile;
	}

	public JMenuItem getOptionExportOutput() {
		return optionExportOutput;
	}

	public void setOptionExportOutput(JMenuItem optionExportOutput) {
		this.optionExportOutput = optionExportOutput;
	}

	public JMenuItem getOptionExit() {
		return optionExit;
	}

	public void setOptionExit(JMenuItem optionExit) {
		this.optionExit = optionExit;
	}

	public JMenu getOptionEdit() {
		return optionEdit;
	}

	public void setOptionEdit(JMenu optionEdit) {
		this.optionEdit = optionEdit;
	}

	public JMenu getOptionTools() {
		return optionTools;
	}

	public void setOptionTools(JMenu optionTools) {
		this.optionTools = optionTools;
	}

	public JMenu getOptionSearch() {
		return optionSearch;
	}

	public void setOptionSearch(JMenu optionSearch) {
		this.optionSearch = optionSearch;
	}

	public JMenu getOptionSettings() {
		return optionSettings;
	}

	public void setOptionSettings(JMenu optionSettings) {
		this.optionSettings = optionSettings;
	}

	public JMenu getOptionHelp() {
		return optionHelp;
	}

	public void setOptionHelp(JMenu optionHelp) {
		this.optionHelp = optionHelp;
	}

	public JMenu getOptionAbout() {
		return optionAbout;
	}

	public void setOptionAbout(JMenu optionAbout) {
		this.optionAbout = optionAbout;
	}
	
	//addActionListener methods
	void addOptionImportTextFileListener(ActionListener optionImportTextFileListener) {
		
		optionImportTextFile.addActionListener(optionImportTextFileListener);
		
	} 
	
	
}
