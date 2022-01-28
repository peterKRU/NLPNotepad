package main;

import java.awt.Color;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

public class TokenHighlighter extends DefaultHighlighter.DefaultHighlightPainter{
	
	private String a;
	
	public TokenHighlighter(Color color) {
		
		super(color);
		
	}
	
	public void highlightText(JTextComponent textComponent, String[] targetPatterns) {
		
		//removeHighlights(textComponent);
        try {
			Highlighter highlighter = textComponent.getHighlighter();
			Document doc = textComponent.getDocument();
			String text = doc.getText(0, doc.getLength());
			
			for (int i = 0; i < targetPatterns.length; i++) {
				
				int pos = 0;
				
				while((pos = text.indexOf(targetPatterns[i], pos)) >= 0) {
					highlighter.addHighlight(pos, pos + targetPatterns[i].length(), this);
					pos += targetPatterns[i].length();
				}
			}
			
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void removeHighlights(JTextComponent textComponent) {
		
		Highlighter highlighter = textComponent.getHighlighter();
		Highlighter.Highlight[] highlights = highlighter.getHighlights();
		
		for (int i = 0; i < highlights.length; i++) {
			
			if (highlights[i].getPainter() instanceof TokenHighlighter) {
				highlighter.removeHighlight(highlights[i]);
			}
		
		}
		
	}
	
	
}
