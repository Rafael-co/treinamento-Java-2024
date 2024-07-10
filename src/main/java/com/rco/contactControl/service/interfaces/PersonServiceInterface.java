package com.rco.contactControl.service.interfaces;

import com.rco.contactControl.dto.request.PersonRequestDTO;
import com.rco.contactControl.dto.response.PersonDirectMailResponseDTO;
import com.rco.contactControl.dto.response.PersonResponseDTO;
import com.rco.contactControl.exceptions.BusinessRuleException;
import com.rco.contactControl.exceptions.InformationNotFound;
import com.rco.contactControl.model.Person;

import java.util.List;

public interface PersonServiceInterface {

    public PersonResponseDTO create (PersonRequestDTO dto) throws BusinessRuleException;

    public Person getById(Long idPerson) throws InformationNotFound;

    public PersonResponseDTO getDtoById(Long idPerson) throws InformationNotFound;

    public PersonDirectMailResponseDTO getDirectMailById(Long idPerson) throws InformationNotFound;

    public List<PersonResponseDTO> getAll();

    public PersonResponseDTO updatePerson(Long idPerson,PersonRequestDTO dto) throws InformationNotFound;

    public void deletePerson(Long edPerson) throws InformationNotFound;

}
