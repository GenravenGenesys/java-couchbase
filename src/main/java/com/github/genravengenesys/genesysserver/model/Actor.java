package com.github.genravengenesys.genesysserver.model;

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
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Defense {
        private int current = 0;
        private int temp = 0;
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
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class PlayerSkill extends ActorSkill {
        private boolean career;
    }
}
