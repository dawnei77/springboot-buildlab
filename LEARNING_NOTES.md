# 🧪 Dawn's BuildLab - Spring Boot Learning Cheat Sheet

## 🛠️ The Build Tools
* **pom.xml:** The factory instruction list. Tells Maven what libraries to download.
* **mvnw:** The Maven Wrapper. Script that install correct ver of maven. Lets me run builds without installing Maven globally (`./mvnw clean package`). mvnw for windows. mvnw.cmd for mac

## 🚦 Spring Architecture
* **@SpringBootApplication:** The main ignition switch in `BuildlabApplication.java`. Run this file to start the server.
* **com.dawnei.buildlab:** My unique package name (Reverse Domain Name format) to prevent code clashes.
* **@Controller:** Serves visual web pages (looks for `.html` files).
* **@RestController:** Serves raw background data (JSON).

## 🍵Student.java
* Practicing POST request - with transforming JSON files in request body sent with POST request, to java objects (class Student). 2 major terms:

            deserialization: JSON -> java object
            serialization: java object -> JSON