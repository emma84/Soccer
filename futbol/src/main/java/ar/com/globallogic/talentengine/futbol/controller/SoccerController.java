package ar.com.globallogic.talentengine.futbol.controller;

import ar.com.globallogic.talentengine.futbol.model.Team;
import ar.com.globallogic.talentengine.futbol.model.Match;
import ar.com.globallogic.talentengine.futbol.service.SoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/v1/futbol")
public class SoccerController {

    @Autowired
    SoccerService soccerService;

    @GetMapping("/teams")
    private ResponseEntity<Team> getTeams(HttpServletRequest request){
        List<Team> listTeams = soccerService.getTeams();
        ResponseEntity responseEntity = new ResponseEntity(listTeams, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/create")
    private Team create(@RequestBody Team e){
        Team team = soccerService.createTeam(e);
        return team;
    }

    @PostMapping("/crearPartido")
    private ResponseEntity<Match> createMatch(){
        List<Team> teams = soccerService.getTeams();
        List<Match> listMatches = soccerService.createMatches(teams);
        ResponseEntity responseEntity = new ResponseEntity(listMatches, HttpStatus.OK);
        return responseEntity;
    }


}
