package com.rco.contactControl.model;

import com.rco.contactControl.model.enums.States;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person",nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String address;

    @Column(name = "zip_code",length = 9)
    private String zipCode;

    @Column
    private String city;

    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    private States uf;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private List<Contact> contacts;

    @Column(name = "username",unique = true)
    private String username;




    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    public Person(){}

    public Person(Long id, String name, String address, String zipCode, String city, States uf, List<Contact> contacts, String username) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.uf = uf;
        this.contacts = contacts;
        this.username = username;
        this.createdAt = LocalDateTime.now();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "[id = " + this.id +
                ", Name = " + this.name +
                ", Adress = " + this.address +
                ", Zip code = " + this.zipCode +
                ", City = " + this.city +
                ", UF = " + this.uf +
                "Creat at = "+ this.createdAt +
                "Update at = " + this.updatedAt +
                "]"
                ;
    }
}
