package com.github.genravengenesys.genesysserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public abstract class Actor {
    private String name;
    private Characteristic brawn = new Characteristic(Characteristic.Type.BRAWN);
    private Characteristic agility = new Characteristic(Characteristic.Type.AGILITY);
    private Characteristic intellect = new Characteristic(Characteristic.Type.INTELLECT);
    private Characteristic cunning = new Characteristic(Characteristic.Type.CUNNING);
    private Characteristic willpower = new Characteristic(Characteristic.Type.WILLPOWER);
    private Characteristic presence = new Characteristic(Characteristic.Type.PRESENCE);
    private int soak;
    private Stats wounds = new Stats(Stats.Type.WOUNDS);
    private Defense melee = new Defense(Defense.Type.MELEE);
    private Defense ranged = new Defense(Defense.Type.RANGED);

    @Data
    public static class Stats {
        private Type type;
        private int current = 0;
        private int max = 1;

        enum Type {
            @JsonProperty("Wounds")
            WOUNDS,
            @JsonProperty("Strain")
            STRAIN
        }

        public Stats(final Type type) {
            this.type = type;
        }
    }

    @Data
    public static class Defense {
        private Type type;
        private int current = 0;
        private int temp = 0;

        enum Type {
            @JsonProperty("Melee")
            MELEE,
            @JsonProperty("Ranged")
            RANGED
        }

        public Defense(final Type type) {
            this.type = type;
        }
    }

    @Data
    public static class Characteristic {
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
}
