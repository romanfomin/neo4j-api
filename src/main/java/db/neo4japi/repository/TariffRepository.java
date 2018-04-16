package db.neo4japi.repository;

import db.neo4japi.model.Option;
import db.neo4japi.model.Tariff;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TariffRepository extends Neo4jRepository<Tariff,String> {

    List<Tariff> findAll();
}
