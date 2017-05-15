package com.example.su.myappconectiontwo.xmlandhtml;

/**
 * Created by su
 * on 2017/5/8.
 */
public class Person {
    //  String json = "[{\"name\":\"阿福\", \"phone\":\"18600012345\"}]";
    String name;
    String phone;

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
