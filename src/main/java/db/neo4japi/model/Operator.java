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

    public Operator(String operatorId) {
        this.operatorId = operatorId;
    }

    public void hasTariffUnrel(Tariff tariff){
        for(Tariff c:tariffs){
            if(c.getTariffId().equals(tariff.getTariffId())){
                tariffs.remove(c);
            }
        }
    }

    public void hasOptionUnrel(Option option){
        for(Option c:options){
            if(c.getOptionId().equals(option.getOptionId())){
                options.remove(c);
            }
        }
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
