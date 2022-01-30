package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RUserMst;
import com.cpc.model.USER_MASTER;

/**
 * ユーザマスタ Service
 */
@Service
public class SUserMst {

    private final RUserMst repos;

    @Autowired
    public SUserMst(RUserMst repos) {
     this.repos = repos;
    }

    public boolean insert(USER_MASTER model) {
     return repos.insert(model) > 0;
    }

    public boolean update(USER_MASTER model) {
     return repos.update(model) > 0;
    }

    public boolean delete(USER_MASTER model) {
     return repos.delete(model) > 0;
    }

    public List<USER_MASTER> select(USER_MASTER model) {
     return repos.select(model);
    }

}
