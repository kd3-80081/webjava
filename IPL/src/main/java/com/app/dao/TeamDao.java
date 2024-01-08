package com.app.dao;

import java.util.List;

import pojos.Team;

public interface TeamDao {
//add a method to insert team details
	/* Create */ String addTeamDetails(Team newTeam);

	/* Retrieve */ List<Team> getTeamIdAndAbbreviation();

	/* Retrieve */ Team getTeamById(Integer id);

	/* Retrieve */ List<Team> getTeamByAgeAndWickets(int age, int wicket);
	
	/* Update */   String updateAgeAndAvgByName(String name, int age, double avg );
	
	/* Delete */   String deleteById(Integer id);
	
	String addTeamDetailsWithOwner(String email);
}
