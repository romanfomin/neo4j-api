package db.neo4japi.controller;

import db.neo4japi.model.Operator;
import db.neo4japi.model.Option;
import db.neo4japi.repository.OperatorRepository;
import db.neo4japi.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/options")
public class OptionController {

    @Autowired
    OptionRepository optionRepository;

    @GetMapping("/findall")
    List<Option> findAll(){
        return optionRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    Option findById(@PathVariable String id){
        return optionRepository.findByOptionId(id);
    }

    @GetMapping("/add/{id}")
    Option save(@PathVariable String id){
        return optionRepository.save(new Option(id));
    }

    @GetMapping("/deletebyid/{id}")
    void delete(@PathVariable String id){
        optionRepository.delete(findById(id));
    }

}
