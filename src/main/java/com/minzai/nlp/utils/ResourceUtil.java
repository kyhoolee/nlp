package com.minzai.nlp.utils;

import org.codehaus.jackson.map.ObjectMapper;

public class ResourceUtil {

	private static ObjectMapper _objectMapper = null;
	
	public static ObjectMapper getObjectMapper() {
		if(_objectMapper == null)
			_objectMapper = new ObjectMapper();
		
		return _objectMapper;
		//return new ObjectMapper();
			
	}
}
