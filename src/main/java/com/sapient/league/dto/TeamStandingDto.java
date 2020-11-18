package com.sapient.league.dto;

import org.springframework.stereotype.Component;

@Component
public class TeamStandingDto {
	private String country;
	private String league;
	private String team;
	private int overallStanding;

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getOverallStanding() {
		return overallStanding;
	}
	public void setOverallStanding(int overallStanding) {
		this.overallStanding = overallStanding;
	}
}
