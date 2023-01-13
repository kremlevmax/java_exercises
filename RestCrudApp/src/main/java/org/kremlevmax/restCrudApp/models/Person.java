package org.kremlevmax.restCrudApp.models;

public class Person {
    private int id;
    private String firstName, lastName, pob, email;
    private int age;

    public Person() {

    }

    public Person(int id, String firstName, String lastName, String pob, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pob = pob;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
