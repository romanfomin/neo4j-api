package db.neo4japi.repository;

import db.neo4japi.model.City;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface CityRepository extends Neo4jRepository<City,String> {

    List<City> findAll();
    List<City> findByCityId(String id);
}
