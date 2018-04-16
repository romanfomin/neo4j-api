package db.neo4japi.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.annotation.Id;


@NodeEntity
public class Tariff {

    @Id
    private Long id;

    private String tariffId;

    public Tariff(){
    }

    public Tariff(String tariffId) {
        this.tariffId = tariffId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTariffId() {
        return tariffId;
    }

    public void setTariffId(String tariffId) {
        this.tariffId = tariffId;
    }

}
