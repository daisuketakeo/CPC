package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RWorkGroupStatus;
import com.cpc.model.WORK_GROUP_STATUS_TABLE;

/**
 * 作業グループステータステーブル Service
 */
@Service
public class SWorkGroupStatus {

    private final RWorkGroupStatus repos;

    @Autowired
    public SWorkGroupStatus(RWorkGroupStatus repos) {
     this.repos = repos;
    }

    public boolean insert(WORK_GROUP_STATUS_TABLE model) {
     return repos.insert(model) > 0;
    }

    public boolean update(WORK_GROUP_STATUS_TABLE model) {
     return repos.update(model) > 0;
    }

    public boolean delete(WORK_GROUP_STATUS_TABLE model) {
     return repos.delete(model) > 0;
    }

    public List<WORK_GROUP_STATUS_TABLE> select(WORK_GROUP_STATUS_TABLE model) {
     return repos.select(model);
    }

}
