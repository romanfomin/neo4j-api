package db.neo4japi.repository;

import db.neo4japi.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User,String> {

    List<User> findAll();
    User findByUserId(String id);
}
