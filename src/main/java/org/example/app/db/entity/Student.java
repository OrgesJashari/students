package org.example.app.db.entity;

public class Student {
    private long id;
    private String  name ;
    private int age;

    public Student (long id , String name , int age){
        this.id= id;
        this.name = name ;
        this.age = age;
    }
    public Student ( String name , int age){

        this.name = name ;
        this.age = age;
    }
    public Student (){

        this.id = 0;
        this.age = 0;
        this.name = "";
    }

    public long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String toString(){
        return "Student id = " + id + ", name" + name + " age " + age;
    }
}
