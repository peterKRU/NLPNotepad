package main;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFinder {
	
	private String currentPattern;
	private ArrayList<String> resultsFound = new ArrayList<>();
	private ArrayList<int[]> resultsIndexes = new ArrayList<>();
	
	public RegexFinder() {
		//Empty constructor
	}
	
	public void findPattern(String pattern, String targetText) {
		
		Pattern newRegexPattern = Pattern.compile(pattern);
		Matcher regexMatcher = newRegexPattern.matcher(targetText);
		
		while(regexMatcher.find()) {
			
			int[] resultsPositions = new int[2];
			if(regexMatcher.group().length() != 0) {
				System.out.println(regexMatcher.group().trim() + " " + "Start: " + regexMatcher.start());
				resultsFound.add(regexMatcher.group());
				resultsPositions[0] = regexMatcher.start();
				resultsPositions[1] = regexMatcher.end();
				resultsIndexes.add(resultsPositions);				
			}
		}
		
	}
	
	public String getCurrentPattern() {
		return currentPattern;
	}

	public void setCurrentPattern(String currentPattern) {
		this.currentPattern = currentPattern;
	}

	public ArrayList<String> getResultsFound() {
		return resultsFound;
	}

	public void setResultsFound(ArrayList<String> resultsFound) {
		this.resultsFound = resultsFound;
	}

	public ArrayList<int[]> getResultsIndexes() {
		return resultsIndexes;
	}

	public void setResultsIndexes(ArrayList<int[]> resultsIndexes) {
		this.resultsIndexes = resultsIndexes;
	}
	
	
}
