package main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class View extends JFrame implements ActionListener {
		
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JScrollPane scrollPane;
    private JLabel fontLabel;
    private JSpinner fontSizeSpinner;
    
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenuItem exitItem; 
	
    public View() {
    	
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setTitle("NLPNotepad"); 
    	this.setSize(1000, 1000);
    	this.setLayout(new FlowLayout());
    	this.setLocationRelativeTo(null);
    	
    	//----Primary Input Area----
    	
    	inputArea = new JTextArea();
        inputArea.setPreferredSize(new Dimension(800,800));
        inputArea.setWrapStyleWord(true);
        inputArea.setFont(new Font("Arial", Font.PLAIN, 14));
    	
    	//----/Primary Input Area----
    
        outputArea = new JTextArea(); 
        inputArea.setPreferredSize(new Dimension(800,800));
        inputArea.setWrapStyleWord(true);
        inputArea.setFont(new Font("Arial", Font.PLAIN, 14));
        
        //----ScrollPane----
        
        scrollPane = new JScrollPane(inputArea);
        scrollPane.setPreferredSize(new Dimension(450,450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        //----/ScrollPane----
        
        //----Labels----
        
        fontLabel = new JLabel("Font Size:");   
        
		//----/Labels----
        
        //----MenuBar----
        
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        
        menuBar.add(fileMenu);
        
        //----/MenuBar----
        
        //----Frame----
        
        this.setJMenuBar(menuBar);
        this.add(fontLabel);
        this.add(scrollPane);
        this.setVisible(true);
        
        //----/Frame----
        
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
