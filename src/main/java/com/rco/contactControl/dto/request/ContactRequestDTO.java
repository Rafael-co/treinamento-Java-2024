package com.rco.contactControl.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rco.contactControl.model.enums.Type;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;

@Validated
public class ContactRequestDTO {

    @NotNull(message = "O tipo de contato não pode ser nulo")
    @Schema(description = "Tipo aceitos(telefone,celular)", example = "TELEFONE")
    @JsonProperty(value = "type")
    private Type type;

    @NotBlank(message = "Número de telefone é obrigatório.")
    @Schema(description = "Número do contato", example = "(11)88144-4789")
    @Pattern(regexp = "^\\(\\d{2}\\)\\d{5}-\\d{4}$", message = "Formato de número de telefone inválido. Utilize (xx)" +
            "xxxxx-xxxx.")
    private String number;

    @NotNull(message = "O id Da pessoa não pode ser nula")
    @Schema(description = "ID da pessoa dona do contato")
    private Long idPerson;

    public ContactRequestDTO(){}

    public ContactRequestDTO(Type type, String number, Long idPerson) {
        this.type = type;
        this.number = number;
        this.idPerson = idPerson;
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

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }
}
