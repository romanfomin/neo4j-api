package db.neo4japi;

import db.neo4japi.City;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
@RestController
@RequestMapping(value = "/cities", method = RequestMethod.GET)
public interface CityRepository extends Neo4jRepository<City,String> {
//    List<City> findByName(@Param("name") String name);

    @RequestMapping("/findAll")
    List<City> findAll();
}
