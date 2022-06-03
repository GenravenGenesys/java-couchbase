package com.github.genravengenesys.genesysserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Characteristic {
    private int current = 1;
    private int temp = 1;
}
