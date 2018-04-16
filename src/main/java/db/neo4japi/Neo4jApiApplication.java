package db.neo4japi;

import db.neo4japi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Neo4jApiApplication {

    @Autowired
    CityRepository repo;

//    @Bean
//    public int meth() {
//        Iterable<City> cities = repo.findAll();
//        return 0;
//    }

    public static void main(String[] args) {
        SpringApplication.run(Neo4jApiApplication.class, args);
    }
}
