package com.github.genravengenesys.genesysserver.service;

import com.couchbase.client.java.Bucket;
import com.github.genravengenesys.genesysserver.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.genravengenesys.genesysserver.util.GenesysUtils.MAX_RANKS;

@Service
public class ActorService extends AbstractService {
    
    @Autowired
    public ActorService(final Bucket bucket) {
        super(bucket);
    }

    public Player createPlayer(final String name) {
        return createRecord(playerCollection, name, PLAYER, new Player(name), Player.class);
    }

    public Player getPlayer(final String name) {
        return getRecord(playerCollection, name, Player.class);
    }

    public List<Player> getPlayers() {
        return getRecords(playerCollection, PLAYER, Player.class);
    }

    public Player updatePlayer(final String name, final Player player) {
        return updateRecord(playerCollection, name, player, Player.class);
    }

    public Nemesis createNemesis(final String name) {
        final Nemesis nemesis = new Nemesis(name);
        nemesis.setSkills(getActiveSkills());
        return createRecord(nemesisCollection, name, NEMESIS, nemesis, Nemesis.class);
    }

    public Nemesis getNemesis(final String name) {
        return getRecord(nemesisCollection, name, Nemesis.class);
    }

    public List<Nemesis> getNemeses() {
        return getRecords(nemesisCollection, NEMESIS, Nemesis.class);
    }

    public Nemesis updateNemesis(final String name, final Nemesis nemesis) {
        return updateRecord(nemesisCollection, name, nemesis, Nemesis.class);
    }
    
    public Nemesis updateNemesisSkill(final String name, final Actor.ActorSkill skill) {
        final Nemesis nemesis = getNemesis(name);
        nemesis.getSkills().replaceAll(actorSkill -> actorSkill.getName().equals(skill.getName()) ? skill : actorSkill);
        return updateNemesis(name, nemesis);
    }

    public Nemesis updateNemesisTalent(final String name, final Actor.ActorTalent talent) {
        final Nemesis nemesis = getNemesis(name);
        final List<Actor.ActorTalent> talents = nemesis.getTalents();
        if (talents.isEmpty()) {
            talents.add(talent);
        }
        else {
            talents.forEach(actorTalent -> {
                if (actorTalent.getName().equals(talent.getName())) {
                    if (Talent.Ranked.YES.equals(actorTalent.getRanked()) && actorTalent.getRanks() < MAX_RANKS) {
                        actorTalent.setRanks(actorTalent.getRanks() + 1);
                    }
                } else {
                    talents.add(talent);
                }
            });
        }
        nemesis.setTalents(talents);
        return updateNemesis(name, nemesis);
    }

    public Rival createRival(final String name) {
        return createRecord(rivalCollection, name, RIVAL, new Rival(name), Rival.class);
    }

    public Rival getRival(final String name) {
        return getRecord(rivalCollection, name, Rival.class);
    }

    public List<Rival> getRivals() {
        return getRecords(rivalCollection, RIVAL, Rival.class);
    }

    public Rival updateRival(final String name, final Rival rival) {
        return updateRecord(rivalCollection, name, rival, Rival.class);
    }

    private List<Actor.ActorSkill> getActiveSkills() {
        return getRecords(skillCollection, SKILL, Actor.ActorSkill.class).stream()
                .filter(Skill::isActive)
                .collect(Collectors.toList());
    }
}
