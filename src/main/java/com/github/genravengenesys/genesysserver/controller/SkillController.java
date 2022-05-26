package com.github.genravengenesys.genesysserver.controller;

import com.github.genravengenesys.genesysserver.model.Skill;
import com.github.genravengenesys.genesysserver.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController {

    private final SkillService skillService;

    @Autowired
    public SkillController(final SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/skills")
    public ResponseEntity<List<Skill>> getSkills() {
        return ResponseEntity.ok(skillService.getSkills());
    }

    @GetMapping("/skills/{name}")
    public ResponseEntity<Skill> getSkill(@PathVariable final String name) {
        return ResponseEntity.ok(skillService.getSkill(name));
    }

    @PostMapping("/skills/{name}")
    public ResponseEntity<Skill> createSkill(@PathVariable final String name) {
        return ResponseEntity.ok(skillService.createSkill(name));
    }

    @PutMapping("/skills/{name}")
    public ResponseEntity<Skill> updateSkill(@PathVariable final String name, @RequestBody final Skill skill) {
        return ResponseEntity.ok(skillService.updateSkill(name, skill));
    }
}
