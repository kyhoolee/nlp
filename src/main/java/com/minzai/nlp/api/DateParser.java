package com.minzai.nlp.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.joestelmach.natty.DateGroup;
import com.joestelmach.natty.Parser;
import com.minzai.nlp.model.NlpDate;


public class DateParser {

	public static List<NlpDate> parseDate(String source) {
		List<NlpDate> result = new ArrayList<NlpDate>(); 
		
		Parser parser = new Parser();
		List<DateGroup> groups = parser.parse(source);
		for(DateGroup group: groups) {
		  List<Date> dates = group.getDates();
		  for(Date date : dates) {
			  System.out.println(date);
		  }
		  
		  int line = group.getLine();
		  int column = group.getPosition();
		  String matchingValue = group.getText();
		  
		  System.out.println(line + " -- " + column + " -- " + matchingValue + " -- ");
		  
		  System.out.println("\n\n\n---------------------------------");
		  String replaced = source.replace(matchingValue, dates.get(0).toString());
		  NlpDate res = new NlpDate(matchingValue, line, column, dates.get(0), replaced);
		  result.add(res);
		}
		
		return result;
	}
	
	
	public static void main(String[] args){
		DateParser.parseDate("i will go to beach at 3pm in three days and go back in 4pm next sunday");
	}
}
