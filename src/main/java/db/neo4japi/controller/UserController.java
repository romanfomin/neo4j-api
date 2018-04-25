package db.neo4japi.controller;

import db.neo4japi.model.City;
import db.neo4japi.model.User;
import db.neo4japi.repository.*;
import org.neo4j.ogm.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    OptionRepository optionRepository;
    @Autowired
    TariffRepository tariffRepository;
    @Autowired
    OperatorRepository operatorRepository;

    @GetMapping("/findall")
    List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    User findById(@PathVariable String id) {
        return userRepository.findByUserId(id);
    }

    @GetMapping("/add/{id}")
    User save(@PathVariable String id) {
        return userRepository.save(new User(id));
    }

    @GetMapping("/fromcityrel/{userId}/{cityId}")
    User fromCityRel(@PathVariable String userId, @PathVariable String cityId) {
        User user = userRepository.findByUserId(userId);
        user.getCities().add(cityRepository.findByCityId(cityId));
        return userRepository.save(user);
    }

    @GetMapping("/fromcityunrel/{userId}/{cityId}")
    void fromCityUnrel(@PathVariable String userId, @PathVariable String cityId) {
        userRepository.fromCityUnrel(userId,cityId);
    }

    @GetMapping("/usesoptionrel/{userId}/{optionId}")
    User usesOptionRel(@PathVariable String userId, @PathVariable String optionId) {
        User user = userRepository.findByUserId(userId);
        user.getOptions().add(optionRepository.findByOptionId(optionId));
        return userRepository.save(user);
    }

    @GetMapping("/usesoptionunrel/{userId}/{optionId}")
    void usesOptionUnrel(@PathVariable String userId, @PathVariable String optionId) {
        User user = userRepository.findByUserId(userId);
//        user.usesOptionUnrel(optionRepository.findByOptionId(optionId));
//        return userRepository.save(user);
    }

    @GetMapping("/usestariffrel/{userId}/{tariffId}")
    User usesTariffRel(@PathVariable String userId, @PathVariable String tariffId) {
        User user = userRepository.findByUserId(userId);
        user.getTariffs().add(tariffRepository.findByTariffId(tariffId));
        return userRepository.save(user);
    }

    @GetMapping("/usestariffunrel/{userId}/{tariffId}")
    void usesTariffUnrel(@PathVariable String userId, @PathVariable String tariffId) {
        User user = userRepository.findByUserId(userId);
//        user.usesTariffUnrel(tariffRepository.findByTariffId(tariffId));
//        return userRepository.save(user);
    }

    @GetMapping("/usesoperatorrel/{userId}/{operatorId}")
    User usesOperatorRel(@PathVariable String userId, @PathVariable String operatorId) {
        User user = userRepository.findByUserId(userId);
        user.getOperators().add(operatorRepository.findByOperatorId(operatorId));
        return userRepository.save(user);
    }

    @GetMapping("/usesoperatorunrel/{userId}/{operatorId}")
    void usesOperatorUnrel(@PathVariable String userId, @PathVariable String operatorId) {
        User user = userRepository.findByUserId(userId);
//        user.usesOperatorUnrel(operatorRepository.findByOperatorId(operatorId));
//        return userRepository.save(user);
    }

    @GetMapping("/deletebyid/{id}")
    void delete(@PathVariable String id) {
        userRepository.delete(findById(id));
    }
}
