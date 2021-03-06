package com.soft.team.demo;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
    public Greeting greeting2(@PathVariable("name") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value="/greeting", method = RequestMethod.POST)
    public Greeting greetingPost() {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, "Vacio"));
    }

    @PostMapping(value = "/save")
    public Greeting saveGreeting(@RequestBody Greeting greeting) {
        return greeting;
    }


}
