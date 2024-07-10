package com.rco.contactControl.dto.response;
import com.rco.contactControl.model.enums.Type;

public class ContactResponseDTO {

    private Long id;
    private String number;
    private Type type;

    private String userName;

    public ContactResponseDTO(){}

    public ContactResponseDTO(Long id, Type type, String number, String userName) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.userName = userName;
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

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
