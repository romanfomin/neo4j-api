package db.neo4japi;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
@RestController
@RequestMapping(value = "/users", method = RequestMethod.GET)
public interface UserRepository extends Neo4jRepository<User,String> {
//    List<City> findByName(@Param("name") String name);

    @RequestMapping("/findAll")
    List<User> findAll();
}
