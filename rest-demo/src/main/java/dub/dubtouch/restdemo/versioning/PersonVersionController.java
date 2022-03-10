package dub.dubtouch.restdemo.versioning;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {


    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Jim Hendrix");
    }
    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Jim", "Hendrix"));
    }

    @GetMapping(value="/person/param", params="version=1")
    public PersonV1 paramV1() {
        return new PersonV1("Jim Hendrix");
    }

    @GetMapping(value="/person/param", params="version=2")
    public PersonV2 paramv2() {
        return new PersonV2(new Name("Jim", "Hendrix"));
    }

    @GetMapping(value="/person/header", headers="version=1")
    public PersonV1 headerV1() {
        return new PersonV1("Jim Hendrix");
    }

    @GetMapping(value="/person/header", headers="version=2")
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Jim", "Hendrix"));
    }
}
