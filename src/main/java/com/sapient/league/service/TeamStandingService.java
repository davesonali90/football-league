package com.sapient.league.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.league.client.FootballRestTemplate;
import com.sapient.league.dto.TeamStandingDto;
import com.sapient.league.model.Country;
import com.sapient.league.model.League;
import com.sapient.league.model.TeamStanding;

@Service
public class TeamStandingService {
	
	@Autowired
	private FootballRestTemplate client;
	
	@Autowired
	private TeamStandingDto teamStandingDto;
	
	public TeamStandingDto fetchTeamStanding(String countryName, String leagueName,  
			String teamName)
	{
		Country country = getCountryDetails(countryName);
		if(null != country && !("").equals(country.getCountry_name()))
		{
			League league = getLeagueDetails(country.getCountry_id(),
					leagueName);
			if(null != league && !("").equals(league.getLeague_name()))
			{
			TeamStanding teamStanding = getStandingDetails(league.getLeague_id(),
					teamName);
			if(null != teamStanding)
				prepareData(teamStanding, country);
			}
		}
		else
			teamStandingDto = null;
		return teamStandingDto;
	}
	
	public Country getCountryDetails(String countryName)
	{
		List<Country> cList;
		Country country = null;
		try {
			cList = client.getCountryDetails(countryName);
		
		country = cList.stream()
				.filter(c -> countryName.equalsIgnoreCase(c.getCountry_name()))
				.findFirst().orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return country;
	}
	
	public League getLeagueDetails(int countryId, String LeagueName)
	{
		List<League> lList;
		League league = null;
		try {
			lList = client.getLeagueDetails(countryId);
		
		league = lList.stream()
				.filter(c -> LeagueName.equalsIgnoreCase(c.getLeague_name()))
				.findFirst().orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return league;
	}
	
	public TeamStanding getStandingDetails(int leagueId, String teamName)
	{
		List<TeamStanding> tList;
		TeamStanding team = null;
		try {
			tList = client.getStandingDetails(leagueId);
		
		team = tList.stream()
				.filter(c -> teamName.equalsIgnoreCase(c.getTeam_name()))
				.findFirst().orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return team;
	}
	
	public TeamStandingDto prepareData(TeamStanding teamStanding,Country country)
	{
		teamStandingDto.setCountry(country.getCountry_id() + "-" + country.getCountry_name());
		teamStandingDto.setLeague(teamStanding.getLeague_id() + "-" + teamStanding.getLeague_name());
		teamStandingDto.setTeam(teamStanding.getTeam_id() + "-" + teamStanding.getTeam_name());
		teamStandingDto.setOverallStanding(teamStanding.getOverall_league_position());
		return teamStandingDto;
	}
}
