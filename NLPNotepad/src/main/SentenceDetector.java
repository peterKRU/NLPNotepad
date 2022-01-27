package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.InvalidFormatException; 

public class SentenceDetector {
	
	
	public static void sentenceDetect() throws InvalidFormatException, IOException{
		
		 //define test paragraph
		 String paragraph = Model.fileText.toString();
		
		 //refer to the ml model
		 //!Fix later: change path to newest model
		 //!Fix later: create option for choosing a ML model
	     InputStream is = new FileInputStream("C:\\ApacheOpenNLP\\OpenNLP_Models\\opennlp-en-ud-ewt-sentence-1.0-1.9.3.bin");
	     SentenceModel model = new SentenceModel(is);
	     
	     //load model
	     SentenceDetectorME sdetector = new SentenceDetectorME(model);
	     
	     //detect sentences in paragraph
	     String sentences[] = sdetector.sentDetect(paragraph);
	     
	     //print sentences
	        for(int i=0;i<sentences.length;i++){
	                
	            Model.sentDetectOutput.add("[" + i + "]" + sentences[i]);
	            
	        }
	     
       is.close();
		
		
	}
	
	
}
