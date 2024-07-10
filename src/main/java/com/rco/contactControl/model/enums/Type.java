package com.rco.contactControl.model.enums;

public enum Type {

    TELEFONE("telefone"),
    CELULAR("celular");


    private final String description;

    Type(String description) {
        this.description = description;
    }
}
