package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SystemController implements ActionListener{
	
	private AppView appView;
	private ModelController modelController;
	
	public SystemController(AppView appView, ModelController modelController) {
		
		this.appView = appView;
		this.modelController = modelController;
		
		this.appView.addOptionImportTextFileListener(new OptionImportTextFileListener());
		
	}
	
	class OptionImportTextFileListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
			fileChooser.setFileFilter(filter);
			
			int response = fileChooser.showOpenDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				Scanner fileIn = null;
				
				try {
					
					fileIn = new Scanner(file);
					if(file.isFile()) {
						while(fileIn.hasNextLine()) {
							String line = fileIn.nextLine()+"\n";
							//textArea.append(line);
							appView.getInputAreaMainTextArea().append(line);	
						}
					}
					
				} catch(FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				finally {
					fileIn.close();
				}
				
				
			}
			
			
		}	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		

		
	}
	
	
	


}
