package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RProcInstructionsDetailMst;
import com.cpc.model.PROC_INSTRUCTIONS_DETAIL_MASTER;

/**
 * 工程別製造指図詳細マスタ Service
 */
@Service
public class SProcInstructionsDetailMst {

    private final RProcInstructionsDetailMst repos;

    @Autowired
    public SProcInstructionsDetailMst(RProcInstructionsDetailMst repos) {
     this.repos = repos;
    }

    public boolean insert(PROC_INSTRUCTIONS_DETAIL_MASTER model) {
     return repos.insert(model) > 0;
    }

    public boolean update(PROC_INSTRUCTIONS_DETAIL_MASTER model) {
     return repos.update(model) > 0;
    }

    public boolean delete(PROC_INSTRUCTIONS_DETAIL_MASTER model) {
     return repos.delete(model) > 0;
    }

    public List<PROC_INSTRUCTIONS_DETAIL_MASTER> select(PROC_INSTRUCTIONS_DETAIL_MASTER model) {
     return repos.select(model);
    }

}
