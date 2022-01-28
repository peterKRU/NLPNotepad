package main;

import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.text.Element;


public class DynamicLineNumberingTextArea extends JTextArea{
	
	private JTextArea textArea;
	
	public DynamicLineNumberingTextArea(JTextArea textArea) {
		
		this.textArea = textArea;
		//Optional:
		//setBackground(Color.LIGHT_GRAY);
		setEditable(false);
		
	}
	
	public void updateLineNumbers() {
		
		String lineNumbers = getLineNumbers();
		setText(lineNumbers);
	}
	
	private String getLineNumbers() {
		
		int caretPosition = textArea.getDocument().getLength();
		Element root = textArea.getDocument().getDefaultRootElement();
		StringBuilder lineNumbersBuilder = new StringBuilder();
		lineNumbersBuilder.append("1").append(System.lineSeparator());
		
		for(int elementIndex = 2; elementIndex < root.getElementIndex(caretPosition) + 2; elementIndex++) {
			lineNumbersBuilder.append(elementIndex).append(System.lineSeparator());
		}
		
		return lineNumbersBuilder.toString();
		
	}
}
