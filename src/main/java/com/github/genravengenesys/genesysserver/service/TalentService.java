package com.github.genravengenesys.genesysserver.service;

import com.couchbase.client.java.Bucket;
import com.github.genravengenesys.genesysserver.model.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentService {

    protected final Bucket bucket;

    @Autowired
    public TalentService(final Bucket bucket) {
        this.bucket = bucket;
    }

    public Talent createTalent(final String name) {
        bucket.defaultCollection().insert(name, new Talent(name));
        return getTalent(name);
    }

    public Talent getTalent(final String name) {
        return bucket.defaultCollection().get(name).contentAs(Talent.class);
    }

    public List<Talent> getTalents() {
        return bucket.defaultScope().query("select * from ").rowsAs(Talent.class);
    }

    public Talent updateTalent(final String name, final Talent talent) {
        bucket.defaultCollection().upsert(name, talent);
        return getTalent(name);
    }
}
