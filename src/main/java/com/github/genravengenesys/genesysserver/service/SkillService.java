package com.github.genravengenesys.genesysserver.service;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Collection;
import com.github.genravengenesys.genesysserver.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService extends AbstractService {

    protected final Collection skillCollection;

    @Autowired
    public SkillService(final Bucket bucket) {
        super(bucket);
        this.skillCollection = bucket.scope(SKILL).collection(SKILL);
    }

    public Skill createSkill(final String name) {
        return createRecord(skillCollection, name, SKILL, new Skill(name), Skill.class);
    }

    public Skill getSkill(final String name) {
        return getRecord(skillCollection, name, Skill.class);
    }

    public List<Skill> getSkills() {
        return getRecords(skillCollection, SKILL, Skill.class);
    }

    public Skill updateSkill(final String name, final Skill skill) {
        return updateRecord(skillCollection, name, skill, Skill.class);
    }
}
