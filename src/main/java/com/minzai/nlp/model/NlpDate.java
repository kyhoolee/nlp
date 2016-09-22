package com.minzai.nlp.model;

import java.util.Date;

import org.json.JSONObject;

public class NlpDate {
	
	public String parsed;
	public int line;
	public int column;
	
	public Date date;
	public String replaced;
	
	public NlpDate() {
		
	}
	
	public NlpDate(String parsed, int line, int column, Date date, String replaced) {
		this.parsed = parsed;
		this.line = line;
		this.column = column;
		this.date = date;
		this.replaced = replaced;
	}

	
	public String toString() {
		JSONObject result = new JSONObject();
		try {
			
			result.put("parsed", parsed);
			result.put("line", line);
			result.put("column", column);
			result.put("date", date);
			result.put("replaced", replaced);
		} catch (Exception e) {
		}
		
		return result.toString();
	}

}
