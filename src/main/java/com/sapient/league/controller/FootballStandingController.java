package com.sapient.league.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.league.dto.TeamStandingDto;
import com.sapient.league.service.TeamStandingService;

@RestController
@RequestMapping("/api")
public class FootballStandingController {
	
	@Autowired
	private TeamStandingService teamStandingService;
	
	@GetMapping("/teamstandings")
	public ResponseEntity retrieveLeagueDet(
			@RequestParam(value="country_name", required=true) String countryName,
			@RequestParam(value="league_name", required=true) String leagueName,
			@RequestParam(value="team_name", required=true) String teamName)
	{
		TeamStandingDto dto = teamStandingService.fetchTeamStanding(countryName,
				leagueName, teamName); 
		if(null == dto)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record found");
		return ResponseEntity.ok(dto);
	}
}
