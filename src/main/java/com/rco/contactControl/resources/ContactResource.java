package com.rco.contactControl.resources;

import com.rco.contactControl.dto.request.ContactRequestDTO;
import com.rco.contactControl.exceptions.BusinessRuleException;
import com.rco.contactControl.exceptions.InformationNotFound;
import com.rco.contactControl.resources.documentation.ContactResourceDoc;
import com.rco.contactControl.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contatos")
public class ContactResource implements ContactResourceDoc {
    @Autowired
    ContactService contactService;

    @PostMapping(path = "/")
    public ResponseEntity<?> create (@RequestBody @Valid ContactRequestDTO dto) throws InformationNotFound {
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.contactService.create(dto));
    }

    @GetMapping(path ="/{idContact}")
    public ResponseEntity<?>getById(@PathVariable Long idContact) throws InformationNotFound {
        return ResponseEntity.status(HttpStatus.OK).body(this.contactService.getDtoById(idContact));
    }

    @GetMapping(path = "/pessoa/{idPessoa}")
    public ResponseEntity<?>getByPerson(@PathVariable Long idPessoa ) throws InformationNotFound {
        return ResponseEntity.status(HttpStatus.OK).body(this.contactService.getAllByPerson(idPessoa));
    }

    @PutMapping(path = "/{idContact}")
    public ResponseEntity<?>updateContact(@PathVariable Long idContact,@RequestBody @Valid ContactRequestDTO dto) throws InformationNotFound, BusinessRuleException {
        return ResponseEntity.status(HttpStatus.OK).body(this.contactService.updateContact(idContact,dto));
    }

    @DeleteMapping(path = "/{idContact}")
    public ResponseEntity<?>deleteContact(@PathVariable Long idContact) throws InformationNotFound {
        this.contactService.deleteContact(idContact);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
