package ar.com.globallogic.talentengine.futbol.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "equipos")
public class Team {

    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    @Field(name = "nombre")
    private String name;
    @Field(name = "partidos_jugados")
    private int matchesPlayed;
    @Field(name = "partidos_ganados")
    private int gamesWon;
    @Field(name = "partidos_empatados")
    private int gamesTied;
    @Field(name = "partidos_perdidos")
    private int gamesLost;
    @Field(name = "puntos")
    private int points;
    @Field("goles_favor")
    private int goalsFor;
    @Field("goles_contra")
    private int goalsAgainst;
    @Field("diferencia_goles")
    private int goalDifference;

    public int calculatePoints() {
        return matchesPlayed * 3 + gamesTied;
    }

}
