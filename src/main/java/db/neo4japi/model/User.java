package db.neo4japi.model;

import db.neo4japi.model.City;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

import java.util.Set;


@NodeEntity
public class User {

    @Id
    private Long id;

    private String userId;

    @Relationship(type = "FROM_CITY", direction = Relationship.OUTGOING)
    private Set<City> cities;

    @Relationship(type = "USES_OPTION", direction = Relationship.OUTGOING)
    private Set<Option> options;

    @Relationship(type = "USES_TARIFF", direction = Relationship.OUTGOING)
    private Set<Tariff> tariffs;

    @Relationship(type = "USES_OPERATOR", direction = Relationship.OUTGOING)
    private Set<Operator> operators;

    public User(){
    }

    public User(String userId, Set<City> cities) {
        this.userId = userId;
        this.cities = cities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    public void setTariffs(Set<Tariff> tariffs) {
        this.tariffs = tariffs;
    }

    public Set<Operator> getOperators() {
        return operators;
    }

    public void setOperators(Set<Operator> operators) {
        this.operators = operators;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }
}
