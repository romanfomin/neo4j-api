package db.neo4japi.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;


@NodeEntity
public class User {

    @Id
    private Long id;

    private String userId;

    @Relationship(type = "FROM_CITY", direction = Relationship.OUTGOING)
    private Set<City> cities=new HashSet<>();

    @Relationship(type = "USES_OPTION", direction = Relationship.OUTGOING)
    private Set<Option> options=new HashSet<>();

    @Relationship(type = "USES_TARIFF", direction = Relationship.OUTGOING)
    private Set<Tariff> tariffs=new HashSet<>();

    @Relationship(type = "USES_OPERATOR", direction = Relationship.OUTGOING)
    private Set<Operator> operators=new HashSet<>();

    public User(Long id, String userId, Set<City> cities, Set<Option> options, Set<Tariff> tariffs, Set<Operator> operators) {
        this.id = id;
        this.userId = userId;
        this.cities = cities;
        this.options = options;
        this.tariffs = tariffs;
        this.operators = operators;
    }

    public User(){

    }

    public User(String userId) {
        this.userId = userId;
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
