package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RStatusMst;
import com.cpc.model.STATUS_MASTER;

/**
 * ステータスマスタ Service
 */
@Service
public class SStatusMst {

    private final RStatusMst repos;

    @Autowired
    public SStatusMst(RStatusMst repos) {
     this.repos = repos;
    }

    public boolean insert(STATUS_MASTER model) {
     return repos.insert(model) > 0;
    }

    public boolean update(STATUS_MASTER model) {
     return repos.update(model) > 0;
    }

    public boolean delete(STATUS_MASTER model) {
     return repos.delete(model) > 0;
    }

    public List<STATUS_MASTER> select(STATUS_MASTER model) {
     return repos.select(model);
    }

}
