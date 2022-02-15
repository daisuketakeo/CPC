package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RWorkMst;
import com.cpc.model.WORK_MASTER;

/**
 * 作業手順マスタ Service
 */
@Service
public class SWorkMst {

    private final RWorkMst repos;

    @Autowired
    public SWorkMst(RWorkMst repos) {
     this.repos = repos;
    }

    public boolean insert(WORK_MASTER model) {
     return repos.insert(model) > 0;
    }

    public boolean update(WORK_MASTER model) {
     return repos.update(model) > 0;
    }

    public boolean delete(WORK_MASTER model) {
     return repos.delete(model) > 0;
    }

    public List<WORK_MASTER> select(WORK_MASTER model) {
     return repos.select(model);
    }

}
