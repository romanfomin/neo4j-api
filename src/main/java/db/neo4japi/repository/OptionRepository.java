package db.neo4japi.repository;

import db.neo4japi.model.Option;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends Neo4jRepository<Option,String> {

    List<Option> findAll();
    Option findByOptionId(String id);
}
