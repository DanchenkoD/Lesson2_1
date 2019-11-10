package com.sbt.lesson2;

public class Main {
    public static void main(String[] args) {
        Person vasya = new Person(true, "Vasya");
        Person lena = new Person(false, "Lena");
        Person nikita = new Person(true, "Nikita");
        Person olya = new Person(false, "Olya");
        Person denis = new Person(true, "Denis");

        marry(vasya, lena);
        marry(nikita, vasya);
        marry(denis, lena);
        marry(vasya, olya);
        marry(nikita, lena);
        marry(denis, olya);
        for (int i = 0; i < Person.totalCount; i++) {
            System.out.println();
            if (Person.pers_.get(i).getSpouse() != null) {
                System.out.println(Person.pers_.get(i).getName() + " + " + Person.pers_.get(i).getSpouse().getName());
            } else {
                System.out.println(Person.pers_.get(i).getName());
            }

        }

    }

    public static void marry(Person per1, Person per2) {
        System.out.println("Attempting to marry " + per1.getName() + "\nwith " + per2.getName());
        boolean result = per1.marry(per2);
        System.out.println("Result = " + result + "\n");
    }
}
