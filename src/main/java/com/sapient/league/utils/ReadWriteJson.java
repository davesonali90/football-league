package com.sapient.league.utils;

import java.io.IOException;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ReadWriteJson {
	
	public static <T> List<T> mapFromJson(String json, Class<T[]> clazz) throws JsonParseException,
		JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		List<T> res = (List<T>) Arrays.asList(mapper.readValue(json,  clazz));
		
		return res;
	}
	
	public static String mapToJson(Object obj) throws JsonProcessingException
{
	ObjectMapper mapper = new ObjectMapper();
	return mapper.writeValueAsString(obj);

}
}
