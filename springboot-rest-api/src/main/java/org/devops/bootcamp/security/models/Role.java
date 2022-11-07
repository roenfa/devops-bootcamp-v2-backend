package org.devops.bootcamp.security.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    private String id;

    @Override
    public String getAuthority() {
        return this.id;
    }
}
