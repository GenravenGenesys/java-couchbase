package com.github.genravengenesys.genesysserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Talent {
    private String name;
    private Ranked ranked;
    private Activation activation;
    private Tier tier;
    private String description;

    public Talent(final String name) {
        this.name = name;
    }

    protected Talent() {}

    enum Ranked {
        @JsonProperty("Yes")
        YES,
        @JsonProperty("No")
        NO
    }

    enum Activation {
        @JsonProperty("Passive")
        PASSIVE,
        @JsonProperty("Active (Action)")
        ACTIVEACTION,
        @JsonProperty("Active (Maneuver)")
        ACTIVEMANEUVER,
        @JsonProperty("Active (Incidental)")
        ACTIVEINCIDENTAL,
        @JsonProperty("Active (Incidental, Out Of Turn)")
        ACTIVEINCIDENTALOUTOFTURN
    }

    enum Tier {
        @JsonProperty("First")
        FIRST,
        @JsonProperty("Second")
        SECOND,
        @JsonProperty("Third")
        THIRD,
        @JsonProperty("Fourth")
        FOURTH,
        @JsonProperty("Fifth")
        FIFTH
    }
}
