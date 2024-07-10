package com.rco.contactControl.resources;

import com.rco.contactControl.dto.request.PersonRequestDTO;
import com.rco.contactControl.exceptions.BusinessRuleException;
import com.rco.contactControl.exceptions.InformationNotFound;
import com.rco.contactControl.resources.documentation.PersonResourceDoc;
import com.rco.contactControl.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pessoas")
public class PersonResource implements PersonResourceDoc {

    @Autowired
    PersonService personService;


    public ResponseEntity<?> create(@RequestBody @Valid PersonRequestDTO dto) throws BusinessRuleException {

        return ResponseEntity.status(HttpStatus.CREATED).body(this.personService.create(dto));
    }


    public ResponseEntity<?> getById(@PathVariable Long idPerson ) throws InformationNotFound {
        return ResponseEntity.status(HttpStatus.OK).body(this.personService.getDtoById(idPerson));
    }



    public ResponseEntity<?>getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.personService.getAll());
    }


    public ResponseEntity<?>getDirectMailById(@PathVariable Long idPerson) throws InformationNotFound {
        return ResponseEntity.status(HttpStatus.OK).body(this.personService.getDirectMailById(idPerson));
    }


    public ResponseEntity<?> update(@PathVariable Long idPerson,@RequestBody @Valid PersonRequestDTO dto) throws InformationNotFound {
       return ResponseEntity.status(HttpStatus.OK).body(this.personService.updatePerson(idPerson,dto));
   }


    public  ResponseEntity<?> delete(@PathVariable Long idPerson) throws InformationNotFound {
        this.personService.deletePerson(idPerson);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
