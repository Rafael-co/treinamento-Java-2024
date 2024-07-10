package com.rco.contactControl.service;

import com.rco.contactControl.dto.request.ContactRequestDTO;
import com.rco.contactControl.dto.response.ContactResponseDTO;
import com.rco.contactControl.exceptions.BusinessRuleException;
import com.rco.contactControl.exceptions.InformationNotFound;
import com.rco.contactControl.model.Contact;
import com.rco.contactControl.model.Person;
import com.rco.contactControl.repository.ContactRepository;
import com.rco.contactControl.service.interfaces.ContactServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements ContactServiceInterface {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private PersonService personService;

    @Override
    public ContactResponseDTO create(ContactRequestDTO dto) throws InformationNotFound {
        Person person = this.personService.getById(dto.getIdPerson());
        Contact contact = contactRequestDtoToContact(dto,person);

        Contact newContact = this.contactRepository.save(contact);
        return contactToContactResponseDto(newContact,person.getUsername());
    }

    @Override
    public Contact getById(Long idContact) throws InformationNotFound {
        return  this.contactRepository.findById(idContact).orElseThrow(()->new InformationNotFound("Não há nenhum contato cadastrado com este id"));
    }


    @Override
    public ContactResponseDTO getDtoById(Long idContact) throws InformationNotFound {
        Contact contact = getById(idContact);

        return contactToContactResponseDto(contact,contact.getPerson().getUsername());
    }

    @Override
    public List<ContactResponseDTO> getAllByPerson(Long idPerson) throws InformationNotFound {
        Person person = this.personService.getById(idPerson);
        List<Contact> contacts = this.contactRepository.findAllByPersonIs(person);
        List<ContactResponseDTO> result = contacts.stream().map(contact -> contactToContactResponseDto(contact,contact.getPerson().getUsername())).toList();

        return result;
    }

    @Override
    public ContactResponseDTO updateContact(Long idContact,ContactRequestDTO dto) throws InformationNotFound, BusinessRuleException {
        Contact contact = getById(idContact);

        samePerson(contact.getPerson().getId(),dto.getIdPerson());

        contact.setNumber(dto.getNumber());
        contact.setType(dto.getType());

        Contact contactUpdated = this.contactRepository.save(contact);

        return contactToContactResponseDto(contactUpdated,contactUpdated.getPerson().getUsername());
    }

    @Override
    public void deleteContact(Long idContact) throws InformationNotFound {
        Contact contact = getById(idContact);

        this.contactRepository.delete(contact);
    }

    public static Contact contactRequestDtoToContact(ContactRequestDTO dto, Person person){
        Contact contact = new Contact(
                null,
                dto.getType(),
                dto.getNumber(),
                person

        );
        return contact;
    }
    public static ContactResponseDTO contactToContactResponseDto(Contact contact, String username){


        ContactResponseDTO contactResponse = new ContactResponseDTO(
                contact.getId(),
                contact.getType(),
                contact.getNumber(),
                username

        );
        return contactResponse;
    }
    private void samePerson(Long idPerson,Long idPersonDto) throws BusinessRuleException {
        if(idPerson != idPersonDto){
            throw new BusinessRuleException("Não é possível atualizar este contato para uma pessoa diferente da que foi cadastrada incialmente");
        }
    }
}
