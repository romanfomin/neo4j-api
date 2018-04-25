package db.neo4japi.repository;

import db.neo4japi.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User,String> {

    List<User> findAll();
    User findByUserId(String id);

    @Query("MATCH (User {userId: {0}})-[rel:FROM_CITY]-(City {cityId: {1}}) DELETE rel")
    User fromCityUnrel(String userId,String cityId);

//    @Query("MATCH (User {userId: {0}})-[rel:FROM_CITY]-(Option {cityId: {1}}) DELETE rel")
    void usesOptionUnrel( String userId, String optionId);
}
