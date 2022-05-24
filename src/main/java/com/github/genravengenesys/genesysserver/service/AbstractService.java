package com.github.genravengenesys.genesysserver.service;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.json.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public abstract class AbstractService {

    protected final Bucket bucket;
    protected final String TALENT = "talents";
    protected final String ACTOR = "actors";
    protected final String PLAYER = "players";

    @Autowired
    public AbstractService(final Bucket bucket) {
        this.bucket = bucket;
    }

    private JsonArray createJsonArray(final String name) {
        final JsonArray array = JsonArray.create();
        return array.add(name);
    }

    protected void updateMasterList(final String type, final String name) {
        if (!bucket.defaultCollection().exists(type).exists()) {
            bucket.defaultCollection().upsert(type, createJsonArray(name));
        }
        final JsonArray array = getMasterList(type);
        if (!array.contains(name)) {
            bucket.defaultCollection().upsert(type, getMasterList(type).add(name));
        }
    }

    protected JsonArray getMasterList(final String type) {
        return bucket.defaultCollection().get(type).contentAsArray();
    }

    protected <T> T getRecord(final Collection collection, final String name, final Class<T> t) {
        return collection.get(name).contentAs(t);
    }

    protected void upsertRecord(final Collection collection, final String name, final Object object) {
        collection.upsert(name, object);
    }

    protected <T> T updateRecord(final Collection collection, final String name, final Object object, final Class<T> t) {
        upsertRecord(collection, name, object);
        return getRecord(collection, name, t);
    }

    protected <T> T createRecord(final Collection collection, final String name, final String type, final Object object, final Class<T> t) {
        upsertRecord(collection, name, object);
        updateMasterList(type, name);
        return getRecord(collection, name, t);
    }

    public <T> List<T> getRecords(final Collection collection, final String type, final Class<T> t) {
        final List<T> results = new ArrayList<>();
        final JsonArray array = getMasterList(type);
        for (int i = 0; i < array.size(); i++) {
            results.add(getRecord(collection, array.getString(i), t));
        }
        return results;
    }
}
