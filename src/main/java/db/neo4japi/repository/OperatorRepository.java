package db.neo4japi.repository;

import db.neo4japi.model.Operator;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperatorRepository extends Neo4jRepository<Operator,String> {

    List<Operator> findAll();
    Operator findByOperatorId(String id);
}
