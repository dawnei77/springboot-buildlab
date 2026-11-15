package com.dawnei.buildlab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// This class is identified as a configuration class while component scanning. Used to define beans and other configuration settings.
@Configuration 
public class AppConfig {
    
    @Bean // marks this method as a bean making method. Returns instance of GreetingService class which is then registered as bean.
    public GreetingService greetingService() {
        return new GreetingService(); // name of the bean is the method name by default. Here, 'greetingService'.
    }
}
