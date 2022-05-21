package com.github.genravengenesys.genesysserver.controller;

import com.github.genravengenesys.genesysserver.model.Talent;
import com.github.genravengenesys.genesysserver.service.TalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TalentController {

    private final TalentService talentService;

    @Autowired
    public TalentController(final TalentService talentService) {
        this.talentService = talentService;
    }

    @GetMapping("/talents")
    public ResponseEntity<List<Talent>> getTalent() {
        return ResponseEntity.ok(talentService.getTalents());
    }

    @GetMapping("/talents/{name}")
    public ResponseEntity<Talent> getTalent(@PathVariable final String name) {
        return ResponseEntity.ok(talentService.getTalent(name));
    }

    @PostMapping("/talents/{name}")
    public ResponseEntity<Talent> createTalent(@PathVariable final String name) {
        return ResponseEntity.ok(talentService.createTalent(name));
    }

    @PutMapping("/talents/{name}")
    public ResponseEntity<Talent> updateTalent(@PathVariable final String name, @RequestBody final Talent talent) {
        return ResponseEntity.ok(talentService.updateTalent(name, talent));
    }
}
