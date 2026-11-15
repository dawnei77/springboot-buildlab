//Reverse domain name of your organization + project name
//( the java convention for package naming )
package com.dawnei.buildlab;  

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Controller class that send back data as JSON or String (not HTML)
public class HelloController {
    
    private final StudentService studentService;
    private final GreetingService greetingService; 

    // constructor injection
    public HelloController(StudentService studentService, GreetingService greetingService) {
        this.studentService = studentService;
        this.greetingService = greetingService; // custom build bean
    }


    @GetMapping ("/hello") // http GET request to the URL/hello will be handled by this method
    public String helloMssg(
            // url parameter can be passed as query parameter in the URL 
            // like /hello?name=John & age=25  ? starts query parameter, & separates multiple parameters
            // RequestParam annotation is used to extract query parameters from the URL
            @RequestParam (required = false, defaultValue = "BOSS") String name,
            @RequestParam (required = false, defaultValue = "18") Integer age
            ) 
        {
        return "Helloo " + name + ", you are " + age + ".";
    }

    @GetMapping ("/hello/{name}")
    public String helloByPath(
            // url parameter can be passed as path variable in the URL 
            // like /hello/John  /hello/25  /hello/John/25
            // PathVariable annotation is used to extract path variables from the URL
            @PathVariable (required = false) String name
            ) 
        {
        return "Helloo " + name;
    }

    @PostMapping ("/students") // http POST request to the URL/students will be handled by this method
    public Student student(@RequestBody Student student) {
        //@RequestBody fetch JSON file and deserialize (JSON to obj of Student class) represented by variable student (does not need new keyword when deserializing)
        
        return studentService.prepareStudent(student); //return the student object after processing it in the service class (returns finally as JSON)

        //TO TEST: Windows Powershell as client:
        /* 
        $body = @{
            name = "Asha"
            age = 20
            course = "BCA"
            } | ConvertTo-Json

        Invoke-RestMethod `
            -Uri "http://localhost:8080/students" `
            -Method Post `
            -ContentType "application/json" `
            -Body $body
        */
    }

    @GetMapping ("/greet")
    public String greet() {
        return greetingService.greet(); // greet() of bean object greetingService
    }
}