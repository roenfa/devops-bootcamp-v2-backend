package org.devops.bootcamp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Employee {

    /* Identify id as this entity's unique identifier. The id value is auto generated. */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String gender;
    private int age;
    private long salary;

    @Override
    public String toString() {
        return "EmployeeEntry [id=" + this.id + ", username=" + this.username +", password=" + this.password + ", email=" + this.email + ", gender=" + this.gender +", age=" + this.age +", salary=" + this.salary +"]";
    }
}
