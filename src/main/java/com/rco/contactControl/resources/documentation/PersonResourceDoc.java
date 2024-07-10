package com.rco.contactControl.resources.documentation;

import com.rco.contactControl.dto.request.PersonRequestDTO;
import com.rco.contactControl.exceptions.BusinessRuleException;
import com.rco.contactControl.exceptions.InformationNotFound;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface PersonResourceDoc {
    @Operation(summary = "Cadastra uma pessoa", description = "Adiciona uma nova pessoa no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pesooa adicionada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição mal formada"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
    })
    @PostMapping(path = "/")
    public ResponseEntity<?> create(@RequestBody @Valid PersonRequestDTO dto) throws BusinessRuleException;

    @Operation(summary = "Busca uma pessoa pelo ID", description = "Busca uma pessoa no banco de dados pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pessoa encontrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição mal formada"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
    })
    @GetMapping(path = "/{idPerson}")
    public ResponseEntity<?> getById(@PathVariable Long idPerson ) throws InformationNotFound;

    @Operation(summary = "Busca todas as pessoas cadastradas", description = "Busca todas as pessoas no banco de dados ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pessoas encontradas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição mal formada"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
    })
    @GetMapping(path = "/")
    public ResponseEntity<?>getAll();


    @Operation(summary = "Busca a mala direta de uma pessoa pelo ID", description = "Busca a mala direta de uma pessoa pelo ID no banco de dados ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pessoa encontrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição mal formada"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
    })
    @GetMapping(path = "maladireta/{idPerson}")
    public ResponseEntity<?>getDirectMailById(@PathVariable Long idPerson) throws InformationNotFound;

    @Operation(summary = "Atualiza uma pessoa pelo ID", description = "Busca uma pessoa pelo ID e atualiza no banco de dados ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pessoa encontrada e atualiada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição mal formada"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
    })
    @PutMapping(path = "/{idPerson}")
    public ResponseEntity<?> update(@PathVariable Long idPerson,@RequestBody @Valid PersonRequestDTO dto) throws InformationNotFound;

    @Operation(summary = "Deleta uma pessoa pelo ID", description = "Busca uma pessoa pelo ID e deleta do banco de dados ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pessoa encontrada e deletada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição mal formada"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
    })
    @DeleteMapping(path = "/{idPerson}")
    public  ResponseEntity<?> delete(@PathVariable Long idPerson) throws InformationNotFound;
}

