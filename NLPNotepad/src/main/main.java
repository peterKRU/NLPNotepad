package main;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class main {

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
		
		//Initialize AppView
		
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppView window = new AppView();
					window.getMainFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		*/
		
		
		System.out.println("View running...");
		
		ModelController modelController = new ModelController();
		System.out.println("Model running...");
		
		AppView appView = new AppView();
		appView.getMainFrame().setVisible(true);
		
		SystemController systemControler = new SystemController(appView, modelController);
		System.out.println("Controller running...");
		
	}

}
