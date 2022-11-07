package org.devops.bootcamp.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @Column(name = "client_id")
    private int userId;

    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "user_email", unique = true)
    private String email;

    @Column(name = "user_password")
    private String password;
}
