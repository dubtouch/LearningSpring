package dub.dubtouch.restdemo.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public String helloWorld() {
        return "hello world from rest web service";
    }

    @GetMapping("/hello-bean")
    public HelloBean helloWorldBean() {
        return new HelloBean("hello returning a bean");
    }

    @GetMapping("/hello-bean/{name}")
    public HelloBean helloWorldBean(@PathVariable String name) {
        return new HelloBean("hello mister " + name);
    }
}
