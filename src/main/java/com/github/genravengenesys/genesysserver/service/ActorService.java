package com.github.genravengenesys.genesysserver.service;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Collection;
import com.github.genravengenesys.genesysserver.model.Actor;
import com.github.genravengenesys.genesysserver.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService extends AbstractService {

    protected final Collection collection;
    
    @Autowired
    public ActorService(final Bucket bucket) {
        super(bucket);
        this.collection = bucket.scope(ACTOR).collection(PLAYER);
    }

    public Player createPlayer(final String name) {
        return createRecord(collection, name, PLAYER, new Player(name), Player.class);
    }

    public Player getPlayer(final String name) {
        return getRecord(collection, name, Player.class);
    }

    public List<Player> getPlayers() {
        return getRecords(collection, PLAYER, Player.class);
    }

    public Player updatePlayer(final String name, final Player player) {
        return updateRecord(collection, name, player, Player.class);
    }
}
