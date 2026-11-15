package com.dawnei.buildlab;


// This class will not be scanned by Spring Boot as a component because it does not have any annotation @
// So this class is turned into bean explicitly in AppConfig.java class using @Bean annotation. This is how we make our own custom beans in Spring Boot.
public class GreetingService {  
    
    public String greet() {
        return "Hello from buildlab!";
    }
}
