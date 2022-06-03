package com.github.genravengenesys.genesysserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Stats {
        private int current = 0;
        private int max = 1;

        enum Type {
            @JsonProperty("Wounds")
            WOUNDS,
            @JsonProperty("Strain")
            STRAIN
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Defense {
        private int current = 0;
        private int temp = 0;

        enum Type {
            @JsonProperty("Melee")
            MELEE,
            @JsonProperty("Ranged")
            RANGED
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
