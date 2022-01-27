package main;

import java.util.HashMap;

public class Console {
	
	private static HashMap<String, String> processLogs = new HashMap<String, String>();
	private static HashMap<String, String> stateLogs = new HashMap<String, String>();
	private static HashMap<String, String> infoLogs = new HashMap<String, String>();
	
	private static String currentLog;
	
	public Console() {
		
		currentLog = infoLogs.get("version");
		
		//processLogs = new HashMap<String, String>();
		processLogs.put("sentDetect", "Detecting sentences...");
		processLogs.put("openFile", "Opening file...");
		processLogs.put("saveFile", "Saving file...");
		
		//stateLogs = new HashMap<String, String>();
		stateLogs.put("run", "Application running...");
		stateLogs.put("start", "Processing...");
		stateLogs.put("done", "Done.");
		
		//infoLogs = new HashMap<String, String>();
		infoLogs.put("version", "Version 0.1");
		infoLogs.put("invalidLog", "Invalid log!");
		infoLogs.put("invalidProcess", "Invalid process!");
		infoLogs.put("invalidState", "Invalid state!");
		infoLogs.put("invalidInfo", "Invalid info!");
		
	}
	
	
	public static String log(String logType, String logKey) {
		
		if(logType == "process") {
			if(processLogs.containsKey(logKey)) {
				currentLog = processLogs.get(logKey);
			}
			else {
				currentLog = infoLogs.get("invalidProcess");
			}
		}
		else if(logType == "state") {
			if(stateLogs.containsKey(logKey)) {
				currentLog = stateLogs.get(logKey);
			}
			else {
				currentLog = infoLogs.get("invalidState");
			}
		}
		else if(logType == "info") {
			if(infoLogs.containsKey(logKey)) {
				currentLog = infoLogs.get(logKey);
			}
			else {
				currentLog = infoLogs.get("invalidInfo");
			}
		}
		else {
			currentLog = infoLogs.get("invalidLog");
		}
		
		return currentLog;
	
	}
	

	
	
}
