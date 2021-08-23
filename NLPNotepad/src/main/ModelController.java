package main;

public class ModelController {
	
	//attributes
	private SentenceDetector sentenceDetector;
	
	//methods
	
	//constructor
	public ModelController() {}
	
	//initMethods
	public static void initSentenceDetector() {
		
		SentenceDetector sentDetect = new SentenceDetector();
		
		System.out.println("SentenceDetectorRunnig...");
		
	}
	
}
