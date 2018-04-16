package db.neo4japi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

import java.util.Set;

@NodeEntity
public class City {

    @Id
    private Long id;

    private String cityId;

    public City() {
    }

    public City(String cityId) {
        this.cityId = cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityId() {
        return cityId;
    }

//    @Getter
//    @Setter
//    @Relationship(type = "FROM_CITY", direction = Relationship.INCOMING)
//    private Set<User> users;
}
