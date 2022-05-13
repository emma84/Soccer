package ar.com.globallogic.talentengine.futbol.service;

import ar.com.globallogic.talentengine.futbol.model.Team;
import ar.com.globallogic.talentengine.futbol.model.Match;

import java.util.List;

public interface SoccerService {

    List<Team> getTeams();

    Team createTeam(Team e);

    List<Match> createMatches(List<Team> teams);

}
