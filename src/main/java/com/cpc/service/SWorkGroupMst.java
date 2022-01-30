package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RWorkGroupMst;
import com.cpc.model.WORK_GROUP_MASTER;

/**
 * 作業グループマスタ Service
 */
@Service
public class SWorkGroupMst {

    private final RWorkGroupMst repos;

    @Autowired
    public SWorkGroupMst(RWorkGroupMst repos) {
     this.repos = repos;
    }

    public boolean insert(WORK_GROUP_MASTER model) {
     return repos.insert(model) > 0;
    }

    public boolean update(WORK_GROUP_MASTER model) {
     return repos.update(model) > 0;
    }

    public boolean delete(WORK_GROUP_MASTER model) {
     return repos.delete(model) > 0;
    }

    public List<WORK_GROUP_MASTER> select(WORK_GROUP_MASTER model) {
     return repos.select(model);
    }

}
