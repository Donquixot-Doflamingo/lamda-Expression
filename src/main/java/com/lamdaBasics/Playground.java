package com.lamdaBasics;

import java.util.List;
import java.util.function.Predicate;

public class Playground {

    // Approach 1 -> Imperative Style of programming
    public static void printPersonOlderThan(List<Person> people, int age ){
        for (Person p : people ){
            if(p.getAge() >= age){
                p.printPerson();
            }
        }
    }

    public static void printPersonWithinAgeRange(List<Person> people, int low, int high){
        for (Person p : people ){
            if(low <= p.getAge() && p.getAge() <= high){
                p.printPerson();
            }
        }
    }

    // Approach 2 -> Functional Style of programming

    @FunctionalInterface
    interface CheckPerson{
        boolean test(Person p);
    }

    static class CheckEligibleForSelectiveSearch implements CheckPerson{

        @Override
        public boolean test(Person p) {
            return p.getGender() == Person.sex.MALE && 18 <= p.getAge() && p.getAge() <= 20;
        }
    }

    public static void printPeople(List<Person> people, CheckPerson tester){
        for (Person p : people ){
            if(tester.test(p)){
                p.printPerson();
            }
        }
    }

    public static void printPeopleWithPredicate(List<Person> people, Predicate<Person> tester){
        for (Person p : people ){
            if(tester.test(p)){
                p.printPerson();
            }
        }
    }

    public static void main(String[] args) {

        /** Approach 1 with custom for different activities */

        System.out.println("Approach 1 with custom for different activities");

        List<Person> people = Person.generateDefaults();

        printPersonOlderThan(people,23);

        System.out.println("For age range");

        printPersonWithinAgeRange(people,24,30);

        /** Approach 2 with custom Class and interface */

        System.out.println("Approach 2 with custom Class and interface");

        printPeople(people, new CheckEligibleForSelectiveSearch() );

        /** Approach 3 with anonymous class */

        System.out.println("Approach 3 with anonymous class");

        printPeople(people, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.sex.MALE && 18 <= p.getAge() && p.getAge() <= 20;
            }
        });

        /** Approach 4 using lambda expression with custom-built functional interface */

        System.out.println("Approach 4 using lambda expression with custom-built functional interface");

        /** Lambda expression only work with functional interface,
         *  functional interface have only one abstract method, if there will be more than that then lambda won't work
         *  it can have more default of static method but only one abstract method.
         *  we can use @FunctionalInterface annotations for a flag that it can only one abstract method or
            the class have only one abstract method
         * Notes on understanding the code
         * 1. why no Person and "()" -> here java understand that we are talking about Person object
            also there is only one variable so () are not required
         * 2. why no return, "{}" and ";" -> if we are writing one line then java knows that we are definitely
            returning something. so we don't need to write return keyword, {} and ;.
         we can write that whole code in one line too.
         * */

        printPeople(people, p -> // 1
            p.getGender() == Person.sex.MALE && 18 <= p.getAge() && p.getAge() <= 20); //2.

        /** Approach 5 using lambda expression with default functional interface called predicate */

        System.out.println("Approach 5 using lambda expression with default functional interface called predicate");

        printPeopleWithPredicate(people, p -> p.getGender() == Person.sex.MALE && 18 <= p.getAge() && p.getAge() <= 20);

        /**
         * */
    }
}
