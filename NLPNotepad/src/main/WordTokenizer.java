package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class WordTokenizer {
	
	private String[] tokenizedText;
	
	//!Add later: Token probabilities function
	//private String[] tokenProbs;
	
	private String model;
	
	//public String modelTest = "C:\\ApacheOpenNLP\\OpenNLP_Models\\opennlp-en-ud-ewt-tokens-1.0-1.9.3.bin";
	
	public WordTokenizer(String model) {
		
		this.model = model;
		
	}
	
	//Method area
	public void tokenizeTargetText(String targetText, String model) throws IOException {
		
		FileInputStream modelIn = new FileInputStream(model);
		TokenizerModel currentModel = new TokenizerModel(modelIn);
		TokenizerME tokenizer = new TokenizerME(currentModel);
		String tokens[] = tokenizer.tokenize(targetText);
		
		tokenizedText = tokens;
		modelIn.close();
		//!Add later: token probabilities.
		
	}
	
	//Getters and Setters area
	public String[] getTokenizedText() {
		return tokenizedText;
	}

	public void setTokenizedText(String[] tokenizedText) {
		this.tokenizedText = tokenizedText;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	

}
