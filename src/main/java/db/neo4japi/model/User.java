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

    public User(){
    }

    public User(String userId, Set<City> cities) {
        this.userId = userId;
        this.cities = cities;
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
