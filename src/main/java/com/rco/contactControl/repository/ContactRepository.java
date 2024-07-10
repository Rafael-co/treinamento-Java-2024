package com.rco.contactControl.repository;


import com.rco.contactControl.model.Contact;
import com.rco.contactControl.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

    List<Contact> findAllByPersonIs(Person person);
}
