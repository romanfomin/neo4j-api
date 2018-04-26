package db.neo4japi.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.annotation.Id;


@NodeEntity
public class Option {

    @Id
    private Long id;

    private String optionId;

    public Option(){
    }

    public Option(String optionId) {
        this.optionId = optionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

}
