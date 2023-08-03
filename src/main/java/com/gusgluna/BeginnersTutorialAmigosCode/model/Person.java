package com.gusgluna.BeginnersTutorialAmigosCode.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class Person {
    private final UUID personId;
    @NotBlank
    private final String personName;

    public Person(@JsonProperty("id") UUID personId,
                  @JsonProperty("name") String personName) {
        this.personId = personId;
        this.personName = personName;
    }

    public UUID getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }
}
