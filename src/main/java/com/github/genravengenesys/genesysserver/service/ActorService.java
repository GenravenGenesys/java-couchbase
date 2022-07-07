package com.github.genravengenesys.genesysserver.service;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Collection;
import com.github.genravengenesys.genesysserver.model.Actor;
import com.github.genravengenesys.genesysserver.model.Nemesis;
import com.github.genravengenesys.genesysserver.model.Player;
import com.github.genravengenesys.genesysserver.model.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.genravengenesys.genesysserver.util.GenesysUtils.MAX_RANKS;

@Service
public class ActorService extends AbstractService {

    protected final Collection playerCollection;
    protected final Collection nemesisCollection;
    
    @Autowired
    public ActorService(final Bucket bucket) {
        super(bucket);
        this.playerCollection = bucket.scope(ACTOR).collection(PLAYER);
        this.nemesisCollection = bucket.scope(ACTOR).collection(NEMESIS);
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
        return createRecord(nemesisCollection, name, NEMESIS, new Nemesis(name), Nemesis.class);
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
}
