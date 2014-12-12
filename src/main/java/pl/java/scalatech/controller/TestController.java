package pl.java.scalatech.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.java.scalatech.controller.HelloController.Car;

import com.google.common.collect.Lists;

@RestController
@RequestMapping(value = "/test", produces = { MediaType.APPLICATION_JSON_VALUE })
public class TestController {
    List<Car> cars = Lists.newArrayList(new Car("bmw", "10"), new Car("star", "12"), new Car("opel", "23"));

    Random rand = new Random();

    @RequestMapping
    public Car car() {
        return new Car("bmw", "10");
    }

    @RequestMapping("/car/name/{name}")
    Car getCarByName(@PathVariable("name") String name) {
        Optional<Car> opt = cars.stream().filter(car -> name.equals(car.name)).findFirst();
        if (opt.isPresent()) { return opt.get(); }
        throw new IllegalArgumentException("car with name " + name + " not exists");
    }

    @Data
    @AllArgsConstructor
    public class Car {

        private String name;

        private String age;
    }

}
