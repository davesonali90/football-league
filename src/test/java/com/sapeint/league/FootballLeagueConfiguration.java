package com.sapeint.league;

import java.io.IOException;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration.WebFluxConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.league.FootballLeagueApplication;
import com.sapient.league.client.FootballRestTemplate;
import com.sapient.league.service.TeamStandingService;

@SpringBootTest(classes=FootballLeagueConfiguration.class )
@WebAppConfiguration
//@ContextConfiguration(classes=WebFluxConfig.class)
public class FootballLeagueConfiguration {
	 public MockMvc mvc;
	
	@Autowired
	public WebApplicationContext wac;

	@BeforeEach
	public void setUp()
	{
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	public <T> List<T> mapFromJson(String json, Class<T[]> clazz) throws JsonParseException,
	JsonMappingException, IOException
{
	ObjectMapper mapper = new ObjectMapper();
	List<T> res = (List<T>) Arrays.asList(mapper.readValue(json,  clazz));
	
	return res;
}

	public String mapToJson(Object obj) throws JsonProcessingException
	{
	ObjectMapper mapper = new ObjectMapper();
	return mapper.writeValueAsString(obj);
	
	}
}
