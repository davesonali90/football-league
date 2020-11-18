package com.sapient.league.client;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sapient.league.model.Country;
import com.sapient.league.model.League;
import com.sapient.league.model.TeamStanding;
import com.sapient.league.utils.ReadWriteJson;

@Component
public class FootballRestTemplate {
	
	@Value("${football.country.action}")
	private String countryAction;
	
	@Value("${football.team.action}")
	private String teamAction;
	
	@Value("${football.league.action}")
	private String leagueAction;
	
	@Value("${football.base.url}")
	private String baseUrl;
	
	@Value("${football.base.apikey}")
	private String apiKey;
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	public List<Country> getCountryDetails(String countryName) throws Exception
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity(headers);
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("action", countryAction);
		URI uri = buildUrl(baseUrl, params);
		String response = getRestTemplate().exchange(uri, HttpMethod.GET,
				entity,String.class).getBody();
		List<Country> country = ReadWriteJson.mapFromJson(response, Country[].class);
		return country;
	}

	private URI buildUrl(String baseUrl, MultiValueMap<String, String> params) {
		URI uri = UriComponentsBuilder.fromUriString(baseUrl)
				.queryParam("APIkey", apiKey)
				.queryParams(params)
				.build().toUri();
		return uri;
	}

	public List<League> getLeagueDetails(int countryId) throws Exception {
		// TODO Auto-generated method stub
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity(headers);
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("action", leagueAction);
		params.add("country_id", String.valueOf(countryId));
		URI uri = buildUrl(baseUrl, params);
		String response = getRestTemplate().exchange(uri, HttpMethod.GET,
				entity,String.class).getBody();
		List<League> league = ReadWriteJson.mapFromJson(response, League[].class);
		return league;
	}

	public List<TeamStanding> getStandingDetails(int leagueId) throws Exception {
		// TODO Auto-generated method stub
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity(headers);
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("action", teamAction);
		params.add("league_id", String.valueOf(leagueId));
		URI uri = buildUrl(baseUrl, params);
		String response = getRestTemplate().exchange(uri, HttpMethod.GET,
				entity,String.class).getBody();
		List<TeamStanding> team = ReadWriteJson.mapFromJson(response, TeamStanding[].class);
		return team;
	}
}
