package com.github.genravengenesys.genesysserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Nemesis extends Actor {

    public Nemesis(final String name) {
        this.setName(name);
    }

    private Nemesis() {}

    private Stats strain = new Stats();
}
