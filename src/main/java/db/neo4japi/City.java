package db.neo4japi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class City {

    @Id
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;
}
