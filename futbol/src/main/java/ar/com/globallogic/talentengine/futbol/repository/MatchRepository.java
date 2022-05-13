package ar.com.globallogic.talentengine.futbol.repository;

import ar.com.globallogic.talentengine.futbol.model.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends MongoRepository<Match, String> {
}
