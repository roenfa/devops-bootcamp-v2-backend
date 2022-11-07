package org.devops.bootcamp.models;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private String username;
	private String password;
}
