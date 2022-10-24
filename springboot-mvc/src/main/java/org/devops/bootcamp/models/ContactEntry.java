package org.devops.bootcamp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class ContactEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;

    private String country;

    @Override
    public String toString() {
        return "ContactEntry [id=" + this.id + ", name=" + this.name + ", email=" + this.email + "]";
    }
}
