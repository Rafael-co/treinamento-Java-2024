package com.rco.contactControl.service;

import com.rco.contactControl.dto.request.ContactRequestDTO;
import com.rco.contactControl.dto.request.PersonRequestDTO;
import com.rco.contactControl.dto.response.ContactResponseDTO;
import com.rco.contactControl.dto.response.PersonDirectMailResponseDTO;
import com.rco.contactControl.dto.response.PersonResponseDTO;
import com.rco.contactControl.exceptions.BusinessRuleException;
import com.rco.contactControl.exceptions.InformationNotFound;
import com.rco.contactControl.model.Contact;
import com.rco.contactControl.model.Person;
import com.rco.contactControl.repository.PersonRepository;
import com.rco.contactControl.service.interfaces.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements PersonServiceInterface {

    @Autowired
    private PersonRepository personRepository;


    @Override
    public PersonResponseDTO create(PersonRequestDTO dto) throws BusinessRuleException {
        Person newPerson = personRequestDtoTOPerson(dto);

        existsUsername(dto.getUsername());

        saveContactsIfExist(newPerson,dto.getContacts());

        Person savedPerson = this.personRepository.save(newPerson);

        return personToPersonResponseDto(savedPerson);
    }

    @Override
    public Person getById(Long idPerson) throws InformationNotFound {

        return this.personRepository.findById(idPerson).orElseThrow(()-> new InformationNotFound("Não foi encontrada nenhuma pessoa cadastrada com este ID"));

    }

    @Override
    public PersonResponseDTO getDtoById(Long idPerson) throws InformationNotFound {
        Person personFound = getById(idPerson);



        return personToPersonResponseDto(personFound);
    }

    @Override
    public PersonDirectMailResponseDTO getDirectMailById(Long idPerson) throws InformationNotFound {
        PersonDirectMailResponseDTO person = this.personRepository.personDirectMail(idPerson).orElseThrow(()->new InformationNotFound("Não existe usuario com este ID"));
        return person ;
    }

    @Override
    public List<PersonResponseDTO> getAll() {
        List<Person> persons = this.personRepository.findAll();
        List<PersonResponseDTO> result = persons.stream().map(person -> personToPersonResponseDto(person)).toList();
        return result;
    }

    @Override
    public PersonResponseDTO updatePerson(Long idPerson,PersonRequestDTO dto) throws InformationNotFound {
        Person person = getById(idPerson);
        person.setName(dto.getName());
        person.setAddress(dto.getAddress());
        person.setCity(dto.getCity());
        person.setUf(dto.getUf());
        person.setZipCode(dto.getZipCode());
        person.setUsername(dto.getUsername());
        person.setUpdatedAt(LocalDateTime.now());

       Person personUpdated =  this.personRepository.save(person);
        return personToPersonResponseDto(personUpdated);
    }

    @Override
    public void deletePerson(Long idPerson) throws InformationNotFound {
        Person person = getById(idPerson);

        this.personRepository.delete(person);

    }

    public static PersonResponseDTO personToPersonResponseDto(Person person){
        List<ContactResponseDTO> contacts = person.getContacts().stream().map(contact -> ContactService.contactToContactResponseDto(contact,person.getUsername())).toList();

          PersonResponseDTO result = new PersonResponseDTO(
                  person.getId(),
                  person.getName(),
                  person.getAddress(),
                  person.getZipCode(),
                  person.getCity(),
                  person.getUf(),
                  contacts,
                  person.getUsername(),
                  person.getCreatedAt(),
                  person.getUpdatedAt());
          return result;
    }
    public static Person personRequestDtoTOPerson(PersonRequestDTO dto){
        Person result = new Person(
                null,
                dto.getName(),
                dto.getAddress(),
                dto.getZipCode(),
                dto.getCity(),
                dto.getUf(),
                null,
                dto.getUsername());
        return result;
    }

    private void existsUsername(String userName) throws BusinessRuleException {
        boolean exists = this.personRepository.existsByUsername(userName);
        if(exists){
            throw new BusinessRuleException("Nome de usuario indisponível");
        }
    }

    private void saveContactsIfExist(Person person, List<ContactRequestDTO> contactsDto){
        List<Contact> contacts = new ArrayList<>();
        if(!contactsDto.isEmpty() || !(contactsDto == null)){
            contacts = contactsDto.stream().map(contactRequestDTO -> ContactService.contactRequestDtoToContact(contactRequestDTO,person)).toList();
        }
        person.setContacts(contacts);
    }
}
