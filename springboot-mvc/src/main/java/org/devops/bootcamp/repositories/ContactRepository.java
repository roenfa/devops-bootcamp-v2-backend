package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.ContactEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntry, Integer> {
    List<ContactEntry> findByEmail(String email);
}
