package com.github.genravengenesys.genesysserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Actor {
    private String name;
    private Characteristic brawn = new Characteristic();
    private Characteristic agility = new Characteristic();
    private Characteristic intellect = new Characteristic();
    private Characteristic cunning = new Characteristic();
    private Characteristic willpower = new Characteristic();
    private Characteristic presence = new Characteristic();
    private int soak;
    private Stats wounds = new Stats();
    private Defense melee = new Defense();
    private Defense ranged = new Defense();
    private List<ActorTalent> talents = new ArrayList<>();
    private List<ActorSkill> skills = new ArrayList<>();

    @Data
    public static class Stats {
        private int current = 0;
        private int max = 1;

        enum Type {
            @JsonProperty("Wounds")
            WOUNDS,
            @JsonProperty("Strain")
            STRAIN
        }

        public Stats() {}
    }

    @Data
    public static class Defense {
        private int current = 0;
        private int temp = 0;

        enum Type {
            @JsonProperty("Melee")
            MELEE,
            @JsonProperty("Ranged")
            RANGED
        }

        public Defense() {}
    }

    @Data
    public static class Characteristic {
        private int current = 1;
        private int temp = 1;

        public Characteristic() {}

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

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class ActorTalent extends Talent {
        private int ranks;
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class ActorSkill extends Skill {
        private int ranks;
        private boolean career;
    }
}
