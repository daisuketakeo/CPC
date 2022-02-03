package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RMaterialCheck;
import com.cpc.model.MATERIAL_CHECK_TABLE;

/**
 * マテリアルチェックテーブル Service
 */
@Service
public class SMaterialCheck {

    private final RMaterialCheck repos;

    @Autowired
    public SMaterialCheck(RMaterialCheck repos) {
     this.repos = repos;
    }

    public boolean insert(MATERIAL_CHECK_TABLE model) {
     return repos.insert(model) > 0;
    }

    public boolean update(MATERIAL_CHECK_TABLE model) {
     return repos.update(model) > 0;
    }

    public boolean delete(MATERIAL_CHECK_TABLE model) {
     return repos.delete(model) > 0;
    }

    public List<MATERIAL_CHECK_TABLE> select(MATERIAL_CHECK_TABLE model) {
     return repos.select(model);
    }

}
