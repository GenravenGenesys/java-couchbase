package com.github.genravengenesys.genesysserver.model.equipment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public abstract class Equipment {
    private String name;
    private String description;
    private Price price;
    private int encumbrance;
    private EquipmentSlot slot;
    private Rarity rarity;

    public enum EquipmentSlot {
        @JsonProperty("Main Hand")
        MAIN_HAND,
        @JsonProperty("Off Hand")
        OFF_HAND,
        @JsonProperty("Both Hands")
        BOTH_HANDS,
        @JsonProperty("Body")
        BODY
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Price {
        private int value = 0;
        private boolean restricted = false;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Rarity {
        private int value = 0;
        private int modifier = 0;
    }
}