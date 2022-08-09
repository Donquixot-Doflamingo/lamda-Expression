package com.lamdaBasics;

import java.util.ArrayList;
import java.util.List;

public class Person {

    public enum sex{
         MALE, FEMALE
    }

    private String name;
    private int age;
    private String emailAddress;
    private sex gender;

    public Person(String name, int age, String emailAddress, sex gender) {
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", emailAddress='" + emailAddress + '\'' +
                ", gender=" + gender +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public sex getGender() {
        return gender;
    }

    public void setGender(sex gender) {
        this.gender = gender;
    }

    public void printPerson(){
        System.out.println(this.toString() );
    }

    public static List<Person> generateDefaults(){
        List<Person> people = new ArrayList<Person>();

        people.add(new Person("Zoro",23,"iwillnavigate@lostmail.com",sex.MALE));
        people.add(new Person("Nami",21,"stealingBerries@marine.com",sex.FEMALE));
        people.add(new Person("Yamato",28,"iamoden@wanokuni.com",sex.FEMALE));
        people.add(new Person("Luffy",19,"whereisthemeat@pirateking.com",sex.MALE));

        return people;
    }
}
