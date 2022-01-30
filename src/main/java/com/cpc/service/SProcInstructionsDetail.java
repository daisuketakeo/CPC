﻿package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RProcInstructionsDetail;
import com.cpc.model.PROC_INSTRUCTIONS_DETAIL_TABLE;

/**
 * 工程別製造指図詳細テーブル Service
 */
@Service
public class SProcInstructionsDetail {

    private final RProcInstructionsDetail repos;

    @Autowired
    public SProcInstructionsDetail(RProcInstructionsDetail repos) {
     this.repos = repos;
    }

    public boolean insert(PROC_INSTRUCTIONS_DETAIL_TABLE model) {
     return repos.insert(model) > 0;
    }

    public boolean update(PROC_INSTRUCTIONS_DETAIL_TABLE model) {
     return repos.update(model) > 0;
    }

    public boolean delete(PROC_INSTRUCTIONS_DETAIL_TABLE model) {
     return repos.delete(model) > 0;
    }

    public List<PROC_INSTRUCTIONS_DETAIL_TABLE> select(PROC_INSTRUCTIONS_DETAIL_TABLE model) {
     return repos.select(model);
    }

}
