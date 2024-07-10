package com.rco.contactControl.dto.response;


import com.rco.contactControl.model.enums.States;

import java.time.LocalDateTime;
import java.util.List;

public class PersonResponseDTO {
    private Long id;
    private String name;

    private String address;

    private String zipCode;

    private String city;

    private States uf;

    private List<ContactResponseDTO> contacts;

    private String username;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public PersonResponseDTO(){}

    public PersonResponseDTO(Long id, String name, String address, String zipCode, String city, States uf, List<ContactResponseDTO> contacts, String username, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id  = id;
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.uf = uf;
        this.contacts = contacts;
        this.username = username;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public void setUf(States uf) {
        this.uf = uf;
    }

    public List<ContactResponseDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactResponseDTO> contacts) {
        this.contacts = contacts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
