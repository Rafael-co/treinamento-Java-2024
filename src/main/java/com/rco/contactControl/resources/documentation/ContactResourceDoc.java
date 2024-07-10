package com.rco.contactControl.resources.documentation;

import com.rco.contactControl.dto.request.ContactRequestDTO;
import com.rco.contactControl.exceptions.BusinessRuleException;
import com.rco.contactControl.exceptions.InformationNotFound;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ContactResourceDoc {
    @Operation(summary = "Cadastra um contato ", description = "Adiciona um novo contato  no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Contato adicionado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição mal formada"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
    })
    @PostMapping(path = "/")
    public ResponseEntity<?> create (@RequestBody @Valid ContactRequestDTO dto) throws InformationNotFound;

    @Operation(summary = "Busca um contato pelo ID", description = "Busca um contato no banco de dados pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Contato encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição mal formada"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
    })
    @GetMapping(path = "/{idContact}")
    public ResponseEntity<?>getById(@PathVariable Long idContact) throws InformationNotFound;

    @Operation(summary = "Busca todos os contatos cadastrados de uma pessoa ", description = "Busca todos os contatos cadastrados de uma pessoa no banco de dados ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Contatos encontrados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição mal formada"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
    })
    @GetMapping(path = "/pessoa/{idPessoa}")
    public ResponseEntity<?>getByPerson(@PathVariable Long idPessoa ) throws InformationNotFound;


    @Operation(summary = "Atualiza o contato  pelo ID", description = "Busca e Atualiza o contato  pelo ID  no banco de dados ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Contato encontrado e atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição mal formada"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
    })
    @PutMapping(path = "/{idContact}")
    public ResponseEntity<?>updateContact(@PathVariable Long idContact,@RequestBody @Valid ContactRequestDTO dto) throws InformationNotFound, BusinessRuleException;



    @Operation(summary = "Deleta um contato pelo ID", description = "Busca um contato pelo ID e deleta do banco de dados ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "contato encontrado e deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição mal formada"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
    })
    @DeleteMapping(path = "/{idContact}")
    public ResponseEntity<?>deleteContact(@PathVariable Long idContact) throws InformationNotFound;
}
