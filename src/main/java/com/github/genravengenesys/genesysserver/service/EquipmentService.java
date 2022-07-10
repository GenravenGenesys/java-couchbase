package com.github.genravengenesys.genesysserver.service;

import com.couchbase.client.java.Bucket;
import com.github.genravengenesys.genesysserver.model.equipment.Armor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService extends AbstractService {
    
    @Autowired
    public EquipmentService(final Bucket bucket) {
        super(bucket);
    }

    public Armor createArmor(final String name) {
        return createRecord(armorCollection, name, ARMOR, new Armor(name), Armor.class);
    }

    public Armor getArmor(final String name) {
        return getRecord(armorCollection, name, Armor.class);
    }

    public List<Armor> getArmors() {
        return getRecords(armorCollection, ARMOR, Armor.class);
    }
}
