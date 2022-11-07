package org.devops.bootcamp.models;

import javax.persistence.*;

import lombok.*;

// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotEmpty;
// import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class DAOUser extends AbstractEntity {
    @Column(nullable = false)
	private String username;
	@Column
	@JsonIgnore
	private String password;
}
