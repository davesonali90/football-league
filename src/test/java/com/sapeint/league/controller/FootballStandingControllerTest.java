package com.sapeint.league.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sapeint.league.FootballLeagueConfiguration;

//@SpringBootTest
public class FootballStandingControllerTest extends FootballLeagueConfiguration {

	@Test
	public void retrieveLeagueDet() throws Exception
	{
		String baseurl = "/api/teamstandings/?country_name=England&league_name=Championship&team_name=Reading";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(baseurl)
				.accept(MediaType.ALL)).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(status, 200);
	}
}
