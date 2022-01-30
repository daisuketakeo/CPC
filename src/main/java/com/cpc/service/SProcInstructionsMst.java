package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RProcInstructionsMst;
import com.cpc.model.PROC_INSTRUCTIONS_MASTER;

/**
 * 工程別製造指図マスタ Service
 */
@Service
public class SProcInstructionsMst {

    private final RProcInstructionsMst repos;

    @Autowired
    public SProcInstructionsMst(RProcInstructionsMst repos) {
     this.repos = repos;
    }

    public boolean insert(PROC_INSTRUCTIONS_MASTER model) {
     return repos.insert(model) > 0;
    }

    public boolean update(PROC_INSTRUCTIONS_MASTER model) {
     return repos.update(model) > 0;
    }

    public boolean delete(PROC_INSTRUCTIONS_MASTER model) {
     return repos.delete(model) > 0;
    }

    public List<PROC_INSTRUCTIONS_MASTER> select(PROC_INSTRUCTIONS_MASTER model) {
     return repos.select(model);
    }

}
