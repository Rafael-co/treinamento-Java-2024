package com.rco.contactControl.repository;

import com.rco.contactControl.dto.response.PersonDirectMailResponseDTO;
import com.rco.contactControl.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    public boolean existsByUsername(String username);


    @Query("SELECT new com.rco.contactControl.dto.response.PersonDirectMailResponseDTO(p.id,p.name, CONCAT(p.address, ' - ', 'cep: ', p.zipCode, ' cidade: ', p.city, '/', p.uf)) FROM Person p WHERE p.id = ?1")
    public Optional<PersonDirectMailResponseDTO> personDirectMail(Long id);
}
