package com.rco.contactControl.model;


import com.rco.contactControl.model.enums.Type;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact",nullable = false)
    private Long id;

    @Column(name = "type_contact")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "id_person",nullable = false)
    private Person person;

     public Contact(){}

    public Contact(Long id, Type type, String number, Person person) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contact other = (Contact) obj;
        return Objects.equals(id, other.id);
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "[id = " + this.id +
                ", Tipo de contato = " + this.type +
                ", Número = " + this.number +
                ", Cliente = " + this.person +
                "]"
                ;
    }


}
