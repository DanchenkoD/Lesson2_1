package com.sbt.lesson2;

import java.util.ArrayList;

public class Person {
    public static int totalCount;
    public static ArrayList<Person> pers_= new ArrayList();
    public static final boolean RESIDENT = true;
    public static final boolean NOT_RESIDENT = false;

    private final boolean man;
    private final String name;
    private Person spouse;

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private boolean isResident;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
        totalCount++;
        pers_.add(this);
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (man == person.isMen() || this.spouse == person || person == null) {
            return false;
        } else {
            if (spouse != null) {
                divorce();
            }
            this.spouse = person;
            person.marry(this);
            return true;
        }
    }

    /**
     * Sets spouse = null if spouse is not null
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (spouse == null) {
            return false;
        } else {
            Person exSpouse = spouse;
            spouse = null;
            exSpouse.divorce();
            return true;
        }
    }



    /* public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }*/
    public void setId(Long id) {
        this.id = id;
    }

    public boolean isMen() {
        return man;
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
    }

}
