package com.github.genravengenesys.genesysserver.model;

import lombok.Data;

@Data
public abstract class NonPlayerCharacter extends Actor {
    private int combat;
    private int social;
    private int general;
}
