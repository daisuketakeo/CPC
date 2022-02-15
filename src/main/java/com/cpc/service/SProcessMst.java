package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RProcessMst;
import com.cpc.model.PROCESS_MASTER;

/**
 * 工程マスタ Service
 */
@Service
public class SProcessMst {

    private final RProcessMst repos;

    @Autowired
    public SProcessMst(RProcessMst repos) {
     this.repos = repos;
    }

    public boolean insert(PROCESS_MASTER model) {
     return repos.insert(model) > 0;
    }

    public boolean update(PROCESS_MASTER model) {
     return repos.update(model) > 0;
    }

    public boolean delete(PROCESS_MASTER model) {
     return repos.delete(model) > 0;
    }

    public List<PROCESS_MASTER> select(PROCESS_MASTER model) {
     return repos.select(model);
    }

}
