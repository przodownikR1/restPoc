package pl.java.scalatech.controller

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController;

@RestController
class HiController {
    @RequestMapping("/hi/{name}")
    String hi(@PathVariable("name")String name){
        return "Hi " + name;
    }
}
