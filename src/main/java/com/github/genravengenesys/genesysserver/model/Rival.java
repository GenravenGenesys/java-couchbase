package com.github.genravengenesys.genesysserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Rival extends NonPlayerCharacter {

    public Rival(final String name) {
        this.setName(name);
    }

    private Rival() {}
}
