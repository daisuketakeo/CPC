package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RAccept;
import com.cpc.model.ACCEPT_TABLE;

/**
 * 受入テーブル Service
 */
@Service
public class SAccept {

    private final RAccept repos;

    @Autowired
    public SAccept(RAccept repos) {
     this.repos = repos;
    }

    public boolean insert(ACCEPT_TABLE model) {
     return repos.insert(model) > 0;
    }

    public boolean update(ACCEPT_TABLE model) {
     return repos.update(model) > 0;
    }

    public boolean delete(ACCEPT_TABLE model) {
     return repos.delete(model) > 0;
    }

    public List<ACCEPT_TABLE> select(ACCEPT_TABLE model) {
     return repos.select(model);
    }

}
