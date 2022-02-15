package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RWorkResult;
import com.cpc.model.WORK_RESULT_TABLE;

/**
 * 作業実績テーブル Service
 */
@Service
public class SWorkResult {

    private final RWorkResult repos;

    @Autowired
    public SWorkResult(RWorkResult repos) {
     this.repos = repos;
    }

    public boolean insert(WORK_RESULT_TABLE model) {
     return repos.insert(model) > 0;
    }

    public boolean update(WORK_RESULT_TABLE model) {
     return repos.update(model) > 0;
    }

    public boolean delete(WORK_RESULT_TABLE model) {
     return repos.delete(model) > 0;
    }

    public List<WORK_RESULT_TABLE> select(WORK_RESULT_TABLE model) {
     return repos.select(model);
    }

}
