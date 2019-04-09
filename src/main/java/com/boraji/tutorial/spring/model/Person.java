package com.boraji.tutorial.spring.model;


import com.boraji.tutorial.spring.parser.LocalDateDeserializer;
import com.boraji.tutorial.spring.parser.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "birthday")
    private LocalDate birthDay;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "specialization")
    private String specialization;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "person_experience", joinColumns = { @JoinColumn(name = "person_id") }, inverseJoinColumns = {
//            @JoinColumn(name = "experience_id") })
//    private List<Experience> experience = new ArrayList<>();

    private Person() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getSpecialization() {
        return specialization;
    }

//    public List<Experience> getExperience() {
//        return experience;
//    }

    public static class Builder {
        private Person newPerson;

        public Builder() {
            newPerson = new Person();
        }

        public Builder withId(Long id) {
            newPerson.id = id;
            return this;
        }

        public Builder withName(String name) {
            newPerson.name = name;
            return this;
        }

        public Builder withAge(int age) {
            newPerson.age = age;
            return this;
        }

        public Builder withBirthDay(LocalDate birthDay) {
            newPerson.birthDay = birthDay;
            return this;
        }

        public Builder withAddress(String address) {
            newPerson.address = address;
            return this;
        }

        public Builder withEmail(String email) {
            newPerson.email = email;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            newPerson.phone = phoneNumber;
            return this;
        }

        public Builder withSpecialization(String specialization) {
            newPerson.specialization = specialization;
            return this;
        }

//        public Builder withExperience(List<Experience> experiences) {
//            newPerson.experience.addAll(experiences);
//            return this;
//        }

        public Person build() {
            return newPerson;
        }
    }

}