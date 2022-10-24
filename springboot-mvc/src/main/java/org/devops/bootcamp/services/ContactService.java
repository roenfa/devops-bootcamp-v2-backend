package org.devops.bootcamp.services;

import org.devops.bootcamp.models.ContactEntry;
import org.devops.bootcamp.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<ContactEntry> findAll() {
        return contactRepository.findAll();
    }

    public Optional<ContactEntry> findById(int id) {
        return contactRepository.findById(id);
    }

    public ContactEntry saveContact(ContactEntry contactEntry) {
        return contactRepository.save(contactEntry);
    }

    public ContactEntry updateContact(int id, ContactEntry contactEntry) {
        ContactEntry updatedContactEntry = contactRepository.findById(id).orElse(null);
        updatedContactEntry.setName(contactEntry.getName());
        updatedContactEntry.setEmail(contactEntry.getEmail());
        updatedContactEntry.setCountry(contactEntry.getCountry());
        return contactRepository.save(updatedContactEntry);
    }

    public void deleteById(int id) {
        contactRepository.deleteById(id);
    }

}
