package db.neo4japi.repository;

import db.neo4japi.model.City;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends Neo4jRepository<City,String> {

    List<City> findAll();
    City findByCityId(String id);
}
