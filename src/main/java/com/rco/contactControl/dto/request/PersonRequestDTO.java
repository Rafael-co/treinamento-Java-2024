package com.rco.contactControl.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rco.contactControl.model.enums.States;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Validated
public class PersonRequestDTO {
    @Size(min = 5, max = 100, message = "O nome deve ter entre 5 e 100 caracteres.")
    @NotBlank(message = "Propriedade 'name' não pode ser nula e não pode ser em branco")
    @Schema(description = "Nome da Pessoa ", example = "Rafael")
    @Pattern(regexp = "^[a-zA-ZÀ-ú-' ]+$", message = "O nome pode conter apenas letras, hífen (-) e apóstrofo (').")
    @JsonProperty(value = "name")
    private String name;

    @Size(max = 150, message = "O campo endereço não pode exceder 150 caracteres.")
    @Schema(description = "Nome Da Rua e número da casa da pessoa ", example = "guaraí,43")
    @NotBlank(message = "Propriedade 'address' não pode ser nula e não pode ser em branco")
    @Pattern(regexp = "([\\p{L}0-9\\s,'.-]+)?", message = "O campo endereço aceita apenas letras, números e " +
            "caracteres especiais relacionados a endereço.")
    @JsonProperty(value = "address")
    private String address;

    @Pattern(regexp = "^[a-zA-ZÀ-ú-' ]+$", message = "O 'userName' pode conter apenas letras, hífen (-) e apóstrofo (').")
    @Schema(description = "Usuario do cadastro ", example = "RafaelCamilo")
    @NotBlank(message = "Propriedade 'username' não pode ser nula e não pode ser em branco")
    private String username;

    @Pattern(regexp = "(\\d{5}-\\d{3})|^$", message = "Formato de CEP inválido. Deve conter apenas dígitos no" +
            " formato 'xxxxx-xxx'.")
    @Schema(description = "Cep do Bairro ", example = "04518-172")
    @JsonProperty(value = "zipCode")
    private String zipCode;

    @Size(max = 150, message = "O campo cidade não pode exceder 150 caracteres.")
    @Schema(description = "Nome Da Cidade da pessoa ", example = "Paraíso")
    @Pattern(regexp = "([\\p{L}\\s]+)?", message = "O campo cidade aceita apenas letras.")
    @JsonProperty(value = "city")
    private String city;


    @JsonProperty(value = "uf")
    @NotNull(message = "uf não pode nulo, insira uma sigla em maiúsculo")
    @Schema(description = "Sigla Do estado da pessoa ", example = "SP")
    private States uf;

    @JsonProperty(value = "contacts")
    private List<ContactRequestDTO> contacts = new ArrayList<>();


    public PersonRequestDTO(){}

    public PersonRequestDTO(String name, String address, String zipCode, String city, States uf, List<ContactRequestDTO> contacts, String username) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.uf = uf;
        this.contacts = contacts;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public States getUf() {
        return uf;
    }

    public List<ContactRequestDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactRequestDTO> contacts) {
        this.contacts = contacts;
    }

    public void setUf(States uf) {
        this.uf = uf;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
