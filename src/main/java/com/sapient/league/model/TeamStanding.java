package com.sapient.league.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TeamStanding {
	
	@JsonProperty("country_id")
	private int country_id;
	
	@JsonProperty("league_id")
	private int league_id;
	
	@JsonProperty("league_name")
	private String league_name;
	
	@JsonProperty("team_id")
	private int team_id;
	
	@JsonProperty("team_name")
	private String team_name;
	
	@JsonProperty("overall_league_position")
	private int overall_league_position;
	
	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public int getLeague_id() {
		return league_id;
	}

	public void setLeague_id(int league_id) {
		this.league_id = league_id;
	}

	public String getLeague_name() {
		return league_name;
	}

	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public int getOverall_league_position() {
		return overall_league_position;
	}

	public void setOverall_league_position(int overall_league_position) {
		this.overall_league_position = overall_league_position;
	}
}
