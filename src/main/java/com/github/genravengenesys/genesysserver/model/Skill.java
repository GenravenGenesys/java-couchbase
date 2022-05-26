package com.github.genravengenesys.genesysserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Skill {

    private String name;
    private boolean active = false;
    private Type type;
    private Characteristic characteristic;

    public Skill(final String name) {
        this.name = name;
    }

    protected Skill() {}

    enum Type {
        @JsonProperty("General")
        GENERAL,
        @JsonProperty("Social")
        SOCIAL,
        @JsonProperty("Magic")
        MAGIC,
        @JsonProperty("Combat")
        COMBAT,
        @JsonProperty("Knowledge")
        KNOWLEDGE
    }

    enum Characteristic {
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
