package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RProcessStatus;
import com.cpc.model.PROCESS_STATUS_TABLE;

/**
 * 工程別ステータステーブル Service
 */
@Service
public class SProcessStatus {

    private final RProcessStatus repos;

    @Autowired
    public SProcessStatus(RProcessStatus repos) {
     this.repos = repos;
    }

    public boolean insert(PROCESS_STATUS_TABLE model) {
     return repos.insert(model) > 0;
    }

    public boolean update(PROCESS_STATUS_TABLE model) {
     return repos.update(model) > 0;
    }

    public boolean delete(PROCESS_STATUS_TABLE model) {
     return repos.delete(model) > 0;
    }

    public List<PROCESS_STATUS_TABLE> select(PROCESS_STATUS_TABLE model) {
     return repos.select(model);
    }

}
