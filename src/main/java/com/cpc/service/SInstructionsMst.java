package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RInstructionsMst;
import com.cpc.model.INSTRUCTIONS_MASTER;

/**
 * 製造指図マスタ Service
 */
@Service
public class SInstructionsMst {

    private final RInstructionsMst repos;

    @Autowired
    public SInstructionsMst(RInstructionsMst repos) {
     this.repos = repos;
    }

    public boolean insert(INSTRUCTIONS_MASTER model) {
     return repos.insert(model) > 0;
    }

    public boolean update(INSTRUCTIONS_MASTER model) {
     return repos.update(model) > 0;
    }

    public boolean delete(INSTRUCTIONS_MASTER model) {
     return repos.delete(model) > 0;
    }

    public List<INSTRUCTIONS_MASTER> select(INSTRUCTIONS_MASTER model) {
     return repos.select(model);
    }

}
