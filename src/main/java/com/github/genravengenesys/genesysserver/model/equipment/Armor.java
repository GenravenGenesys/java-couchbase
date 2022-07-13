package com.github.genravengenesys.genesysserver.model.equipment;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Armor extends Equipment {
    private int defense;
    private int soak;

    private Armor() {}

    public Armor(final String name) {
        this.setName(name);
    }
}
