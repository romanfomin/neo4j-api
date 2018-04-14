package db.neo4japi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class User {

    @Id
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Relationship(type = "FROM_CITY", direction = Relationship.OUTGOING)
    private Set<City> cities;
}
