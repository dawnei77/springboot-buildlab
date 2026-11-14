package com.dawnei.buildlab;

//class specifically for JSON serialization and deserialization
//This class follows JavaBean convention - pvt vars with public getters, setters, naming of them and no-arg constructor
public class Student {

    private String name;     
    private int age;
    private String course;
    //private values not accessible - so use getter and setter methods to access these private variables


    public Student() {
        //no argument constructor - to deserialize JSON to Java object of Student class
    }

    //getter methods for JSON -> object mapping (real use: return private values)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    //setter methods for object -> JSON mapping (real use: set private values)
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course; 
    }
}