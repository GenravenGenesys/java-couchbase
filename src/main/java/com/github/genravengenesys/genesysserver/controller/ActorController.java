package com.github.genravengenesys.genesysserver.controller;

import com.github.genravengenesys.genesysserver.model.Actor;
import com.github.genravengenesys.genesysserver.model.Nemesis;
import com.github.genravengenesys.genesysserver.model.Player;
import com.github.genravengenesys.genesysserver.model.Rival;
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
    public ResponseEntity<Player> updatePlayer(@PathVariable final String name, @RequestBody final Player player) {
        return ResponseEntity.ok(actorService.updatePlayer(name, player));
    }

    @GetMapping("/actors/nemesis")
    public ResponseEntity<List<Nemesis>> getNemeses() {
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
    public ResponseEntity<Nemesis> updateNemesis(@PathVariable final String name, @RequestBody final Nemesis nemesis) {
        return ResponseEntity.ok(actorService.updateNemesis(name, nemesis));
    }
    
    @PutMapping("/actors/nemesis/{name}/skill")
    public ResponseEntity<Nemesis> updateNemesisSkill(@PathVariable final String name, @RequestBody final Actor.ActorSkill skill) {
        return ResponseEntity.ok(actorService.updateNemesisSkill(name, skill));
    }

    @PutMapping("/actors/nemesis/{name}/talent")
    public ResponseEntity<Nemesis> updateNemesisTalent(@PathVariable final String name, @RequestBody final Actor.ActorTalent talent) {
        return ResponseEntity.ok(actorService.updateNemesisTalent(name, talent));
    }

    @GetMapping("/actors/rival")
    public ResponseEntity<List<Rival>> getRivals() {
        return ResponseEntity.ok(actorService.getRivals());
    }

    @GetMapping("/actors/rival/{name}")
    public ResponseEntity<Rival> getRival(@PathVariable final String name) {
        return ResponseEntity.ok(actorService.getRival(name));
    }

    @PostMapping("/actors/rival/{name}")
    public ResponseEntity<Rival> createRival(@PathVariable final String name) {
        return ResponseEntity.ok(actorService.createRival(name));
    }

    @PutMapping("/actors/rival/{name}")
    public ResponseEntity<Rival> updateRival(@PathVariable final String name, @RequestBody final Rival rival) {
        return ResponseEntity.ok(actorService.updateRival(name, rival));
    }
}
