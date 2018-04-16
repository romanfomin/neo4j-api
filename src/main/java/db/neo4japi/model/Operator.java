package db.neo4japi.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

import java.util.Set;


@NodeEntity
public class Operator {

    @Id
    private Long id;

    private String operatorId;

    @Relationship(type = "HAS_TARIFF", direction = Relationship.OUTGOING)
    private Set<Tariff> tariffs;

    @Relationship(type = "HAS_OPTION", direction = Relationship.OUTGOING)
    private Set<Option> options;

    public Operator(){
    }

    public Operator(String operatorId, Set<Tariff> tariffs, Set<Option> options) {
        this.operatorId = operatorId;
        this.tariffs = tariffs;
        this.options = options;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    public void setTariffs(Set<Tariff> tariffs) {
        this.tariffs = tariffs;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }
}
