package db.neo4japi.repository;

import db.neo4japi.model.Operator;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface OperatorRepository extends Neo4jRepository<Operator,String> {

    List<Operator> findAll();
    Operator findByOperatorId(String id);

    @Query("MATCH (Operator {operatorId: {0}})-[rel:HAS_OPTION]-(Option {optionId: {1}}) DELETE rel")
    void hasOptionUnrel( String operatorId,  String optionId);

    @Query("MATCH (Operator {operatorId: {0}})-[rel:HAS_TARIFF]-(Tariff {tariffId: {1}}) DELETE rel")
    void hasTariffUnrel( String operatorId,  String tariffId);
}
