package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import opennlp.tools.util.InvalidFormatException;

public class Model {	
	
	static StringBuilder fileText = new StringBuilder();
	static String outputText;
	//static String[] sentDetectOutput;
	static ArrayList<String> sentDetectOutput = new ArrayList<String>();
	public static String modelTest = "C:\\ApacheOpenNLP\\OpenNLP_Models\\opennlp-en-ud-ewt-tokens-1.0-1.9.3.bin";
	public static String[] tokenizerOutput;
	
	
	public static void openFileChoser() {
		
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
						fileText.append(line);

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
	
	//File -> Save Text File
	public static void saveFileChoser() {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("."));
		int response = fileChooser.showSaveDialog(null);
		
		if(response == JFileChooser.APPROVE_OPTION) {
			
			File file;
			PrintWriter fileOut = null;
			file = new File(fileChooser.getSelectedFile().getAbsolutePath());
			
			try {
				fileOut = new PrintWriter(file);
				fileOut.println(outputText);
				fileOut.println(fileText.toString());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				fileOut.close();
			}
			
		}
		
		
	}
	//
	
	//Process -> Detect Sentences
	public static void detectSentences() throws InvalidFormatException, IOException{
		
		SentenceDetector.sentenceDetect();
		
	}
	//
	
	public static void tokenizeText(String targetText, String model) throws IOException {
		
		WordTokenizer wordTokenizer = new WordTokenizer(modelTest);
		wordTokenizer.tokenizeTargetText(targetText, model);
		tokenizerOutput = wordTokenizer.getTokenizedText();
		
		
	}
}
