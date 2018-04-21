package db.neo4japi.controller;

import db.neo4japi.model.City;
import db.neo4japi.model.User;
import db.neo4japi.repository.CityRepository;
import db.neo4japi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/fromcity/{userId}/{cityId}")
    User fromCity(@PathVariable String userId, @PathVariable String cityId) {
        User user = userRepository.findByUserId(userId);
        user.getCities().add(cityRepository.findByCityId(cityId));
        return userRepository.save(user);
    }

    @GetMapping("/deletebyid/{id}")
    void delete(@PathVariable String id) {
        userRepository.delete(findById(id));
    }
}
