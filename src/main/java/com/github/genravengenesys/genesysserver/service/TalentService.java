package com.github.genravengenesys.genesysserver.service;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.json.JsonArray;
import com.github.genravengenesys.genesysserver.model.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TalentService extends AbstractService {

    protected final Collection collection;

    @Autowired
    public TalentService(final Bucket bucket) {
        super(bucket);
        this.collection = bucket.scope(TALENT).collection(TALENT);
    }

    public Talent createTalent(final String name) {
        upsertRecord(collection, name, new Talent(name));
        updateMasterList(TALENT, name);
        return getTalent(name);
    }

    public Talent getTalent(final String name) {
        return getRecord(collection, name).contentAs(Talent.class);
    }

    public List<Talent> getTalents() {
        final List<Talent> talents = new ArrayList<>();
        final JsonArray array = getMasterList(TALENT);
        for (int i = 0; i < array.size(); i++) {
            talents.add(getTalent(array.getString(i)));
        }
        return talents;
    }

    public Talent updateTalent(final String name, final Talent talent) {
        upsertRecord(collection, name, talent);
        return getTalent(name);
    }
}
