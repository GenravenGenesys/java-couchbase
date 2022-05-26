package com.github.genravengenesys.genesysserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data()
@EqualsAndHashCode(callSuper = false)
public class Player extends Actor {

    public Player(final String name) {
        this.setName(name);
    }

    private Player() {}

    private Stats strain = new Stats();
}
