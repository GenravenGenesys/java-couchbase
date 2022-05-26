package com.github.genravengenesys.genesysserver.service;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Collection;
import com.github.genravengenesys.genesysserver.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService extends AbstractService {

    protected final Collection collection;

    @Autowired
    public SkillService(final Bucket bucket) {
        super(bucket);
        this.collection = bucket.scope(SKILL).collection(SKILL);
    }

    public Skill createSkill(final String name) {
        return createRecord(collection, name, TALENT, new Skill(name), Skill.class);
    }

    public Skill getSkill(final String name) {
        return getRecord(collection, name, Skill.class);
    }

    public List<Skill> getSkills() {
        return getRecords(collection, TALENT, Skill.class);
    }

    public Skill updateSkill(final String name, final Skill skill) {
        return updateRecord(collection, name, skill, Skill.class);
    }
}
