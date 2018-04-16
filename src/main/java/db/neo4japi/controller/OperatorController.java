package db.neo4japi.controller;

import db.neo4japi.model.Operator;
import db.neo4japi.model.User;
import db.neo4japi.repository.OperatorRepository;
import db.neo4japi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/operators")
public class OperatorController {

    @Autowired
    OperatorRepository operatorRepository;

    @GetMapping("/findall")
    List<Operator> findAll(){
        return operatorRepository.findAll();
    }
}
