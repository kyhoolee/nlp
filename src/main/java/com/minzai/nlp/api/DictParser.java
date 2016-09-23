package com.minzai.nlp.api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DictParser {
	public static final String SOURCE = "http://tratu.soha.vn";
	public static final String I_SOURCE = "http://browser.anyquiz.info/ai/nlp";
	public static final String HEAD = "<meta name=\"viewport\" charset=\"UTF-8\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\">  <link rel=\"stylesheet\" type=\"text/css\" href=\"http://tratu.soha.vn/skins/monobook/main_min.css?97\"><link rel=\"stylesheet\" type=\"text/css\" href=\"http://tratu.soha.vn/skins/common/shared.css?97\"><link rel=\"stylesheet\" type=\"text/css\" href=\"http://tratu.soha.vn/skins/monobook/style.css?ver=1216\"><link rel=\"stylesheet\" type=\"text/css\" media=\"print\" href=\"/skins/common/commonPrint.css?97\">";
	public static String parseWord(String type, String word) {
		String result = "";
		String head = "<head><title>"+ word +"</title></head>";
		head += "\n" + HEAD;
		try {
			Document doc = Jsoup.connect(SOURCE + "/dict/" + type + "/" + word).get();
			//System.out.println(doc.html());

			Elements content = doc.select("div.main-content  div#content");
			
			try {
				content.select("div#catlinks").remove();
			} catch (Exception ex) {
				
			}
			
			try {
				Elements as = content.select("a");
				for(Element a : as) {
					String href = a.attr("href");
					//System.out.println(href);
					if(href.contains("dict") && !href.contains("index.php")) {
						a.attr("href", I_SOURCE + href);
					} else {
						a.removeAttr("href");
					}
				}
			} catch (Exception ex) {
				
			}
			if(content.html().length() > 0) {
				result = head + "\n" + content.html();
				try {
					Elements elem = content.select("div.noarticletext");
					if(elem.size() > 0) {
						elem.remove();
						result =  head + "Sory, No exact match found for '" + word + "'";
					}
				} catch (Exception ex) {
					
				}
			} else {
				result =  head + "Sory, No exact match found for '" + word + "'";
			}
			
		} catch (Exception e) {
			result =  head + "Sory, No exact match found for '" + word + "'";
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(DictParser.parseWord("en_vi", "hello"));
	}

}
