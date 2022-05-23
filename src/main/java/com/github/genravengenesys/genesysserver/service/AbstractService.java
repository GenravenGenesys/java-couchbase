package com.github.genravengenesys.genesysserver.service;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.json.JsonArray;
import com.couchbase.client.java.kv.GetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractService {

    protected final Bucket bucket;
    protected final String TALENT = "talents";

    @Autowired
    public AbstractService(final Bucket bucket) {
        this.bucket = bucket;
    }

    protected void updateMasterList(final String type, final String name) {
        bucket.defaultCollection().upsert(type, getMasterList(type).add(name));
    }

    protected JsonArray getMasterList(final String type) {
        return bucket.defaultCollection().get(type).contentAsArray();
    }

    protected GetResult getRecord(final Collection collection, final String name) {
        return collection.get(name);
    }

    protected void upsertRecord(final Collection collection, final String name, final Object object) {
        collection.upsert(name, object);
    }
}
