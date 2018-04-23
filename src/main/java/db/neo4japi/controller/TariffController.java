package db.neo4japi.controller;

import db.neo4japi.model.Option;
import db.neo4japi.model.Tariff;
import db.neo4japi.repository.OptionRepository;
import db.neo4japi.repository.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tariffs")
public class TariffController {

    @Autowired
    TariffRepository tariffRepository;

    @GetMapping("/findall")
    List<Tariff> findAll(){
        return tariffRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    Tariff findById(@PathVariable String id){
        return tariffRepository.findByTariffId(id);
    }

    @GetMapping("/add/{id}")
    Tariff save(@PathVariable String id){
        return tariffRepository.save(new Tariff(id));
    }

    @GetMapping("/deletebyid/{id}")
    void delete(@PathVariable String id){
        tariffRepository.delete(findById(id));
    }

}
