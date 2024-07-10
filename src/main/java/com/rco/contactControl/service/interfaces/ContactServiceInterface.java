package com.rco.contactControl.service.interfaces;

import com.rco.contactControl.dto.request.ContactRequestDTO;
import com.rco.contactControl.dto.response.ContactResponseDTO;
import com.rco.contactControl.exceptions.BusinessRuleException;
import com.rco.contactControl.exceptions.InformationNotFound;
import com.rco.contactControl.model.Contact;

import java.util.List;

public interface ContactServiceInterface {

    public ContactResponseDTO create(ContactRequestDTO dto) throws InformationNotFound;

    public Contact getById(Long idContact) throws InformationNotFound;

    public List<ContactResponseDTO> getAllByPerson(Long idPerson) throws InformationNotFound;

    public ContactResponseDTO updateContact(Long idContact,ContactRequestDTO dto) throws InformationNotFound, BusinessRuleException;

    public ContactResponseDTO getDtoById(Long idContact) throws InformationNotFound;

    public void deleteContact(Long idContact) throws InformationNotFound;
}
