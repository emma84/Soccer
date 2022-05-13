package ar.com.globallogic.talentengine.futbol.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
public class MongoConfig {

    public @Bean
    MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://andromeda-user:31wfAlG5qLJLb7eR@clustertalentengine.k0gwx.mongodb.net/andromeda-integrador");
    }

    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }
}
