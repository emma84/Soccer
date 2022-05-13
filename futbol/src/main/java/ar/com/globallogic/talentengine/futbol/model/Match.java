package ar.com.globallogic.talentengine.futbol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "partidos")
public class Match {

    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    @Field(name = "equipo_local")
    private Team teamLocal;
    @Field(name = "equipo_visitante")
    private Team teamVisitor;

    public Match(Team teamLocal, Team teamVisitor) {
        this.teamLocal = teamLocal;
        this.teamVisitor = teamVisitor;
    }
}
