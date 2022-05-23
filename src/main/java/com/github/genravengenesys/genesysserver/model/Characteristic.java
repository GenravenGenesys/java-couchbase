package com.github.genravengenesys.genesysserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Characteristic {
    private Type type;
    private int current = 1;
    private int temp = 1;

    public Characteristic(final Type type) {
        this.type = type;
    }

    enum Type {
        @JsonProperty("Brawn")
        BRAWN,
        @JsonProperty("Agility")
        AGILITY,
        @JsonProperty("Intellect")
        INTELLECT,
        @JsonProperty("Cunning")
        CUNNING,
        @JsonProperty("Willpower")
        WILLPOWER,
        @JsonProperty("Presence")
        PRESENCE
    }
}
