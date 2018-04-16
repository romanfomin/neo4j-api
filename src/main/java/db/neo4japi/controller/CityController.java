package db.neo4japi.controller;

import db.neo4japi.model.City;
import db.neo4japi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @GetMapping("/findall")
    List<City> findAll(){
        return cityRepository.findAll();
    }
}
