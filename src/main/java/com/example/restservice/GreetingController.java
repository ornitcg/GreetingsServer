package com.example.restservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //the following will return a record
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name){
        //@RequestParam takes the value from the query in the url and inserts it into the parameter name.
        //also a default name is defined
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }   // counter is by default initiallized to 0. and is incremented on each get request
        // string. format takes the final trmplate variable and replaces the %s to be name and uses this as parameter


}
