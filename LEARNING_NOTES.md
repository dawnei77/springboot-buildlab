# 🧪 Dawn's BuildLab - Spring Boot Learning Cheat Sheet

## 🛠️ The Build Tools
* **pom.xml:** The factory instruction list. Tells Maven what libraries to download. Maven's project configuration file. It declares dependencies, project information, plugins, and build settings.
* **mvnw:** The Maven Wrapper. Script that install correct ver of maven. Lets me run builds without installing Maven globally (`./mvnw clean package`). mvnw.cmd for windows. mvnw for mac

## 🚦 Spring Architecture
* **@SpringBootApplication:** The main ignition switch in `BuildlabApplication.java`. Run this file to start the server.
* **com.dawnei.buildlab:** My unique package name (Reverse Domain Name format) to prevent code clashes.
* **@Controller:** Serves visual web pages (looks for `.html` files).
* **@RestController:** Serves raw background data (JSON).

## 🍵Student.java
* Practicing POST request - with transforming JSON data in request body sent with POST request, to java objects (class Student). 2 major terms:

            deserialization: JSON -> java object
            serialization: java object -> JSON

## Services
* Controllers having both logic and http handling may become complex or untidy. So we use services ( classes with @service ). Service classes handles business logic. They are objected in controller where the service needed, as 
        
        private final datatype ServiceClass serviceVar;
        public controllerName(ServiceClass serviceVar) {
            this.serviceVar = serviceVar;
        }

Then they are called in controller's constructor (called constructor injection), so that framework can find the service class and bind to here. Then using the service object in controller, we can use its functions and properties anywhere inside controller.
This structure where controllers handling http and services handling logic is called "Seperation of Concerns".
"Dependency Injection" is the mechanism through which Spring supplies the required service object to the controller.

## Architecture (controller, services, repository, database)
* controller    - handles http request and response
* services      - handles business logic and Application rules
* repository    - Handles communication with the data source
* database      - persistent data storage


## Spring Beans and IoC Container
* **IoC (Inversion of Control):** The responsibility of creating and managing objects is handed over to the Spring framework.

  In normal Java, creating an object needs `ClassName obj = new ClassName();`, but Spring Boot detects configured classes(by component scanning seeing component annotations or explicit bean configuration), creates their objects, and registers them in the IoC Container.

  While we can make projects with manual `ClassName obj = new ClassName();`. Classes from other files can be used as objects with `new` keyword. But in some Application level development, it becomes overhead, or complex to modify and maintain. 

        example: new OrderController(new OrderService(new PaymentService(new Logger()), new OrderRepository(new DatabaseConnection())))


* **IoC Container:** Spring's object-management system. It creates, manages, and connects Spring beans.

* **Spring Bean:** An object created and managed by the IoC container.

* **@Service:** Marks a class as a service component so Spring can discover and manage it.

* **Dependency Injection (DI):** Spring supplies the required objects (dependencies) to other classes.

* **Constructor Injection:** A form of DI where dependencies are supplied through a class constructor.

* **Singleton Scope:** Default bean scope. Spring shares one instance of a bean within the application context. Like, two classes receive the same shared instance of a bean.

* **Bean Lifecycle:** The stages through which a bean is created, initialized, used, and eventually cleaned up.

* **Normal object vs Bean:**
  `Ordinary Java object`                                  `Spring Bean`
  Created using keyword 'new' by our code	                Created/registered and managed by Spring
  We manage its lifecycle	                                Spring manages its lifecycle
  Not automatically available for dependency injection	  Available for injection when registered appropriately

  A Spring bean is still an ordinary Java object. The difference is who manages it.


## Create my own beans
* Sometimes we need to create our own beans and give to spring to manage. That's beautiful. we can do that by:
  create class (this class we love to make it a bean). Next make a file (AppConfig.java) in root com.dawnei.buildlab. Make a class in it with @configuration (this tells spring this is bean configuration class), and make a method with @Bean. In it returns the object of the class that we want to use as bean. See the example

        public class MakeMeBean {
          public String desire = "want to be bean";
          }

        in AppConfig.java:

          @Configuration
          public class AppConfig {

            @Bean
            public MakeMeBean bean1() {
              return new MakeMeBean();      // new bean name will be method name, here 'bean1'
              }
            }

  In this buildlab, we made our own bean called greetingService, check it out! beautiful, right? Mainly when libraries we use, where we cant modify code, like classes to use as bean, we use this @configuration classes to make them beans. Beans everywhere. 


## Component Scanning

`@SpringBootApplication`: Includes component scanning by default, starting from the package of the main class and its subpackages.

During component scanning, Spring searches for classes marked with component annotations such as `@Component`, `@Service`, `@Repository`, `@Controller`, and `@RestController`.

These discovered classes are registered as Spring beans.

Spring also registers objects returned by `@Bean` methods inside `@Configuration` classes. This is explicit bean registration, separate from component scanning.

Really great, right? Spring takes care of discovering and managing our configured components!