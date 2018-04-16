package db.neo4japi.controller;

import db.neo4japi.model.Option;
import db.neo4japi.model.Tariff;
import db.neo4japi.repository.OptionRepository;
import db.neo4japi.repository.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
