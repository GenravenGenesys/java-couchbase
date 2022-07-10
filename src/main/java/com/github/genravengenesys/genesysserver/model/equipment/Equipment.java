package com.github.genravengenesys.genesysserver.model.equipment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public abstract class Equipment {
    private String name;
    private String description;
    private Price price;
    private Encumbrance encumbrance;
    private Rarity rarity;

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
    public static class Encumbrance {
        private int value = 0;
        private boolean worn = false;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Rarity {
        private int value = 0;
        private int modifier = 0;
    }
}