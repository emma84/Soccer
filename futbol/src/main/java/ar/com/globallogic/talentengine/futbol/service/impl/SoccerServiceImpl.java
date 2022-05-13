package ar.com.globallogic.talentengine.futbol.service.impl;

import ar.com.globallogic.talentengine.futbol.model.Team;
import ar.com.globallogic.talentengine.futbol.model.Match;
import ar.com.globallogic.talentengine.futbol.repository.TeamRepository;
import ar.com.globallogic.talentengine.futbol.repository.MatchRepository;
import ar.com.globallogic.talentengine.futbol.service.SoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SoccerServiceImpl implements SoccerService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    MatchRepository matchRepository;

    @Override
    public List<Team> getTeams() {
        List<Team> equiposList = teamRepository.findAll();
        return equiposList;
    }

    @Override
    public Team createTeam(Team e) {
        Team team = new Team();
        team.setName(e.getName());
        return teamRepository.save(team);
    }

    @Override
    public List<Match> createMatches(List<Team> teams) {
//        initialise instance variables
        List<Match> matches = new ArrayList();
        List<Match> listMatches = new ArrayList<>();
        // Empareja los equipos dos a dos sin repetir de forma aleatoria,
        // mezclando primero los equipos
        Collections.shuffle(teams);
        int index = 0;
        // Toma los equipos dos a dos para el emparejamiento
//        Partido partido = new Partido();
//        partido.setEquipoLocal(teams.get(indice));
//        partido.setEquipoVisitante(teams.get(indice+1));
//        matches.add(partido);
        while (index < teams.size()) {
//            Equipo equipoUno = new Equipo();
//            equipoUno.setNombre(teams.get(indice).getNombre());
//            equipoUno.setPuntos(teams.get(indice).getPuntos());
//            Equipo equipoDos = new Equipo();
//            equipoDos.setNombre(teams.get(indice).getNombre());
//            equipoDos.setPuntos(teams.get(indice).getPuntos());
            matches.add(new Match(teams.get(index), teams.get(index + 1)));
            index += 2;

        }
        listMatches = matchRepository.saveAll(matches);
        return listMatches;
    }

}
