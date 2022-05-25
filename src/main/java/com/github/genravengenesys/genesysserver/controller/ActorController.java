package com.github.genravengenesys.genesysserver.controller;

import com.github.genravengenesys.genesysserver.model.Nemesis;
import com.github.genravengenesys.genesysserver.model.Player;
import com.github.genravengenesys.genesysserver.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {
    
    private final ActorService actorService;
    
    @Autowired
    public ActorController(final ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actors/players")
    public ResponseEntity<List<Player>> getPlayer() {
        return ResponseEntity.ok(actorService.getPlayers());
    }

    @GetMapping("/actors/players/{name}")
    public ResponseEntity<Player> getPlayer(@PathVariable final String name) {
        return ResponseEntity.ok(actorService.getPlayer(name));
    }

    @PostMapping("/actors/players/{name}")
    public ResponseEntity<Player> createPlayer(@PathVariable final String name) {
        return ResponseEntity.ok(actorService.createPlayer(name));
    }

    @PutMapping("/actors/players/{name}")
    public ResponseEntity<Player> updatePlayer(@PathVariable final String name, @RequestBody final Player talent) {
        return ResponseEntity.ok(actorService.updatePlayer(name, talent));
    }

    @GetMapping("/actors/nemesis")
    public ResponseEntity<List<Nemesis>> getNemesis() {
        return ResponseEntity.ok(actorService.getNemeses());
    }

    @GetMapping("/actors/nemesis/{name}")
    public ResponseEntity<Nemesis> getNemesis(@PathVariable final String name) {
        return ResponseEntity.ok(actorService.getNemesis(name));
    }

    @PostMapping("/actors/nemesis/{name}")
    public ResponseEntity<Nemesis> createNemesis(@PathVariable final String name) {
        return ResponseEntity.ok(actorService.createNemesis(name));
    }

    @PutMapping("/actors/nemesis/{name}")
    public ResponseEntity<Nemesis> updateNemesis(@PathVariable final String name, @RequestBody final Nemesis talent) {
        return ResponseEntity.ok(actorService.updateNemesis(name, talent));
    }
}
