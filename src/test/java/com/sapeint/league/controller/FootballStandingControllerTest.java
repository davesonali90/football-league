package com.sapeint.league.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sapeint.league.FootballLeagueConfiguration;
import com.sapient.league.dto.TeamStandingDto;
import com.sapient.league.service.TeamStandingService;

public class FootballStandingControllerTest extends FootballLeagueConfiguration {

	@MockBean
	TeamStandingService mockTeamStandingService;
	
	@Test
	public void should_Return_LeagueDetails() throws Exception
	{
		String baseurl = "/api/teamstandings/?country_name=England&league_name=Championship&team_name=Reading";
		TeamStandingDto dto = new TeamStandingDto();
		dto.setCountry("41-England");
		dto.setLeague("149-Championship");
		dto.setTeam("2647-Reading");
		dto.setOverallStanding(1);

		when(mockTeamStandingService.fetchTeamStanding("England",
				"Championship", "Reading")).thenReturn(dto);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(baseurl)
				.accept(MediaType.ALL)).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	@Test
	public void should_Return404_NoLeagueDetails() throws Exception
	{
		String baseurl = "/api/teamstandings/?country_name=England1&league_name=Championship&team_name=Reading";
		TeamStandingDto dto = null;

		when(mockTeamStandingService.fetchTeamStanding("England1",
				"Championship", "Reading")).thenReturn(dto);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(baseurl)
				.accept(MediaType.ALL)).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(404, status);
	}	
}
