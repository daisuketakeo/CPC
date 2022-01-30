package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RInstructions;
import com.cpc.model.INSTRUCTIONS_TABLE;

/**
 * 製造指図テーブル Service
 */
@Service
public class SInstructions {

    private final RInstructions repos;

    @Autowired
    public SInstructions(RInstructions repos) {
     this.repos = repos;
    }

    public boolean insert(INSTRUCTIONS_TABLE model) {
     return repos.insert(model) > 0;
    }

    public boolean update(INSTRUCTIONS_TABLE model) {
     return repos.update(model) > 0;
    }

    public boolean delete(INSTRUCTIONS_TABLE model) {
     return repos.delete(model) > 0;
    }

    public List<INSTRUCTIONS_TABLE> select(INSTRUCTIONS_TABLE model) {
     return repos.select(model);
    }

}
