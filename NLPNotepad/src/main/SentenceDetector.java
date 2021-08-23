package main;

public class SentenceDetector {
	
	private String[] sentences;
	private String sentDetectModel;
	
	public SentenceDetector() {	
		
	}
	
	public String[] getSentences() {
		
		return sentences;
	}
	
	public String getSentDetectModel() {
		
		return sentDetectModel;
	}
	
	public void setSentDetectModel(String modelFilePath) {
		
		sentDetectModel = modelFilePath;
	
	} 
	
}
