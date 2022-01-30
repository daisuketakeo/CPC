package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RAiRelation;
import com.cpc.model.AI_RELATION_TABLE;

/**
 * 受入指図連携テーブル Service
 */
@Service
public class SAiRelation {

    private final RAiRelation repos;

    @Autowired
    public SAiRelation(RAiRelation repos) {
     this.repos = repos;
    }

    public boolean insert(AI_RELATION_TABLE model) {
     return repos.insert(model) > 0;
    }

    public boolean update(AI_RELATION_TABLE model) {
     return repos.update(model) > 0;
    }

    public boolean delete(AI_RELATION_TABLE model) {
     return repos.delete(model) > 0;
    }

    public List<AI_RELATION_TABLE> select(AI_RELATION_TABLE model) {
     return repos.select(model);
    }

}
