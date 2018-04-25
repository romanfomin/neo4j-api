package db.neo4japi.controller;

import db.neo4japi.model.City;
import db.neo4japi.model.Operator;
import db.neo4japi.model.User;
import db.neo4japi.repository.OperatorRepository;
import db.neo4japi.repository.OptionRepository;
import db.neo4japi.repository.TariffRepository;
import db.neo4japi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/operators")
public class OperatorController {

    @Autowired
    OperatorRepository operatorRepository;
    @Autowired
    OptionRepository optionRepository;
    @Autowired
    TariffRepository tariffRepository;

    @GetMapping("/findall")
    List<Operator> findAll(){
        return operatorRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    Operator findById(@PathVariable String id){
        return operatorRepository.findByOperatorId(id);
    }

    @GetMapping("/add/{id}")
    Operator save(@PathVariable String id){
        return operatorRepository.save(new Operator(id));
    }

    @GetMapping("/hasoptionrel/{operatorId}/{optionId}")
    Operator hasOptionRel(@PathVariable String operatorId, @PathVariable String optionId) {
        Operator operator = operatorRepository.findByOperatorId(operatorId);
        operator.getOptions().add(optionRepository.findByOptionId(optionId));
        return operatorRepository.save(operator);
    }

    @GetMapping("/hasoptionunrel/{operatorId}/{optionId}")
    Operator hasOptionUnrel(@PathVariable String operatorId, @PathVariable String optionId) {
        Operator operator = operatorRepository.findByOperatorId(operatorId);
        operator.hasOptionUnrel(optionRepository.findByOptionId(optionId));
        return operatorRepository.save(operator);
    }

    @GetMapping("/hastariffrel/{operatorId}/{tariffId}")
    Operator hasTariffRel(@PathVariable String operatorId, @PathVariable String tariffId) {
        Operator operator = operatorRepository.findByOperatorId(operatorId);
        operator.getTariffs().add(tariffRepository.findByTariffId(tariffId));
        return operatorRepository.save(operator);
    }

    @GetMapping("/hastariffunrel/{operatorId}/{tariffId}")
    Operator hasTariffUnrel(@PathVariable String operatorId, @PathVariable String tariffId) {
        Operator operator = operatorRepository.findByOperatorId(operatorId);
        operator.hasTariffUnrel(tariffRepository.findByTariffId(tariffId));
        return operatorRepository.save(operator);
    }

    @GetMapping("/deletebyid/{id}")
    void delete(@PathVariable String id){
        operatorRepository.delete(findById(id));
    }

}
