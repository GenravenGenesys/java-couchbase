package com.github.genravengenesys.genesysserver.controller;

import com.github.genravengenesys.genesysserver.model.equipment.Armor;
import com.github.genravengenesys.genesysserver.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(final EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/equipment/armor")
    public ResponseEntity<List<Armor>> getArmors() {
        return ResponseEntity.ok(equipmentService.getArmors());
    }

    @GetMapping("/equipment/armor/{name}")
    public ResponseEntity<Armor> getArmor(@PathVariable final String name) {
        return ResponseEntity.ok(equipmentService.getArmor(name));
    }

    @PostMapping("/equipment/armor/{name}")
    public ResponseEntity<Armor> createArmor(@PathVariable final String name) {
        return ResponseEntity.ok(equipmentService.createArmor(name));
    }
}
