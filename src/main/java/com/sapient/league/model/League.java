package com.sapient.league.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class League 
{
	@JsonProperty("country_id")
	private int country_id;
	
	@JsonProperty("country_name")
	private String country_name;
	
	
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
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
	
	@JsonProperty("league_id")
	private int league_id;
	
	@JsonProperty("league_name")
	private String league_name;
}
