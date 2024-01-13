package com.batch.example.boot_batch_example.model;

public class Person {
    private String personId;
    private String firstName;
    private String lastName;
    private String contact;
    public String getPersonId() {
        return personId;
    }
    public Person(String personId, String firstName, String lastName, String contact, String email) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
    }
    public void setPersonId(String personId) {
        this.personId = personId;
    }
    public Person() {
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
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    private String email;
}
